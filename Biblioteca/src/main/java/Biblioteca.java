import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<ItemBiblioteca> itensDisponiveis;
    private ArrayList<Usuario> usuarios;

    public Biblioteca(){
        itensDisponiveis = new ArrayList<ItemBiblioteca>();
        usuarios = new ArrayList<Usuario>();
    };

    public void adicionaItem(ItemBiblioteca item) {
        itensDisponiveis.add(item);
    }

    public void registraUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    public void exibeItensDisponiveis() {
        itensDisponiveis.forEach(item -> System.out.println(STR."\{item.titulo} \{item.codigo}"));
    }
}
