package com.example.TecniStore.modelo;

public class Categoria {
    int id;
    int imgId;

    public Categoria(int id, int imgId) {
        this.id = id;
        this.imgId = imgId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
