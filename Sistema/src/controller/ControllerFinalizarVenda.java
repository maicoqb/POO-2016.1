/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Registro;
import model.Venda;
import view.ViewCaixa;
import view.ViewRelatorioVenda;

/**
 *
 * @author User
 */
public class ControllerFinalizarVenda implements ActionListener {
    DefaultTableModel listaProdutos;
    ViewCaixa viewCaixa;
    private final String codigoCaixa;
    private final String codigoFuncionario;
    
    
    public ControllerFinalizarVenda(ViewCaixa viewCaixa,DefaultTableModel produtos,
                                    String codigoCaixa,String codigoFuncionario) {
        this.listaProdutos=produtos;   
        this.viewCaixa=viewCaixa;
        this.codigoCaixa = codigoCaixa;
        this.codigoFuncionario = codigoFuncionario;
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        Venda venda = new Venda(listaProdutos);
        Registro registro = Registro.getInstancia();
        registro.adicionarVenda(venda);
        viewCaixa.limparVenda();   
        
        JFrame telaRelatorio = new ViewRelatorioVenda();
    }
    
}
