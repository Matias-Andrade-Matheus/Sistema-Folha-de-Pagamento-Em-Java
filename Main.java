
// arquivo inicial do trabalho
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ArrayList<String> familias = new ArrayList<>(); // guardar toda informações das familias

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
                // aqui iremos cadastrar uma nova família indo pelo fluxograma da helena
                // Perguntar ao usuário sua renda per capital, número de dependentes, 
                // se tem alguma deficiência, 
                // se apresenta risco de violência urbana e causas naturais e tempo de desemprego.
                // e dai quando apertar essa opção já criar uma familia, 
                // podendo ser F001, se logo em seguida outra ser criada vai na lógica, F002 e assim por diante...

            } else if (opcao == 2) {
                // aqui iremos listar as familias que tem, exemplo: F001, dae vai dizer tudo em
                // questão
                // da renda, dos dependentes... essas coisas

            } else if (opcao == 3) {
                // aqui iremos calcular as prioridades sem precisar cadastrar, pra fazer tipo
                // uma simulação

            } else if (opcao == 4) {
                System.out.println("\n Sistema encerrando...");
                break;
            }

        }

    }

}

// dados das famílias

class Familia {

    String idFamilia;
    int rendaPerCapita;
    int dependentes;
    boolean deficientes;
    int desemprego;
    String risco;
    int bonus;

    public Familia(String idFamilia, int rendaPerCapita, int dependentes, boolean deficientes, int desemprego,
            String risco, int bonus) {

        this.idFamilia = idFamilia;
        this.rendaPerCapita = rendaPerCapita;
        this.dependentes = dependentes;
        this.deficientes = deficientes;
        this.desemprego = desemprego;
        this.risco = risco;
        this.bonus = bonus;

    }

    // mostrar todas as informações da familia de forma organizada.
    // daqui jogaremos pro if, lá em cima...

    public void mostrarDados() {

        System.out.println("Id: " + idFamilia);
        System.out.println("Renda per capita: " + rendaPerCapita);
        System.out.println("Dependentes: " + dependentes);
        System.out.println("Deficiência? " + deficientes);
        System.out.println("Desemprego: " + desemprego + " meses");
        System.out.println("Risco: " + risco);
        System.out.println("Prioridade: " + bonus);
        System.out.println("");

    }

}

// não sei se tô fazendo certo, mas acho q tô começando a entender
// tá mesmo testa agoraaaaaaaaaa
// boa, valeu irmão