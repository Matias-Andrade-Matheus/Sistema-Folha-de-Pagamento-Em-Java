
// arquivo inicial do trabalho
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

        ArrayList<Familia> familias = new ArrayList<>(); // guardar todas informações das familias

        System.out.println(CIANO + "---Sistema de prioridade---" + RESET);

        // menu
        while (true) {
            System.out.println("\n Escolha uma opção: ");
            System.out.println("\n 1 - Cadastrar nova família");
            System.out.println(" 2 - Listar famílias");
            System.out.println(" 3 - Vê prioridade na fila");
            System.out.println(" 4 - sair");
            int opcao = Integer.parseInt(entrada.nextLine());

            if (opcao == 1) {
                boolean flagDeficiencia = false;
                boolean flagRisco = false;
                boolean flagDesemprego = false;

                boolean temDeficiencia = false;
                int rendaPerCapita = 0;
                int numeroDependentes = 0;
                int numeroDeficientes = 0;
                int desempregoEmMeses = 0;

                String tipoRisco = "nenhum";


                System.out.println(AMARELO +"\n---Cadastro de Nova Família---" + RESET);


                System.out.print("Qual a renda per capita da família? ");
                rendaPerCapita = Integer.parseInt(entrada.nextLine());

                System.out.print("Se há dependentes, quantos são? ");
                numeroDependentes = Integer.parseInt(entrada.nextLine());

                while (!flagDeficiencia) {
                    System.out.print("Alguém apresenta algum tipo de deficiência? (sim/não):");
                    String existeRisco = entrada.nextLine().toLowerCase();
                    if (existeRisco.equals("sim") || existeRisco.equals("s")) {
                        temDeficiencia = true;
                        System.out.print("Quantos integrantes?: ");
                        numeroDeficientes = Integer.parseInt(entrada.nextLine());
                        flagDeficiencia = true;
                    } else if (existeRisco.equals("não") || existeRisco.equals("n")) {
                        flagDeficiencia = true;
                    } else {
                        System.out.println("Preencha com uma resposta válida.");
                    }
                }

                while (!flagRisco) {
                    System.out.print("Existe risco no bairro? (sim/não): ");
                    String existeRisco = entrada.nextLine().toLowerCase();
                    if (existeRisco.equals("sim") || existeRisco.equals("s")) {
                        System.out.print("De qual tipo? (violência/natural/ambos) ");
                        tipoRisco = entrada.nextLine().toLowerCase();
                        flagRisco = true;
                    } else if (existeRisco.equals("não") || existeRisco.equals("n")) {
                        flagRisco = true;
                    } else {
                        System.out.println("Preencha com uma resposta válida.");
                    }}

                while (!flagDesemprego) {
                    System.out.print("Existe risco no bairro? (sim/não): ");
                    String existeDesemprego = entrada.nextLine().toLowerCase();
                    if (existeDesemprego.equals("sim") || existeDesemprego.equals("s")) {
                        System.out.print("Há quantos meses?: ");
                        desempregoEmMeses = Integer.parseInt(entrada.nextLine());
                        flagDesemprego = true;
                    } else if (existeDesemprego.equals("não") || existeDesemprego.equals("n")) {
                        flagDesemprego = true;
                    } else {
                        System.out.println("Preencha com uma resposta válida.");
                    }}
                System.out.print("Alguém desempregado? (sim/não): ");
                if (entrada.nextLine().equalsIgnoreCase("sim")) {
                    System.out.print("Há quantos meses?: ");
                    desempregoEmMeses = Integer.parseInt(entrada.nextLine());
                }

                // ----PARTE DA CRIAÇÃO DE TODAS AS FAMÍLIAS----
                String id = "F" + String.format("%03d", familias.size() + 1);
                Familia nova = new Familia(id, rendaPerCapita, numeroDependentes, temDeficiencia, numeroDeficientes, desempregoEmMeses, tipoRisco);
                familias.add(nova);

                System.out.println(VERDE + "Família " + id + " cadastrada com sucesso!" + RESET);


            } else if (opcao == 2) {
                System.out.println("\n" + CIANO + "------------------------------------------------------------");
                System.out.printf("%-6s | %-10s | %-12s | %-10s | %-10s%n", "ID", "RENDA", "DEPENDENTES", "RISCO", "STATUS");
                System.out.println("------------------------------------------------------------" + RESET);
                for (Familia f : familias) {
                    f.calcularPontuacao(); // Garante que o total está atualizado
                    System.out.printf("%-6s | R$%-8d | %-12d | %-10s | %-10s%n",
                            f.idFamilia, f.rendaPerCapita, f.dependentes, f.risco, f.getNivelVulnerabilidade());
                }


            } else if (opcao == 3) {
                // --- 4. ORDENAÇÃO CORRETA (Lógica) ---
                // Primeiro calcula a pontuação de todos
                for (Familia f : familias) f.calcularPontuacao();

                // Depois ordena do maior para o menor
                familias.sort(Comparator.comparingInt((Familia f) -> f.total).reversed());

                System.out.println(AMARELO + "\n--- RANKING DE PRIORIDADE ---" + RESET);
                for (int i = 0; i < familias.size(); i++) {
                    Familia f = familias.get(i);
                    System.out.println((i + 1) + "º Lugar: " + f.idFamilia + " | Pontos: " + f.total + " (" + f.getNivelVulnerabilidade() + ")");
                }

            } else if (opcao == 4) {
                System.out.println(VERMELHO + "Encerrando...");
                break;
            }

        }

    }
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

    public Familia(String idFamilia, int rendaPerCapita, int dependentes, boolean deficiencia, int deficientes, int desemprego,
            String risco) {

        this.idFamilia = idFamilia;
        this.rendaPerCapita = rendaPerCapita;
        this.dependentes = dependentes;
        this.deficiencia = deficiencia;
        this.deficientes = deficientes;
        this.desemprego = desemprego;
        this.risco = risco;
        this.bonus = 15;

    }

    public void calcularPontuacao() {
        if (rendaPerCapita <= 200) {
            this.total = this.total + this.bonus + 10;
        } else if (rendaPerCapita <= 400) {
            this.total = this.total + this.bonus;
        } else if (rendaPerCapita <= 600) {
            this.total = this.total + 10;
        } else if (rendaPerCapita <= 700) {
            this.total = this.total + 5:
        }

        if (deficientes > 0) {
            this.total = this.total + 10 * this.deficientes;
        }

        if (dependentes > 0) {
            this.total = this.total + 10 * this.dependentes;
        }

        if (risco != null) {
            if (risco.equals("violencia") || risco.equals("violência") || risco.equals("natural")) {
                this.total = this.total + 7;
            } else if (risco.equals("ambos")) {
                this.total = this.total + 10;
            }
        }

        if (desemprego > 0) {
            if (desemprego <= 6) {
                this.total = this.total + 5;
            } else if (desemprego >= 12) {
                this.total = this.total + 10;
            }
        }
    }

    public void mostrarDados() {

        System.out.println("Id: " + this.idFamilia);
        System.out.println("Renda per capita: " + this.rendaPerCapita);
        System.out.println("Dependentes: " + this.dependentes);
        System.out.println("Deficiência? " + this.deficientes);
        System.out.println("Desemprego: " + this.desemprego + " meses");
        System.out.println("Risco: " + this.risco);
        System.out.println("Prioridade: " + this.total + "\n");

    }


 public String getNivelVulnerabilidade() {
        if (this.total > 50) return Main.VERMELHO + "CRÍTICA" + Main.RESET;
        if (this.total > 30) return Main.AMARELO + "MODERADA" + Main.RESET;
        return Main.VERDE + "BAIXA" + Main.RESET;
    }

    }

}


 

