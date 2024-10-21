package org.example;

//@author AlejandroGpublic

import java.util.Scanner;

class MainLibreria {
Scanner sc = new Scanner(System.in);
    CrudLibro crudLibro = new CrudLibro();
    CrudAutor crudAutor = new CrudAutor();
    CrudUsuario crudUsuario = new CrudUsuario();
    CrudLibro_Autor crudLibro_Autor = new CrudLibro_Autor();

int opcion;
    public static void main(String[] args) {
        MainLibreria mainLibreria = new MainLibreria();

        mainLibreria.biblioteca();

    }
public void biblioteca(){

        do {
            System.out.println("Menu Biblioteca");
            System.out.println("1.Menu libros "+"2.Menu autores "+"3.Menu Usuario "+"4.Menu libros y autores "+"5.Salir");
                opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                crudLibro.menuLibro();
                break;
            case 2:
                crudAutor.menuAutor();
                break;
            case 3:
                crudUsuario.menuUsuario();
                break;
            case 4:
                crudLibro_Autor.menuLib_au();
                break;
            case 5:
                System.out.println("Vuelve pronto :)");
                break;
        }
        }while (opcion!=5);
}

}
