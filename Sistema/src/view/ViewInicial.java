/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerInicializaViewFuncionario;
import controller.ControllerInicializaViewGerente;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ViewInicial extends JFrame {
JTextField campoLogin = new JTextField("");
JPasswordField campoSenha = new JPasswordField("");
    public ViewInicial() {
        super("Inicio");

        montaJanela();
        this.setVisible(true);
        this.pack();
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void montaJanela() {

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        
        this.setContentPane(painelPrincipal);
        
        JPanel painelbotoes = new JPanel(new GridLayout(1,3));
        painelPrincipal.add(painelbotoes,BorderLayout.CENTER);
        
        //BOTOES
        JButton botaoLoginGerente = new JButton("Gerente");
        botaoLoginGerente.addActionListener(new ControllerInicializaViewGerente(campoLogin,campoSenha));
        JButton botaoLoginFuncionario = new JButton("Funcionario");
        botaoLoginFuncionario.addActionListener(new ControllerInicializaViewFuncionario(campoLogin,campoSenha));
        JButton botaoBuscarProdutos = new JButton("Buscar Produtos");
  //      botaoBuscarProdutos.addActionListener(new ControllerInicializaViewRelatorioEstoque());
        
        
        //BLOCO LOGIN GERENTE
        JPanel blocoLoginSenha = new JPanel(new GridLayout(2,1));
        JPanel blocoSenha = new JPanel(new GridLayout(2,1));
        JPanel blocoLogin = new JPanel(new GridLayout(2,1));
       
         
        //Nome e campo
        JLabel labelLogin = new JLabel("Nome: ");
        
        blocoLogin.add(labelLogin,BorderLayout.NORTH);
        blocoLogin.add(campoLogin,BorderLayout.SOUTH);
        
        //senha e campo
        JLabel labelSenha = new JLabel("Senha: ");
        
        blocoSenha.add(labelSenha,BorderLayout.NORTH);
        blocoSenha.add(campoSenha,BorderLayout.SOUTH);
        
        blocoLoginSenha.add(blocoLogin);
        blocoLoginSenha.add(blocoSenha);
        
        
        
        JPanel centralizar = new JPanel(new GridLayout(1,3));
        centralizar.add(new JPanel());
        centralizar.add(blocoLoginSenha);
        centralizar.add(new JPanel());
        painelPrincipal.add(centralizar,BorderLayout.SOUTH);
        
        ///////////////////////////////
        


          
        painelbotoes.add(botaoLoginGerente);
        painelbotoes.add(botaoLoginFuncionario);
        painelbotoes.add(botaoBuscarProdutos);
    }

}
