package org.example;

//@author AlejandroGpublic

import java.util.List;
import java.util.Scanner;

class CrudLibro_Autor {

    Servicios daoLibroAutor=new Servicios();
static Scanner sc = new Scanner(System.in);
int opcion;
public void menuLib_au(){
    System.out.println("Menu Libro Autor");
    System.out.println("1.Crear Relacion "+ "2.listar relacion "+"3.Eliminar relacion"+"4.salir");
    opcion=sc.nextInt();

    do {
        switch (opcion) {
            case 1:
                System.out.println("introduzca el id del libro");
                int idLibro=sc.nextInt();
                System.out.println("introduzca el id del autor");
                int idAutor=sc.nextInt();
                Libro_Autor la=new Libro_Autor(idLibro,idAutor);
                daoLibroAutor.crearLibAut(la);
                break;
                case 2:
                    System.out.println("lista de relaciones");
                    List<Libro_Autor>LA=daoLibroAutor.getLibroAutor();
                    for(Libro_Autor a:LA){
                        System.out.println(a);

                    }
                    break;
            case 3:
                System.out.println("ingrese el id del libro a eliminar");
                int idLibroa=sc.nextInt();
                System.out.println("ingrese el id del autor a eliminar");
                int idAutora=sc.nextInt();

                daoLibroAutor.deletela(idLibroa,idAutora);
                break;
        }

    }while(opcion!=4);
}
}
