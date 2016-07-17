/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerRemoverProduto;
import controller.ControllerSalvarProduto;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Estoque;
import model.Produto;

public class ViewCaixa extends JFrame {

    private DefaultTableModel produtos = new DefaultTableModel();
    
    private final JTextField campoCodigo = new JTextField();
    private final JTextField campoQuantidade = new JTextField();
    
    private final JTextField campoNome = new JTextField();
    private final JTextField campoValor = new JTextField();
    private final JTextArea campoDescricao = new JTextArea();
    private final JTextField campoSubtotal = new JTextField();
    
    
    public ViewCaixa() {
        super("Caixa");
        
        montaJanela();

        this.setVisible(true);
    }

    private void montaJanela() {

        JPanel painelProduto = new JPanel(new BorderLayout());
        
        // Bloco do Produto
        JPanel blocoProduto = new JPanel(new GridLayout(5,2));
        
        JPanel blocoCodigo = new JPanel(new BorderLayout());
        blocoCodigo.add(new JLabel("Codigo:"), BorderLayout.NORTH);
        blocoCodigo.add(campoCodigo, BorderLayout.CENTER);
        blocoProduto.add(blocoCodigo);
        
        JPanel blocoQuantidade = new JPanel(new BorderLayout());
        blocoQuantidade.add(new JLabel("Quantidade:"), BorderLayout.NORTH);
        blocoQuantidade.add(campoQuantidade, BorderLayout.CENTER);
        blocoProduto.add(blocoQuantidade);
        
        // Info do produto
        JPanel blocoNome = new JPanel(new BorderLayout());
        blocoNome.add(new JLabel("Nome:"), BorderLayout.NORTH);
        campoNome.setEditable(false);
        blocoNome.add(campoNome, BorderLayout.CENTER);
        blocoProduto.add(blocoNome);
        
        JPanel blocoValor = new JPanel(new BorderLayout());
        blocoValor.add(new JLabel("Valor:"), BorderLayout.NORTH);
        campoValor.setEditable(false);
        blocoValor.add(campoValor, BorderLayout.CENTER);
        blocoProduto.add(blocoValor);
        
        JPanel blocoDescricao = new JPanel(new BorderLayout());
        blocoDescricao.add(new JLabel("Descricao:"), BorderLayout.NORTH);
        campoDescricao.setEditable(false);
        blocoDescricao.add(campoDescricao, BorderLayout.CENTER);
        blocoProduto.add(blocoDescricao);
        
        JPanel blocoSubtotal = new JPanel(new BorderLayout());
        blocoSubtotal.add(new JLabel("Sub Total:"), BorderLayout.NORTH);
        campoSubtotal.setEditable(false);
        blocoSubtotal.add(campoSubtotal, BorderLayout.CENTER);
        blocoProduto.add(blocoSubtotal);
        
        // Botão adicionar produto
        JButton botaoAdicionar = new JButton("Adicionar");
        blocoProduto.add(new JPanel());
        blocoProduto.add(botaoAdicionar);
        
        painelProduto.add(blocoProduto);

        
        // Painel da Tabela
        JPanel painelTabela = new JPanel(new BorderLayout());
        painelTabela.setBorder(BorderFactory.createTitledBorder("Produtos"));
        
        JTable tabela = new JTable(produtos);
        produtos.addColumn("Item");
        produtos.addColumn("Codigo");
        produtos.addColumn("Nome");
        produtos.addColumn("Preço");
        produtos.addColumn("Qtd");
        produtos.addColumn("Sub.Total");

        ArrayList<Produto> produtosArr = Estoque.getInstancia().getProdutos();
        int i = 0;
        for(Produto p : produtosArr){
            i++;
            produtos.addRow(new Object[]{i, p.getCodigo(), p.getNome(), p.getValor(), '2', 2*p.getValor()});
        }

        painelTabela.add(tabela, BorderLayout.CENTER);
        
        /*JPanel blocoTotal = new JPanel(new GridLayout(5,2));
        
        JPanel blocoCodigo = new JPanel(new BorderLayout());
        blocoCodigo.add(new JLabel("Codigo:"), BorderLayout.NORTH);
        blocoCodigo.add(campoCodigo, BorderLayout.CENTER);
        blocoProduto.add(blocoCodigo);*/
        
        // Botões da venda
        JPanel blocoBotes = new JPanel(new GridLayout(1,2));
        JButton botaoCancelar = new JButton("Cancelar Vendar");
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

}
