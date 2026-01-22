/**
 * @author Pablo Iglesias
 */

public class GestorUsuarios {
    private Usuario[] usuarios;
    private final int MAX =100;
    private int totalUsuarios;

    public GestorUsuarios(){
        this.usuarios = new Usuario[MAX];
        this.totalUsuarios=0;
    }

    //Registrar usuario, solo puede hacerlo el admin
    public boolean registrarUsuarios(String nombre, String contrasena, boolean admin){
        //comprobar que hay espacio en el array
        if (totalUsuarios >= MAX){
            return false;
        }

        //registrar el nuevo usuario
        int id = totalUsuarios+1;
        Usuario nuevoUsuario = new Usuario(id, nombre, contrasena, admin);

        usuarios[totalUsuarios]= nuevoUsuario;
        totalUsuarios++;
        return true;
    }
}
