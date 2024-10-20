package org.example;

import java.util.List;
import java.util.Scanner;

public class CrudAutor {

    DAOAutor daoAutor=new DAOAutor();

    Scanner sc=new Scanner(System.in);

    public void menuAutor(){
        int opc=0;
        do {
            System.out.println("MENU Autor");
            System.out.println("1. Crear Autor "+"2. Listar Autores "+"3. Modificar autores "+"4. Eliminar autor "+"5. Salir");
            opc=sc.nextInt();

            switch(opc){
                case 1:
                    System.out.println("Creacion de autor");
                    System.out.println("introduzca el id del autor");
                    int idAutor=sc.nextInt();
                    System.out.println("introduzca el nombre del autor");
                    String nombreAutor=sc.next();
                    Autor autor=new Autor(idAutor,nombreAutor);
                    daoAutor.InsertarAutor(autor);
                    break;

                case 2:
                    System.out.println("Listado de autores");
                    List<Autor> autores=daoAutor.listar();
                    for(Autor a:autores) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    System.out.println("Modificar autor");
                    System.out.println("introduzca el id del autor");
                    int idmod=sc.nextInt();
                    System.out.println("introduzca el nuevo nombre del autor");
                    String nomAutor=sc.next();

                    Autor autormod=new Autor(idmod,nomAutor);

                    daoAutor.updateable(autormod);
                    break;
                case 4:
                    System.out.println("Eliminar autor");
                    System.out.println("introduzca el id del autor");
                    int iddell=sc.nextInt();
                    daoAutor.Delet(iddell);
                    break;
            }
        }while (opc!=5);
    }

}
