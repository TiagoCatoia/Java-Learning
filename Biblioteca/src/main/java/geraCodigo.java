import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class geraCodigo {
    static int serialUsuario = 10000;
    static int serialDVD = 10000;
    static int serialLivro = 10000;

    private geraCodigo(){}

    public static String gerarCodigo(Object identificador) {
        LocalDateTime agora = LocalDateTime.now();
        String novoCodigo = String.valueOf(agora.getYear() + "-" + agora.getMonth() + "-" + agora.getDayOfMonth());
        if (Objects.equals(identificador, "Livro")) {
            novoCodigo += serialLivro++;
        }
        if (Objects.equals(identificador, "DVD")) {
            novoCodigo += serialDVD++;
        }
        if (Objects.equals(identificador, "Usuario")) {
            novoCodigo += serialUsuario++;
        }
        return novoCodigo;
    }
}
