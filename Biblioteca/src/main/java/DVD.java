public final class DVD extends ItemBiblioteca {
    private String diretor;
    private int duracao;

    public DVD(String titulo, String diretor, int duracao) {
        super(titulo);
        codigo = geraCodigo.gerarCodigo("DVD");
        this.diretor = diretor;
        this.duracao = duracao;
    }

    @Override
    public String exibeDetalhes() {
        return STR."Título: \{titulo}\nCódigo: \{codigo}\nDiretor: \{diretor}\nDuração: \{duracao}";
    }
}
