/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ViewRelatorioEstoque;


/**
 *
 * @author User
 */
public class ControllerInicializaViewRelatorioEstoque implements ActionListener {

    public ControllerInicializaViewRelatorioEstoque() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       ViewRelatorioEstoque.abrirJanela();
    }
    
}
