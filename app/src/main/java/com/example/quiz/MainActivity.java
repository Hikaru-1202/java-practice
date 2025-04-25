package com.example.quiz;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView countLabel, questionLabel;
    private Button answerBtn1, answerBtn2, answerBtn3, answerBtn4;
    private String rightAnswer;
    private int rightAnswerCount;
    private  int quizCount = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        countLabel = findViewById(R.id.countLabel);
        questionLabel = findViewById(R.id.questionLabel);
        answerBtn1 = findViewById(R.id.answerBtn1);
        answerBtn2 = findViewById(R.id.answerBtn2);
        answerBtn3 = findViewById(R.id.answerBtn3);
        answerBtn4 = findViewById(R.id.answerBtn4);

        answerBtn1.setOnClickListener(this);
        answerBtn2.setOnClickListener(this);
        answerBtn3.setOnClickListener(this);
        answerBtn4.setOnClickListener(this);


        showNextQuiz();
    }
    private void showNextQuiz(){
        //countLabel.setText("第"+quizCount+"問");
        countLabel.setText(getString(R.string.count_label, quizCount));
        questionLabel.setText("北海道");
        answerBtn1.setText("札幌市");
        answerBtn2.setText("長崎市");
        answerBtn3.setText("福島市");
        answerBtn4.setText("前橋市");

        rightAnswer = "札幌市";
    }

    @Override
    public void onClick(View v) {
        Button answerBtn = findViewById(v.getId());
        String btnText = answerBtn.getText().toString();

        if (rightAnswer.equals(btnText)){
            Log.v("MY_LOG","正解！");
        }else {
            Log.v("MY_LOG","不正解...");
        }

        if (quizCount == 5){
            Log.v("MY_LOG","クイズ終了");
        }else{
            quizCount++;
            showNextQuiz();
        }
    }
}

