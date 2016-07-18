/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ViewCadastroProduto;

/**
 *
 * @author User
 */
public class ControllerInicializaViewCadastro implements ActionListener {

    public ControllerInicializaViewCadastro() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       ViewCadastroProduto.abrirJanela();
    }
    
}
