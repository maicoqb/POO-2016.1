/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Produto;

/**
 *
 * @author maico
 */
public class ControllerCarregarProduto implements ListSelectionListener {

    private final JList<Produto> lista;
    private final JTextField campoCodigo;
    private final JTextField campoNome;
    private final JTextField campoValor;
    private final JTextField campoQuantidade;
    private final JTextArea campoDescricao;
    private final JComboBox campoTipoQuantidade;

    public ControllerCarregarProduto(
            JList<Produto> listaProduto,
            JTextField campoCodigo,
            JTextField campoNome,
            JTextField campoValor,
            JTextField campoQuantidade,
            JTextArea campoDescricao,
            JComboBox campoTipoQuantidade) {
        this.lista = listaProduto;
        this.campoCodigo = campoCodigo;
        this.campoNome = campoNome;
        this.campoValor = campoValor;
        this.campoQuantidade = campoQuantidade;
        this.campoDescricao = campoDescricao;
        this.campoTipoQuantidade = campoTipoQuantidade;
        
        
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Produto produto = lista.getSelectedValue();
        // Verifica se realmente tem um produto selecionado 
        if(produto != null){
            campoCodigo.setText(produto.getCodigo());
            campoNome.setText(produto.getNome());
            campoValor.setText(Float.toString(produto.getValor()).replace('.', ','));
            campoQuantidade.setText(Float.toString(produto.getQuantidade()));
            campoDescricao.setText(produto.getDescricao());
            campoTipoQuantidade.setSelectedItem(produto.getTipoQuantidade());
            
        }
        lista.repaint();
    }
    
}
