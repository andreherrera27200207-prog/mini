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
                            System.out.print("Introduce parte del nombre del libro: ");
                            String textoBusqueda = sc.nextLine();

                            int[] resultados = g_Biblioteca.g_libro.buscarLibrosPorNombre(textoBusqueda);

                            if (resultados == null) {
                                System.out.println("No se encontraron libros que contengan: " + textoBusqueda);
                            } else {
                                System.out.println("Libros encontrados:");
                                for (int i = 0; i < resultados.length; i++) {
                                    Libro libroEncontrado = g_Biblioteca.g_libro.todos_los_libros()[resultados[i]];
                                    System.out.println((i) + ". " + libroEncontrado.getNombre_Libro() + " - " + libroEncontrado.getAutor() + " - ID: " + libroEncontrado.getId_libro());
                                }

                                System.out.print("Elige el número del libro que quieres: ");
                                int elegido = Integer.parseInt(sc.nextLine());
                                
                                if (elegido >= 0 && elegido < resultados.length) {
                                    Libro libroElegido = g_Biblioteca.g_libro.todos_los_libros()[resultados[elegido]];
                                    System.out.println("Has seleccionado: " + libroElegido.getNombre_Libro() + " - " + libroElegido.getAutor());
                                } else {
                                    System.out.println("Número inválido.");
                                }
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
                            String prestamos = g_Biblioteca.mostrar_prueba();

                            if (prestamos.equals("")) {
                                System.out.println("No hay ningún libro prestado actualmente.");
                            } else {
                                System.out.println("--- Libros Prestados ---");
                                System.out.println(prestamos);
                            }
                            break;
                        
                        case "9":
                            System.out.println("--- Pedir prestado un ibro ---");

                            System.out.print("Introduce parte del nombre del libro: ");
                            String textoBusquedaPrestado = sc.nextLine();

                            int[] resultadosPrestados = g_Biblioteca.g_libro.buscarLibrosPorNombre(textoBusquedaPrestado);

                            if (resultadosPrestados == null) {
                                System.out.println("No se encontraron libros que contengan: " + textoBusquedaPrestado);
                            } else {
                                System.out.println("Libros encontrados:");
                                for (int i = 0; i < resultadosPrestados.length; i++) {
                                    Libro libroEncontrado = g_Biblioteca.g_libro.todos_los_libros()[resultadosPrestados[i]];
                                    System.out.println((i) + ". " + libroEncontrado.getNombre_Libro() + " - " + libroEncontrado.getAutor() + " - ID: " + libroEncontrado.getId_libro());
                                }

                                System.out.print("Elige el número del libro que quieres: ");
                                int elegido = Integer.parseInt(sc.nextLine());
                                
                                if (elegido >= 0 && elegido < resultadosPrestados.length) {
                                    Libro libroElegido = g_Biblioteca.g_libro.todos_los_libros()[resultadosPrestados[elegido]];
                                    //pedir prestado usando el id del libro con el login actual
                                    String nombre = gUsuarios.getUsuarioEn(usuarioLogueado).getNombre();
                                    g_Biblioteca.coger_prestados_libros_biblioteca(nombre, libroElegido.getId_libro());
                                    System.out.println("Has pedido prestado: " + libroElegido.getNombre_Libro() + " - " + libroElegido.getAutor());
                                } else {
                                    System.out.println("Número inválido.");
                                }
                            }

                            break;

                        case "10":
                            System.out.println("--- Devolver un libro ---");
                            int[] prestamosUsuario = g_Biblioteca.g_libro.buscarLibrosPrestadosPorUsuario(gUsuarios.getUsuarioEn(usuarioLogueado).getNombre());
                                                    
                            if (prestamosUsuario == null) {
                                System.out.println("No tienes libros prestados actualmente.");
                            } else {
                                System.out.println("Tus libros prestados:");
                                for (int i = 0; i < prestamosUsuario.length; i++) {
                                    Libro libroPrestadaos = g_Biblioteca.g_libro.mostrar_prueba_libro()[prestamosUsuario[i]];
                                    System.out.println(i + ". " + libroPrestadaos.getNombre_Libro() + " - " + libroPrestadaos.getAutor() + " - ID: " + libroPrestadaos.getId_libro());
                                }
                            
                                System.out.print("Elige el número del libro que deseas devolver: ");
                                int elegido = Integer.parseInt(sc.nextLine());
                            
                                if (elegido >= 0 && elegido < prestamosUsuario.length) {
                                    String idLibro = g_Biblioteca.g_libro.mostrar_prueba_libro()[prestamosUsuario[elegido]].getId_libro();
                                    boolean devuelto = g_Biblioteca.devolver_libros_biblioteca(idLibro);
                                
                                    if (devuelto) {
                                        System.out.println("Libro devuelto correctamente: " + g_Biblioteca.g_libro.mostrar_prueba_libro()[prestamosUsuario[elegido]].getNombre_Libro());
                                    } else {
                                        System.out.println("Error al devolver el libro.");
                                    }
                                } else {
                                    System.out.println("Número inválido.");
                                }
                            }
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
                            System.out.print("Introduce parte del nombre del libro: ");
                            String textoBusqueda = sc.nextLine();

                            int[] resultados = g_Biblioteca.g_libro.buscarLibrosPorNombre(textoBusqueda);

                            if (resultados == null) {
                                System.out.println("No se encontraron libros que contengan: " + textoBusqueda);
                            } else {
                                System.out.println("Libros encontrados:");
                                for (int i = 0; i < resultados.length; i++) {
                                    Libro libroEncontrado = g_Biblioteca.g_libro.todos_los_libros()[resultados[i]];
                                    System.out.println((i) + ". " + libroEncontrado.getNombre_Libro() + " - " + libroEncontrado.getAutor() + " - ID: " + libroEncontrado.getId_libro());
                                }

                                System.out.print("Elige el número del libro que quieres: ");
                                int elegido = Integer.parseInt(sc.nextLine());
                                
                                if (elegido >= 0 && elegido < resultados.length) {
                                    Libro libroElegido = g_Biblioteca.g_libro.todos_los_libros()[resultados[elegido]];
                                    System.out.println("Has seleccionado: " + libroElegido.getNombre_Libro() + " - " + libroElegido.getAutor());
                                } else {
                                    System.out.println("Número inválido.");
                                }
                            }
                            break;

                        case "2":
                            System.out.println("--- Libros Disponibles ---");
                            System.out.println(g_Biblioteca.mostrar_libro());
                            break;

                        case "3":
                            System.out.println("--- Pedir prestado un ibro ---");

                            System.out.print("Introduce parte del nombre del libro: ");
                            String textoBusquedaPrestado = sc.nextLine();

                            int[] resultadosPrestados = g_Biblioteca.g_libro.buscarLibrosPorNombre(textoBusquedaPrestado);

                            if (resultadosPrestados == null) {
                                System.out.println("No se encontraron libros que contengan: " + textoBusquedaPrestado);
                            } else {
                                System.out.println("Libros encontrados:");
                                for (int i = 0; i < resultadosPrestados.length; i++) {
                                    Libro libroEncontrado = g_Biblioteca.g_libro.todos_los_libros()[resultadosPrestados[i]];
                                    System.out.println((i) + ". " + libroEncontrado.getNombre_Libro() + " - " + libroEncontrado.getAutor() + " - ID: " + libroEncontrado.getId_libro());
                                }

                                System.out.print("Elige el número del libro que quieres: ");
                                int elegido = Integer.parseInt(sc.nextLine());
                                
                                if (elegido >= 0 && elegido < resultadosPrestados.length) {
                                    Libro libroElegido = g_Biblioteca.g_libro.todos_los_libros()[resultadosPrestados[elegido]];
                                    //pedir prestado usando el id del libro con el login actual
                                    String nombre = gUsuarios.getUsuarioEn(usuarioLogueado).getNombre();
                                    g_Biblioteca.coger_prestados_libros_biblioteca(nombre, libroElegido.getId_libro());
                                    System.out.println("Has pedido prestado: " + libroElegido.getNombre_Libro() + " - " + libroElegido.getAutor());
                                } else {
                                    System.out.println("Número inválido.");
                                }
                            }
                            break;

                        case "4":
                            System.out.println("--- Devolver un libro ---");
                            int[] prestamosUsuario = g_Biblioteca.g_libro.buscarLibrosPrestadosPorUsuario(gUsuarios.getUsuarioEn(usuarioLogueado).getNombre());
                                                    
                            if (prestamosUsuario == null) {
                                System.out.println("No tienes libros prestados actualmente.");
                            } else {
                                System.out.println("Tus libros prestados:");
                                for (int i = 0; i < prestamosUsuario.length; i++) {
                                    Libro libroPrestadaos = g_Biblioteca.g_libro.mostrar_prueba_libro()[prestamosUsuario[i]];
                                    System.out.println(i + ". " + libroPrestadaos.getNombre_Libro() + " - " + libroPrestadaos.getAutor() + " - ID: " + libroPrestadaos.getId_libro());
                                }
                            
                                System.out.print("Elige el número del libro que deseas devolver: ");
                                int elegido = Integer.parseInt(sc.nextLine());
                            
                                if (elegido >= 0 && elegido < prestamosUsuario.length) {
                                    String idLibro = g_Biblioteca.g_libro.mostrar_prueba_libro()[prestamosUsuario[elegido]].getId_libro();
                                    boolean devuelto = g_Biblioteca.devolver_libros_biblioteca(idLibro);
                                
                                    if (devuelto) {
                                        System.out.println("Libro devuelto correctamente: " + g_Biblioteca.g_libro.mostrar_prueba_libro()[prestamosUsuario[elegido]].getNombre_Libro());
                                    } else {
                                        System.out.println("Error al devolver el libro.");
                                    }
                                } else {
                                    System.out.println("Número inválido.");
                                }
                            }

                            
                            break;

                        case "5":
                            String prestamos = g_Biblioteca.mostrar_prueba();
                                                    
                            if (prestamos.equals("")) {
                                System.out.println("No hay ningún libro prestado actualmente.");
                            } else {
                                System.out.println("--- Libros Prestados ---");
                                System.out.println(prestamos);
                            }
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