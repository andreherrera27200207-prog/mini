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

            //Menú principal-------------------------
            boolean salir= false;

            while(!salir){
                Usuario u =gUsuarios.getUsuarioEn(usuarioLogueado);

                
                if (u.isAdmin()) {
                    //Menú admin
                    System.out.println("--- Menú Admin ---");
                    System.out.println("1. Agregar libro");
                    System.out.println("2. Eliminar libro");
                    System.out.println("3. Buscar libro");
                    System.out.println("4. Mostrar todos los libros");
                    System.out.println("5. Registrar usuario");
                    System.out.println("6. Consultar usuarios");
                    System.out.println("0. Salir");
                    System.out.print("Opción: ");
                    String opcion = sc.nextLine();
                    System.out.println("");

                    switch (opcion) {
                        case "1":
                            System.out.println("1- Agregar libro");
                            System.out.print("ID libro: ");
                            String id = sc.nextLine();
                            System.out.print("Nombre libro: ");
                            String nombreLibro = sc.nextLine();
                            System.out.print("Autor: ");
                            String autor = sc.nextLine();
                            System.out.print("Categoría: ");
                            String categoria = sc.nextLine();

                            g_Biblioteca.agregar_libros_biblioteca(id, nombreLibro, autor, categoria);
                            System.out.println("¡Libro agregado correctamente!");
                            break;

                        case "2":
                            System.out.print("ID libro a eliminar: ");
                            String idEliminar = sc.nextLine();
                            boolean ok = g_Biblioteca.g_libro.eliminar_Libro(idEliminar);
                            if (ok){
                                System.out.println("Libro eliminado.");
                            }else{
                                System.out.println("No se encontró el libro.");
                            }
                            break;

                        case "3":
                            System.out.println("3- Buscar libro");
                            System.out.print("Nombre: ");
                            String nLibro = sc.nextLine();
                            System.out.print("Autor): ");
                            String aLibro = sc.nextLine();
                            System.out.print("Categoría: ");
                            String cLibro= sc.nextLine();

                            Libro libro = g_Biblioteca.g_libro.buscar_Libro(nLibro, aLibro, cLibro);
                            if (libro != null) {
                                System.out.println("Libro encontrado: " + libro.getNombre_Libro() + " - " + libro.getAutor() + " - " + libro.getCategoria());
                            } else {
                                System.out.println("No se encontró ningún libro.");
                            }
                            break;

                        case "4":
                            System.out.println("--- Libros Disponibles ---");
                            System.out.println(g_Biblioteca.mostrar_libro());
                            break;

                        case "5":
                            System.out.print("Nombre usuario: ");
                            String nUsuario = sc.nextLine();
                            System.out.print("Contraseña: ");
                            String passUsuario = sc.nextLine();
                            System.out.print("Admin? (true/false): ");
                            boolean esAdmin = Boolean.parseBoolean(sc.nextLine());

                            boolean registrado = gUsuarios.registrarUsuarios(nUsuario, passUsuario, esAdmin);
                            if (registrado) System.out.println("Usuario registrado.");
                            else System.out.println("No se pudo registrar (base de datos llena).");
                            break;

                        case "6":


                        case "0":
                            salir = true;
                            break;

                        default:
                            System.out.println("Opción no válida.");
                    }
                }
            }

        }

    }
}