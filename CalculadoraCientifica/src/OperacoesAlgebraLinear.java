package calculadoracientifica;

import java.util.Scanner;

public class OperacoesAlgebraLinear {
    private Scanner scanner = new Scanner(System.in);
    
    public void menuAlgebraLinear(int opcao, HistoricoCalculos historico) {
        switch (opcao) {
            case 1:
                somarMatrizes(historico);
                break;
            case 2:
                multiplicarMatrizes(historico);
                break;
            case 3:
                calcularDeterminante(historico);
                break;
            case 4:
                multiplicarMatrizPorEscalar(historico);
                break;
            case 5:
                transporMatriz(historico);
                break;
            case 6:
                resolverSistemaLinear(historico);
                break;
            case 7:
                return;
            default:
                System.out.println("Opção inválida!");
        }
    }
    
    private void somarMatrizes(HistoricoCalculos historico) {
        System.out.println("\n--- SOMA DE MATRIZES ---");
        System.out.print("Digite o número de linhas: ");
        int linhas = scanner.nextInt();
        System.out.print("Digite o número de colunas: ");
        int colunas = scanner.nextInt();
        
        double[][] matrizA = lerMatriz("Matriz A", linhas, colunas);
        double[][] matrizB = lerMatriz("Matriz B", linhas, colunas);
        
        double[][] resultado = new double[linhas][colunas];
        
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        
        System.out.println("\nResultado da soma:");
        imprimirMatriz(resultado);
        
        historico.adicionarCalculo("Soma de matrizes " + linhas + "x" + colunas + " realizada");
    }
    
    private void multiplicarMatrizes(HistoricoCalculos historico) {
        System.out.println("\n--- MULTIPLICAÇÃO DE MATRIZES ---");
        System.out.print("Digite o número de linhas da matriz A: ");
        int linhasA = scanner.nextInt();
        System.out.print("Digite o número de colunas da matriz A: ");
        int colunasA = scanner.nextInt();
        System.out.print("Digite o número de colunas da matriz B: ");
        int colunasB = scanner.nextInt();
        
        double[][] matrizA = lerMatriz("Matriz A", linhasA, colunasA);
        double[][] matrizB = lerMatriz("Matriz B", colunasA, colunasB); // linhasB = colunasA
        
        double[][] resultado = new double[linhasA][colunasB];
        
        for (int i = 0; i < linhasA; i++) {
            for (int j = 0; j < colunasB; j++) {
                resultado[i][j] = 0;
                for (int k = 0; k < colunasA; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        
        System.out.println("\nResultado da multiplicação:");
        imprimirMatriz(resultado);
        
        historico.adicionarCalculo("Multiplicação de matrizes realizada");
    }
    
    private void calcularDeterminante(HistoricoCalculos historico) {
        System.out.println("\n--- CÁLCULO DE DETERMINANTE ---");
        System.out.println("Escolha o tamanho da matriz:");
        System.out.println("1. 2x2");
        System.out.println("2. 3x3");
        int escolha = scanner.nextInt();
        
        double determinante = 0;
        
        if (escolha == 1) {
            double[][] matriz = lerMatriz("Matriz", 2, 2);
            determinante = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
            System.out.println("\nMatriz 2x2:");
            imprimirMatriz(matriz);
            System.out.printf("Determinante = %.2f\n", determinante);
        } else if (escolha == 2) {
            double[][] matriz = lerMatriz("Matriz", 3, 3);
            
            // Regra de Sarrus para 3x3
            double parte1 = matriz[0][0] * matriz[1][1] * matriz[2][2];
            double parte2 = matriz[0][1] * matriz[1][2] * matriz[2][0];
            double parte3 = matriz[0][2] * matriz[1][0] * matriz[2][1];
            double parte4 = matriz[0][2] * matriz[1][1] * matriz[2][0];
            double parte5 = matriz[0][0] * matriz[1][2] * matriz[2][1];
            double parte6 = matriz[0][1] * matriz[1][0] * matriz[2][2];
            
            determinante = parte1 + parte2 + parte3 - parte4 - parte5 - parte6;
            
            System.out.println("\nMatriz 3x3:");
            imprimirMatriz(matriz);
            System.out.printf("Determinante = %.2f\n", determinante);
        } else {
            System.out.println("Opção inválida!");
            return;
        }
        
        historico.adicionarCalculo("Determinante calculado = " + determinante);
    }
    
    private void multiplicarMatrizPorEscalar(HistoricoCalculos historico) {
        System.out.println("\n--- MULTIPLICAÇÃO POR ESCALAR ---");
        System.out.print("Digite o número de linhas: ");
        int linhas = scanner.nextInt();
        System.out.print("Digite o número de colunas: ");
        int colunas = scanner.nextInt();
        
        double[][] matriz = lerMatriz("Matriz", linhas, colunas);
        System.out.print("Digite o escalar: ");
        double escalar = scanner.nextDouble();
        
        double[][] resultado = new double[linhas][colunas];
        
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                resultado[i][j] = matriz[i][j] * escalar;
            }
        }
        
        System.out.println("\nResultado:");
        imprimirMatriz(resultado);
        
        historico.adicionarCalculo("Matriz multiplicada por escalar " + escalar);
    }
    
    private void transporMatriz(HistoricoCalculos historico) {
        System.out.println("\n--- TRANSPOSIÇÃO DE MATRIZ ---");
        System.out.print("Digite o número de linhas: ");
        int linhas = scanner.nextInt();
        System.out.print("Digite o número de colunas: ");
        int colunas = scanner.nextInt();
        
        double[][] matriz = lerMatriz("Matriz", linhas, colunas);
        double[][] transposta = new double[colunas][linhas];
        
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                transposta[j][i] = matriz[i][j];
            }
        }
        
