package view;

import controller.ControllerRelatorioVendaFiltro;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Registro;
import model.Venda;

public class ViewRelatorioVenda extends JFrame {

    private final DefaultTableModel listaVendasModel = new DefaultTableModel();
    private final JTable tabela = new JTable(listaVendasModel);

    private JComboBox<String> campoCaixa;
    private JComboBox<String> campoFuncionario;
    private JComboBox<String> campoTipoPagamento;
    private JTextField campoValorMin = new JTextField();
    private JTextField campoValorMax = new JTextField();

    public ViewRelatorioVenda() {
        super("Relatório Venda");

        montaJanela();

        this.setVisible(true);

        this.pack();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void montaJanela() {

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        JPanel painelFiltro = new JPanel(new GridLayout(2, 3));
        painelPrincipal.add(painelFiltro, BorderLayout.NORTH);

        JPanel painelTabela = new JPanel(new BorderLayout());
        painelPrincipal.add(painelTabela, BorderLayout.CENTER);

        this.setContentPane(painelPrincipal);

        // Bloco Filtro
        // Combo Caixa
        String[] caixas = {"", "Caixa 1", "Caixa 2", "Caixa 3"};
        campoCaixa = new JComboBox<>(caixas);
        campoCaixa.setSelectedIndex(0);

        JPanel blocoCaixa = new JPanel(new BorderLayout());
        blocoCaixa.add(new JLabel("Caixa:"), BorderLayout.NORTH);
        blocoCaixa.add(campoCaixa, BorderLayout.CENTER);
        painelFiltro.add(blocoCaixa);

        // Combo Funcionario
        String[] funcionarios = {"", "Funcionario 1", "Funcionario 2",
            "Funcionario 3", "Funcionario 4", "Funcionario 5"};
        campoFuncionario = new JComboBox<>(funcionarios);
        campoFuncionario.setSelectedIndex(0);

        JPanel blocoFuncionario = new JPanel(new BorderLayout());
        blocoFuncionario.add(new JLabel("Funcionario:"), BorderLayout.NORTH);
        blocoFuncionario.add(campoFuncionario, BorderLayout.CENTER);
        painelFiltro.add(blocoFuncionario);

        // Combo Tipo de Pagameto
        String[] tiposPagamento = {"", "dinheiro", "cartao"};
        campoTipoPagamento = new JComboBox<>(tiposPagamento);
        campoTipoPagamento.setSelectedIndex(0);

        JPanel blocoTipoPagamento = new JPanel(new BorderLayout());
        blocoTipoPagamento.add(new JLabel("Tipo Pgto:"), BorderLayout.NORTH);
        blocoTipoPagamento.add(campoTipoPagamento, BorderLayout.CENTER);
        painelFiltro.add(blocoTipoPagamento);

        // Campo Valor
        JPanel blocoValorEntre = new JPanel(new GridLayout(1, 4));
        blocoValorEntre.add(new JLabel("Min: ", JLabel.RIGHT));
        blocoValorEntre.add(campoValorMin);
        blocoValorEntre.add(new JLabel("Max: ", JLabel.RIGHT));
        blocoValorEntre.add(campoValorMax);

        JPanel blocoValor = new JPanel(new BorderLayout());
        blocoValor.add(new JLabel("Valor:"), BorderLayout.NORTH);
        blocoValor.add(blocoValorEntre, BorderLayout.CENTER);
        painelFiltro.add(blocoValor);
        
        // Botão Limpar Filtro
        JButton botaoLimparFiltro = new JButton("Limpar Filtro");
        painelFiltro.add(new JPanel());
        painelFiltro.add(botaoLimparFiltro);

        // Adiciona os listener só depois de incializar todos os campos
        // Isso evita os NullPointerExceptions
        
        campoCaixa.addItemListener(
                new ControllerRelatorioVendaFiltro(
                        campoCaixa,
                        campoFuncionario,
                        campoTipoPagamento,
                        campoValorMin,
                        campoValorMax,
                        listaVendasModel));
        campoFuncionario.addItemListener(
                new ControllerRelatorioVendaFiltro(
                        campoCaixa,
                        campoFuncionario,
                        campoTipoPagamento,
                        campoValorMin,
                        campoValorMax,
                        listaVendasModel));
        campoTipoPagamento.addItemListener(
                new ControllerRelatorioVendaFiltro(
                        campoCaixa,
                        campoFuncionario,
                        campoTipoPagamento,
                        campoValorMin,
                        campoValorMax,
                        listaVendasModel));
        campoValorMin.addKeyListener(
                new ControllerRelatorioVendaFiltro(
                        campoCaixa,
                        campoFuncionario,
                        campoTipoPagamento,
                        campoValorMin,
                        campoValorMax,
                        listaVendasModel));
        campoValorMax.addKeyListener(
                new ControllerRelatorioVendaFiltro(
                        campoCaixa,
                        campoFuncionario,
                        campoTipoPagamento,
                        campoValorMin,
                        campoValorMax,
                        listaVendasModel));
        
        botaoLimparFiltro.addActionListener(
                new ControllerRelatorioVendaFiltro(
                        campoCaixa,
                        campoFuncionario,
                        campoTipoPagamento,
                        campoValorMin,
                        campoValorMax,
                        listaVendasModel));
        
        // BLOCO TABELA
        JScrollPane painelScrollTabela = new JScrollPane();
        painelScrollTabela.setViewportView(tabela);

        painelTabela.setBorder(BorderFactory.createTitledBorder("Produtos"));
        listaVendasModel.addColumn("Caixa");
        listaVendasModel.addColumn("Funcionario");
        listaVendasModel.addColumn("Valor");
        listaVendasModel.addColumn("Tipo Pgto.");
        listaVendasModel.addColumn("Data");
        painelTabela.add(painelScrollTabela, BorderLayout.CENTER);

        ArrayList<Venda> vendasArr = Registro.getInstancia().getVendas();
        for (Venda v : vendasArr) {

            listaVendasModel.addRow(
                    new Object[]{
                        v.getCaixa().toString(),
                        v.getFuncionario().toString(),
                        v.getValorVenda(),
                        v.getTipoPagamento(),
                        v.getData().toString()
                    });

        }
        //  listaVendasModel.addRow(new Object[]{"caixa","Func","1.00","data"});

    }

    public static void abrirJanela() {
        JFrame view = new ViewRelatorioVenda();
    }

}
