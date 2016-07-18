/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerFinalizarVenda;
import controller.ControllerCancelarVenda;
import controller.ControllerAdicionarProdutoCaixa;
import controller.ControllerCodigoQuantidadeCaixa;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import lib.Helpers;
import model.Registro;
import model.Venda;

public class ViewRelatorioVenda extends JFrame {

    private final DefaultTableModel listaVendasModel = new DefaultTableModel();
    private final JTable tabela = new JTable(listaVendasModel);
     

    
    public ViewRelatorioVenda() {
        super("Relatório Venda");
        montaJanela();
        this.setVisible(true);
    }

    private void montaJanela() {
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        JPanel painelTabela = new JPanel(new BorderLayout());
        painelPrincipal.add(painelTabela, BorderLayout.CENTER);
        this.setContentPane(painelPrincipal);
        
        //BLOCO TABELA
        
        JScrollPane painelScrollTabela = new JScrollPane();
        painelScrollTabela.setViewportView(tabela);
        
        painelTabela.setBorder(BorderFactory.createTitledBorder("Produtos"));
        listaVendasModel.addColumn("Caixa");
        listaVendasModel.addColumn("Funcionario");
        listaVendasModel.addColumn("Valor");
        listaVendasModel.addColumn("Data");
        painelTabela.add(painelScrollTabela, BorderLayout.CENTER);
        ArrayList<Venda> vendasArr = Registro.getInstancia().getVendas();
       for(Venda v : vendasArr){
           System.out.println("entrei");
           listaVendasModel.addRow(
                    new Object[]{
                        v.getCaixa(),
                        v.getFuncionario(),
                        v.getValorVenda(),
                        v.getData().toString()
                    });
           
       }
  //  listaVendasModel.addRow(new Object[]{"caixa","Func","1.00","data"});
        
        
        
        
        
        
        
        
        this.pack();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public void limparVenda() {
        

    }
}
