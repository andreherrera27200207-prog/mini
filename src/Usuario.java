/**
 * @author Pablo
 */
public class Usuario {
    private int id;
    private String nombre;
    private String contrasena;
    private boolean admin;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String contrasena, boolean admin) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

}
