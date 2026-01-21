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

    public String mostrar_libro() {

        String frase = "";

        for (int i = 0; i < g_libro.indice_incremento_servicioLibro(); i++) {

            frase += g_libro.todos_los_libros()[i].getId_libro() + " " + g_libro.todos_los_libros()[i].getNombre_Libro()
                    + " " + g_libro.todos_los_libros()[i].getAutor() + " "
                    + g_libro.todos_los_libros()[i].getCategoria() + "\n";

        }

        return frase;

    }

}
