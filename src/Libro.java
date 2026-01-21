public class Libro {
    private int id_libro;
    private String nombre_Libro;
    private String autor;
    private String categoria;

    public Libro() {
    }

    public Libro(int id_libro, String nombre_Libro, String autor, String categoria) {
        this.id_libro = id_libro;
        this.nombre_Libro = nombre_Libro;
        this.autor = autor;
        this.categoria = categoria;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getNombre_Libro() {
        return nombre_Libro;
    }

    public void setNombre_Libro(String nombre_Libro) {
        this.nombre_Libro = nombre_Libro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
