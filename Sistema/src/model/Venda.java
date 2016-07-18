package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class Venda {

    private ArrayList<Produto> produtos;
    private float valorVenda;
    private Caixa caixa;
    private Funcionario funcionario;
    private Date data;
    private final String tipoPagamento;

    public Venda(
            Caixa caixa, 
            Funcionario funcionario, 
            ArrayList<Produto> produtos, 
            String tipoPagamento) {
        this.caixa = caixa;
        this.funcionario = funcionario;
        this.produtos = produtos;
        this.data = new Date();
        this.tipoPagamento = tipoPagamento;
        this.valorVenda = 0;
        
        for (Produto produto : produtos) {
            this.valorVenda += produto.getValor() * produto.getQuantidade();
        }

    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Date getData() {
        return data;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

}