        System.out.println("\nMatriz original:");
        imprimirMatriz(matriz);
        System.out.println("\nMatriz transposta:");
        imprimirMatriz(transposta);
        
        historico.adicionarCalculo("Transposição de matriz realizada");
    }
    
    private void resolverSistemaLinear(HistoricoCalculos historico) {
        System.out.println("\n--- RESOLUÇÃO DE SISTEMA LINEAR 2x2 ---");
        System.out.println("Sistema na forma:");
        System.out.println("a1*x + b1*y = c1");
        System.out.println("a2*x + b2*y = c2");
        
        System.out.print("Digite a1: ");
        double a1 = scanner.nextDouble();
        System.out.print("Digite b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Digite c1: ");
        double c1 = scanner.nextDouble();
        System.out.print("Digite a2: ");
        double a2 = scanner.nextDouble();
        System.out.print("Digite b2: ");
        double b2 = scanner.nextDouble();
        System.out.print("Digite c2: ");
        double c2 = scanner.nextDouble();
        
        double determinante = a1 * b2 - a2 * b1;
        
        if (determinante == 0) {
            System.out.println("Sistema indeterminado ou impossível!");
            historico.adicionarCalculo("Sistema linear: determinante = 0 (sem solução única)");
            return;
        }
        
        double x = (c1 * b2 - c2 * b1) / determinante;
        double y = (a1 * c2 - a2 * c1) / determinante;
        
        System.out.printf("\nSolução:\n");
        System.out.printf("x = %.4f\n", x);
        System.out.printf("y = %.4f\n", y);
        
        historico.adicionarCalculo(String.format("Sistema linear resolvido: x=%.4f, y=%.4f", x, y));
    }
    
    private double[][] lerMatriz(String nome, int linhas, int colunas) {
        double[][] matriz = new double[linhas][colunas];
        System.out.println("\nDigite os elementos da " + nome + ":");
        
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.printf("%s[%d][%d]: ", nome, i+1, j+1);
                matriz[i][j] = scanner.nextDouble();
            }
        }
        
        return matriz;
    }
    
    private void imprimirMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.printf("%8.2f ", matriz[i][j]);
            }
            System.out.println("|");
        }
    }
}
