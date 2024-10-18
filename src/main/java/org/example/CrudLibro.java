package org.example;

//@author AlejandroGpublic

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CrudLibro {

DAOlibro daOlibro=new DAOlibro();

Scanner sc=new Scanner(System.in);

public void menuLibro(){
int opc=0;
    do {
        System.out.println("MENU LIBRO");
        System.out.println("1. Crear Libro "+"2. Listar Libros "+"3. Modificar libro "+"4. Eliminar libro "+"5. Salir");
    opc=sc.nextInt();

    switch(opc){
        case 1:
        System.out.println("Creacion de libro");
            System.out.println("introduzca el id del libro");
            int idLibro=sc.nextInt();
            System.out.println("introduzca el nombre del libro");
            String nombreLibro=sc.next();
            System.out.println("introduzca el isbn del libro");
            String isbnLibro=sc.next();

            Libro lib=new Libro(idLibro,nombreLibro,isbnLibro);
            daOlibro.Insertarlibro(lib);
            break;

        case 2:
            System.out.println("Listado de libros");
            List<Libro>libros=daOlibro.listar();
            for(Libro l:libros) {
                System.out.println(l);
            }
            break;
        case 3:
            System.out.println("Modificar libro");
            System.out.println("introduzca el id del libro");
            int idmod=sc.nextInt();
            System.out.println("introduzca el nuevo titulo del libro");
            String tituloLibro=sc.next();
            System.out.println("introduzca el nuevo isbn del libro");
            String isbnmod=sc.next();

            Libro libmod=new Libro(idmod,tituloLibro,isbnmod);

            daOlibro.updateable(libmod);
            break;
            case 4:
                System.out.println("Eliminar libro");
                System.out.println("introduzca el id del libro");
                int iddell=sc.nextInt();
                daOlibro.Delet(iddell);
                break;
    }
    }while (opc!=5);
}

}
