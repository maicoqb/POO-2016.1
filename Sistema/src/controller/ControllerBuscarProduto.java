/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import model.Produto;

public class ControllerBuscarProduto implements ActionListener {

    private final DefaultListModel<Produto> produtos;
    private final JList<Produto> listaProduto;
    private final JTextField campoCodigo;
    private final JTextField campoNome;

    public ControllerBuscarProduto(
            DefaultListModel<Produto> produtos,
            JList<Produto> listaProduto,
            JTextField campoBuscaCodigo,
            JTextField campoBuscaNome) {
        this.produtos = produtos;
        this.listaProduto = listaProduto;
        this.campoCodigo = campoBuscaCodigo;
        this.campoNome = campoBuscaNome;
    }

    public void actionPerformed(ActionEvent e) {
        DefaultListModel<Produto> produtos = new DefaultListModel<>();
        String nome = campoNome.getText().toLowerCase();
        String codigo = campoCodigo.getText().toLowerCase();
        
        Produto produto;
        for(int i=0; i<this.produtos.size(); i++){
        // for (Produto produto : (Produto[])this.produtos.toArray()) {
            produto = this.produtos.get(i);
            
            if (produto.getNome().toLowerCase().contains(nome)
                    && produto.getCodigo().toLowerCase().contains(codigo)) {
                produtos.addElement(produto);
            }
        }
        
        listaProduto.setModel(produtos);
    }

}
