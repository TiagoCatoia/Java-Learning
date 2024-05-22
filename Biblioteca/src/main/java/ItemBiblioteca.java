import static java.lang.StringTemplate.STR;

public abstract sealed class ItemBiblioteca permits Livro, DVD {
    protected String titulo;
    protected String codigo;

    public ItemBiblioteca(String titulo) {
        this.titulo = titulo;
    }

    public abstract String exibeDetalhes();

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    protected String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }
}
