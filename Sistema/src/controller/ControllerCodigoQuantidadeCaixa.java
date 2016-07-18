/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import lib.Helpers;
import model.Estoque;
import model.Produto;

/**
 *
 * @author maico
 */
public class ControllerCodigoQuantidadeCaixa implements FocusListener {

    private final JTextField campoCodigo;
    private final JTextField campoNome;
    private final JTextField campoValor;
    private final JTextArea campoDescricao;
    private final JTextField campoSubtotal;
    private final JTextField campoQuantidade;

    public ControllerCodigoQuantidadeCaixa(
            JTextField campoCodigo,
            JTextField campoNome,
            JTextField campoValor,
            JTextArea campoDescricao,
            JTextField campoSubtotal,
            JTextField campoQuantidade) {
        this.campoCodigo = campoCodigo;
        this.campoNome = campoNome;
        this.campoValor = campoValor;
        this.campoDescricao = campoDescricao;
        this.campoSubtotal = campoSubtotal;
        this.campoQuantidade = campoQuantidade;
    }

    @Override
    public void focusGained(FocusEvent e) {
        // DO NOTHING
    }

    @Override
    public void focusLost(FocusEvent e) {
        Produto produto = Estoque.getInstancia().getProdutoByCodigo(campoCodigo.getText());
        if (produto != null) {
            float quantidade = Helpers.toFloat(campoQuantidade.getText());
            if (produto.getTipoQuantidade().equals(Produto.TIPO_UNIDADE)) {
                quantidade = (int) quantidade;
            }

            if (quantidade > produto.getQuantidade()) {
//                JOptionPane.showMessageDialog(
//                        null,
//                        "Não há quantidade suficiente do produto.",
//                        "Quantidade Insuficiente",
//                        JOptionPane.INFORMATION_MESSAGE);
//                quantidade = produto.getQuantidade();
//                campoQuantidade.setText(Helpers.toMoney(quantidade));
//                campoCodigo.setText(produto.getCodigo());
            } else {
                campoQuantidade.setText(Helpers.toMoney(quantidade));
                campoNome.setText(produto.getNome());
                campoValor.setText(Helpers.toMoney(produto.getValor()));
                campoDescricao.setText(produto.getDescricao());
                campoSubtotal.setText(Helpers.toMoney(quantidade * produto.getValor()));
            }

        }
    }

}
