package com.example.calculadoradeprecio.Model;

public class Producto {
    String nombre;
    String cantidad;
    double precio;
    public Producto() {
    }

    public Producto(String nombre, String cantidad,double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio=precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
