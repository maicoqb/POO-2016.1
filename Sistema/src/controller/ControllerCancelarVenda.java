/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import lib.Helpers;
import model.Estoque;
import model.Produto;
import view.ViewCaixa;

/**
 *
 * @author maico
 */
public class ControllerCancelarVenda implements ActionListener {

    private final ViewCaixa viewCaixa;
    private final DefaultTableModel produtos;
    public ControllerCancelarVenda(ViewCaixa viewCaixa,DefaultTableModel produtos) {
        this.produtos = produtos;
        this.viewCaixa = viewCaixa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object[] options = { "Confirmar", "Cancelar" };
        int opcao = JOptionPane.showOptionDialog(
                null, 
                "Tem certeza que deseja cancelar esta venda?", 
                "Cancelamento de Venda", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.WARNING_MESSAGE, 
                null, 
                options,
                options[1]
                );
        
        if(opcao==0){
            Produto p;
            String codigo;
            float quantidade;
            int linhas = produtos.getRowCount();
            for (int i = 0; i < linhas; i++) {
                codigo = (String) produtos.getValueAt(i,1);
                quantidade = Helpers.toFloat((String) produtos.getValueAt(i,4));
                p = Estoque.getInstancia().getProdutoByCodigo(codigo);
                p.setQuantidade(p.getQuantidade()+quantidade);
            }
            viewCaixa.limparVenda();
            
        }
    }
}
