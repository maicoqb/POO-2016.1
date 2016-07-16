/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Estoque;
import model.Produto;
import view.ViewBuscaProduto;

/**
 *
 * @author maico
 */
public class ControllerBuscarProduto implements ActionListener {

    private final ViewBuscaProduto janela;

    public ControllerBuscarProduto(ViewBuscaProduto janela) {
        this.janela = janela;
    }

    public void actionPerformed(ActionEvent e) {
        // Inicia lista de produtos
        ArrayList<Produto> produtos = Estoque.getInstancia().buscaProdutos("Nome");
        // Efetua busca no model
        

        // Informa a view da mudança
        this.janela.exibeResultados(produtos);

    }

}
