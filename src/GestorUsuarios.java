/**
 * @author Pablo Iglesias
 */

public class GestorUsuarios {
    private Usuario[] usuarios;
    private final int MAX =100;
    private int cantidad;

    public GestorUsuarios(){
        this.usuarios = new Usuario[MAX];
        this.cantidad=0;
    }

}
