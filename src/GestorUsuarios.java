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

    //Para listar usuarios:
    //Decirle al main cuantos usuarios tenemos
    public int getTotalUsuarios(){
        return totalUsuarios;
    }

    //Devolver un usuario
    public Usuario getUsuarioEn (int posicion){
        if(posicion<0 || posicion>=totalUsuarios){
            return null;
        }
        return usuarios[posicion];
    }

    //método login
    public int login(String nombre, String contrasena){
        for(int i=0; i<totalUsuarios;i++){
            if(usuarios[i].getNombre().equals(nombre) && usuarios[i].getContrasena().equals(contrasena)){
                return i;
            }
        }
        return -1;
    }

    //método para ver si es admin
    public boolean esAdmin(int indiceUsuario){
        return usuarios[indiceUsuario].isAdmin();
    }

    //Buscar usuario por id para eliminarlo
    public int buscarIndicePorId(int idUsuario) {
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getId() == idUsuario) {
                return i;
            }
        }

        return -1;
    }

    //Eliminar usuarios
    public boolean eliminarUsuario(int idUsuario) {
        int posicion = buscarIndicePorId(idUsuario);

        if (posicion != -1) {
        for (int i = posicion + 1; i < totalUsuarios; i++) {
            usuarios[i - 1] = usuarios[i];
        }
        totalUsuarios--;
        return true;
    }

    return false;
    }

}
