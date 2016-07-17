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

/**
 *
 * @author maico
 */
public class ControllerLimparBusca implements ActionListener {

    private final DefaultListModel<Produto> produtos;
    private final JList<Produto> listaProduto;
    private final JTextField campoCodigo;
    private final JTextField campoNome;

    public ControllerLimparBusca(
            DefaultListModel<Produto> produtos,
            JList<Produto> listaProduto,
            JTextField campoBuscaCodigo,
            JTextField campoBuscaNome) {
        this.produtos = produtos;
        this.listaProduto = listaProduto;
        this.campoCodigo = campoBuscaCodigo;
        this.campoNome = campoBuscaNome;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        campoNome.setText("");
        campoCodigo.setText("");
        listaProduto.setModel(produtos);
    }
    
}
