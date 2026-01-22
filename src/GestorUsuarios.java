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

}
