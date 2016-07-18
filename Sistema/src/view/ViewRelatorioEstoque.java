/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;


public class ViewRelatorioEstoque extends JFrame {
    
    public ViewRelatorioEstoque(){
        super("Relatório Estoque");
        
        //montaJanela();
        
        this.setVisible(true);
        this.pack();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    public static void abrirJanela() {
       JFrame view = new ViewRelatorioEstoque();
    }
    
}
