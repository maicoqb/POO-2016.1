/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerLimparBusca;
import controller.ControllerBuscarProduto;
import controller.ControllerCarregarProduto;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import model.Estoque;
import model.Produto;

public class ViewBuscaProduto extends JFrame {

    private final DefaultListModel<Produto> produtos = new DefaultListModel();
    private final JList<Produto> listaProduto = new JList(produtos);

    private final JTextField campoBuscaNome = new JTextField();
    private final JTextField campoBuscaCodigo = new JTextField();
    
    private final JTextField campoNome = new JTextField();
    private final JTextField campoValor = new JTextField();
    private final JTextArea campoDescricao = new JTextArea();
    private final JTextField campoQuantidade = new JTextField();
    private final JTextField campoCodigo = new JTextField();
    private final JComboBox campoTipoQuantidade = new JComboBox(Produto.getTipoQuantidadeArray());

    public ViewBuscaProduto(){
        super("Busca de Produtos");
        // Pega do estoque quando inicia
        Estoque.getInstancia().updateListModel(produtos);
        
        montaJanela();
        
        // Configurando a janela
        this.setVisible(true);
        this.pack();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void montaJanela() {
        // LISTA;
        JPanel painelLista = new JPanel(new BorderLayout());
        painelLista.setBorder(BorderFactory.createTitledBorder("Produtos"));
        listaProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaProduto.addListSelectionListener(
                new ControllerCarregarProduto(listaProduto, campoCodigo,
                        campoNome, campoValor, campoQuantidade,
                        campoDescricao, campoTipoQuantidade));

        painelLista.add(new JScrollPane(listaProduto), BorderLayout.CENTER);

        //INPUTS DE BUSCA
        JPanel blocoBusca = new JPanel(new GridLayout(3, 1));
        
        JPanel blocoBuscaCodigo = new JPanel(new BorderLayout());
        blocoBuscaCodigo.add(new JLabel("Codigo:"), BorderLayout.NORTH);
        blocoBuscaCodigo.add(campoBuscaCodigo, BorderLayout.CENTER);
        blocoBusca.add(blocoBuscaCodigo);
        
        JPanel blocoBuscaNome = new JPanel(new BorderLayout());
        blocoBuscaNome.add(new JLabel("Nome:"), BorderLayout.NORTH);
        blocoBuscaNome.add(campoBuscaNome, BorderLayout.CENTER);
        blocoBusca.add(blocoBuscaNome);
        
        
        JPanel blocoBuscaBotoes = new JPanel(new GridLayout(1,2));
        
        JButton botaoBuscar = new JButton("Buscar");
        botaoBuscar.addActionListener(
        new ControllerBuscarProduto(produtos, listaProduto, campoBuscaCodigo, campoBuscaNome));
        blocoBuscaBotoes.add(botaoBuscar);

        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(
        new ControllerLimparBusca(produtos, listaProduto, campoBuscaCodigo, campoBuscaNome));
        blocoBuscaBotoes.add(botaoLimpar);

        blocoBusca.add(blocoBuscaBotoes);
        
        painelLista.add(blocoBusca, BorderLayout.NORTH);
                
        // PAINEL EDICAO PRODUTO
        JPanel painelProduto = new JPanel(new BorderLayout());

        //INPUTS DO PRODUTO
        JPanel blocoProduto = new JPanel(new GridLayout(4, 1));

        JPanel blocoCodigo = new JPanel(new BorderLayout());
        blocoCodigo.add(new JLabel("Codigo:"), BorderLayout.NORTH);
        campoCodigo.setEditable(false);
        blocoCodigo.add(campoCodigo, BorderLayout.CENTER);
        blocoProduto.add(blocoCodigo);

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
       
        // Combobox Tipo Quantidade
        JPanel blocoTipoQuantidade = new JPanel(new BorderLayout());
        blocoTipoQuantidade.add(new JLabel("Tipo Quantidade:"), BorderLayout.NORTH);
        campoTipoQuantidade.setEditable(false);
        blocoTipoQuantidade.add(campoTipoQuantidade, BorderLayout.CENTER);
        blocoProduto.add(blocoTipoQuantidade);

        // TextArea Descrição
        JPanel blocoDescricao = new JPanel(new BorderLayout());
        blocoDescricao.add(new JLabel("Descricão:"), BorderLayout.NORTH);
        campoDescricao.setEditable(false);
        blocoDescricao.add(campoDescricao, BorderLayout.CENTER);
        painelProduto.add(blocoDescricao, BorderLayout.CENTER);
        painelProduto.add(blocoProduto, BorderLayout.NORTH);

        //DIVIDE JANELA
        JSplitPane painelPrincipal
                = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, painelLista, painelProduto);
        painelPrincipal.setDividerLocation(200);
        this.setContentPane(painelPrincipal);

    }

    public void exibeResultados(ArrayList<Produto> produtos) {
        // Pega os produtos e adiciona na JList dos resultados
        // Exibe a JList
    }
    
    public static void abrirJanela() {
       JFrame view = new ViewBuscaProduto();
    }
    
}
