package calculadoracientifica;

import java.util.ArrayList;
import java.util.List;

public class HistoricoCalculos {
    private List<String> historico;
    private static final int LIMITE_HISTORICO = 50;
    
    public HistoricoCalculos() {
        historico = new ArrayList<>();
    }
    
    public void adicionarCalculo(String calculo) {
        historico.add(calculo);
        
        // Limitar o tamanho do histórico
        if (historico.size() > LIMITE_HISTORICO) {
            historico.remove(0);
        }
    }
    
    public void exibirHistorico() {
        System.out.println("\n========== HISTÓRICO DE CÁLCULOS ==========");
        
        if (historico.isEmpty()) {
            System.out.println("Nenhum cálculo realizado ainda.");
        } else {
            for (int i = 0; i < historico.size(); i++) {
                System.out.printf("%3d. %s\n", i+1, historico.get(i));
            }
        }
        
        System.out.println("============================================");
    }
    
    public void limparHistorico() {
        historico.clear();
    }
    
    public int getQuantidadeCalculos() {
        return historico.size();
    }
}
