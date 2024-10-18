package org.example;

//@author AlejandroGpublic

import java.util.List;

class Servicios {

    List<Libro>librosmem;
    DAOlibro daolibro;
    public Servicios(){
        inciar();
    }


    public void inciar(){
    daolibro = new DAOlibro();
    librosmem = daolibro.listar();
    }

    public void Crear(Libro libro){
        daolibro.Insertarlibro(libro);
        librosmem.add(libro);
    }

    public List<Libro> getLibros(){
        return this.librosmem;
    }
    public void upgrade(Libro libro){
        daolibro.updateable(libro);
        librosmem.add(libro);
    }
    public void delete(int id){
        daolibro.Delet(id);
        librosmem.remove(id);
    }
}

