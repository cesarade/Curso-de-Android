package com.cursoandroid.geoquiz;

public class Pregunta {
    private int textoId;
    private boolean respuesta;

    public Pregunta(final int textoId, final boolean respuesta) {
        this.textoId = textoId;
        this.respuesta = respuesta;
    }

    public int getTextoId() {
        return textoId;
    }

    public void setTextoId(final int textoId) {
        this.textoId = textoId;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(final boolean respuesta) {
        this.respuesta = respuesta;
    }
}
