package com.mycompany.proyecto2progra;

public class NodoVehiculo {

    String placa;
    String color;
    String linea;
    int modelo;
    String propietario;
    NodoVehiculo arriba;
    NodoVehiculo abajo;
    NodoVehiculo izquierda;
    NodoVehiculo derecha;

    public NodoVehiculo(String placa, String color, String linea, int modelo, String propietario) {
        this.placa = placa;
        this.color = color;
        this.linea = linea;
        this.modelo = modelo;
        this.propietario = propietario;
        this.arriba = null;
        this.abajo = null;
        this.izquierda = null;
        this.derecha = null;
    }

    //getter y setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public NodoVehiculo getArriba() {
        return arriba;
    }

    public void setArriba(NodoVehiculo arriba) {
        this.arriba = arriba;
    }

    public NodoVehiculo getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoVehiculo abajo) {
        this.abajo = abajo;
    }

    public NodoVehiculo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoVehiculo izquierda) {
        this.izquierda = izquierda;
    }

    public NodoVehiculo getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoVehiculo derecha) {
        this.derecha = derecha;
    }

}
