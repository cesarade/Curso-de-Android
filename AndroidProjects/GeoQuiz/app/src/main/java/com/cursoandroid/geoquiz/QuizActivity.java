package com.cursoandroid.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

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
}
