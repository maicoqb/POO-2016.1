/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import view.ViewGerente;

/**
 *
 * @author User
 */
public class ControllerInicializaViewGerente implements ActionListener {

    JTextField campoLogin;
    JPasswordField campoSenha;

    public ControllerInicializaViewGerente(JTextField campoLogin, JPasswordField campoSenha) {
        this.campoLogin = campoLogin;
        this.campoSenha = campoSenha;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (((campoLogin).getText().equals("admin")) && ((campoSenha).getText().equals("123"))) {

            ViewGerente.abrirJanela();

        }

    }

}
