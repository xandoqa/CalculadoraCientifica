package calculadoracientifica;

public class OperacoesCientificas {
    
    public double seno(double angulo) {
        // Converter para radianos se o usuário provavelmente inseriu graus
        // Assumindo que valores > 2π estão em graus
        if (Math.abs(angulo) > 2 * Math.PI) {
            angulo = Math.toRadians(angulo);
        }
        return Math.sin(angulo);
    }
    
    public double cosseno(double angulo) {
        if (Math.abs(angulo) > 2 * Math.PI) {
            angulo = Math.toRadians(angulo);
        }
        return Math.cos(angulo);
    }
    
    public double tangente(double angulo) {
        if (Math.abs(angulo) > 2 * Math.PI) {
            angulo = Math.toRadians(angulo);
        }
        return Math.tan(angulo);
    }
    
    public double logaritmoNatural(double numero) {
        return Math.log(numero);
    }
    
    public double logaritmoBase10(double numero) {
        return Math.log10(numero);
    }
    
    public double exponencial(double expoente) {
        return Math.exp(expoente);
    }
    
    public long fatorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fatorial não definido para números negativos");
        }
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
    
    // Derivada numérica de f(x) = x^2 usando método de diferença finita
    public double derivadaNumerica(double x) {
        double h = 0.0001; // Pequena variação
        return (Math.pow(x + h, 2) - Math.pow(x, 2)) / h;
    }
    
    // Integral numérica de f(x) = x^2 usando método do trapézio
    public double integralNumerica(double a, double b) {
        int n = 1000; // Número de trapézios
        double h = (b - a) / n;
        double soma = 0.5 * (funcaoParaIntegral(a) + funcaoParaIntegral(b));
        
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            soma += funcaoParaIntegral(x);
        }
        
        return soma * h;
    }
    
    private double funcaoParaIntegral(double x) {
        return x * x; // f(x) = x^2
    }
}
