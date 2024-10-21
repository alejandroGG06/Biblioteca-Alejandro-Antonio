package org.example;

//@author AlejandroGpublic

class Libro_Autor {
int idLibro;
int idAutor;

    public Libro_Autor(int idLibro, int idAutor) {
        this.idLibro = idLibro;
        this.idAutor = idAutor;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public String toString() {
        return "libro_autos{" +
                "idLibro=" + idLibro +
                ", idAutor=" + idAutor +
                '}';
    }
}
