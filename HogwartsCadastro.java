import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HogwartsCadastro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno[] alunos = new Aluno[10];
        int count = 0;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("\n--- Menu Hogwarts ---");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Listar todos os alunos");
            System.out.println("3. Exibir alunos de uma casa");
            System.out.println("4. Listar alunos maiores de idade");
            System.out.println("5. Listar alunos menores de idade");
            System.out.println("6. Buscar alunos por sobrenome");
            System.out.println("7. Encerrar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // limpar buffer

            if (opcao == 1) {
                if (count >= 10) {
                    System.out.println("Limite de 10 alunos atingido.");
                    continue;
                }

                System.out.print("Nome: ");
                String nome = scanner.nextLine().trim();

                System.out.print("Sobrenome: ");
                String sobrenome = scanner.nextLine().trim();

                System.out.print("Casa: ");
                String casa = scanner.nextLine().trim();

                System.out.print("Data de Nascimento (dd/MM/yyyy): ");
                String dataStr = scanner.nextLine().trim();

                try {
                    LocalDate dataNascimento = LocalDate.parse(dataStr, formatter);

                    Aluno aluno = new Aluno(nome, sobrenome, casa, dataNascimento);
                    aluno.gerarCodigoMatricula(count + 1);

                    alunos[count] = aluno;
                    count++;

                    System.out.println("Aluno cadastrado: " + aluno);

                } catch (Exception e) {
                    System.out.println("Data inválida. Tente novamente.");
                }

            } else if (opcao == 2) {
                if (count == 0) {
                    System.out.println("Nenhum aluno cadastrado.");
                } else {
                    for (int i = 0; i < count; i++) {
                        System.out.println(alunos[i]);
                    }
                }

            } else if (opcao == 3) {
                System.out.print("Informe o nome da casa: ");
                String casaConsulta = scanner.nextLine().trim();

                int totalCasa = 0;
                for (int i = 0; i < count; i++) {
                    if (alunos[i].verificarCasa(casaConsulta)) {
                        System.out.println(alunos[i]);
                        totalCasa++;
                    }
                }
                System.out.println("Total de alunos na casa " + casaConsulta.toUpperCase() + ": " + totalCasa);

            } else if (opcao == 4) {
                for (int i = 0; i < count; i++) {
                    if (alunos[i].isMaioridadeMagica()) {
                        System.out.println(alunos[i]);
                    }
                }

            } else if (opcao == 5) {
                for (int i = 0; i < count; i++) {
                    if (!alunos[i].isMaioridadeMagica()) {
                        System.out.println(alunos[i]);
                    }
                }

            } else if (opcao == 6) {
                System.out.print("Informe palavra para buscar no sobrenome: ");
                String palavra = scanner.nextLine().trim();

                boolean achou = false;
                for (int i = 0; i < count; i++) {
                    if (alunos[i].sobrenomeContemPalavra(palavra)) {
                        System.out.println(alunos[i]);
                        achou = true;
                    }
                }
                if (!achou) {
                    System.out.println("Nenhum aluno encontrado com essa palavra no sobrenome.");
                }

            } else if (opcao == 7) {
                System.out.println("Encerrando programa...");
                break;

            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }

        scanner.close();
    }
}
