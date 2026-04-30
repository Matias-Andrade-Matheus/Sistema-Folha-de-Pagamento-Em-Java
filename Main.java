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

        System.out.println(CIANO + "---Sistema de prioridade---" + RESET);

        while (true) {
            System.out.println("\n Escolha uma opção: ");
            System.out.println(" 1 - Cadastrar nova família");
            System.out.println(" 2 - Listar famílias");
            System.out.println(" 3 - Ver prioridade na fila");
            System.out.println(" 4 - Sair");

            int opcao = Integer.parseInt(entrada.nextLine());

            if (opcao == 1) {
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

                System.out.println(AMARELO + "\n---Cadastro de Nova Família---" + RESET);

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
                Familia nova = new Familia(id, titular, rendaPerCapita, numeroDependentes, temDeficiencia, numeroDeficientes, desempregoEmMeses, tipoRisco);
                familias.add(nova);

                System.out.println(VERDE + "Família " + id + " cadastrada com sucesso!" + RESET);

            } else if (opcao == 2) {
                System.out.println("\n" + CIANO + "------------------------------------------------------------");
                System.out.printf("%-6s | %-10s | %-12s | %-10s | %-10s%n", "ID", "RENDA", "DEPENDENTES", "RISCO", "STATUS");
                System.out.println("------------------------------------------------------------" + RESET);
                for (Familia f : familias) {
                    f.calcularPontuacao();
                    System.out.printf("%-6s | R$%-8d | %-12d | %-10s | %-10s%n",
                            f.idFamilia, f.rendaPerCapita, f.dependentes, f.risco, f.getNivelVulnerabilidade());
                }

            } else if (opcao == 3) {
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

            } else if (opcao == 4) {
                System.out.println(VERMELHO + "Encerrando...");
                break;
            }
        }
    }

    // A classe Familia deve ficar dentro da classe Main se for static, ou fora sem o static.
    // Para facilitar, deixei ela aqui como uma classe interna estática.
    static class Familia {
        String idFamilia;
        int rendaPerCapita;
        int dependentes;
        boolean deficiencia;
        int deficientes;
        int desemprego;
        String risco;
        int bonus;
        int total;
        String titular;

        public Familia(String idFamilia, String titular, int rendaPerCapita, int dependentes, boolean deficiencia, int deficientes, int desemprego, String risco) {
            this.idFamilia = idFamilia;
            this.titular = titular;
            this.rendaPerCapita = rendaPerCapita;
            this.dependentes = dependentes;
            this.deficiencia = deficiencia;
            this.deficientes = deficientes;
            this.desemprego = desemprego;
            this.risco = risco;
            this.bonus = 15;
            this.total = 0; // Inicializar o total
        }

        public void calcularPontuacao() {
            this.total = 0; // Zera para não somar infinitamente ao listar várias vezes

            if (rendaPerCapita <= 200) {
                this.total += this.bonus + 10;
            } else if (rendaPerCapita <= 400) {
                this.total += this.bonus;
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

            if (risco != null) {
                if (risco.contains("violen") || risco.equals("natural")) {
                    this.total += 7;
                } else if (risco.equals("ambos")) {
                    this.total += 10;
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
}