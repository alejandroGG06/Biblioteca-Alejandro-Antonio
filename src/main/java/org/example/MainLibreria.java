package org.example;

//@author AlejandroGpublic

import java.util.Scanner;

class MainLibreria {
Scanner sc = new Scanner(System.in);
    CrudLibro crudLibro = new CrudLibro();

int opcion;
    public static void main(String[] args) {
        MainLibreria mainLibreria = new MainLibreria();

        mainLibreria.biblioteca();

    }
public void biblioteca(){

        do {
            System.out.println("Menu Biblioteca");
            System.out.println("1.Menu libros "+"2.Menu autores "+"3.Menu libros y autores");
                opcion = sc.nextInt();
        switch (opcion){
            case 1:
                crudLibro.menuLibro();
                break;
        }
        }while (opcion!=6);
}

}
