package org.example;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CrudPrestamo {
    Servicios daoprestamo = new Servicios();

    Scanner sc=new Scanner(System.in);

    public void menuPrestamo(){
        int opc=0;
        do {
            System.out.println("MENU Prestamo");
            System.out.println("1. Crear prestamo "+"2. Listar prestamos "+"3. Modificar prestamo "+"4. Eliminar prestamo "+"5. Salir");
            opc=sc.nextInt();

            switch(opc){
                case 1:
                    System.out.println("Creacion de prestamo");
                    System.out.println("introduzca el id del prestamo");
                    int idPrestamo=sc.nextInt();
                    System.out.println("introduzca la fecha de inicio del prestamo");
                    int fechaIni=sc.nextInt();
                    System.out.println("introduzca la fecha fin del prestamo");
                    int fechaFin=sc.nextInt();
                    System.out.println("introduzca el id del usuario");
                    int idUsuario=sc.nextInt();
                    System.out.println("introduzca el id del libro");
                    int idLibro=sc.nextInt();
                    Prestamo prestamo=new Prestamo(idUsuario,fechaIni, fechaFin, idUsuario, idLibro);
                    daoprestamo.CrearPrestamo(prestamo);
                    break;

                case 2:
                    System.out.println("Listado de Prestamos");
                    List<Prestamo> prestamos=daoprestamo.getPrestamos();
                    for(Prestamo p:prestamos) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.println("Modificar Prestamo");
                    System.out.println("introduzca el id del Prestamo");
                    int idmod=sc.nextInt();
                    System.out.println("introduzca la nueva fecha de inicio del prestamo");
                    int nuevaFechaIni=sc.nextInt();
                    System.out.println("introduzca la nueva fecha de fin del prestamo");
                    int nuevaFechaFin=sc.nextInt();
                    System.out.println("introduzca el nuevo id del usuario");
                    int nuevoIdUsuario=sc.nextInt();
                    System.out.println("introduzca el nuevo id del libro");
                    int nuevoIdLibro=sc.nextInt();
                    Prestamo prestamoMod=new Prestamo(idmod,nuevaFechaIni, nuevaFechaFin,nuevoIdUsuario,nuevoIdLibro);

                    daoprestamo.upgradePrestamo(prestamoMod);
                    break;
                case 4:
                    System.out.println("Eliminar prestamo");
                    System.out.println("introduzca el id del prestamo");
                    int iddell=sc.nextInt();
                    daoprestamo.deletePrestamo(iddell);
                    break;
            }
        }while (opc!=5);
    }
}
