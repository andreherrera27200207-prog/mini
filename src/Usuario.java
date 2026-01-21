/**
 * @author Pablo
 */
public class Usuario {
    private int id;
    private String nombre;
    private String contrasena;
    private boolean admin;
    
    public Usuario(int id, String nombre, String contrasena, boolean admin){
        this.id=id;
        this.nombre=nombre;
        this.contrasena=contrasena;
        this.admin=admin;
    }
}
