package com.example.quizzapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.content.Intent;
import android.os.Handler;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textViewQuestion;
    private TextView textViewScore;
    private LinearLayout answersLayout; // For dynamically adding answer buttons
    private int score = 0;
    // You will need to create a method to calculate the progress, we will do this later.
    private List<Question> questions;
    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        progressBar = findViewById(R.id.progressBar);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewScore = findViewById(R.id.textViewScore);
        answersLayout = findViewById(R.id.answersLayout);

        String userName = getIntent().getStringExtra("USER_NAME");
        questions = QuizDataManager.getQuestions();
        loadNextQuestion();
    }

    private void loadNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            textViewQuestion.setText(currentQuestion.getQuestionText());
            answersLayout.removeAllViews();
            for (int i = 0; i < currentQuestion.getAnswers().size(); i++) {
                Button answerButton = new Button(this);
                answerButton.setText(currentQuestion.getAnswers().get(i));
                answerButton.setOnClickListener(v -> checkAnswer(answerButton.getText().toString()));
                answersLayout.addView(answerButton);
            }
            updateProgressBar();
        } else
            if (currentQuestionIndex >= questions.size()) {
                showResults();
        }
    }

    private void checkAnswer(String selectedAnswer) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        if (currentQuestion.isCorrectAnswer(selectedAnswer)) {
            score++;
            textViewScore.setText("Score: " + score);
        } else {
        }
        currentQuestionIndex++;
        new Handler().postDelayed(this::loadNextQuestion, 2000);
    }

    private void updateProgressBar() {
        int progress = (int) (((double) currentQuestionIndex / questions.size()) * 100);
        progressBar.setProgress(progress);
    }

        private void showResults() {
            Intent resultIntent = new Intent(QuizActivity.this, ResultActivity.class);
            resultIntent.putExtra("SCORE", score);
            resultIntent.putExtra("TOTAL_QUESTIONS", questions.size());
            startActivity(resultIntent);
            finish();
        }
}


