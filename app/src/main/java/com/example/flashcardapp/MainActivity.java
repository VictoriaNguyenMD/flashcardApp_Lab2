package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.answer1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer1).setBackgroundColor(Color.RED);
            }
        });
        findViewById(R.id.answer2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer2).setBackgroundColor(Color.RED);
            }
        });
        findViewById(R.id.answer3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer3).setBackgroundColor(Color.GREEN);
            }
        });
        findViewById(R.id.toggle_choices_visibility).setOnClickListener(new View.OnClickListener() {
            boolean isShowingAnswers = true;
            @Override
            public void onClick(View v) {
                if (isShowingAnswers)
                {
                    ImageView img1 = findViewById(R.id.toggle_choices_visibility);
                    img1.setImageResource(R.drawable.ic_hidden_eye);
                    findViewById(R.id.answer1).setVisibility(View.INVISIBLE);
                    findViewById(R.id.answer2).setVisibility(View.INVISIBLE);
                    findViewById(R.id.answer3).setVisibility(View.INVISIBLE);
                    isShowingAnswers = false;
                } else {
                    ImageView img2 = findViewById(R.id.toggle_choices_visibility);
                    img2.setImageResource(R.drawable.ic_unhidden_eye);
                    findViewById(R.id.answer1).setVisibility(View.VISIBLE);
                    findViewById(R.id.answer2).setVisibility(View.VISIBLE);
                    findViewById(R.id.answer3).setVisibility(View.VISIBLE);
                    isShowingAnswers = true;
                }
            }
        });
        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               findViewById(R.id.answer1).setVisibility(View.VISIBLE);
               findViewById(R.id.answer1).setBackgroundColor(Color.parseColor("#838B8B"));
               findViewById(R.id.answer2).setVisibility(View.VISIBLE);
               findViewById(R.id.answer2).setBackgroundColor(Color.parseColor("#838B8B"));
               findViewById(R.id.answer3).setVisibility(View.VISIBLE);
               findViewById(R.id.answer3).setBackgroundColor(Color.parseColor("#838B8B"));
               findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
               findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.add_card_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String question = data.getExtras().getString("question"); // 'string1' needs to match the key we used when we put the string in the Intent
            String answer = data.getExtras().getString("answer");

            setContentView(R.layout.activity_main);

            TextView q = findViewById(R.id.flashcard_question);
            q.setText(question);

            findViewById(R.id.answer1).setVisibility(View.INVISIBLE);
            findViewById(R.id.answer2).setVisibility(View.INVISIBLE);
            findViewById(R.id.answer3).setVisibility(View.INVISIBLE);
            findViewById(R.id.add_card_button).setVisibility(View.INVISIBLE);
            findViewById(R.id.toggle_choices_visibility).setVisibility(View.INVISIBLE);
            findViewById(R.id.reset).setVisibility(View.INVISIBLE);

            TextView a = findViewById(R.id.flashcard_answer);
            a.setText(answer);

            findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
                    findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                }
            });
            findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                    findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
                }
            });
        }
    }
}
