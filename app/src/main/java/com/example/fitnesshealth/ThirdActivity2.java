package com.example.fitnesshealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity2 extends AppCompatActivity {

    String buttonvalue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MTimeLeftinmills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2);
        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");
        int intvalue = Integer.valueOf(buttonvalue);

        switch (intvalue) {
            case 1:
                setContentView(R.layout.a1_2);
                break;
            case 2:
                setContentView(R.layout.a2_2);
                break;
            case 3:
                setContentView(R.layout.a3_2);
                break;
            case 4:
                setContentView(R.layout.a4_2);
                break;
            case 5:
                setContentView(R.layout.a5_2);
                break;
            case 6:
                setContentView(R.layout.a6_2);
                break;
            case 7:
                setContentView(R.layout.a7_2);
                break;
            case 8:
                setContentView(R.layout.a8_2);
                break;
            case 9:
                setContentView(R.layout.a9_2);
                break;
            case 10:
                setContentView(R.layout.a10_2);
                break;
            case 11:
                setContentView(R.layout.a11_2);
                break;
            case 12:
                setContentView(R.layout.a12_2);
                break;
            case 13:
                setContentView(R.layout.a13_2);
                break;
            case 14:
                setContentView(R.layout.a14_2);
                break;
            case 15:
                setContentView(R.layout.a15_2);
                break;
        }

        startBtn = findViewById(R.id.startbutton);
        mtextview = findViewById(R.id.time);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MTimeRunning) {
                    stoptimer();
                } else {
                    startTimer();
                }
            }
        });
    }

    private void stoptimer() {
        countDownTimer.cancel();
        MTimeRunning = false;
        startBtn.setText("START");
    }

    private void startTimer() {
        final CharSequence value1 = mtextview.getText();
        String num1 = value1.toString();
        String num2 = "0"; // Default value
        String num3 = "0"; // Default value

        if (num1.length() >= 5) {
            num2 = num1.substring(0, 2);
            num3 = num1.substring(3, 5);
        }

        final int number = Integer.parseInt(num2) * 60 + Integer.parseInt(num3);

        MTimeLeftinmills = number * 1000;

        countDownTimer = new CountDownTimer(MTimeLeftinmills, 1000) {
            @Override
            public void onTick(long l) {
                MTimeLeftinmills = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                int newvalue = Integer.valueOf(buttonvalue) + 1;
                if (newvalue <= 7) {
                    Intent intent = new Intent(ThirdActivity2.this, ThirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newvalue));
                    startActivity(intent);
                } else {
                    newvalue = 1;
                    Intent intent = new Intent(ThirdActivity2.this, ThirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newvalue));
                    startActivity(intent);
                }
            }
        }.start();
        startBtn.setText("Pause");
        MTimeRunning = true;
    }

    private void updateTimer() {
        int minutes = (int) (MTimeLeftinmills / 60000);
        int seconds = (int) ((MTimeLeftinmills % 60000) / 1000);
        String timeLeftText = "";

        if (minutes < 10) {
            timeLeftText += "0" + minutes;
        } else {
            timeLeftText += minutes;
        }

        timeLeftText += ":";

        if (seconds < 10) {
            timeLeftText += "0" + seconds;
        } else {
            timeLeftText += seconds;
        }

        mtextview.setText(timeLeftText);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
