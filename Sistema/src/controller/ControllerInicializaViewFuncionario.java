/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import view.ViewCaixa;

/**
 *
 * @author User
 */
public class ControllerInicializaViewFuncionario implements ActionListener {

    JTextField campoLogin;
    JPasswordField campoSenha;
    HashMap<Integer, Integer> login;
    Boolean[] caixaDisponivel;

    public ControllerInicializaViewFuncionario(JTextField campoLogin, JPasswordField campoSenha) {
        this.campoLogin = campoLogin;
        this.campoSenha = campoSenha;
        login = new HashMap<>();
        this.login.put(1, 123);
        this.login.put(2, 123);
        this.login.put(3, 123);
        this.login.put(4, 123);
        this.login.put(5, 123);
        caixaDisponivel = new Boolean[3];
        for (int i = 0; i < caixaDisponivel.length; i++) {
                caixaDisponivel[i]=true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String SLogin = this.campoLogin.getText();
        int loginNum = Integer.parseInt(SLogin);

        String Senha = this.campoSenha.getText();
        int senhaNum = Integer.parseInt(Senha);

        if (login.get(loginNum) == senhaNum) {
            int i;
            for (i = 0; i < caixaDisponivel.length; i++) {
                if (caixaDisponivel[i]){
                    caixaDisponivel[i]=false;
                    ViewCaixa.abrirJanela(loginNum, i+1);
                    return;
                }
            }
            if (i>2){
                System.out.println("MENSAGEM CAIXAS OCUPADAS");
            }

        }

//        if (((this.campoLogin).getText().equals("admin")) && ((this.campoSenha).getText().equals("123"))) {
//
//        }

    }

}
