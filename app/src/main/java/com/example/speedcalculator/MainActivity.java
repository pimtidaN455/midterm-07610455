package com.example.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import static com.example.speedcalculator.R.id.showans;

public class MainActivity extends AppCompatActivity {
    TextView aaa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cal = findViewById(R.id.CAL);
        Button clear = findViewById(R.id.CLEAR);
        final EditText E1 = findViewById(R.id.EDNB1);
        final EditText E2 = findViewById(R.id.EDNB2);
         aaa = findViewById(showans);
         clear.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 E1.setText("");
                 E2.setText("");
                 aaa.setText("");
             }
         });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num1 = findViewById(R.id.EDNB1);
                EditText num2 = findViewById(R.id.EDNB2);
                String a= num1.getText().toString();
                String b= num2.getText().toString();

                double a1 = Double.parseDouble(a);
                double b1 = Double.parseDouble(b);

                if (a.length()<1 || b.length()<1) {
                    Toast toast1 = Toast.makeText(MainActivity.this, R.string.Time,Toast.LENGTH_LONG);
                    toast1.show ( );
                }

               else if (b1<1){
                    Toast toast = Toast.makeText(MainActivity.this, R.string.zero,Toast.LENGTH_LONG);
                    toast.show ( );
                }
                else if (a1>=0 && b1>0){
                    double answer = 0;
                    double BB = b1*0.0166666667;
                    answer = a1/BB;
                    if (answer>80){
                        AlertDialog.Builder di = new AlertDialog.Builder(MainActivity.this);
                        di.setTitle("SPEED CALCULATOR");
                        di.setMessage("Speed is over limit");
                        di.show();
                    }
                    String ANV = String.format(
                            Locale.getDefault(),"%.2f",answer
                    );
                    aaa.setText(ANV);


                }

            }
        });




    }
}