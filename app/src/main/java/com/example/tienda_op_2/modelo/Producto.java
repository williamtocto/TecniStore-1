package com.example.tienda_op_2.modelo;

public class Producto {

    private int idProducto;
    private String nombre;
    private int stock;
    private String fotoUrl;
    private String descripcion;
    private String precio;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, int stock, String fotoUrl, String descripcion, String precio) {

        this.idProducto = idProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.fotoUrl = fotoUrl;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
