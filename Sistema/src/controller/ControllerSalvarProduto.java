/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Estoque;
import model.Produto;

/**
 *
 * @author maico
 */
public class ControllerSalvarProduto implements ActionListener {

    private final JList<Produto> lista;
    private final JTextField campoCodigo;
    private final JTextField campoNome;
    private final JTextField campoValor;
    private final JTextField campoQuantidade;
    private final JTextArea campoDescricao;
    private final JComboBox campoTipoQuantidade;

    public ControllerSalvarProduto(
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
    public void actionPerformed(ActionEvent e) {
        Produto produto = lista.getSelectedValue();
        // Verifica se realmente tem um produto selecionado 
        if (produto != null) {
            produto.setCodigo(campoCodigo.getText());
            produto.setNome(campoNome.getText());
            produto.setValor(Float.parseFloat(campoValor.getText().replace(',', '.')));
            produto.setDescricao(campoDescricao.getText());
            produto.setTipoQuantidade(campoTipoQuantidade.getSelectedItem().toString());

            // Se for Kg, a quantidade pode ser float
            if (campoTipoQuantidade.getSelectedItem().equals(Produto.TIPO_QUILO)) {
                produto.setQuantidade(Float.parseFloat(campoQuantidade.getText().replace(',', '.')));
            } 
            // Se não, pra unidade a quantidade tem que ser inteiro
            else {
                produto.setQuantidade((int) Float.parseFloat(campoQuantidade.getText().replace(',', '.')));
            }
            
            Estoque.getInstancia().salvaProduto(produto);
        }
        
        lista.repaint();
    }

}
