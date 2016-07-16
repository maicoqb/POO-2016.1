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
import model.Estoque;
import model.Produto;

/**
 *
 * @author User
 */
public class ControllerRemoverProduto implements ActionListener {

    private final JList<Produto> lista;
    private final DefaultListModel<Produto> produtos;

    public ControllerRemoverProduto(DefaultListModel<Produto> produtos, JList<Produto> listaProduto) {
        this.produtos = produtos;
        this.lista = listaProduto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Produto produto = lista.getSelectedValue();
        produtos.removeElement(produto);
    }
   
    

}
