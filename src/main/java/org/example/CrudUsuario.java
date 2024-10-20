package org.example;

import java.util.List;
import java.util.Scanner;

public class CrudUsuario {
    DAOUsuario daoUsuario=new DAOUsuario();

    Scanner sc=new Scanner(System.in);

    public void menuUsuario(){
        int opc=0;
        do {
            System.out.println("MENU Usuario");
            System.out.println("1. Crear Usuario "+"2. Listar Usuarios "+"3. Modificar Usuario "+"4. Eliminar Usuario "+"5. Salir");
            opc=sc.nextInt();

            switch(opc){
                case 1:
                    System.out.println("Creacion de Usuario");
                    System.out.println("introduzca el id del Usuario");
                    int idUsuario=sc.nextInt();
                    System.out.println("introduzca el nombre del Usuario");
                    String nombreUsuario=sc.next();
                    Usuario usuario=new Usuario(idUsuario,nombreUsuario);
                    daoUsuario.InsertarUsuario(usuario);
                    break;

                case 2:
                    System.out.println("Listado de Usuarios");
                    List<Usuario> usuarios=daoUsuario.listar();
                    for(Usuario u:usuarios) {
                        System.out.println(u);
                    }
                    break;
                case 3:
                    System.out.println("Modificar Usuario");
                    System.out.println("introduzca el id del Usuario");
                    int idmod=sc.nextInt();
                    System.out.println("introduzca el nuevo nombre del Usuario");
                    String nomUser=sc.next();

                    Usuario userMod=new Usuario(idmod,nomUser);

                    daoUsuario.updateable(userMod);
                    break;
                case 4:
                    System.out.println("Eliminar Usuario");
                    System.out.println("introduzca el id del Usuario");
                    int iddell=sc.nextInt();
                    daoUsuario.Delet(iddell);
                    break;
            }
        }while (opc!=5);
    }
}
