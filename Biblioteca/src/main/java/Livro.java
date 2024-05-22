public final class Livro extends ItemBiblioteca {
    private String autor;
    private int anoPublicacao;

    public Livro(String titulo, String autor, int anoPublicação) {
        super(titulo);
        codigo = geraCodigo.gerarCodigo("Livro");
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String exibeDetalhes() {
        return STR."Título: \{titulo}\nCódigo: \{codigo}\nAutor: \{autor}\nAno Publicado: \{anoPublicacao}";
    }
}
