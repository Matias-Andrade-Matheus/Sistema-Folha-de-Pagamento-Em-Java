import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class Main {
    // Cores para estética do terminal
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";
    public static final String CIANO = "\u001B[36m";

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Familia> familias = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        System.out.println(CIANO + "=== SISTEMA INTEGRADO ===" + RESET);

        while (true) {
            System.out.println("\n" + CIANO + "╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║                    MENU PRINCIPAL                            ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝" + RESET);

            
            System.out.println(" 1 - Sistema de Famílias (Prioridade) ");
            System.out.println(" 2 - Sistema de Funcionários (Folha de Pagamento)");
            System.out.println(" 0 - Sair");

            System.out.println("\n Escolha uma opção: ");
           int opcao = Integer.parseInt(entrada.nextLine());

            if (opcao == 1) {
                sistemaFamilia(entrada, familias);            
            }
            else if (opcao == 2) {
                sistemaFuncionarios(entrada, funcionarios);
            }
            else if (opcao == 0) {
                System.out.println(VERMELHO + "Encerrando o sistema..." + RESET);
                break;
            } else {
                System.out.println(VERMELHO + "Opção invalida...");
            }
        }
        entrada.close();    
    }

        //                          ÁREA DO SISTEMA DE FAMÍLIAS (prioridade)
        // _________________________________________________________________________________________

        private static void sistemaFamilia(Scanner entrada, ArrayList<Familia> familias) {
            while (true) {
                
            
                

        
                System.out.println(CIANO + "╔══════════════════════════════════════════════════════════════╗");
                System.out.println("║                 SISTEMA DE FAMÍLIAS (prioridade)                    ║");
                System.out.println("╚══════════════════════════════════════════════════════════════╝" + RESET);

                System.out.println("\n1 - Cadastrar nova família");
                System.out.println("2 - Listar famílias");
                System.out.println("3 - Ver prioridade na fila");
                System.out.println("0 - Voltar ao Menu Principal");

                System.out.println("\nEscolha uma opção: ");
                int opcaoFamilia = entrada.nextInt();
                entrada.nextLine();

                

                if (opcaoFamilia == 1) {
                //                          CADASTRO
               //_________________________________________________________________

                boolean flagDeficiencia = false;
                boolean flagTemRisco = false;
                boolean flagRiscoTipo = false;
                boolean flagDesemprego = false;

                boolean temDeficiencia = false;
                int rendaPerCapita = 0;
                int numeroDependentes = 0;
                int numeroDeficientes = 0;
                int desempregoEmMeses = 0;
                String tipoRisco = "nenhum";
                String titular = "";

                System.out.println(CIANO + "\n---Cadastro de Nova Família---" + RESET);

        
                System.out.println(CIANO + "╔══════════════════════════════════════════════════════════════╗");
                System.out.println("║                 CADASTRO DE NOVA FAMÍLIA                     ║");
                System.out.println("╚══════════════════════════════════════════════════════════════╝" + RESET);

                System.out.print("Qual a renda per capita da família? ");
                rendaPerCapita = Integer.parseInt(entrada.nextLine());

                System.out.print("Se há dependentes, quantos são? ");
                numeroDependentes = Integer.parseInt(entrada.nextLine());

                while (!flagDeficiencia) {
                    System.out.print("Alguém apresenta algum tipo de deficiência? (sim/não): ");
                    String resposta = entrada.nextLine().toLowerCase();
                    if (resposta.equals("sim") || resposta.equals("s")) {
                        temDeficiencia = true;
                        System.out.print("Quantos integrantes?: ");
                        numeroDeficientes = Integer.parseInt(entrada.nextLine());
                        flagDeficiencia = true;
                    } else if (resposta.equals("não") || resposta.equals("n") || resposta.equals("nao")) {
                        flagDeficiencia = true;
                    } else {
                        System.out.println("Preencha com uma resposta válida.");
                    }
                }

                while (!flagTemRisco) {
                    System.out.print("Existe risco no bairro? (sim/não): ");
                    String resposta = entrada.nextLine().toLowerCase();
                    if (resposta.equals("sim") || resposta.equals("s")) {
                        while (!flagRiscoTipo) {
                            System.out.print("De qual tipo? (violência/natural/ambos): ");
                            tipoRisco = entrada.nextLine().toLowerCase();
                            if (tipoRisco.equals("violência") || tipoRisco.equals("violencia")
                                    || tipoRisco.equals("natural") || tipoRisco.equals("ambos")) {
                                flagTemRisco = true;
                                flagRiscoTipo = true;
                            } else {
                                System.out.print("Preencha com uma resposta válida.");
                            }
                        }

                    } else if (resposta.equals("não") || resposta.equals("n") || resposta.equals("nao")) {
                        flagTemRisco = true;
                    } else {
                        System.out.println("Preencha com uma resposta válida.");
                    }
                }

                while (!flagDesemprego) {
                    System.out.print("Alguém desempregado? (sim/não): ");
                    String resposta = entrada.nextLine().toLowerCase();
                    if (resposta.equals("sim") || resposta.equals("s")) {
                        System.out.print("Há quantos meses?: ");
                        desempregoEmMeses = Integer.parseInt(entrada.nextLine());
                        flagDesemprego = true;
                    } else if (resposta.equals("não") || resposta.equals("n") || resposta.equals("nao")) {
                        flagDesemprego = true;
                    } else {
                        System.out.println("Preencha com uma resposta válida.");
                    }
                }
                System.out.print("Indique o nome do títular da familía: ");
                titular = entrada.nextLine();


                
                String id = "F" + String.format("%03d", familias.size() + 1);
                

               
                //                          RESUMO

                System.out.println("\n" + CIANO + "╔═══════════════════════ RESUMO DO CADASTRO ═════════════════════════╗");
                System.out.printf("║ %-18s : %-45s ║%n", "ID Gerado", id);
                System.out.printf("║ %-18s : %-45s ║%n", "Titular", titular);
                System.out.printf("║ %-18s : R$ %-42d ║%n", "Renda per capita", rendaPerCapita);
                System.out.printf("║ %-18s : %-45d ║%n", "Dependentes", numeroDependentes);
                System.out.printf("║ %-18s : %-45s ║%n", "Deficiência", 
                    (temDeficiencia ? numeroDeficientes + " pessoa(s)" : "Não"));
                System.out.printf("║ %-18s : %-45s ║%n", "Risco", 
                    (tipoRisco.equals("nenhum") ? "Não" : tipoRisco.toUpperCase()));
                System.out.printf("║ %-18s : %-45s ║%n", "Desemprego", 
                    (desempregoEmMeses > 0 ? desempregoEmMeses + " meses" : "Não"));
                System.out.println("╚════════════════════════════════════════════════════════════════════╝" + RESET);

                System.out.print("\nDeseja confirmar o cadastro? (sim/não): ");
                String confirma = entrada.nextLine().toLowerCase();

                if (confirma.equals("sim") || confirma.equals("s")) {
                    id = "F" + String.format("%03d", familias.size() + 1);
                    Familia nova = new Familia(id, titular, rendaPerCapita, numeroDependentes, temDeficiencia, numeroDeficientes, desempregoEmMeses, tipoRisco);
                    familias.add(nova);

                    System.out.println(VERDE + "Família " + id + " cadastrada com sucesso!" + RESET);
                } else {
                    System.out.println(VERMELHO + "Cadastro cancelado." + RESET);
                }
            // ____________________________________________________________________________________________________________________________



            //                      LISTAR FAMILIA
            //_____________________________________________________________

            } else if (opcaoFamilia == 2) {
                System.out.println("\n" + CIANO + "------------------------------------------------------------");
                System.out.printf("%-6s | %-10s | %-12s | %-10s | %-10s%n", "ID", "RENDA", "DEPENDENTES", "RISCO", "STATUS");
                System.out.println("------------------------------------------------------------" + RESET);
                for (Familia f : familias) {
                    f.calcularPontuacao();
                    System.out.printf("%-6s | R$%-8d | %-12d | %-10s | %-10s%n",
                            f.idFamilia, f.rendaPerCapita, f.dependentes, f.risco, f.getNivelVulnerabilidade());
                }
                

            //                      RANKING
            //___________________________________________________________

            } else if (opcaoFamilia == 3) {
                for (Familia f : familias) f.calcularPontuacao();
                familias.sort(Comparator.comparingInt((Familia f) -> f.total).reversed());

                System.out.println(AMARELO + "\n--- RANKING DE PRIORIDADE ---" + RESET);
                for (int i = 0; i < familias.size(); i++) {
                    Familia f = familias.get(i);
                    System.out.println(
                            (i + 1) + "º Lugar: " + f.idFamilia +
                            " | Titular: " + f.titular +
                            " | Pontos: " + f.total +
                            " (" + f.getNivelVulnerabilidade() + ")");
                }

            } else if (opcaoFamilia == 0) {
                System.out.println(VERMELHO + "Encerrando...");
                break;
            }
        }
    }

    //                               A PARTE DE QUANDO CHAMA O SISTEMA DE FUNCIONÁRIOS
    //________________________________________________________________________________________________________________
    
    private static void sistemaFuncionarios(Scanner entrada, ArrayList<Funcionario> funcionarios) {

        while (true) {
            System.out.println(CIANO + "=== SISTEMA DE FUNCIONARIO ===" + RESET);

            System.out.println(CIANO + "\n╔══════════════════════════════════════════════════════════════╗");
                System.out.println("║                 SISTEMA DE FUNCIONARIOS                     ║");
                System.out.println("╚══════════════════════════════════════════════════════════════╝" + RESET);


            System.out.println("\n1- Cadastrar funcionario padrão");
            System.out.println("2- Cadastrar funcionario comissionado");
            System.out.println("3- Cadastrar funcionario produção");
            System.out.println("4- Gerar folha de pagamento");
            System.out.println("0- Voltar");

            int opcao = Integer.parseInt(entrada.nextLine());


            if (opcao == 1) {
                cadastrarFuncionarioPadrão(entrada, funcionarios);
            }
            else if (opcao == 2) {
                cadastrarFuncionarioComissionado(entrada, funcionarios);
            }
            else if (opcao == 3) {
                cadastrarFuncionarioProducao(entrada, funcionarios);
            }
            else if (opcao == 4) {
                gerarFolhaPagamento(funcionarios);
            } 
            else if (opcao == 0) {
                break;

            } else {
                System.out.println(VERDE + "Opção invalida" + RESET);
            }


        }
    }



    private static void cadastrarFuncionarioPadrão(Scanner sc, ArrayList<Funcionario> lista) {
        System.out.println(CIANO + "\n=== CADASTRO DE FUNCIONÁRIO PADRÃO ===" + RESET);

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();

        String id = "F" + String.format("%03d", lista.size() + 1);


        System.out.println("\n" + CIANO + "╔═══════════════════════ RESUMO DO CADASTRO ═══════════════════════╗");
        System.out.printf("║ %-18s : %-45s ║%n", "ID", id);
        System.out.printf("║ %-18s : %-45s ║%n", "Nome", nome);
        System.out.printf("║ %-18s : %-45s ║%n", "Matrícula", matricula);
        System.out.printf("║ %-18s : %-45s ║%n", "Tipo", "Padrão (Salário Base)");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝" + RESET);


        System.out.println("\nConfirmar cadastro? (sim/não): ");
        if (sc.nextLine().toLowerCase().startsWith("s")) {
            lista.add(new funcionarioPadrao(id, nome, matricula));
            System.out.println(VERDE + "Funionário cadastrado com sucesso!" + RESET);
        } else {
            System.out.println(VERMELHO + "Cadastro cancelado." + RESET);
        }
    }

    private static void cadastrarFuncionarioComissionado(Scanner sc, ArrayList<Funcionario> lista) {
        System.out.println(CIANO + "\n===CADASTRO DE FUNCIONÁRIO COMISSIONADO ===" + RESET);
        
        
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();

        System.out.print("Valor das vendas (R$): ");
        double vendas = Double.parseDouble(sc.nextLine());

        System.out.print("Percentual de comissão (%): ");
        double percentual = Double.parseDouble(sc.nextLine());


        String id = "F" + String.format("%03d", lista.size() + 1);
        
        
        System.out.println("\n" + CIANO + "╔═══════════════════════ RESUMO DO CADASTRO ═══════════════════════╗");
        System.out.printf("║ %-18s : %-45s ║%n", "ID", id);
        System.out.printf("║ %-18s : %-45s ║%n", "Nome", nome);
        System.out.printf("║ %-18s : %-45s ║%n", "Matrícula", matricula);
        System.out.printf("║ %-18s : R$ %-42.2f ║%n", "Vendas", vendas);
        System.out.printf("║ %-18s : %-45.2f ║%n", "Comissão (%)", percentual);
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝" + RESET);

        System.out.println("\nConfirmar cadastro? (sim/não): ");
        if (sc.nextLine().toLowerCase().startsWith("s")) {
            lista.add(new funcionarioComissionado(id, nome, matricula, vendas, percentual));
            System.out.println(VERDE + "Funcionário Comissionado cadastrado!" + RESET);
        } else {
            System.out.println(VERMELHO + "Cadastro cancelado." + RESET);
        }
    }

    private static void cadastrarFuncionarioProducao(Scanner sc, ArrayList<Funcionario> lista) {
        System.out.println(CIANO + "\n=== CADASTRO DE FUNCIONÁRIO DE PRODUÇÃO ===" + RESET);

        System.out.println("Nome: ");
        String nome = sc.nextLine();

        System.out.println("Matrícula: ");
        String matricula = sc.nextLine();

        System.out.println("Quantidade de peças produzidas: ");
        int qtdPecas = Integer.parseInt(sc.nextLine());

        System.out.println("Valor por peça (R$): ");
        double valorPeca = Double.parseDouble(sc.nextLine());


        String id = "F" + String.format("%03d", lista.size() + 1);

        System.out.println("\n" + CIANO + "╔═══════════════════════ RESUMO DO CADASTRO ═══════════════════════╗");
        System.out.printf("║ %-18s : %-45s ║%n", "ID", id);
        System.out.printf("║ %-18s : %-45s ║%n", "Nome", nome);
        System.out.printf("║ %-18s : %-45s ║%n", "Matrícula", matricula);
        System.out.printf("║ %-18s : %-45d ║%n", "Qtd Peças", qtdPecas);
        System.out.printf("║ %-18s : R$ %-42.2f ║%n", "Valor por peça", valorPeca);
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝" + RESET);


        System.out.println("Confirmar cadastro? (sim/não): ");
        if (sc.nextLine().toLowerCase().startsWith("s")) {
            lista.add(new funcionarioProducao(id, nome, matricula, qtdPecas, valorPeca));
            System.out.println(VERDE + "Funcionário de Produção cadastrado!" + RESET);
        } else {
            System.out.println(VERMELHO + "Cadastro cancelado." + RESET);
        }
    }

    private static void gerarFolhaPagamento(ArrayList<Funcionario> lista) {
        if (lista.isEmpty()) {
            System.out.println(AMARELO + "Nenhum funcionario cadastrado ainda." + RESET);
            return;
        }
        
        System.out.println(CIANO + "\n" + "=".repeat(80));
        System.out.println("                    FOLHA DE PAGAMENTO");
        System.out.println("=".repeat(80) + RESET);


        for (Funcionario f : lista) {
            f.mostrarDados();
            System.out.println("-".repeat(70));
        }
    }
    
    static class Familia {

        String idFamilia;
        String titular;
        int rendaPerCapita;
        int dependentes;
        boolean deficiencia;
        int deficientes;
        int desemprego;
        String risco;
        int total;

        public Familia(String idFamilia, String titular, int rendaPerCapita, int dependentes, boolean deficiencia, int deficientes, int desemprego,
                String risco) {

            this.idFamilia = idFamilia;
            this.titular = titular;
            this.rendaPerCapita = rendaPerCapita;
            this.dependentes = dependentes;
            this.deficiencia = deficiencia;
            this.deficientes = deficientes;
            this.desemprego = desemprego;
            this.risco = risco;
            this.total = 0;
        }

        public void calcularPontuacao() {
            this.total = 0; // Zera para não somar infinitamente ao listar várias vezes

            if (rendaPerCapita <= 200) {
                this.total += 25;
            } else if (rendaPerCapita <= 400) {
                this.total += 15;
            } else if (rendaPerCapita <= 600) {
                this.total += 10;
            } else if (rendaPerCapita <= 700) {
                this.total += 5;
            }

            if (deficientes > 0) {
                this.total += 10 * this.deficientes;
            }

            if (dependentes > 0) {
                this.total += 10 * this.dependentes;
            }

            if (risco != null && !risco.equals("nenhum")) {
                if (risco.contains("violen") || risco.equals("natural")) {
                    this.total += 7;
                } else if (risco.equals("ambos")) {
                    this.total += 12;
                }
            }

            if (desemprego > 0) {
                if (desemprego <= 6) {
                    this.total += 5;
                } else {
                    this.total += 10;
                }
            }
        }

        public String getNivelVulnerabilidade() {
            if (this.total > 50) return VERMELHO + "CRÍTICA" + RESET;
            if (this.total > 30) return AMARELO + "MODERADA" + RESET;
            return VERDE + "BAIXA" + RESET;
        }
    }


    //                           CLASSE DOS FUNCIONARIOS
    //___________________________________________________________________________________


    static class Funcionario {
        String id;
        String nome;
        String matricula;
        double salarioBase = 2000.0;

        public Funcionario(String id, String nome, String matricula) {
            this.id = id;
            this.nome = nome;
            this.matricula = matricula;
            
        }

        public double calcularSalario() {
            return salarioBase;
        }

        public void mostrarDados() {
            System.out.println("Id: " + id);
            System.out.println("Nome: " + nome);
            System.out.println("Matricula: " + matricula);
            System.out.printf("Salário base: R$ %.2f%n", salarioBase);
            System.out.printf("Salário final: R$ %.2f%n", calcularSalario());            
        }

    } 

    static class funcionarioPadrao extends Funcionario {
            public funcionarioPadrao(String id, String nome, String matricula) {
                super(id, nome, matricula);
            }
            public double calcularSalario() {
                return salarioBase; 
            }
            
    }
    
    static class funcionarioComissionado extends Funcionario {
        double valorVendas;
        double percentualComissao;

        public funcionarioComissionado(String id, String nome, String matricula, double valorVendas, double percentualComissao) {
            super(id, nome, matricula);
            this.valorVendas = valorVendas;
            this.percentualComissao = percentualComissao;
            

        }

        public double calcularSalario() {
            double comissao = valorVendas * (percentualComissao / 100.0);
            return salarioBase + comissao;
        }

    }

    static class funcionarioProducao extends Funcionario {
        int qtdPecas;
        double valorPeca;

        public funcionarioProducao(String id, String nome, String matricula, int qtdPecas, double valorPeca) {
            super(id, nome, matricula);
            this.qtdPecas = qtdPecas;
            this.valorPeca = valorPeca;
        }
        
        public double calcularSalario() {
            double bonus = qtdPecas * valorPeca;
            return salarioBase + bonus;
        }

    }

}