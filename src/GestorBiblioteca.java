import java.util.Random;

public class GestorBiblioteca {
    private Libro[] GestorLibro;

    private int aumento_secuencial;
    private final int MAX = 100;

    GestorLibro g_libro = new GestorLibro();

    public GestorBiblioteca() {
        GestorLibro = new Libro[MAX];
        aumento_secuencial = 0;
    }

    public void agregar_libros_biblioteca(String id, String nombre_libro, String autor, String categoria) {

        Libro libro = new Libro();
        libro.setId_libro(id);
        libro.setNombre_Libro(nombre_libro);
        libro.setAutor(autor);
        libro.setCategoria(categoria);

        g_libro.agregar_Libros_nuevos(libro);

    }

    public void coger_prestados_libros_biblioteca(String nombre_usuario, String id_libro) {

        Random r = new Random();

        int x = r.nextInt(300) + 100;

        Usuario usuario = new Usuario(x, nombre_usuario, "-", false);

        g_libro.coger_prestado_libro(usuario, id_libro);

    }



    public void devolver_libros_biblioteca(String nombre_Usuario){

        g_libro.devolver_libro(nombre_Usuario);

    }



    public String mostrar_prueba() {

        String frase = "";

        for (int i = 0; i < g_libro.mostrar_aumento_secuencial(); i++) {

            frase += "USUARIO: "+  g_libro.mostrar_prueba_usuario()[i].getNombre() + "\n"
                    + "LIBRO: " +g_libro.mostrar_prueba_libro()[i].getNombre_Libro() + "\n";

        }

        return frase;

    }

    public String mostrar_libro() {

        String frase = "";

        for (int i = 0; i < g_libro.indice_incremento_servicioLibro(); i++) {

            frase += "ID: " + g_libro.todos_los_libros()[i].getId_libro() + " " + " TITULO: " +g_libro.todos_los_libros()[i].getNombre_Libro()
                    + " AUTOR: " + g_libro.todos_los_libros()[i].getAutor() + " "
                    + g_libro.todos_los_libros()[i].getCategoria() + "  STOCK: " + g_libro.todos_los_libros()[i].getStock()
                    + "\n";

        }

        return frase;

    }

}
