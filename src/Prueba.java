import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GestorUsuarios gUsuarios = new GestorUsuarios();
        GestorBiblioteca g_Biblioteca = new GestorBiblioteca();

        // Libros guardados de prueba
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

        // Usuarios guardados de prueba
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

        System.out.println("LIBROS DISPONIBLES:");
        System.out.println("                            ");
        System.out.println(g_Biblioteca.mostrar_libro());

        int x = -1;

        while (x != 0) {

            System.out.println("ELIJA SU OPCIÓN");
            System.out.println("1- PEDIR PRESTAMO");
            System.out.println("2- DEVOLVER");
            System.out.println("3- MOSTRAR LISTA DE PRESTAMOS");
            System.out.println("4- MOSTRAR STOCK DE LIBROS");
            System.out.println("0- SALIR");

            x = Integer.parseInt(sc.nextLine());

            switch (x) {
                case 1:
                    System.out.println("COMO TE LLAMAS Y QUE LIBRO QUIERES ESCOGER?");
                    String nombre = sc.nextLine();
                    System.out.println("Escoge el libro");
                    String id_libro = sc.nextLine();

                    g_Biblioteca.coger_prestados_libros_biblioteca(nombre, id_libro);

                    break;


                case 2:

                    System.out.println("NOMBRE DEL USUARIO QUE VA DEVOLVER");
                    String name = sc.nextLine();

                    g_Biblioteca.devolver_libros_biblioteca(name);
                    
                
                   break;

                case 3:

                    System.out.println(g_Biblioteca.mostrar_prueba());

                    break;
                case 4:

                    System.out.println(g_Biblioteca.mostrar_libro());

                default:
                    break;
            }

        }

        
    }
}
