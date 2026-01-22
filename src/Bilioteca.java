import java.util.Scanner;

/**
 * @author Pablo
 * @author Fabricio
 */
public class Bilioteca { 
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GestorUsuarios gUsuarios = new GestorUsuarios();
        GestorBiblioteca g_Biblioteca = new GestorBiblioteca();

        //Libros guardados de prueba
        g_Biblioteca.agregar_libros_biblioteca("1234", "Jair", "Juego 1", "Romance");
        g_Biblioteca.agregar_libros_biblioteca("1345", "Eddy", "juego2", "Accion");
        g_Biblioteca.agregar_libros_biblioteca("1367", "Santiago", "Juego3", "Documental");
        g_Biblioteca.agregar_libros_biblioteca("1789", "Ernesto", "Juego4", "Romance");
        g_Biblioteca.agregar_libros_biblioteca("1965", "Jhosue", "Juego5", "Accion");
        g_Biblioteca.agregar_libros_biblioteca("1978", "Arnaldo", "Juego6", "Ciencia Ficción");
        g_Biblioteca.agregar_libros_biblioteca("1990", "Mitchell", "Juego7", "Romance");
        g_Biblioteca.agregar_libros_biblioteca("1922", "Gianny", "Juego8", "Accion");
        g_Biblioteca.agregar_libros_biblioteca("1897", "Ana", "Juego9", "Documental");
        g_Biblioteca.agregar_libros_biblioteca("1854", "Camila", "Juego9", "Romance");
        g_Biblioteca.agregar_libros_biblioteca("1123", "Rocio", "Juego10", "Ciencia Ficción");
        g_Biblioteca.agregar_libros_biblioteca("1115", "Pilar", "Juego11", "Documental");

         //Usuarios guardados de prueba
        gUsuarios.registrarUsuarios("admin", "admin", true);
        gUsuarios.registrarUsuarios("pablo", "abcd", true);
        gUsuarios.registrarUsuarios("fabricio", "1234", true);
        gUsuarios.registrarUsuarios("pedro", "1234", false);
        gUsuarios.registrarUsuarios("alberto", "abcd", false);
        gUsuarios.registrarUsuarios("maría", "4321", false);
        gUsuarios.registrarUsuarios("ana", "1234", false);
        gUsuarios.registrarUsuarios("juana", "abcd", false);
        gUsuarios.registrarUsuarios("roberto", "4321", false);
        gUsuarios.registrarUsuarios("irene", "1234", false);
        gUsuarios.registrarUsuarios("jose", "abcd", false);
        gUsuarios.registrarUsuarios("angel", "4321", false);

        //--------------------------------Login---------------------------------------
        int usuarioLogueado =-1;
        boolean logueado = false;
        while(!logueado){
            System.out.println("----Login----");
            System.out.println("Usuario: ");
            String nombre = sc.nextLine();
            System.out.println("Contraseña: ");
            String contrasena= sc.nextLine();

            usuarioLogueado = gUsuarios.login(nombre, contrasena);
            if(usuarioLogueado!= -1){
                System.out.println("¡Login correcto! Bienvenido "+ gUsuarios.getUsuarioEn(usuarioLogueado).getNombre());
                logueado = true;
            }else{
                System.out.println("Usuario o contraseña incorrectos, inténtalo de nuevo");
            }

            
        }

    }
}