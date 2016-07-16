/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerBuscarProduto;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import model.Produto;

/**
 *
 * @author maico
 */
public class ViewBuscaProduto extends JFrame {

    public ViewBuscaProduto(){
        super("Busca de Produtos");
        montaJanela();
        this.setVisible(true);
    }

    private void montaJanela() {
        // Montando a janela;
        
        // Adiciona input
        
        // Adiciona botão
        JButton botaoBuscarProduto = new JButton();
        botaoBuscarProduto.setText("Buscar");
        botaoBuscarProduto.addActionListener(new ControllerBuscarProduto(this));
        
        // Bla bla
    }

    public void exibeResultados(ArrayList<Produto> produtos) {
        // Pega os produtos e adiciona na JList dos resultados
        // Exibe a JList
    }
    
    
    
}
