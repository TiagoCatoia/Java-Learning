import java.util.*;

public class UrnaImpl implements Urna {
    private int[] nulos;
    private int[] brancos;
    private Map<Integer, Partido> partidos;

    public UrnaImpl () {
        carregar();
        this.nulos = nulos = new int[]{0, 0, 0, 0, 0};
        this.brancos = new int[]{0, 0, 0, 0, 0};
    }

    private void imprimirPartidos() {
        StringBuilder conteudoTexto = new StringBuilder();
        conteudoTexto.append("--------------------------PARTIDOS--------------------------\n");
        conteudoTexto.append(Utilitario.textoFixo("Número", 25));
        conteudoTexto.append("Nome\n");
        partidos.values()
                .forEach(partido -> {
                    conteudoTexto.append(Utilitario.textoFixo(String.valueOf(partido.getNumero()), 25));
                    conteudoTexto.append(partido.getNome()).append("\n");
                });
        System.out.println(conteudoTexto);
    }

    private void imprimirCandidatos() {
        for (Cargo cargo : Cargo.values()) {
            StringBuilder conteudoTexto = new StringBuilder();
            conteudoTexto.append(String.format("---------------------- CANDIDATOS A %s ----------------------%n", cargo.name()));
            conteudoTexto.append(Utilitario.textoFixo("Nome", 60));
            conteudoTexto.append(Utilitario.textoFixo("Cargo", 30));
            conteudoTexto.append(Utilitario.textoFixo("Número", 20));
            conteudoTexto.append("Partido\n");
            for (Partido partido : partidos.values()) {
                for (Candidato candidato : partido.getCandidatosPorCargo(cargo).values()) {
                    conteudoTexto.append(Utilitario.textoFixo(candidato.getNomeCompleto(), 60));
                    conteudoTexto.append(Utilitario.textoFixo(String.valueOf(candidato.getCargo()), 30));
                    conteudoTexto.append(Utilitario.textoFixo(String.valueOf(candidato.getNumero()), 20));
                    conteudoTexto.append(partido.getNome()).append("\n");
                }
            }
            System.out.println(conteudoTexto);
        }
    }

    @Override
    public void carregar() {
        Map<Integer, Partido> partidos = new TreeMap<>();
        List<String> linhas = Utilitario.carregarCandidatos();
        linhas = linhas.stream().skip(1).toList();

        for (String linha : linhas) {
            String[] dados = linha.split(";");

            String nomeCandidato = dados[0];
            String nomeUrna = dados[1];
            Cargo cargoCandidato = Cargo.valueOf(String.join("_", dados[2].toUpperCase().split(" ")));
            int numeroCandidato = Integer.parseInt(dados[3]);

            int numeroPartido = Integer.parseInt(dados[3].substring(0,2));
            String nomePartido = dados[4];

            if (partidos.containsKey(numeroPartido)) {
                Candidato candidato = new Candidato(nomeUrna, nomeCandidato, numeroCandidato, cargoCandidato);
                partidos.get(numeroPartido).addCandidato(candidato);
            } else {
                Partido partido = new Partido(numeroPartido, nomePartido);
                Candidato candidato = new Candidato(nomeUrna, nomeCandidato, numeroCandidato, cargoCandidato);
                partido.addCandidato(candidato);
                partidos.put(numeroPartido, partido);
            }
        }
        this.partidos = partidos;
        imprimirPartidos();
        imprimirCandidatos();
    }

    @Override
    public void votar() {
        int numeroPorCargo = 5;
        for (Cargo cargo : Cargo.values()) {
            System.out.print(String.valueOf(cargo).charAt(0) + String.valueOf(cargo).substring(1).toLowerCase());
            System.out.print("  [" + numeroPorCargo + " Números | BRANCO]: ");
            Scanner scanner = new Scanner(System.in);
            String voto = scanner.nextLine();
            System.out.println(voto);

            if (Objects.equals(voto, "BRANCO")) {
                System.out.println("VOTO EM BRANCO");
                System.out.print("       [CORRIGE] | CONFIRMA]: ");
                String opcao = scanner.nextLine();
                if (Objects.equals(opcao, "CONFIRMA")) brancos[Cargo.values().length - 1]++;
                else votar(); // adicionar loop while
            }
            else {
                for (Partido partido : partidos.values()) {
                    for (Candidato candidato : partido.getCandidatosPorCargo(cargo).values()) {
                        if (candidato.getNumero() == Integer.parseInt(voto)) {
                            System.out.print(Utilitario.textoFixo("Nome: " + candidato.getNomeCompleto(), 50));
                            System.out.println("Partido: " + partido.getNome() + " (" + partido.getNumero() + ")\n");
                            System.out.print("       [CORRIGE] | CONFIRMA]: ");
                            String opcao = scanner.nextLine();
                            if (Objects.equals(opcao, "CONFIRMA")) candidato.receberVoto();
                            else votar(); // adicionar loop while
                        }
                    }
                }
            }
            numeroPorCargo--;
        }
//        Deputado Federal [4 números | BRANCO]: 9908
//        Nome: SANTINHO                   Partido: UMAB (99)
//                [CORRIGE | CONFIRMA]: CONFIRMA
//
//        Deputado Estadual [5 números | BRANCO]: BRANCO
//        VOTO EM BRANCO
//                [CORRIGE | CONFIRMA]: CONFIRMA
//
//        Senador [3 números | BRANCO]: 138
//        VOTO NULO
//        [CORRIGE | CONFIRMA]: CORRIGE
    }

    @Override
    public void imprimir() {

    }
}
