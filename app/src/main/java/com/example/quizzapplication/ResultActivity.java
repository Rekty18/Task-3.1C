package com.example.quizzapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewFinalScore = findViewById(R.id.textViewFinalScore);
        Button buttonNewQuiz = findViewById(R.id.buttonNewQuiz);
        Button buttonFinish = findViewById(R.id.buttonFinish);

        int score = getIntent().getIntExtra("SCORE", 0);
        int totalQuestions = getIntent().getIntExtra("TOTAL_QUESTIONS", 0);

        textViewFinalScore.setText("Your score: " + score + " / " + totalQuestions);

        buttonNewQuiz.setOnClickListener(v -> {
            Intent mainIntent = new Intent(ResultActivity.this, MainActivity.class);
            mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(mainIntent);
        });

        buttonFinish.setOnClickListener(v -> finishAffinity());
    }
}
