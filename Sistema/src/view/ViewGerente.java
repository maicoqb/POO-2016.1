/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerCarregarProduto;
import controller.ControllerSalvarProduto;
import controller.ControllerAdicionarProduto;
import controller.ControllerRemoverProduto;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import model.Estoque;
import model.Produto;

/**
 *
 * @author maico
 */
public class ViewGerente extends JFrame {

    private final DefaultListModel<Produto> produtos = new DefaultListModel();
    private final JList<Produto> listaProduto = new JList(produtos);

    private final JTextField campoNome = new JTextField();
    private final JTextField campoValor = new JTextField();
    private final JTextArea campoDescricao = new JTextArea();
    private final JTextField campoQuantidade = new JTextField();
    private final JTextField campoCodigo = new JTextField();
    private final JComboBox campoTipoQuantidade = new JComboBox(Produto.getTipoQuantidadeArray());

    public ViewGerente() {
        super("Gerenciamento de produtos");
        // Pega do estoque quando inicia
        Estoque.getInstancia().updateListModel(produtos);
        
        montaJanela();

        this.setVisible(true);
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

        JButton botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.addActionListener(new ControllerAdicionarProduto(produtos));

        painelLista.add(botaoAdicionar, BorderLayout.SOUTH);

        // PAINEL EDICAO PRODUTO
        JPanel painelProduto = new JPanel(new BorderLayout());

        //INPUTS DO PRODUTO
        JPanel blocoProduto = new JPanel(new GridLayout(5, 1));

        JPanel blocoCodigo = new JPanel(new BorderLayout());
        blocoCodigo.add(new JLabel("Codigo:"), BorderLayout.NORTH);
        campoCodigo.setEnabled(false);
        blocoCodigo.add(campoCodigo, BorderLayout.CENTER);
        blocoProduto.add(blocoCodigo);

        JPanel blocoNome = new JPanel(new BorderLayout());
        blocoNome.add(new JLabel("Nome:"), BorderLayout.NORTH);
        campoNome.setEnabled(false);
        blocoNome.add(campoNome, BorderLayout.CENTER);
        blocoProduto.add(blocoNome);

        JPanel blocoValor = new JPanel(new BorderLayout());
        blocoValor.add(new JLabel("Valor:"), BorderLayout.NORTH);
        campoValor.setEnabled(false);
        blocoValor.add(campoValor, BorderLayout.CENTER);
        blocoProduto.add(blocoValor);

        JPanel blocoQuantidade = new JPanel(new BorderLayout());
        blocoQuantidade.add(new JLabel("Quantidade:"), BorderLayout.NORTH);
        campoQuantidade.setEnabled(false);
        blocoQuantidade.add(campoQuantidade, BorderLayout.CENTER);
        blocoProduto.add(blocoQuantidade);
        
        // Combobox Tipo Quantidade
        JPanel blocoTipoQuantidade = new JPanel(new BorderLayout());
        blocoTipoQuantidade.add(new JLabel("Tipo Quantidade:"), BorderLayout.NORTH);
        campoTipoQuantidade.setSelectedIndex(1);
        campoTipoQuantidade.setEnabled(false);
        blocoTipoQuantidade.add(campoTipoQuantidade, BorderLayout.CENTER);
        blocoProduto.add(blocoTipoQuantidade);

        // TextArea Descrição
        JPanel blocoDescricao = new JPanel(new BorderLayout());
        blocoDescricao.add(new JLabel("Descricão:"), BorderLayout.NORTH);
        campoDescricao.setEnabled(false);
        blocoDescricao.add(campoDescricao, BorderLayout.CENTER);
        painelProduto.add(blocoDescricao, BorderLayout.CENTER);
        painelProduto.add(blocoProduto, BorderLayout.NORTH);

        //PAINEL BOTAO EDICAO PRODUTO        
        JButton botaoRemover = new JButton("Remover");
        botaoRemover.addActionListener(new ControllerRemoverProduto(produtos, listaProduto));

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(
                new ControllerSalvarProduto(listaProduto, campoCodigo,
                        campoNome, campoValor, campoQuantidade, 
                        campoDescricao, campoTipoQuantidade));

        JPanel painelBotoesProduto = new JPanel(new GridLayout(1, 2));
        painelBotoesProduto.add(botaoSalvar);
        painelBotoesProduto.add(botaoRemover);
        painelProduto.add(painelBotoesProduto, BorderLayout.SOUTH);

        //DIVIDE JANELA
        JSplitPane painelPrincipal
                = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, painelLista, painelProduto);
        painelPrincipal.setDividerLocation(200);
        this.setContentPane(painelPrincipal);

        // Configurando a janela
        this.pack();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
