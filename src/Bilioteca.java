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

        // Libros guardados de prueba
        g_Biblioteca.agregar_libros_biblioteca("1001", "Cien años de soledad", "Gabriel García Márquez", "Novela");
        g_Biblioteca.agregar_libros_biblioteca("1002", "Don Quijote de la Mancha", "Miguel de Cervantes", "Clásico");
        g_Biblioteca.agregar_libros_biblioteca("1003", "1984", "George Orwell", "Ciencia Ficción");
        g_Biblioteca.agregar_libros_biblioteca("1004", "Fahrenheit 451", "Ray Bradbury", "Ciencia Ficción");
        g_Biblioteca.agregar_libros_biblioteca("1005", "El señor de los anillos", "J.R.R. Tolkien", "Fantasía");
        g_Biblioteca.agregar_libros_biblioteca("1006", "Harry Potter y la piedra filosofal", "J.K. Rowling", "Fantasía");
        g_Biblioteca.agregar_libros_biblioteca("1007", "Crónica de una muerte anunciada", "Gabriel García Márquez", "Novela");
        g_Biblioteca.agregar_libros_biblioteca("1008", "La sombra del viento", "Carlos Ruiz Zafón", "Misterio");
        g_Biblioteca.agregar_libros_biblioteca("1009", "El código Da Vinci", "Dan Brown", "Thriller");
        g_Biblioteca.agregar_libros_biblioteca("1010", "Los juegos del hambre", "Suzanne Collins", "Ciencia Ficción");
        g_Biblioteca.agregar_libros_biblioteca("1011", "El principito", "Antoine de Saint-Exupéry", "Fábula");
        g_Biblioteca.agregar_libros_biblioteca("1012", "La metamorfosis", "Franz Kafka", "Clásico");


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

        // --------------------------------Login---------------------------------------
        int usuarioLogueado = -1;
        boolean logueado = false;
        boolean logueado2 = false;

        while (!logueado2) {
            while (!logueado) {
                System.out.println("----Login----");
                System.out.println("Usuario: ");
                String nombre = sc.nextLine();
                System.out.println("Contraseña: ");
                String contrasena = sc.nextLine();

                usuarioLogueado = gUsuarios.login(nombre, contrasena);
                if (usuarioLogueado != -1) {
                    System.out.println(
                            "¡Login correcto! Bienvenido " + gUsuarios.getUsuarioEn(usuarioLogueado).getNombre());
                    logueado = true;
                } else {
                    System.out.println("Usuario o contraseña incorrectos, inténtalo de nuevo");
                }
            }
            // -----------------------------Menú principal-------------------------
            boolean salir = false;
            while (!salir) {
                Usuario u = gUsuarios.getUsuarioEn(usuarioLogueado);

                if (u.isAdmin()) {
                    // Menú admin
                    System.out.println("--- Menú Admin ---");
                    System.out.println("1. Agregar libro");
                    System.out.println("2. Eliminar libro");
                    System.out.println("3. Buscar libro");
                    System.out.println("4. Mostrar todos los libros");
                    System.out.println("5. Registrar usuario");
                    System.out.println("6. Consultar usuarios");
                    System.out.println("7. Eliminar usuario");
                    System.out.println("8. Mostrar libros prestados");
                    System.out.println("9. Pedir prestado un libro");
                    System.out.println("10. Devolver libro");
                    System.out.println("11. Libro más prestado");
                    System.out.println("12. Usuario que más solicito");
                    System.out.println("13. Mostrar cantidad de prestamos activos");
                    System.out.println("14. Salir de este usuario");
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
                            if (ok) {
                                System.out.println("Libro eliminado.");
                            } else {
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
                            String cLibro = sc.nextLine();
                            Libro libro = g_Biblioteca.g_libro.buscar_Libro(nLibro, aLibro, cLibro);
                            if (libro != null) {
                                System.out.println("Libro encontrado: " + libro.getNombre_Libro() + " - "
                                        + libro.getAutor() + " - " + libro.getCategoria());
                            } else {
                                System.out.println("No se encontró ningún libro.");
                            }
                            break;

                        case "4":
                            System.out.println("--- Libros Disponibles ---");
                            System.out.println(g_Biblioteca.mostrar_libro());
                            break;

                        case "5":
                            System.out.println("--- Registrar Usuario ---");
                            System.out.print("Nombre usuario: ");
                            String nUsuario = sc.nextLine();
                            System.out.print("Contraseña: ");
                            String passUsuario = sc.nextLine();
                            System.out.print("Admin? (true/false): ");
                            boolean esAdmin = Boolean.parseBoolean(sc.nextLine());
                            boolean registrado = gUsuarios.registrarUsuarios(nUsuario, passUsuario, esAdmin);
                            if (registrado)
                                System.out.println("Usuario registrado.");
                            else
                                System.out.println("No se pudo registrar (base de datos llena).");
                            break;

                        case "6":
                            System.out.println("--- Usuarios Registrados ---");
                            for (int i = 0; i < gUsuarios.getTotalUsuarios(); i++) {
                                Usuario user = gUsuarios.getUsuarioEn(i);
                                System.out.println(
                                        user.getId() + " - " + user.getNombre() + " - admin? " + user.isAdmin());
                            }
                            break;

                        case "7":
                            System.out.print("ID del usuario a eliminar: ");
                            int idEliminarUsuario = Integer.parseInt(sc.nextLine());
                            boolean eliminado = gUsuarios.eliminarUsuario(idEliminarUsuario);
                            if (eliminado) {
                                System.out.println("Usuario eliminado correctamente.");
                            } else {
                                System.out.println("No se encontró ningún usuario con ese ID.");
                            }
                            break;

                        case "8":
                            System.out.println("--- Libros Prestados ---");
                            System.out.println(g_Biblioteca.mostrar_prueba());

                            break;
                        
                        case "9":
                            System.out.println("--- Pedir prestado un ibro ---");
                            String nombre = gUsuarios.getUsuarioEn(usuarioLogueado).getNombre();
                            System.out.println("Introduce el ID del libro que quieres pedir prestado");
                            String id_libro = sc.nextLine();

                            g_Biblioteca.coger_prestados_libros_biblioteca(nombre, id_libro);

                            break;

                        case "10":
                            System.out.println("--- Devolver un libro ---");
                            System.out.println("Introduce el ID del libro que deseas devolver: ");
                            String id1 = sc.nextLine();

                            g_Biblioteca.devolver_libros_biblioteca(id1);

                            break;

                        case "11":
                            String libroMasPrestado = g_Biblioteca.libro_mas_prestado();

                            if (libroMasPrestado == null) {
                                System.out.println("No hay libros prestados todavía.");
                            } else {
                                System.out.println("Libro más prestado: " + libroMasPrestado);
                            }  
                            break;
                            
                        case "12":
                            
                            System.out.println("Usuario que más realizó prestamos: " + g_Biblioteca.usuario_que_mas_solicito());    
                            break;

                        case "13":
                            System.out.println("Cantidad de préstamos activos: " + g_Biblioteca.cantidad_prestamos());   
                            break; 
                        
                        case "14":
                            salir = true;
                            logueado = false;
                            break;
                        
                        case "0":
                            salir = true;
                            logueado = true;
                            logueado2 = true;
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                } else {
                    // Menú Usuario normal
                    System.out.println("--- Menú Usuario ---");
                    System.out.println("1. Buscar libro");
                    System.out.println("2. Mostrar todos los libros");
                    System.out.println("3. Pedir prestado un libro");
                    System.out.println("4. Devolver libro");
                    System.out.println("5. Mostrar lista de prestamos");
                    System.out.println("6. Libro más prestado");
                    System.out.println("7. Usuario que más solicito");
                    System.out.println("8. Mostrar cantidad de prestamos activos");
                    System.out.println("9. Salir de este usuario");
                    System.out.println("0. Salir definitivamente");
                    System.out.print("Opción: ");
                    String opcion = sc.nextLine();

                    switch (opcion) {
                        case "1":
                            System.out.print("Nombre: ");
                            String nBuscar = sc.nextLine();
                            System.out.print("Autor: ");
                            String aBuscar = sc.nextLine();
                            System.out.print("Categoría: ");
                            String cBuscar = sc.nextLine();
                            Libro libro = g_Biblioteca.g_libro.buscar_Libro(nBuscar, aBuscar, cBuscar);
                            if (libro != null) {
                                System.out.println("Libro encontrado: " + libro.getNombre_Libro() + " - "
                                        + libro.getAutor() + " - " + libro.getCategoria());
                            } else {
                                System.out.println("No se encontró ningún libro.");
                            }
                            break;

                        case "2":
                            System.out.println("--- Libros Disponibles ---");
                            System.out.println(g_Biblioteca.mostrar_libro());
                            break;

                        case "3":
                            System.out.println("--- Pedir prestado un ibro ---");
                            String nombre = gUsuarios.getUsuarioEn(usuarioLogueado).getNombre();
                            System.out.println("Introduce el ID del libro que quieres pedir prestado");
                            String id_libro = sc.nextLine();

                            g_Biblioteca.coger_prestados_libros_biblioteca(nombre, id_libro);

                            break;

                        case "4":
                            System.out.println("--- Devolver un libro ---");
                            System.out.println("Introduce el ID del libro que deseas devolver: ");
                            String id = sc.nextLine();

                            g_Biblioteca.devolver_libros_biblioteca(id);

                            break;

                        case "5":

                            System.out.println(g_Biblioteca.mostrar_prueba());

                            break;

                        case "6":
                            String libroMasPrestado = g_Biblioteca.libro_mas_prestado();

                            if (libroMasPrestado == null) {
                                System.out.println("No hay libros prestados todavía.");
                            } else {
                                System.out.println("Libro más prestado: " + libroMasPrestado);
                            }  
                            break;
                            
                        case "7":
                            
                            System.out.println("Usuario que más realizó prestamos: " + g_Biblioteca.usuario_que_mas_solicito());    
                            break;

                        case "8":
                            System.out.println("Cantidad de préstamos activos: " + g_Biblioteca.cantidad_prestamos());   
                            break; 

                        case "9":
                            salir = true;
                            logueado = false;
                            break;
                                                    
                        case "0":
                            
                            salir = true;
                            logueado = true;
                            logueado2 = true;
                            break;

                        default:
                            System.out.println("Opción no válida.");
                    }
                }
            }
        }

        System.out.println("¡Hasta luego!");
    }
}