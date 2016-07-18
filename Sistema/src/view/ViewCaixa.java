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
import model.Caixa;
import model.Funcionario;

public class ViewCaixa extends JFrame {

    private final DefaultTableModel produtos = new DefaultTableModel();
    private final JTable tabela = new JTable(produtos);

    private final JTextField campoCodigo = new JTextField();
    private final JTextField campoQuantidade = new JTextField();

    private final JTextField campoNome = new JTextField();
    private final JTextField campoValor = new JTextField();
    private final JTextArea campoDescricao = new JTextArea();
    private final JTextField campoSubtotal = new JTextField();
    private final JTextField campoFuncionario = new JTextField(); // vai mudar
    private final JTextField campoCaixa = new JTextField(); // vai mudar
    private final JTextField campoTotal = new JTextField();

    private final JTextField campoVenda = new JTextField();
    private final JTextField campoData = new JTextField();

    private final Caixa caixa;
    private final Funcionario funcionario;

    public ViewCaixa(int numFuncionario,int numCaixa) {
        super("Caixa");

        caixa = new Caixa(numCaixa);
        funcionario = new Funcionario(numFuncionario);

        montaJanela();

        // Configurando a janela
        this.setVisible(true);
        this.pack();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void montaJanela() {
        //PAINEL GERAL - hierarquia dos paineis
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        this.setContentPane(painelPrincipal);
        JPanel blocoDadosProduto = new JPanel(new BorderLayout());
        painelPrincipal.add(blocoDadosProduto, BorderLayout.NORTH);
        JPanel painelTabela = new JPanel(new BorderLayout());
        painelPrincipal.add(painelTabela, BorderLayout.CENTER);
        JPanel blocoBotoesVenda = new JPanel(new GridLayout(1, 2));
        painelPrincipal.add(blocoBotoesVenda, BorderLayout.SOUTH);

        //BLOCO DOS DADOS
        //BLOCO NORTH INPUT
        JPanel blocoNorthProduto = new JPanel(new GridLayout(2, 2));
        blocoDadosProduto.add(blocoNorthProduto, BorderLayout.NORTH); //codigo,quantidade,nome,valor ao norte
        //BLOCO DESCRICAO
        JPanel blocoDescricao = new JPanel(new BorderLayout());
        blocoDadosProduto.add(blocoDescricao, BorderLayout.CENTER); // descricao no meio

        //BLOCO SOUTH DESCRICAO
        JPanel blocoSouthProduto = new JPanel(new GridLayout(1, 2));
        blocoDadosProduto.add(blocoSouthProduto, BorderLayout.SOUTH); // subtotal e adicionar ao sul
        ///////////////////////////////////

        //BLOCO CODIGO
        JPanel blocoCodigo = new JPanel(new BorderLayout());
        blocoCodigo.add(new JLabel("Codigo:"), BorderLayout.NORTH);
        campoCodigo.addFocusListener(
                new ControllerCodigoQuantidadeCaixa(campoCodigo, campoNome, campoValor,
                        campoDescricao, campoSubtotal, campoQuantidade));
        blocoCodigo.add(campoCodigo, BorderLayout.CENTER);
        blocoNorthProduto.add(blocoCodigo);

        //BLOCO QUANTIDADE
        JPanel blocoQuantidade = new JPanel(new BorderLayout());
        blocoQuantidade.add(new JLabel("Quantidade/Peso:"), BorderLayout.NORTH);
        campoQuantidade.setText("1");
        campoQuantidade.addFocusListener(
                new ControllerCodigoQuantidadeCaixa(campoCodigo, campoNome, campoValor,
                        campoDescricao, campoSubtotal, campoQuantidade));
        blocoQuantidade.add(campoQuantidade, BorderLayout.CENTER);
        blocoNorthProduto.add(blocoQuantidade);

        //BLOCO NOME
        JPanel blocoNome = new JPanel(new BorderLayout());
        blocoNome.add(new JLabel("Nome:"), BorderLayout.NORTH);
        campoNome.setEditable(false);
        blocoNome.add(campoNome, BorderLayout.CENTER);
        blocoNorthProduto.add(blocoNome);

        //BLOCO VALOR
        JPanel blocoValor = new JPanel(new BorderLayout());
        blocoValor.add(new JLabel("Valor:"), BorderLayout.NORTH);
        campoValor.setEditable(false);
        blocoValor.add(campoValor, BorderLayout.CENTER);
        blocoNorthProduto.add(blocoValor);

        //BLOCO DESCRICAO
        blocoDescricao.add(new JLabel("Descricao:"), BorderLayout.NORTH);
        campoDescricao.setEditable(false);
        campoDescricao.setRows(3);
        blocoDescricao.add(campoDescricao, BorderLayout.CENTER);

        //BLOCO SUBTOTAL
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

        // Painel da Tabela
        JScrollPane painelScrollTabela = new JScrollPane();
        painelScrollTabela.setViewportView(tabela);

        painelTabela.setBorder(BorderFactory.createTitledBorder("Produtos"));
        produtos.addColumn("Item");
        produtos.addColumn("Codigo");
        produtos.addColumn("Nome");
        produtos.addColumn("Preço");
        produtos.addColumn("Qtd");
        produtos.addColumn("Unid");
        produtos.addColumn("Sub.Total");
        painelTabela.add(painelScrollTabela, BorderLayout.CENTER);

        //BLOCO BOTTOM
        JPanel blocoBottom = new JPanel(new GridLayout(1, 3)); //divide rodapé em 3 colunas
        painelTabela.add(blocoBottom, BorderLayout.SOUTH);
        blocoBottom.setSize(800, 50);

        //Bloco Total
        JPanel blocoTotal = new JPanel(new FlowLayout());
        blocoTotal.add(new JLabel("Total: "));
        campoTotal.setEditable(false);
        campoTotal.setColumns(7); //seta largura em colunas do campo
        blocoTotal.add(campoTotal);
        blocoBottom.add(blocoTotal); //coluna 1

        //Bloco Funcionario
        JPanel blocoFuncionario = new JPanel(new FlowLayout());
        blocoFuncionario.add(new JLabel("Funcionario: "));
        campoFuncionario.setEditable(false);
        campoFuncionario.setColumns(7);
        campoFuncionario.setText(funcionario.toString());
        blocoFuncionario.add(campoFuncionario);
        blocoBottom.add(blocoFuncionario); //coluna 2

        //Bloco Caixa
        JPanel blocoCaixa = new JPanel(new FlowLayout());
        blocoCaixa.add(new JLabel("Caixa: "));
        campoCaixa.setEditable(false);
        campoCaixa.setColumns(7);
        campoCaixa.setText(caixa.toString());
        blocoCaixa.add(campoCaixa);
        blocoBottom.add(blocoCaixa); // coluna 3

        
        // Botões da venda
        JButton botaoCancelar = new JButton("Cancelar Venda");
        botaoCancelar.addActionListener(
                new ControllerCancelarVenda(this, produtos));
        blocoBotoesVenda.add(botaoCancelar);
        
        JButton botaoFinalizar = new JButton("Finalizar");
        botaoFinalizar.addActionListener(
                new ControllerFinalizarVenda(this, produtos, caixa, funcionario));
        blocoBotoesVenda.add(botaoFinalizar);

    }

    public void limparInputs() {
        campoCodigo.setText("");
        campoQuantidade.setText("1");
        campoNome.setText("");
        campoValor.setText("");
        campoDescricao.setText("");
        campoSubtotal.setText("");
    }

    public void limparVenda() {
        limparInputs();
        
        while (produtos.getRowCount() != 0) { // Não pode usar o getRowCount no for porque a cada rodada ele diminui, logo o for não roda as N vezes que deveria rodar. 

            //System.out.println(produtos.getRowCount());
            produtos.removeRow(0); //não sei porque, mas é o unico que funciona direito
        }
        
        campoTotal.setText("");

    }
    public static void abrirJanela(int numFuncionario,int numCaixa) {
       JFrame view = new ViewCaixa(numFuncionario,numCaixa);
    }

}
