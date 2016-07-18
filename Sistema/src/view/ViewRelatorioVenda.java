package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Registro;
import model.Venda;

public class ViewRelatorioVenda extends JFrame {

    private final DefaultTableModel listaVendasModel = new DefaultTableModel();
    private final JTable tabela = new JTable(listaVendasModel);

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

    public void limparVenda() {

    }
}
