import java.util.Scanner;

/**
 * @author Pablo
 * @author Fabricio
 */
public class Bilioteca {
    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";

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
                System.out.println("\n----Login----");
                System.out.println("Usuario: ");
                String nombre = sc.nextLine();
                System.out.println("Contraseña: ");
                String contrasena = sc.nextLine();

                usuarioLogueado = gUsuarios.login(nombre, contrasena);
                if (usuarioLogueado != -1) {
                    System.out.println(VERDE+"¡Login correcto! Bienvenido " + gUsuarios.getUsuarioEn(usuarioLogueado).getNombre()+ RESET);
                    logueado = true;
                } else {
                    System.out.println(ROJO+ "Usuario o contraseña incorrectos, inténtalo de nuevo"+ RESET);
                }
            }
            // -----------------------------Menú principal-------------------------
            boolean salir = false;
            while (!salir) {
                Usuario u = gUsuarios.getUsuarioEn(usuarioLogueado);

                if (u.isAdmin()) {
                    // Menú admin
                    System.out.println(MORADO + "\n ════════ MENÚ ADMIN ════════" + RESET);
                    System.out.println(MORADO + "|   " + CYAN + "1." + RESET + " Agregar libro" + MORADO + "        |");
                    System.out.println(MORADO + "|   " + CYAN + "2." + RESET + " Eliminar libro" + MORADO + "       |");
                    System.out.println(MORADO + "|   " + CYAN + "3." + RESET + " Buscar libro" + MORADO + "         |");
                    System.out.println(MORADO + "|   " + CYAN + "4." + RESET + " Mostrar libros" + MORADO + "       |");
                    System.out.println(MORADO + "|   " + CYAN + "5." + VERDE + " Registrar usuario" + MORADO + "    |");
                    System.out.println(MORADO + "|   " + CYAN + "6." + VERDE + " Consultar usuarios" + MORADO + "   |");
                    System.out.println(MORADO + "|   " + CYAN + "7." + VERDE + " Eliminar usuario" + MORADO + "     |");
                    System.out.println(MORADO + "|   " + CYAN + "8." + RESET + " Mostrar prestados" + MORADO + "    |");
                    System.out.println(MORADO + "|   " + CYAN + "9." + RESET + " Pedir prestado" + MORADO + "       |");
                    System.out.println(MORADO + "|  " + CYAN + "10." + RESET + " Devolver libro" + MORADO + "       |");
                    System.out.println(MORADO + "|  " + CYAN + "11." + RESET + " Libro más prestado" + MORADO + "   |");
                    System.out.println(MORADO + "|  " + CYAN + "12." + VERDE + " Usuario más activo" + MORADO + "   |");
                    System.out.println(MORADO + "|  " + CYAN + "13." + RESET + " Préstamos activos" + MORADO + "    |");
                    System.out.println(MORADO + "|  " + AMARILLO + "14. Cerrar sesión" + MORADO + "        |");
                    System.out.println(MORADO + "|  " + ROJO + "0. Salir" + MORADO + "                 |");
                    System.out.println(MORADO + " ═══════════════════════════" + RESET);
                    System.out.print(CYAN + "Opción: " + RESET);

                    String opcion = sc.nextLine();
                    System.out.println("");
                    switch (opcion) {
                        case "1":
                            System.out.println(VERDE + "----Agregar libro----"+ RESET);
                            System.out.print("ID libro: ");
                            String id = sc.nextLine();
                            System.out.print("Nombre libro: ");
                            String nombreLibro = sc.nextLine();
                            System.out.print("Autor: ");
                            String autor = sc.nextLine();
                            System.out.print("Categoría: ");
                            String categoria = sc.nextLine();
                            g_Biblioteca.agregar_libros_biblioteca(id, nombreLibro, autor, categoria);
                            System.out.println(VERDE +"¡Libro agregado correctamente!"+ RESET);
                            break;

                        case "2":
                            System.out.println(ROJO + "----Eliminar libro----"+ RESET);
                            System.out.print("ID libro a eliminar: ");
                            String idEliminar = sc.nextLine();
                            boolean ok = g_Biblioteca.g_libro.eliminar_Libro(idEliminar);
                            if (ok) {
                                System.out.println(VERDE+ "Libro eliminado." + RESET);
                            } else {
                                System.out.println(ROJO+"No se encontró el libro."+ RESET);
                            }
                            break;

                        case "3":
                            System.out.println(VERDE + "----Buscar libro----"+ RESET);
                            System.out.print("Introduce parte del nombre del libro: ");
                            String textoBusqueda = sc.nextLine();

                            int[] resultados = g_Biblioteca.g_libro.buscarLibrosPorNombre(textoBusqueda);

                            if (resultados == null) {
                                System.out.println(ROJO +"No se encontraron libros que contengan: " + textoBusqueda +RESET);
                            } else {
                                System.out.println(VERDE+ "Libros encontrados:"+ RESET);
                                for (int i = 0; i < resultados.length; i++) {
                                    Libro libroEncontrado = g_Biblioteca.g_libro.todos_los_libros()[resultados[i]];
                                    System.out.println((i) + ". " + libroEncontrado.getNombre_Libro() + " - " + libroEncontrado.getAutor() + " - ID: " + libroEncontrado.getId_libro());
                                }

                                System.out.print("Elige el número del libro que quieres: ");
                                int elegido = Integer.parseInt(sc.nextLine());
                                
                                if (elegido >= 0 && elegido < resultados.length) {
                                    Libro libroElegido = g_Biblioteca.g_libro.todos_los_libros()[resultados[elegido]];
                                    System.out.println(VERDE+"Has seleccionado: " + libroElegido.getNombre_Libro() + " - " + libroElegido.getAutor()+RESET);
                                } else {
                                    System.out.println(ROJO+"Número inválido."+RESET);
                                }
                            }
                            break;

                        case "4":
                            System.out.println(VERDE+"---- Libros Disponibles ----"+RESET);
                            System.out.println(g_Biblioteca.mostrar_libro());
                            break;

                        case "5":
                            System.out.println(VERDE+"---- Registrar Usuario ----"+RESET);
                            System.out.print("Nombre usuario: ");
                            String nUsuario = sc.nextLine();
                            System.out.print("Contraseña: ");
                            String passUsuario = sc.nextLine();
                            System.out.print("Admin? (true/false): ");
                            boolean esAdmin = Boolean.parseBoolean(sc.nextLine());
                            boolean registrado = gUsuarios.registrarUsuarios(nUsuario, passUsuario, esAdmin);
                            if (registrado)
                                System.out.println(VERDE+"Usuario registrado."+RESET);
                            else
                                System.out.println(ROJO+"No se pudo registrar (base de datos llena)."+RESET);
                            break;

                        case "6":
                            System.out.println(VERDE+"---- Usuarios Registrados ----"+RESET);
                            for (int i = 0; i < gUsuarios.getTotalUsuarios(); i++) {
                                Usuario user = gUsuarios.getUsuarioEn(i);
                                System.out.println(
                                        user.getId() + " - " + user.getNombre() + " - admin? " + user.isAdmin());
                            }
                            break;

                        case "7":
                            System.out.println(ROJO+"---- Eliminar Usuarios ----"+RESET);
                            System.out.print("ID del usuario a eliminar: ");
                            int idEliminarUsuario = Integer.parseInt(sc.nextLine());
                            boolean eliminado = gUsuarios.eliminarUsuario(idEliminarUsuario);
                            if (eliminado) {
                                System.out.println(VERDE+"Usuario eliminado correctamente."+RESET);
                            } else {
                                System.out.println(ROJO+"No se encontró ningún usuario con ese ID."+RESET);
                            }
                            break;

                        case "8":
                            System.out.println(VERDE+"---- Mostrar prestados ----"+RESET);
                            String prestamos = g_Biblioteca.mostrar_prueba();

                            if (prestamos.equals("")) {
                                System.out.println(ROJO+"No hay ningún libro prestado actualmente."+RESET);
                            } else {
                                System.out.println(VERDE+"---- Libros Prestados ----"+RESET);
                                System.out.println(prestamos);
                            }
                            break;
                        
                        case "9":
                            System.out.println(VERDE+"---- Pedir prestado un ibro ----"+RESET);

                            System.out.print("Introduce parte del nombre del libro: ");
                            String textoBusquedaPrestado = sc.nextLine();

                            int[] resultadosPrestados = g_Biblioteca.g_libro.buscarLibrosPorNombre(textoBusquedaPrestado);

                            if (resultadosPrestados == null) {
                                System.out.println(ROJO+"No se encontraron libros que contengan: " + textoBusquedaPrestado+RESET);
                            } else {
                                System.out.println(VERDE+"Libros encontrados:"+RESET);
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
                                    System.out.println(VERDE+"Has pedido prestado: " + libroElegido.getNombre_Libro() + " - " + libroElegido.getAutor()+RESET);
                                } else {
                                    System.out.println(ROJO+"Número inválido."+RESET);
                                }
                            }

                            break;

                        case "10":
                            System.out.println(VERDE+ "---- Devolver un libro ----"+ RESET);
                            int[] prestamosUsuario = g_Biblioteca.g_libro.buscarLibrosPrestadosPorUsuario(gUsuarios.getUsuarioEn(usuarioLogueado).getNombre());
                                                    
                            if (prestamosUsuario == null) {
                                System.out.println(ROJO+"No tienes libros prestados actualmente."+RESET);
                            } else {
                                System.out.println(VERDE+"Tus libros prestados:"+RESET);
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
                                        System.out.println(VERDE+"Libro devuelto correctamente: " + g_Biblioteca.g_libro.mostrar_prueba_libro()[prestamosUsuario[elegido]].getNombre_Libro()+RESET);
                                    } else {
                                        System.out.println(ROJO+"Error al devolver el libro."+RESET);
                                    }
                                } else {
                                    System.out.println(ROJO+"Número inválido."+RESET);
                                }
                            }
                            break;
                            
                        case "11":
                            System.out.println(VERDE+ "---- Libro más prestado ----"+ RESET);
                            String libroMasPrestado = g_Biblioteca.libro_mas_prestado();

                            if (libroMasPrestado == null) {
                                System.out.println(ROJO+"No hay libros prestados todavía."+RESET);
                            } else {
                                System.out.println(VERDE+"Libro más prestado: " + libroMasPrestado+RESET);
                            }  
                            break;
                            
                        case "12":
                            System.out.println(VERDE+ "---- Usuario más activo ----"+ RESET);
                            System.out.println("Usuario que más realizó prestamos: " + g_Biblioteca.usuario_que_mas_solicito());    
                            break;

                        case "13":
                            System.out.println(VERDE+ "---- Prestamos activos ----"+ RESET);
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
                            System.out.println(ROJO+"Opción no válida."+RESET);
                    }
                } else {
                    // Menú Usuario normal
                    System.out.println(AZUL + "\n ══════ MENÚ USUARIO ══════" + RESET);
                    System.out.println(AZUL + "|   " + CYAN + "1." + RESET + " Buscar libro" + AZUL + "       |");
                    System.out.println(AZUL + "|   " +CYAN + "2." + RESET + " Mostrar libros"+ AZUL + "     |");
                    System.out.println(AZUL + "|   " +CYAN + "3." + RESET + " Pedir prestado"+ AZUL + "     |");
                    System.out.println(AZUL + "|   " +CYAN + "4." + RESET + " Devolver libro"+ AZUL + "     |");
                    System.out.println(AZUL + "|   " +CYAN + "5." + RESET + " Ver préstamos" + AZUL + "      |");
                    System.out.println(AZUL + "|   " +CYAN + "6." + RESET + " Libro más prestado" + AZUL + " |");
                    System.out.println(AZUL + "|   " +CYAN + "7." + VERDE + " Usuario más activo"+ AZUL+ " |");
                    System.out.println(AZUL + "|   " +CYAN + "8." + VERDE + " Préstamos activos"+ AZUL+ "  |");
                    System.out.println(AZUL + "|   " +AMARILLO + "9. Cerrar sesión"+ AZUL + "      |");
                    System.out.println(AZUL + "|   " +ROJO + "0. Salir"  + AZUL + "              |");
                    System.out.println(AZUL +" ══════════════════════════");
                    System.out.print(CYAN + "Opción: "+ RESET);


                    String opcion = sc.nextLine();

                    switch (opcion) {
                        case "1":
                            System.out.print("\nIntroduce parte del nombre del libro: ");
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
                            System.out.println("\n--- Libros Disponibles ---");
                            System.out.println(g_Biblioteca.mostrar_libro());
                            break;

                        case "3":
                            System.out.println("\n--- Pedir prestado un ibro ---");

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