public final class Usuario {
    private String nome;
    private String id;

    public Usuario(String nome) {
        this.nome = nome;
        id = geraCodigo.gerarCodigo("Usuario");
    }
//
//    public emprestaItem(ItemBiblioteca item) {
//
//    }
//
//    public devolveItem(ItemBiblioteca item) {
//
//    }
}
