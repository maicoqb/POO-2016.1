/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.ViewPagamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import lib.Helpers;
import model.Caixa;
import model.Estoque;
import model.Funcionario;
import model.Produto;
import view.ViewCaixa;

/**
 *
 * @author User
 */
public class ControllerFinalizarVenda implements ActionListener {

    DefaultTableModel listaProdutos;
    ViewCaixa viewCaixa;
    private final Caixa caixa;
    private final Funcionario funcionario;

    public ControllerFinalizarVenda(
            ViewCaixa viewCaixa,
            DefaultTableModel produtos,
            Caixa caixa,
            Funcionario funcionario) {
        this.listaProdutos = produtos;
        this.viewCaixa = viewCaixa;
        this.caixa = caixa;
        this.funcionario = funcionario;
    }

    public void actionPerformed(ActionEvent e) {
        int linhas = listaProdutos.getRowCount();
        
        ArrayList<Produto> produtos = new ArrayList<>();

        Produto produto;
        String codigo;
        float quantidade;
        
        float valorTotal = 0;
        
        for (int i = 0; i < linhas; i++) {
            codigo = (String) listaProdutos.getValueAt(i, 1);
            quantidade = Helpers.toFloat((String) listaProdutos.getValueAt(i, 4));
            produto = Estoque.getInstancia().getProdutoByCodigo(codigo).clone();
            produto.setQuantidade(quantidade);

            produtos.add(produto);
            
            valorTotal+=produto.getValor() * produto.getQuantidade();
        }

        JFrame pagamento = new ViewPagamento(caixa, funcionario, viewCaixa, produtos, valorTotal);
    }

}
