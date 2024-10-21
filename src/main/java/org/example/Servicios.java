package org.example;

//@author AlejandroGpublic

import java.util.List;

class Servicios {

    List<Libro>librosmem;
    DAOlibro daolibro;

    List<Autor>autorlist;
    DAOAutor daoAutor;

    List<Usuario>usuarioList;
    DAOUsuario daoUsuario;

    //-----Inicializacion de los daos en la memoria-----\\
    public Servicios(){
        inciar();
        iniciarAutor();
        iniciarUsuario();
    }

    //----------Inicializar-------------\\

    public void inciar(){
    daolibro = new DAOlibro();
    librosmem = daolibro.listar();
    }
    public void iniciarAutor() {
        daoAutor = new DAOAutor();
        autorlist = daoAutor.listar();}
    public void iniciarUsuario() {
        daoUsuario = new DAOUsuario();
        usuarioList = daoUsuario.listar();
    }

    //---------Crear-------------------\\
    public void Crear(Libro libro){
        daolibro.Insertarlibro(libro);
        librosmem.add(libro);}

    public void CrearAutor(Autor autor){
        daoAutor.InsertarAutor(autor);
        autorlist.add(autor);}

    public void CrearUsuario(Usuario usuario){
        daoUsuario.InsertarUsuario(usuario);
        usuarioList.add(usuario);
    }

    //---------Listar-------------------\\
    public List<Libro> getLibros(){
        return this.librosmem;}

    public List<Autor> getAutores(){
        return this.autorlist;}

    public List<Usuario> getUsuarios(){
        return this.usuarioList;
    }

    //--------Updates--------------------\\
    public void upgrade(Libro libro){
        daolibro.updateable(libro);
        librosmem.add(libro);}

    public void upgradeAutor(Autor autor){
        daoAutor.updateable(autor);
        autorlist.add(autor);}

    public void upgradeUsuario(Usuario usuario){
        daoUsuario.updateable(usuario);
        usuarioList.add(usuario);
    }

    //---------Eliminar--------------------\\
    public void delete(int id){
        daolibro.Delet(id);
        librosmem.remove(id);}

    public void deleteAutor(int id){
        daoAutor.Delet(id);
        autorlist.remove(id);}

    public void deleteUsuario(int id){
        daoUsuario.Delet(id);
        usuarioList.remove(id);
    }
}

