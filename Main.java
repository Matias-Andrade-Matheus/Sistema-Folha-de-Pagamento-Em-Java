
// arquivo inicial do trabalho
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ArrayList<Familia> familias = new ArrayList<>(); // guardar toda informações das familias

        System.out.println("---Sistema de prioridade---");

        // menu
        while (true) {
            System.out.println("\n Escolha uma opção: ");
            System.out.println("\n 1 - Cadastrar nova família");
            System.out.println(" 2 - Listar famílias");
            System.out.println(" 3 - Vê prioridade na fila");
            System.out.println(" 4 - sair");
            int opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 1) {
                boolean flagRisco = false;
                boolean flagDesemprego = false;

                System.out.println("---Cadastro de Nova Família---");

                System.out.println("Qual a renda per capita da família? ");
                int rendaPerCapita = entrada.nextInt();

                System.out.println("Quantos dependentes tem na família? ");
                int dependentes = entrada.nextInt();

                System.out.println("Alguém da família tem algum tipo de deficiência? (sim/não)");
                String respostaDef = entrada.nextLine().toLowerCase();
                if (respostaDef.equals("sim")) {
                    boolean deficiencia = true;
                    System.out.println("Quantos integrantes da família tem algum tipo de deficiência?");
                    int numeroDeficientes = entrada.nextInt();
                } else if (respostaDef.equals("nao") || respostaDef.equals("não")) {
                    boolean deficiencia = false;
                }

                entrada.nextLine();

                while (!flagRisco) {
                    System.out.println("Existe um nível de risco no seu bairro? (sim/não)");
                    String respostaRisco = entrada.nextLine().toLowerCase();
                    if (respostaRisco.equals("sim")) {
                        System.out.println("Que tipo de risco? (violência/natural/ambos)");
                        String tipoRisco = entrada.nextLine().toLowerCase();
                        flagRisco = true;
                    } else if (respostaRisco.equals("não")) {
                        String tipoRisco = "nenhum";
                        flagRisco = true;
                    } else {
                        System.out.println("Preencha com uma resposta válida.");
                    }}

                while (!flagDesemprego) {
                    System.out.println("Alguém da família está desempregado? (sim/não)");
                    String respostaDes = entrada.nextLine().toLowerCase();
                    if (respostaDes.equals("sim")) {
                        System.out.println("Quantos meses alguém está desempregado? ");
                        int desemprego = entrada.nextInt();
                        flagDesemprego = true;
                    } else if (respostaDes.equals("não")) {
                        int desemprego = 0;
                        flagDesemprego = true;
                    } else {
                        System.out.println("Preencha com uma resposta válida.");
                    }}

                // ----PARTE DA CRIAÇÃO DE TODAS AS FAMÍLIAS----

                // Aqui cria o código da família automaticamente (F001, F002, F003 e assim vai)
                String idFamilia = "F" + String.format("%03d", familias.size() + 1);

                // coloca os dados acima na família q foi criada agora.
                Familia novaFamilia = new Familia(idFamilia, rendaPerCapita, dependentes, deficientes, desemprego,
                        risco, 0);

                // guarda a família na lista
                familias.add(novaFamilia);

                System.out.println("\nFamília " + idFamilia + " cadastrada com sucesso!");

            } else if (opcao == 2) {
                System.out.println("--- Lista de Famílias ---");
                for (Familia f : familias) {
                    f.mostrarDados();
                }

            } else if (opcao == 3) {
                // Ordena a lista do maior bônus para o menor
                familias.sort((f1, f2) -> Integer.compare(f2.bonus, f1.bonus));

                System.out.println("--- Fila de Prioridade (Ranking) ---");
                for (int i = 0; i < familias.size(); i++) {
                    familias.get(i).calcularPontuacao();
                    System.out.println((i + 1) + "º Lugar: " + familias.get(i).idFamilia + " - Pontos: " + familias.get(i).total);
                }

            } else if (opcao == 4) {
                System.out.println("\n Sistema encerrando...");
                break;
            }

        }

    }

}

public void desemprego(){

}

// dados das famílias
class Familia {

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
        this.total = 0;

    }

    // mostrar todas as informações da familia de forma organizada.
    // daqui jogaremos pro if, lá em cima...

    public void calcularPontuacao() {
        if (rendaPerCapita <= 200) {
            this.total = this.total + this.bonus + 10;
        } else if (rendaPerCapita <= 400) {
            this.total = this.total + this.bonus;
        } else if (rendaPerCapita <= 600) {
            this.total = this.total + 10;
        } else if (rendaPerCapita <= 700) {
            this.total = this.total + 5;
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

}

void main() {
}

// não sei se tô fazendo certo, mas acho q tô começando a entender
// tá mesmo testa agoraaaaaaaaaa
// boa, valeu irmão