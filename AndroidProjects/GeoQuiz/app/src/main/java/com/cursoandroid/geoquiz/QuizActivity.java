package com.cursoandroid.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";

    private Pregunta[] preguntas = {
            new Pregunta(R.string.pregunta_1,true),
            new Pregunta(R.string.pregunta_2,true),
            new Pregunta(R.string.pregunta_3,false),
            new Pregunta(R.string.pregunta_4,true),
            new Pregunta(R.string.pregunta_5,false),
    };

    private int posicionActual = 0;

    private TextView preguntaText;
    private Button siguienteButton;
    private Button atrasButton;
    private Button verdaderoButton;
    private Button falsoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Log.d(TAG, "onCreate called");

        if(savedInstanceState!=null){
            posicionActual = savedInstanceState.getInt(KEY_INDEX,0);
        }

        preguntaText = findViewById(R.id.pregunta_text);
        actualizarPregunta();

        verdaderoButton = findViewById(R.id.verdadero_button);
        verdaderoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                verificarRepuesta(true);
            }
        });

        falsoButton = findViewById(R.id.falso_button);
        falsoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                verificarRepuesta(false);
            }
        });

        siguienteButton = findViewById(R.id.siguiente_button);
        siguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                posicionActual = (posicionActual + 1) % preguntas.length;
                actualizarPregunta();
            }
        });

        atrasButton = findViewById(R.id.atras_button);
        atrasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                posicionActual--;
                if(posicionActual==-1)
                    posicionActual = preguntas.length - 1;

                actualizarPregunta();
            }
        });
    }

    private void actualizarPregunta(){
        int preguntaId = preguntas[posicionActual].getTextoId();
        preguntaText.setText(preguntaId);
    }

    private void verificarRepuesta(boolean respuestaClick){
        boolean respuesta = preguntas[posicionActual].isRespuesta();

        int mensajeId = 0;

        if(respuestaClick == respuesta)
            mensajeId = R.string.correcto_toast;
        else
            mensajeId = R.string.incorrecto_toast;

        Toast.makeText(this,mensajeId,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"onSaveInstanceState");
        outState.putInt(KEY_INDEX, posicionActual);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }
}
