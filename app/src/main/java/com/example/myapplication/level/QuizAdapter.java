package com.example.myapplication.level;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ItemPuzzleLevelBinding;
import com.example.myapplication.databinding.QuizItemRecyclerRowBinding;
import com.example.myapplication.kuis.QuizModel;

import java.util.List;
import java.util.Map;

public class QuizAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_QUIZ = 0;
    private static final int TYPE_PUZZLE = 1;

    private List<QuizModel> levels;
    private QuizLevelClickListener quizClickListener;
    private PuzzleLevelClickListener puzzleClickListener;
    private UnlockCheck unlockCheck;
    private Map<Integer, Integer> highScores;

    public interface QuizLevelClickListener {
        void onQuizLevelClick(QuizModel level);
    }

    public interface PuzzleLevelClickListener {
        void onPuzzleLevelClick(QuizModel level);
    }

    public interface UnlockCheck {
        boolean isUnlocked(int position);
    }

    public QuizAdapter(List<QuizModel> levels, QuizLevelClickListener quizClickListener,
                       PuzzleLevelClickListener puzzleClickListener, UnlockCheck unlockCheck) {
        this.levels = levels;
        this.quizClickListener = quizClickListener;
        this.puzzleClickListener = puzzleClickListener;
        this.unlockCheck = unlockCheck;
    }

    @Override
    public int getItemViewType(int position) {
        return levels.get(position).isPuzzle() ? TYPE_PUZZLE : TYPE_QUIZ;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_QUIZ) {
            QuizItemRecyclerRowBinding binding = QuizItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new QuizViewHolder(binding);
        } else {
            ItemPuzzleLevelBinding binding = ItemPuzzleLevelBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new PuzzleViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        QuizModel level = levels.get(position);
        if (holder instanceof QuizViewHolder) {
            ((QuizViewHolder) holder).bind(level, position);
        } else if (holder instanceof PuzzleViewHolder) {
            ((PuzzleViewHolder) holder).bind(level,position);
        }
    }

    @Override
    public int getItemCount() {
        return levels.size();
    }

    public void setHighScores(Map<Integer, Integer> highScores) {
        this.highScores = highScores;
    }

    class QuizViewHolder extends RecyclerView.ViewHolder {
        private final QuizItemRecyclerRowBinding binding;

        public QuizViewHolder(QuizItemRecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(QuizModel level, int position) {
            binding.quizLevelText.setText(level.getLevel());
            binding.quizTimeText.setText(level.getTime() + " menit");

            if (unlockCheck.isUnlocked(position)) {
                itemView.setClickable(true);
                itemView.setOnClickListener(v -> quizClickListener.onQuizLevelClick(level));
//                Integer highScore = highScores.get(position);
//                if (highScore != null) {
//                    binding.highScoreText.setText("Nilai:\n" + highScore);
//                    binding.highScoreText.setVisibility(View.VISIBLE);
//                } else {
//                    binding.highScoreText.setVisibility(View.GONE);
//                }
                binding.quizLevelText.setTextColor(itemView.getContext().getResources().getColor(R.color.dark_brown));
            } else {
                itemView.setClickable(false);
                binding.imgLevel.setImageResource(R.drawable.icon_lock);
                binding.quizLevelText.setTextColor(itemView.getContext().getResources().getColor(R.color.dark_gray));
            }
        }
    }

    class PuzzleViewHolder extends RecyclerView.ViewHolder {
        private final ItemPuzzleLevelBinding binding;

        public PuzzleViewHolder(ItemPuzzleLevelBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(QuizModel level,int position) {
            binding.puzzleLevelText.setText(level.getLevel());

                if (unlockCheck.isUnlocked(position)) {
                    itemView.setClickable(true);
                    itemView.setOnClickListener(v -> puzzleClickListener.onPuzzleLevelClick(level));
                    binding.puzzleLevelText.setTextColor(itemView.getContext().getResources().getColor(R.color.dark_brown));
                } else {
                    itemView.setClickable(false);
                    binding.imgLevel.setImageResource(R.drawable.icon_lock);
                    binding.puzzleLevelText.setTextColor(itemView.getContext().getResources().getColor(R.color.dark_gray));
                }
            };
        }
    }

