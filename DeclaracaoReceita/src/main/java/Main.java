import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public void main(String[] args) {
    boolean running = true;

    while (running) {
        System.out.println("\n[1]. Fazer Declaração");
        System.out.println("[2]. Adicionar Gasto");
        System.out.println("[3]. Remover Gasto");
        System.out.println("[4]. Calcular Imposto");
        System.out.println("[5]. Editar Declaração");
        System.out.println("[6]. Sair");
        System.out.print("Opção: ");
        Scanner scanner = new Scanner(System.in);
        final String option = scanner.nextLine();
        switch (Integer.parseInt(option)) {
            case 1 -> {
                System.out.print("Ganho Tributável: ");
                final double ganho = Double.parseDouble(scanner.nextLine());
                System.out.print("Valor pago: ");
                final double pago = Double.parseDouble(scanner.nextLine());
                DeclaracaoService service = new DeclaracaoService(new DeclaracaoRepository());
                service.iniciarDeclaracao(ganho, pago);
            }
            case 2 -> {
                DeclaracaoRepository declaracaoRepository = new DeclaracaoRepository();
                final Optional<Declaracao> declaracao = declaracaoRepository.findByKey(2L);
                if (declaracao.isEmpty()) {
                    System.out.println("Declaração não encontrada. Selecione opção [1]");
                    break;
                }

                DeclaracaoCompleta completa = (DeclaracaoCompleta) declaracao.get();

                System.out.println("[1]. Gasto de Saúde");
                System.out.println("[2]. Gasto de Educação");
                final int tipo = Integer.parseInt(scanner.nextLine());

                System.out.print("Descrição: ");
                final String descricao = scanner.nextLine();

                System.out.print("Valor: ");
                final double valor = Double.parseDouble(scanner.nextLine());

                System.out.print("CNPJ: ");
                final String cnpj = scanner.nextLine();

                Gasto gasto;
                GastoService service = new GastoService(completa);
                if (tipo == 1) {
                    System.out.print("Registro Conselho: ");
                    final String registroConselho = scanner.nextLine();
                    service.iniciaGastoSaude(descricao,valor,cnpj,registroConselho);
                } else if (tipo == 2) {
                    System.out.print("Nome da Instituição: ");
                    final String nomeInstituicao = scanner.nextLine();
                    service.iniciaGastoEducacao(descricao,valor,cnpj,nomeInstituicao);
                } else {
                    System.out.println("Tipo inválido!");
                }
            }
            case 3 -> {
                DeclaracaoRepository declaracaoRepository = new DeclaracaoRepository();
                final Optional<Declaracao> declaracao = declaracaoRepository.findByKey(2L);

                if (declaracao.isEmpty()) {
                    System.out.println("Declaração não encontrada. Selecione opção [1]");
                    break;
                }

                DeclaracaoCompleta completa = (DeclaracaoCompleta) declaracao.get();

                System.out.print("ID do gasto: ");
                final long idGasto = Long.parseLong(scanner.nextLine());

                completa.removeGastoPeloID(idGasto);
            }
            case 4 -> {
                DeclaracaoService service = new DeclaracaoService(new DeclaracaoRepository());
                final String result = service.pegarInformacoes();

                if (result.isEmpty()) System.out.println("Declaração não encontrada. Selecione opção [1]");
                else System.out.println(result);
            }
            case 5 -> {
                DeclaracaoRepository declaracaoRepository = new DeclaracaoRepository();

                System.out.print("ID: ");
                final long id = Long.parseLong(scanner.nextLine());

                final Optional<Declaracao> declaracao = declaracaoRepository.findByKey(2L);
                if (declaracao.isEmpty())
                    System.out.println("Declaração não encontrada. Selecione opção [1]");
                else {
                    DeclaracaoCompleta completa = (DeclaracaoCompleta) declaracao.get();

                    System.out.println("[1]. Alterar Ganho Tributável");
                    System.out.println("[2]. Alterar Valor Pago");
                    final int opcaoAlterar = Integer.parseInt(scanner.nextLine());

                    if (opcaoAlterar == 1) {
                        System.out.println("Novo Ganho Tributável: ");
                        final double novoGanhoTributavel = Double.parseDouble(scanner.nextLine());
                        completa.setGanhoTributavel(novoGanhoTributavel);
                    }
                    else {
                        System.out.println("Novo Valor Pago: ");
                        final double valorPago = Double.parseDouble(scanner.nextLine());
                        completa.setValorPago(valorPago);
                    }
                }
            }
            case 6 -> running = false;
            default -> System.out.println("Opção Inválida!");
        }
    }
}

