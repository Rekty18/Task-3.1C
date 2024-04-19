package com.example.quizzapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserName = findViewById(R.id.editTextUserName);
        Button buttonStart = findViewById(R.id.buttonStart);

        buttonStart.setOnClickListener(v -> {
            String userName = editTextUserName.getText().toString();
            if (!userName.isEmpty()) {
                startQuiz(userName);
            } else {
                Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startQuiz(String userName) {
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        intent.putExtra("USER_NAME", userName);
        startActivity(intent);
    }

}
