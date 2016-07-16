/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import model.Produto;

/**
 *
 * @author User
 */
public class ControllerAdicionarProduto implements ActionListener {

    private final DefaultListModel<Produto> produtos;
    
    public ControllerAdicionarProduto(DefaultListModel<Produto> produtos){
        this.produtos=produtos;
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.produtos.addElement(new Produto());        
    }
    
    
    
    
}
