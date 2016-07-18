/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerInicializaViewRelatorioEstoque;
import controller.ControllerInicializaViewRelatorioVenda;
import controller.ControllerInicializaViewRelatorioVenda;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class ViewGerente extends JFrame {
    
    
    public ViewGerente(){
        super("Gerente");
        
        montaJanela();
        this.setVisible(true);
        this.pack();
        this.setSize(500, 150);
        this.setLocationRelativeTo(null);
    }

    private void montaJanela() {
        
       JPanel painelPrincipal = new JPanel(new GridLayout(1,3));
       JButton botaoCadastroProdutos = new JButton("Cadastro de Produtos");
            botaoCadastroProdutos.addActionListener( new ControllerInicializaViewRelatorioVenda());
       
       JButton botaoRelatorioVendas = new JButton("Relatorio de Vendas");
            botaoRelatorioVendas.addActionListener( new ControllerInicializaViewRelatorioVenda());
       
       JButton botaoRelatorioEstoque = new JButton("Relatorio de estoque");
            botaoRelatorioEstoque.addActionListener(new ControllerInicializaViewRelatorioEstoque());
       
       this.setContentPane(painelPrincipal);
       painelPrincipal.add(botaoCadastroProdutos);
       painelPrincipal.add(botaoRelatorioVendas);
       painelPrincipal.add(botaoRelatorioEstoque);
       
       
       
       
       
       
       
       
       
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
