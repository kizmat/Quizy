package com.tribe9.quizy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

//TODO: Complete Log Code
//TODO: Create scoring method
//TODO: Display wrong questions

//Toast.makeText(MyAndroidAppActivity.this, "Checked", Toast.LENGTH_LONG).show();

public class MainActivity extends AppCompatActivity {

    // Array logs questions answered incorrectly
    ArrayList<Integer> wrongAnswer = new ArrayList<>();

    // Array log unanswered questions
    ArrayList<Integer> notAnswered = new ArrayList<>();


    // Total Quiz Score
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void gradeQuiz(View view) {
        // Clear notAnswered list
        notAnswered.clear();
        // Clear score
        score = 0;

        // Check all questions have been answered

        isAnsweredQuestionOne();
        isAnsweredQuestionTwo();
        isAnsweredQuestionThree();
        isAnsweredQuestionFour();
        isAnsweredQuestionFive();

        if (notAnswered.isEmpty()) {
            // All questions answered, score displayed
            Toast.makeText(this, "Your Score is: " + score, Toast.LENGTH_SHORT).show();

        } else {
            // Show user which questions need to be answered
            Toast.makeText(this, "Please answer questions: " + notAnswered, Toast.LENGTH_SHORT).show();
        }


    }


    // Method Logs questions answered incorrectly to wrongAnswer Array
    protected void errorLog(int question) {
        wrongAnswer.add(question);


    }

    // Is question one answered?

    protected void isAnsweredQuestionOne() {

        // Question One
        CheckBox q1b1 = (CheckBox) findViewById(R.id.q1b1);
        CheckBox q1b2 = (CheckBox) findViewById(R.id.q1b2);
        CheckBox q1b3 = (CheckBox) findViewById(R.id.q1b3);
        CheckBox q1b4 = (CheckBox) findViewById(R.id.q1b4);

        // Check if correct boxes are checked
        if (q1b1.isChecked() && q1b2.isChecked() && q1b3.isChecked()) {
            score = score + 1;
        } else if (q1b1.isChecked() || q1b2.isChecked() || q1b3.isChecked() || q1b4.isChecked()) {
            errorLog(1);
        } else {
            // no radio buttons are checked
            notAnswered.add(1);
        }



    }

    // Is question two answered?

    protected void isAnsweredQuestionTwo() {

        // Question Two
        RadioGroup question_two_radio_group = (RadioGroup) findViewById(R.id.question_two_radio_group);
        RadioButton q2b1 = (RadioButton) findViewById(R.id.q2b1);
        RadioButton q2b2 = (RadioButton) findViewById(R.id.q2b2);

        if (question_two_radio_group.getCheckedRadioButtonId() == -1) {
            // no radio buttons are checked
            notAnswered.add(2);


        } else if (q2b1.isChecked()){

            // one of the radio buttons is checked
                score += 1;
            }
        }

    // Is question three answered?

    protected void isAnsweredQuestionThree() {

        // Question Three
        RadioGroup question_three_radio_group = (RadioGroup) findViewById(R.id.question_three_radio_group);
        RadioButton q3b1 = (RadioButton) findViewById(R.id.q3b1);
        RadioButton q3b2 = (RadioButton) findViewById(R.id.q3b2);

        if (question_three_radio_group.getCheckedRadioButtonId() == -1) {
            // no radio buttons are checked
            notAnswered.add(3);


        } else {
            // one of the radio buttons is checked
        }
    }

    // Is question four answered?

    protected void isAnsweredQuestionFour() {

        // Question 4
        CheckBox q4b1 = (CheckBox) findViewById(R.id.q4b1);
        CheckBox q4b2 = (CheckBox) findViewById(R.id.q4b2);
        CheckBox q4b3 = (CheckBox) findViewById(R.id.q4b3);
        CheckBox q4b4 = (CheckBox) findViewById(R.id.q4b4);

        if (q4b1.isChecked()) {

        } else if (q4b2.isChecked()) {

        } else if (q4b3.isChecked()) {

        } else if (q4b4.isChecked()) {
        } else {
            // no radio buttons are checked
            notAnswered.add(4);

        }
    }

    // Is question 5 Answered

    protected void isAnsweredQuestionFive() {

        // Question 5
        EditText q5textAnswer = (EditText) findViewById(R.id.q5TextAnswer);

        if (q5textAnswer.length() > 0) {

        } else {
            notAnswered.add(5);

        }
    }


}
