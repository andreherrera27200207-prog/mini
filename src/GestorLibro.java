public class GestorLibro {
    private Libro[] libro_array;
    private Libro[] auxilaLibros;

    private int aumento_secuencial;


    public GestorLibro(int capacidad) {

        libro_array = new Libro[capacidad];
        auxilaLibros = new Libro[capacidad];
        aumento_secuencial = 0;

    }

    public void agregar_Libros_nuevos(String nombreLibro, String autorLibro, String categoria) {

        Libro lib = new Libro();
   
        lib.setNombre_Libro(nombreLibro);
        lib.setAutor(autorLibro);
        lib.setCategoria(categoria);

        libro_array[aumento_secuencial] = lib;
        aumento_secuencial++;

    }


    public void eliminar_Libro(String nombre) {

        for (int i = 0; i < aumento_secuencial; i++) {

            if (libro_array[i].getNombre_Libro().equals(nombre)) {

                libro_array[i].setNombre_Libro(null);
                libro_array[i].setAutor(null);
                libro_array[i].setCategoria(null);

            }

        }

    }

    public String buscar_Libro(String nombreLibro, String autorLibro, String categoria) {

        String retorno = "";

        for (int i = 0; i < aumento_secuencial; i++) {

            if (libro_array[i].getNombre_Libro().equals(nombreLibro) || libro_array[i].getAutor().equals(autorLibro)
                    || libro_array[i].getCategoria().equals(categoria)) {

                retorno = libro_array[i].getNombre_Libro() + libro_array[i].getAutor() + libro_array[i].getCategoria();

            }

        }

        return retorno;

    }


    public String mostrar() {

        String todos_los_libros = "";

        for (int i = 0; i < aumento_secuencial; i++) {

            if (libro_array[i].getNombre_Libro() == null) {
                todos_los_libros += "";
            } else {

                todos_los_libros += " Nombre del Libro:  " + libro_array[i].getNombre_Libro() + "  Nombre del autor: " + libro_array[i].getAutor() + " Nombre de la categoría: "
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
