# Calculadora Científica - UCB 2023

## Descrição
Projeto avaliativo desenvolvido para a Universidade Católica de Brasília (2023) que testa conhecimentos em desenvolvimento de aplicativos complexos em Java. A calculadora tem como objetivo otimizar cálculos nas matérias de cálculo, física e álgebra linear.

## Funcionalidades

### 1. Operações Básicas
- Adição, subtração, multiplicação e divisão
- Potenciação e raiz quadrada

### 2. Operações Científicas (Cálculo)
- Funções trigonométricas (seno, cosseno, tangente)
- Logaritmos natural e base 10
- Exponencial (e^x)
- Fatorial
- Derivada numérica
- Integral numérica

### 3. Operações de Física
- Velocidade média
- Aceleração
- Força (2ª Lei de Newton)
- Energia cinética e potencial
- Trabalho e potência
- Lei de Ohm

### 4. Álgebra Linear
- Soma e multiplicação de matrizes
- Cálculo de determinantes (2x2 e 3x3)
- Multiplicação por escalar
- Transposição de matriz
- Resolução de sistemas lineares 2x2

### 5. Histórico
- Armazenamento dos últimos 50 cálculos
- Visualização completa do histórico

## Como Compilar e Executar

### Compilação
```bash
javac -d bin src/calculadoracientifica/*.java

Execução:

java -cp bin calculadoracientifica.Main


Criar JAR Executável:

jar cfe CalculadoraCientifica.jar calculadoracientifica.Main -C bin .
java -jar CalculadoraCientifica.jar
