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

    List<Libro_Autor> libroAutorlist;
    DAOlibroautor daolibroautor;

    List<Prestamo>prestamoList;
    DAOPrestamo daoPrestamo;

    //-----Inicializacion de los daos en la memoria-----\\
    public Servicios(){
        inciar();
        iniciarAutor();
        iniciarUsuario();
        iniciarlibaut();
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
        usuarioList = daoUsuario.listar();}
    public void iniciarlibaut(){
        daolibroautor = new DAOlibroautor();
        libroAutorlist=daolibroautor.list();
    }
    public void iniciarprestamo() {
        daoPrestamo = new DAOPrestamo();
        prestamoList=daoPrestamo.listar();
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
    public void crearLibAut(Libro_Autor libro){
        daolibroautor.insertal(libro);
        libroAutorlist.add(libro);
    }
    public void crearprestamo(Prestamo prestamo){
        daoPrestamo.InsertarPrestamo(prestamo);
        prestamoList.add(prestamo);
    }

    //---------Listar-------------------\\
    public List<Libro> getLibros(){
        return this.librosmem;}

    public List<Autor> getAutores(){
        return this.autorlist;}

    public List<Usuario> getUsuarios(){
        return this.usuarioList;
    }
    public List<Libro_Autor> getLibroAutor(){
        return this.libroAutorlist;
    }
    public List<Prestamo> getPrestamo(){
        return this.prestamoList;
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
    public void upgradeprestamo(Prestamo prestamo){
        daoPrestamo.updateable(prestamo);
        prestamoList.add(prestamo);
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

    public void deletela(int id, int id2){
        daolibroautor.delet(id,id2);
        autorlist.remove(id);
    }
    public void deleteprestamo(int id){
        daoPrestamo.Delet(id);
        prestamoList.remove(id);
    }
}

