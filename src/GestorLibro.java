public class GestorLibro {
    private Libro[] libro_array;
    private Usuario[] usuario_prestamos;
    private Libro[] auxilaLibros_prestamos;

    private int aumento_secuencial;
    private int aumento_secuencial_prestamos;
    private final int MAX = 100;

    public GestorLibro() {

        libro_array = new Libro[MAX];
        usuario_prestamos = new Usuario[MAX];
        auxilaLibros_prestamos = new Libro[MAX];
        aumento_secuencial = 0;
        aumento_secuencial_prestamos = 0;

    }

    public void agregar_Libros_nuevos(Libro libro) {

        if (aumento_secuencial < MAX) {
            libro_array[aumento_secuencial] = libro;
            aumento_secuencial++;

        }

    }

    public void prestar_libro(Usuario usuario, String id) {

        int x = 0;

        Libro lib = new Libro();

        for (int i = 0; i < aumento_secuencial; i++) {
            if (libro_array[i].equals(id)) {

                x = libro_array[i].getStock();
                libro_array[i].setStock(x--);

                ////////////////////////////////////7
                /// 
                /// 
                /// 

                lib.setNombre_Libro(libro_array[i].getNombre_Libro());
 
                
                usuario_prestamos[aumento_secuencial_prestamos] = usuario;
                auxilaLibros_prestamos[aumento_secuencial_prestamos] = lib;
                aumento_secuencial_prestamos++;




            }
        }

    }

    public int buscarIndicePorDNI(String dni) {
        for (int i = 0; i < aumento_secuencial; i++) {
            if (libro_array[i].getId_libro().equals(dni)) {
                return i;
            }
        }
        return -1;
    }

    public boolean eliminar_Libro(String dni) {

        int posicion = buscarIndicePorDNI(dni);

        if (posicion != -1) {
            for (int i = posicion + 1; i < aumento_secuencial; i++) {
                libro_array[i - 1] = libro_array[i];
            }
            return true;
        }
        return false;

    }

    public Libro buscar_Libro(String nombreLibro, String autorLibro, String categoria) {

        for (int i = 0; i < aumento_secuencial; i++) {

            if (libro_array[i].getNombre_Libro().equals(nombreLibro) || libro_array[i].getAutor().equals(autorLibro)
                    || libro_array[i].getCategoria().equals(categoria)) {

                return libro_array[i];

            }

        }

        return null;

    }

    public String mostrar() {

        String todos_los_libros = "";

        for (int i = 0; i < aumento_secuencial; i++) {

            if (libro_array[i].getNombre_Libro() == null) {
                todos_los_libros += "";
            } else {

                todos_los_libros += " Nombre del Libro:  " + libro_array[i].getNombre_Libro() + "  Nombre del autor: "
                        + libro_array[i].getAutor() + " Nombre de la categoría: "
                        + libro_array[i].getCategoria() + "\n";
            }

        }

        return todos_los_libros;

    }

    public Libro[] todos_los_libros() {

        return libro_array;

    }

    public int indice_incremento_servicioLibro() {
        return aumento_secuencial;
    }

}
