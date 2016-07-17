/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerCancelarVenda;
import controller.ControllerAdicionarProdutoCaixa;
import controller.ControllerCodigoQuantidadeCaixa;
import java.awt.BorderLayout;
import java.awt.GridLayout;
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

public class ViewCaixa extends JFrame {

    private final DefaultTableModel produtos = new DefaultTableModel();
    private final JTable tabela = new JTable(produtos);
    
    private final JTextField campoCodigo = new JTextField();
    private final JTextField campoQuantidade = new JTextField();
    
    private final JTextField campoNome = new JTextField();
    private final JTextField campoValor = new JTextField();
    private final JTextArea campoDescricao = new JTextArea();
    private final JTextField campoSubtotal = new JTextField();
    
    private final JTextField campoTotal = new JTextField();
    
    private final String codigoCaixa;
    private final String codigoFuncionario;
    
    public ViewCaixa() {
        super("Caixa");
        
        codigoCaixa = UUID.randomUUID().toString();
        codigoFuncionario = UUID.randomUUID().toString();
        
        montaJanela();

        this.setVisible(true);
    }

    private void montaJanela() {

        JPanel painelProduto = new JPanel(new BorderLayout());
        
        // Bloco do Produto
        JPanel blocoProduto = new JPanel(new BorderLayout());
        
        JPanel blocoNorthProduto = new JPanel(new GridLayout(2,2));
        
        JPanel blocoCodigo = new JPanel(new BorderLayout());
        blocoCodigo.add(new JLabel("Codigo:"), BorderLayout.NORTH);
        campoCodigo.addFocusListener(
                new ControllerCodigoQuantidadeCaixa(campoCodigo, campoNome, campoValor, 
                        campoDescricao, campoSubtotal, campoQuantidade));
        blocoCodigo.add(campoCodigo, BorderLayout.CENTER);
        blocoNorthProduto.add(blocoCodigo);
        
        JPanel blocoQuantidade = new JPanel(new BorderLayout());
        blocoQuantidade.add(new JLabel("Quantidade/Peso:"), BorderLayout.NORTH);
        campoQuantidade.setText("1");
        campoQuantidade.addFocusListener(
                new ControllerCodigoQuantidadeCaixa(campoCodigo, campoNome, campoValor, 
                        campoDescricao, campoSubtotal, campoQuantidade));
        blocoQuantidade.add(campoQuantidade, BorderLayout.CENTER);
        blocoNorthProduto.add(blocoQuantidade);
        
        // Info do produto
        JPanel blocoNome = new JPanel(new BorderLayout());
        blocoNome.add(new JLabel("Nome:"), BorderLayout.NORTH);
        campoNome.setEditable(false);
        blocoNome.add(campoNome, BorderLayout.CENTER);
        blocoNorthProduto.add(blocoNome);
        
        JPanel blocoValor = new JPanel(new BorderLayout());
        blocoValor.add(new JLabel("Valor:"), BorderLayout.NORTH);
        campoValor.setEditable(false);
        blocoValor.add(campoValor, BorderLayout.CENTER);
        blocoNorthProduto.add(blocoValor);
        
        blocoProduto.add(blocoNorthProduto, BorderLayout.NORTH);
        
        JPanel blocoDescricao = new JPanel(new BorderLayout());
        blocoDescricao.add(new JLabel("Descricao:"), BorderLayout.NORTH);
        campoDescricao.setEditable(false);
        campoDescricao.setRows(3);
        blocoDescricao.add(campoDescricao, BorderLayout.CENTER);
        blocoProduto.add(blocoDescricao, BorderLayout.CENTER);
        
        JPanel blocoSouthProduto = new JPanel(new GridLayout(1,2));

        JPanel blocoSubtotal = new JPanel(new BorderLayout());
        blocoSubtotal.add(new JLabel("Sub Total:"), BorderLayout.WEST);
        campoSubtotal.setEditable(false);
        blocoSubtotal.add(campoSubtotal, BorderLayout.CENTER);
        blocoSouthProduto.add(blocoSubtotal);
        
        // Botão adicionar produto
        JButton botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.addActionListener(
                new ControllerAdicionarProdutoCaixa(
                        campoCodigo, campoQuantidade, produtos, campoTotal, this));
        blocoSouthProduto.add(botaoAdicionar);
        blocoProduto.add(blocoSouthProduto, BorderLayout.SOUTH);
        
        painelProduto.add(blocoProduto);

        // Painel da Tabela
        JScrollPane painelScrollTabela = new JScrollPane();
        
        // painelScrollTabela.add(tabela);
        
        painelScrollTabela.setViewportView(tabela);  
        
        JPanel painelTabela = new JPanel(new BorderLayout());
        painelTabela.setBorder(BorderFactory.createTitledBorder("Produtos"));
        
        produtos.addColumn("Item");
        produtos.addColumn("Codigo");
        produtos.addColumn("Nome");
        produtos.addColumn("Preço");
        produtos.addColumn("Qtd");
        produtos.addColumn("Unid");
        produtos.addColumn("Sub.Total");

        painelTabela.add(painelScrollTabela, BorderLayout.CENTER);
        
        JPanel blocoTotal = new JPanel(new GridLayout(1,2));
        blocoTotal.add(new JLabel("Total:"));
        campoTotal.setEditable(false);
        blocoTotal.add(campoTotal);
        painelTabela.add(blocoTotal, BorderLayout.SOUTH);
        
        // Botões da venda
        JPanel blocoBotes = new JPanel(new GridLayout(1,2));
        JButton botaoCancelar = new JButton("Cancelar Venda");
        botaoCancelar.addActionListener(
                new ControllerCancelarVenda(this));
        blocoBotes.add(botaoCancelar);
        JButton botaoFinalizar = new JButton("Finalizar");
        blocoBotes.add(botaoFinalizar);

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.add(painelProduto, BorderLayout.NORTH);
        painelPrincipal.add(painelTabela, BorderLayout.CENTER);
        painelPrincipal.add(blocoBotes, BorderLayout.SOUTH);
        this.setContentPane(painelPrincipal);
        
        // Configurando a janela
        this.pack();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void limparInputs(){
        campoCodigo.setText("");
        campoQuantidade.setText("1");
        campoNome.setText("");
        campoValor.setText("");
        campoDescricao.setText("");
        campoSubtotal.setText("");
    }

    public void limparVenda() {
        limparInputs();
        for(int i=0; i<produtos.getRowCount(); i++){
            produtos.removeRow(i);
        }
    }
    
}
