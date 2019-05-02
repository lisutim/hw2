package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed1,ed2,ed3;
    private TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.sad);

        Button submit = (Button)findViewById(R.id.button);
        int size=15;
        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int size = 15;

                ed1 = findViewById(R.id.editText2);
                ed2 = findViewById(R.id.editText3);
                ed3 = findViewById(R.id.editText4);
                txv = findViewById(R.id.textView);

                float height = Float.parseFloat(ed2.getText().toString());
                float weight = Float.parseFloat(ed3.getText().toString());
                float BMI1 = calculateBMI(height, weight);
                String BMI2 = String.valueOf(BMI1);

                txv.setTextSize(size);
                txv.setText(ed1.getText().toString() + "Hello" + "\n" + "your BMI is" + BMI2);
                Toast.makeText(MainActivity.this,standardBMI(BMI1),Toast.LENGTH_LONG).show();


            }

            private float calculateBMI(float ht, float wt) {
                ht=ht/100;
                float BMI = (float) (wt / (ht*ht));
                return BMI;
            }

            private String standardBMI(double st) {
                String alert = "";
                if (st > 25) {
                    alert = String.valueOf("You are too heary ");
                    getWindow().setBackgroundDrawableResource(R.drawable.sad2);
                } else if (st < 18.5) {
                    alert = String.valueOf("You are too slim ");
                    getWindow().setBackgroundDrawableResource(R.drawable.sad2);
                } else {
                    alert = String.valueOf("Your body is good ");
                    getWindow().setBackgroundDrawableResource(R.drawable.happy);
                }

                return alert;
            }
        });

    }
}
