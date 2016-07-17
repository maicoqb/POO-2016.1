/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.ViewCaixa;

/**
 *
 * @author maico
 */
public class ControllerCancelarVenda implements ActionListener {

    private final ViewCaixa viewCaixa;

    public ControllerCancelarVenda(ViewCaixa viewCaixa) {
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
            viewCaixa.limparVenda();
        }
    }
    
}
