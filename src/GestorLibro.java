/***
 * @author Fabricio
 */

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

    public void coger_prestado_libro(Usuario usuario, String id_libro) {

        int x = 0;

        Libro lib = new Libro();

        for (int i = 0; i < aumento_secuencial; i++) {
            if (libro_array[i].getId_libro().equals(id_libro)) {

                x = libro_array[i].getStock();
                libro_array[i].setStock(x - 1);

                //////////////////////////////////// 7
                ///
                ///
                ///

                lib.setNombre_Libro(libro_array[i].getNombre_Libro());
                lib.setId_libro(libro_array[i].getId_libro());

                usuario_prestamos[aumento_secuencial_prestamos] = usuario;
                auxilaLibros_prestamos[aumento_secuencial_prestamos] = lib;
                aumento_secuencial_prestamos++;

            }
        }

    }

    // Cambiado para devolver por id de libro--------------------------------
    public void devolver_libro(String id_libro) {

        if (id_libro == null) {
            return;
        }

        int posicionPrestamo = -1;
        boolean encontradoPrestamo = false;

        // Buscar el libro por id
        for (int i = 0; i < aumento_secuencial_prestamos && !encontradoPrestamo; i++) {
            if (auxilaLibros_prestamos[i].getId_libro().equals(id_libro)) {
                posicionPrestamo = i;
                encontradoPrestamo = true;
            }
        }

        if (!encontradoPrestamo) {
            System.out.println("Ese libro no está prestado.");
            return;
        }

        // Aumentar stock del libro devuelto
        boolean stockActualizado = false;

        for (int j = 0; j < aumento_secuencial && !stockActualizado; j++) {
            if (libro_array[j].getId_libro().equals(id_libro)) {
                libro_array[j].setStock(libro_array[j].getStock() + 1);
                stockActualizado = true;
            }
        }

        // Eliminar el préstamo del array
        for (int i = posicionPrestamo + 1; i < aumento_secuencial_prestamos; i++) {
            auxilaLibros_prestamos[i - 1] = auxilaLibros_prestamos[i];
            usuario_prestamos[i - 1] = usuario_prestamos[i];
        }

        aumento_secuencial_prestamos--;

        System.out.println("Libro devuelto correctamente.");
    }

    public String libro_más_prestados() {
        if (aumento_secuencial_prestamos == 0) {
            return null;
        }
        int x = 0;

        int indice = 0;

        for (int j = 0; j < aumento_secuencial_prestamos; j++) {
            int contador = 0;
            for (int i = 0; i < aumento_secuencial_prestamos; i++) {
                if (j != i) {
                    if (auxilaLibros_prestamos[j].getNombre_Libro()
                            .equals(auxilaLibros_prestamos[i].getNombre_Libro())) {

                        contador++;
                        if (x < contador) {
                            x = contador;
                            indice = j;

                        }

                    }

                }
            }
        }

        return auxilaLibros_prestamos[indice].getNombre_Libro();

    }

    public String Usuario_más_prestamos() {

        int x = 0;

        int indice = 0;

        for (int j = 0; j < aumento_secuencial_prestamos; j++) {
            int contador = 0;
            for (int i = 0; i < aumento_secuencial_prestamos; i++) {
                if (j != i) {
                    if (usuario_prestamos[j].getNombre()
                            .equals(usuario_prestamos[i].getNombre())) {

                        contador++;
                        if (x < contador) {
                            x = contador;
                            indice = j;

                        }

                    }

                }
            }
        }

        return usuario_prestamos[indice].getNombre();

    }



    public int cantidad_de_prestamos(){

        return aumento_secuencial_prestamos;
        

    }



    public int mostrar_aumento_secuencial() {

        return aumento_secuencial_prestamos;

    }

    public Libro[] mostrar_prueba_libro() {

        return auxilaLibros_prestamos;

    }

    public Usuario[] mostrar_prueba_usuario() {

        return usuario_prestamos;
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

            aumento_secuencial--;

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
                        + libro_array[i].getCategoria() + " STOCK:  " + libro_array[i].getStock() + "\n";
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
