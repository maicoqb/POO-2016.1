package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import lib.Helpers;
import model.Caixa;
import model.Funcionario;
import model.Produto;
import model.Registro;
import model.Venda;
import view.ViewCaixa;
import view.ViewPagamento;
import view.ViewRelatorioVenda;

/**
 *
 * @author maico
 */
public class ControllerPagamentoFinalizar implements ActionListener {

    private final String tipoPagamento;
    private final JTextField campoValorPago;
    private final JTextField campoTroco;
    private final float valorTotal;
    private final ViewCaixa viewCaixa;
    private final Caixa caixa;
    private final Funcionario funcionario;
    private final ArrayList<Produto> produtos;
    private final ViewPagamento viewPagamento;

    public ControllerPagamentoFinalizar(
            ButtonGroup grupoBotoesPagamento,
            JTextField campoValorPago,
            JTextField campoTroco,
            float valorTotal,
            ViewCaixa viewCaixa,
            ViewPagamento viewPagamento,
            Caixa caixa,
            Funcionario funcionario,
            ArrayList<Produto> produtos) {

        this.tipoPagamento = grupoBotoesPagamento.getSelection().getActionCommand();
        this.campoValorPago = campoValorPago;
        this.campoTroco = campoTroco;
        this.valorTotal = valorTotal;
        
        this.viewCaixa = viewCaixa;
        this.viewPagamento = viewPagamento;

        this.caixa = caixa;
        this.funcionario = funcionario;
        this.produtos = produtos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        float valorPago = Helpers.toFloat(campoValorPago.getText());
        float troco = valorPago - valorTotal;
        
        if (troco >= 0) { // OK
            Venda venda = new Venda(caixa, funcionario, produtos, tipoPagamento);
            Registro registro = Registro.getInstancia();
            registro.adicionarVenda(venda);
            viewCaixa.limparVenda();
            viewCaixa.setEnabled(true);

            JFrame telaRelatorio = new ViewRelatorioVenda();
            
            JOptionPane.showMessageDialog(
                    null,
                    "Compra Efetuada!!!",
                    "Compra Efetuada",
                    JOptionPane.INFORMATION_MESSAGE);
            viewPagamento.dispose();
            
        } else { // NOK
            JOptionPane.showMessageDialog(
                    null,
                    "Informe um valor maior ou igual ao valor da compra.",
                    "Valor Inválida",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
