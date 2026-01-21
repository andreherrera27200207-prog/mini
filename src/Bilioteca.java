public class Bilioteca {
    

    public static void main(String[] args) {
        

        GestorBiblioteca g_Biblioteca = new GestorBiblioteca();

        g_Biblioteca.agregar_libros_biblioteca("1234", "Jair", "Juego 1", "Romance");
        g_Biblioteca.agregar_libros_biblioteca("1345", "Eddy", "juego2", "Accion");
        g_Biblioteca.agregar_libros_biblioteca("1367", "Santiago", "Juego3", "Documental");
        g_Biblioteca.agregar_libros_biblioteca("1789", "Ernesto", "Juego4", "Romance");
        g_Biblioteca.agregar_libros_biblioteca("1965", "Jhosue", "Juego5", "Accion");
        g_Biblioteca.agregar_libros_biblioteca("1978", "Arnaldo", "Juego6", "Ciencia Ficción");
        g_Biblioteca.agregar_libros_biblioteca("1990", "Mitchell", "Juego7", "Romance");
        g_Biblioteca.agregar_libros_biblioteca("1922", "Gianny", "Juego8", "Accion");
        g_Biblioteca.agregar_libros_biblioteca("1897", "Ana", "Juego9", "Documental");
        g_Biblioteca.agregar_libros_biblioteca("1854", "Camila", "Juego9", "Romance");
        g_Biblioteca.agregar_libros_biblioteca("1123", "Rocio", "Juego10", "Ciencia Ficción");
        g_Biblioteca.agregar_libros_biblioteca("1115", "Pilar", "Juego11", "Ciencia Ficción");




        System.out.println(g_Biblioteca.mostrar_libro());




        










    }



}