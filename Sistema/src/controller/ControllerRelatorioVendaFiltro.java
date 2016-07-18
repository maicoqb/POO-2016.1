/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import lib.Helpers;
import model.Registro;
import model.Venda;

/**
 *
 * @author maico
 */
public class ControllerRelatorioVendaFiltro implements KeyListener, ItemListener, ActionListener {

    private final JComboBox<String> campoCaixa;
    private final JComboBox<String> campoFuncionario;
    private final JComboBox<String> campoTipoPagamento;
    private final JTextField campoValorMin;
    private final JTextField campoValorMax;
    private final DefaultTableModel listaVendasModel;

    public ControllerRelatorioVendaFiltro(
            JComboBox<String> campoCaixa, 
            JComboBox<String> campoFuncionario, 
            JComboBox<String> campoTipoPagamento, 
            JTextField campoValorMin, 
            JTextField campoValorMax, 
            DefaultTableModel listaVendasModel) {
        this.campoCaixa = campoCaixa;
        this.campoFuncionario = campoFuncionario;
        this.campoTipoPagamento = campoTipoPagamento;
        this.campoValorMin = campoValorMin;
        this.campoValorMax = campoValorMax;
        this.listaVendasModel = listaVendasModel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // DO NOTHING
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // DO NOTHING
    }

    @Override
    public void keyReleased(KeyEvent e) {
        aplicarFiltro();
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        aplicarFiltro();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        limparFiltro();
        aplicarFiltro();
    }
    
    protected void aplicarFiltro(){
        String funcionario = (String) campoFuncionario.getSelectedItem();
        String caixa = (String) campoCaixa.getSelectedItem();
        String tipoPagamento = (String) campoTipoPagamento.getSelectedItem();
        String valorMin = campoValorMin.getText();
        String valorMax = campoValorMax.getText();

        // Limpa a lista de vendas
        while (listaVendasModel.getRowCount() > 0) {
            listaVendasModel.removeRow(0);
        }

        // Preenche a lista com o valor selecionado
        ArrayList<Venda> vendasArr = Registro.getInstancia().getVendas();
        for (Venda venda : vendasArr) {
            // Se caixa não for vazio,
            // E a venda não possuir o caixa, continue
            if(!caixa.isEmpty() &&
                    !venda.getCaixa().toString().equals(caixa)){
                continue;
            }
            
            // Se funcionario não for vazio,
            // E a venda não possuir o funcionário, continue
            if(!funcionario.isEmpty() &&
                    !venda.getFuncionario().toString().equals(funcionario)){
                continue;
            }
            
            // Se tipo pagamento não for vazio,
            // E a venda não possuir o tipo pagamento, continue
            if(!tipoPagamento.isEmpty() &&
                    !venda.getTipoPagamento().equals(tipoPagamento)){
                continue;
            }
            
            // Se o valor min não for vazio,
            // E a venda não for maior que o valor min, continue
            if(!valorMin.isEmpty() &&
                    !(venda.getValorVenda() >= Helpers.toFloat(valorMin))){
                continue;
            }
            
            // Se o valor max não for vazio,
            // E a venda não for menor que o valor max, continue
            if(!valorMax.isEmpty() &&
                    !(venda.getValorVenda() <= Helpers.toFloat(valorMax))){
                continue;
            }
            
            listaVendasModel.addRow(
                    new Object[]{
                        venda.getCaixa().toString(),
                        venda.getFuncionario().toString(),
                        venda.getValorVenda(),
                        venda.getTipoPagamento(),
                        venda.getData().toString()
                    });
        }
    }

    protected void limparFiltro(){
        campoFuncionario.setSelectedIndex(0);
        campoCaixa.setSelectedIndex(0);
        campoTipoPagamento.setSelectedIndex(0);
        campoValorMin.setText("");
        campoValorMax.setText("");
    }
}
