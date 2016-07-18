package model;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultListModel;
import lib.Helpers;

public class Registro {

    private static Registro instancia;

    private ArrayList<Venda> vendas;

    private Registro() {
        vendas = new ArrayList<>();
        
        seed();
    }

    public static Registro getInstancia() {
        if (instancia == null) {
            init();
        }
        return instancia;
    }
    public void adicionarVenda(Venda venda){
        vendas.add(venda);
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }
    
    public static void init(){
        instancia = new Registro();
    }
    
    public void seed() {
        Random rand = new Random();

        ArrayList<Produto> todosProdutos = Estoque.getInstancia().getProdutos();
        
        Caixa[] caixas = new Caixa[3];
        for(int i=0; i<3; i++){
            caixas[i] = new Caixa(i+1);
        }
        
        Funcionario[] funcionarios = new Funcionario[5];
        for(int i=0; i<5; i++){
            funcionarios[i] = new Funcionario(i+1);
        }
        
        String[] tiposPagamento = {"dinheiro", "cartao"};
        
        for (int i = 0; i < 20; i++) {
            Caixa caixa = caixas[Helpers.randIntMinMax(0,3)];
            Funcionario funcionario = funcionarios[Helpers.randIntMinMax(0,5)];
            String tipoPagamento = tiposPagamento[Helpers.randIntMinMax(0, 2)];

            ArrayList<Produto> produtos = new ArrayList<>();
            int x = Helpers.randIntMinMax(1, todosProdutos.size()-1);
            for(int j = 0; j < x; j++){
                int y = Helpers.randIntMinMax(1, todosProdutos.size()-1);
                
                Produto p = todosProdutos.get(y).clone();
                float quantidade = rand.nextFloat()*p.getQuantidade();
                if(quantidade == 0){
                    continue;
                }
                
                p.setQuantidade(quantidade);
                produtos.add(p);
                
                p = todosProdutos.get(y);
                p.setQuantidade(p.getQuantidade() - quantidade);
            }
            
            Venda venda = new Venda(caixa, funcionario, produtos, tipoPagamento);
            this.adicionarVenda(venda);
            
        }
    }
}
