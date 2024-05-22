public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        DVD dvd = new DVD("Multimidia", "Blu-ray", 2);
        Livro livro = new Livro("Era uma vez", "Adam Horowitz", 2011);
        Usuario usuario = new Usuario("Tiago");

        biblioteca.adicionaItem(dvd);
        biblioteca.adicionaItem(livro);
        biblioteca.registraUsuario(usuario);
        biblioteca.exibeItensDisponiveis();
    }
}
