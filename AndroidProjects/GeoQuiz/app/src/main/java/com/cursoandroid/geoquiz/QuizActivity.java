package com.cursoandroid.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button verdaderoButton;
    private Button falsoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        verdaderoButton = findViewById(R.id.verdadero_button);
        verdaderoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Toast.makeText(QuizActivity.this,
                        R.string.correcto_toast,
                        Toast.LENGTH_LONG).show();
            }
        });

        falsoButton = findViewById(R.id.falso_button);
        falsoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Toast.makeText(QuizActivity.this,
                        R.string.incorrecto_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
