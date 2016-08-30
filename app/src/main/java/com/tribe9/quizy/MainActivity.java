package com.tribe9.quizy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

//TODO: Complete Questions
//TODO: Complete Log Code
//TODO: Create scoring method
//TODO: Display wrong questions

//Toast.makeText(MyAndroidAppActivity.this, "Checked", Toast.LENGTH_LONG).show();

public class MainActivity extends AppCompatActivity {

    // Array logs questions answered incorrectly
    ArrayList<Integer> wrongAnswer = new ArrayList<Integer>();
    int score = 0; // Total Quiz Score

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question_one();
    }

    protected void gradeQuiz(View view) {
        question_one();

        Toast.makeText(this, "this is my Toast message!!! =)",
                Toast.LENGTH_LONG).show();

    }

    protected void question_one() {
        int score = 0;
        // Find & Define Checkboxes, only the correct answers
        final CheckBox q1b1 = (CheckBox) findViewById(R.id.q1b1);
        final CheckBox q1b2 = (CheckBox) findViewById(R.id.q1b2);
        final CheckBox q1b3 = (CheckBox) findViewById(R.id.q1b3);

        // Check if correct boxes are checked
        if (q1b1.isChecked() && q1b2.isChecked() && q1b3.isChecked()) {
            score = score + 1;
        } else {
            errorLog(1);
        }
        Log.i("Question One", "Score: " + score);
    }

    // Method Logs questions answered incorrectly to wrongAnswer Array
    protected void errorLog(int question) {
        wrongAnswer.add(question);


    }

}
