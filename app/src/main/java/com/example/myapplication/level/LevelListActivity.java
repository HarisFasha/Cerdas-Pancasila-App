package com.example.myapplication.level;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import com.example.myapplication.kuis.QuizActivity;
import com.example.myapplication.puzzle.PuzzleActivity;
import com.google.firebase.database.*;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LevelListActivity extends AppCompatActivity implements LevelListAdapter.OnLevelClickListener {
    private RecyclerView levelRecyclerView;
    private LevelListAdapter levelListAdapter;
    private List<LevelModel> levelList;
    private String[] puzzleFiles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.myapplication.R.layout.activity_level_list);

        levelRecyclerView = findViewById(R.id.level_recycler_view);
        levelRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        levelList = new ArrayList<>();
        fetchLevelsFromFirebase();

        levelListAdapter = new LevelListAdapter(levelList, this);
        levelRecyclerView.setAdapter(levelListAdapter);

        try {
            puzzleFiles = getAssets().list("img");
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error loading puzzle images", Toast.LENGTH_SHORT).show();
        }
    }

    private void fetchLevelsFromFirebase() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("levels");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    LevelModel level = snapshot.getValue(LevelModel.class);
                    if (level != null) {
                        if (Integer.parseInt(level.getId()) % 4 == 0) {
                            level.setType("puzzle");
                        } else {
                            level.setType("quiz");
                        }
                        levelList.add(level);
                    }
                }
                levelListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(LevelListActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onLevelClick(LevelModel levelModel) {
        Intent intent;
        if ("quiz".equals(levelModel.getType())) {
            intent = new Intent(this, QuizActivity.class);
            intent.putExtra("levelId", levelModel.getId());
            intent.putExtra("time", levelModel.getTime());
            intent.putExtra("questionList", new Gson().toJson(levelModel.getQuestionList()));
        } else {
            intent = new Intent(this, PuzzleActivity.class);
            intent.putExtra("assetName", getAssetName(Integer.parseInt(levelModel.getId())));
        }
        startActivity(intent);
    }

    private String getAssetName(int level) {
        if (puzzleFiles != null && puzzleFiles.length > 0) {
            return puzzleFiles[(level - 1) % puzzleFiles.length];
        }
        return null;
    }
}
