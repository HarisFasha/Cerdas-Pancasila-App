package com.example.myapplication.level;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;

import java.util.List;

public class LevelListAdapter extends RecyclerView.Adapter<LevelListAdapter.LevelViewHolder> {
    private List<LevelModel> levelList;
    private OnLevelClickListener listener;

    public interface OnLevelClickListener {
        void onLevelClick(LevelModel levelModel);
    }

    public LevelListAdapter(List<LevelModel> levelList, OnLevelClickListener listener) {
        this.levelList = levelList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LevelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.level_item_recycler_row, parent, false);
        return new LevelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelViewHolder holder, int position) {
        LevelModel level = levelList.get(position);
        holder.levelText.setText(level.getLevel());
        holder.levelType.setText(level.getType());
        holder.itemView.setOnClickListener(v -> listener.onLevelClick(level));
    }

    @Override
    public int getItemCount() {
        return levelList.size();
    }

    static class LevelViewHolder extends RecyclerView.ViewHolder {
        TextView levelText;
        TextView levelType;

        LevelViewHolder(@NonNull View itemView) {
            super(itemView);
            levelText = itemView.findViewById(R.id.level_text);
            levelType = itemView.findViewById(R.id.level_type);
        }
    }
}
