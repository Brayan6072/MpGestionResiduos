package com.microservice.miniJuego.models;

public class UsuarioRequest {
    private String userId;
    private String nombreUsuario;
    private int puntos;

    public UsuarioRequest() {

    }

    public UsuarioRequest(String userId, String nombreUsuario, int puntos) {
        this.userId = userId;
        this.nombreUsuario = nombreUsuario;
        this.puntos = puntos;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}
