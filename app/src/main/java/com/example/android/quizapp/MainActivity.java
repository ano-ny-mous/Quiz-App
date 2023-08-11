package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkedRadioButtons(RadioButton radioButtonCheck)
    {
        Boolean answer=radioButtonCheck.isChecked();
        if(answer==true)
            score=score+1;
    }

    public void checkedCheckBox(CheckBox checkBoxCheck1, CheckBox checkBoxCheck2, CheckBox checkBoxCheck3, CheckBox checkBoxCheck4)
    {
        if(checkBoxCheck1.isChecked()&&checkBoxCheck2.isChecked()&&!checkBoxCheck3.isChecked()&&!checkBoxCheck4.isChecked())
            score=score+2;
            else if((checkBoxCheck1.isChecked()||checkBoxCheck2.isChecked())&&!checkBoxCheck3.isChecked()&&!checkBoxCheck4.isChecked())
                score=score+1;
            else
                score=score+0;
    }

    public void checkEditText(EditText editText)
    {
        String answer = editText.getText().toString();
        if(answer.equalsIgnoreCase("Central Processing Unit"))
        score=score+5;
    }


    public void submitQuiz(View view)
    {
        EditText name=(EditText) findViewById(R.id.Name);
        RadioButton radioButton1= (RadioButton) findViewById(R.id.Question1_Option2);
        checkedRadioButtons(radioButton1);
        RadioButton radioButton2= (RadioButton) findViewById(R.id.Question2_Option1);
        checkedRadioButtons(radioButton2);
        RadioButton radioButton3= (RadioButton) findViewById(R.id.Question3_Option1);
        checkedRadioButtons(radioButton3);
        RadioButton radioButton4= (RadioButton) findViewById(R.id.Question4_Option3);
        checkedRadioButtons(radioButton4);
        CheckBox checkBox5_1 = (CheckBox) findViewById(R.id.Question5_Option1);
        CheckBox checkBox5_2 = (CheckBox) findViewById(R.id.Question5_Option2);
        CheckBox checkBox5_3 = (CheckBox) findViewById(R.id.Question5_Option3);
        CheckBox checkBox5_4 = (CheckBox) findViewById(R.id.Question5_Option4);
        checkedCheckBox(checkBox5_1, checkBox5_2, checkBox5_3, checkBox5_4);
        RadioButton radioButton6= (RadioButton) findViewById(R.id.Question6_Option2);
        checkedRadioButtons(radioButton6);
        RadioButton radioButton7= (RadioButton) findViewById(R.id.Question7_Option1);
        checkedRadioButtons(radioButton7);
        EditText editText = (EditText) findViewById(R.id.type_here);
        checkEditText(editText);

        Toast.makeText(this,name.getText() + " your score is "+score,Toast.LENGTH_LONG).show();

        score=0;
    }
}
