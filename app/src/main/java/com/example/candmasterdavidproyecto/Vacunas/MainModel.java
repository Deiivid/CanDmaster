package com.example.candmasterdavidproyecto.Vacunas;


public class MainModel {
    String fecha, nombreperro,foto, nombrevacuna;

    MainModel(){

    }
    public MainModel(String comprar, String nombreperro, String foto, String nombrevacuna) {
        this.fecha = comprar;
        this.nombreperro = nombreperro;
        this.foto = foto;
        this.nombrevacuna = nombrevacuna;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreperro() {
        return nombreperro;
    }

    public void setNombreperro(String nombreperro) {
        this.nombreperro = nombreperro;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombrevacuna() {
        return nombrevacuna;
    }

    public void setNombrevacuna(String nombrevacuna) {
        this.nombrevacuna = nombrevacuna;
    }
}