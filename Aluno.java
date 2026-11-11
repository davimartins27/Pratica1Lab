import java.util.Scanner;

class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;

    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.imc = 0.0;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    public double getImc() { return imc; }

    public void calculaIMC() {
        this.imc = peso / (altura * altura);
    }

    public String informaObesidade() {
        if (imc < 18.5) return "Abaixo do peso";
        else if (imc < 25) return "Peso normal";
        else if (imc < 30) return "Sobrepeso";
        else if (imc < 35) return "Obesidade grau 1";
        else if (imc < 40) return "Obesidade grau 2";
        else return "Obesidade grau 3";
    }
}

class Aluno {
    private String nome;
    private int idade;
    private int coragem;
    private int inteligencia;
    private int ambicao;
    private int lealdade;
    private String casa;

    public Aluno(String nome, int idade, int coragem, int inteligencia, int ambicao, int lealdade) {
        this.nome = nome;
        this.idade = idade;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.casa = "";
    }

    public void calcularCasa() {
        int grifinoria = (2 * coragem) + lealdade;
        int sonserina = (2 * ambicao) + inteligencia; // ajustei "estrategia" para inteligencia pela prática
        int corvinal = (2 * inteligencia) + ambicao;  // ajustei "criatividade" para ambicao para facilitar
        int lufalufa = ((2 * lealdade) + coragem) / 3;

        int max = grifinoria;
        casa = "Grifinória";

        if (sonserina > max) {
            max = sonserina;
            casa = "Sonserina";
        }
        if (corvinal > max) {
            max = corvinal;
            casa = "Corvinal";
        }
        if (lufalufa > max) {
            max = lufalufa;
            casa = "Lufa-Lufa";
        }
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Coragem: " + coragem);
        System.out.println("Inteligência: " + inteligencia);
        System.out.println("Ambição: " + ambicao);
        System.out.println("Lealdade: " + lealdade);
        System.out.println("Casa: " + casa);
        System.out.println("----------------------");
    }
}

public class Pratica01_PM_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Exercício 1 - Pessoa IMC
        System.out.println("Digite nome:");
        String nome = sc.nextLine();
        System.out.println("Digite sobrenome:");
        String sobrenome = sc.nextLine();
        System.out.println("Digite idade:");
        int idade = sc.nextInt();
        System.out.println("Digite altura (m):");
        double altura = sc.nextDouble();
        System.out.println("Digite peso (kg):");
        double peso = sc.nextDouble();
        sc.nextLine(); // limpar buffer

        Pessoa p = new Pessoa(nome, sobrenome, idade, altura, peso);
        p.calculaIMC();

        System.out.printf("IMC de %s %s: %.2f\n", nome, sobrenome, p.getImc());
        System.out.println("Classificação: " + p.informaObesidade());

        // Exercício 2 - Chapéu Seletor
        System.out.println("\nCadastro de alunos para Chapéu Seletor. Digite 'sair' para encerrar.");

        while (true) {
            System.out.println("Nome do aluno:");
            String alunoNome = sc.nextLine();
            if (alunoNome.equalsIgnoreCase("sair")) break;

            System.out.println("Idade:");
            int alunoIdade = sc.nextInt();
            System.out.println("Coragem (0 a 10):");
            int coragem = sc.nextInt();
            System.out.println("Inteligência (0 a 10):");
            int inteligencia = sc.nextInt();
            System.out.println("Ambição (0 a 10):");
            int ambicao = sc.nextInt();
            System.out.println("Lealdade (0 a 10):");
            int lealdade = sc.nextInt();
            sc.nextLine(); // limpar buffer

            Aluno aluno = new Aluno(alunoNome, alunoIdade, coragem, inteligencia, ambicao, lealdade);
            aluno.calcularCasa();
            aluno.exibirInformacoes();
        }

        sc.close();
        System.out.println("Programa encerrado.");
    }
}
