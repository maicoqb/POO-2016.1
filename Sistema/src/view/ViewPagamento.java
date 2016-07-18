package view;

import controller.ControllerPagamentoFinalizar;
import controller.ControllerPagamentoCartaoRadio;
import controller.ControllerPagamentoDinheiroRadio;
import controller.ControllerPagamentoValorPago;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.Caixa;
import model.Funcionario;
import model.Produto;

/**
 *
 * @author maico
 */
public class ViewPagamento extends JFrame {

    private final Caixa caixa;
    private final Funcionario funcionario;
    private final ViewCaixa viewCaixa;
    private final ArrayList<Produto> produtos;
    private final float valorTotal;

    private final JTextField campoValorPago = new JTextField();
    private final JTextField campoTroco = new JTextField();

    public ViewPagamento(
            Caixa caixa,
            Funcionario funcionario,
            ViewCaixa viewCaixa,
            ArrayList<Produto> produtos,
            float valorTotal) {
        super("Caixa");

        this.caixa = caixa;
        this.funcionario = funcionario;
        this.viewCaixa = viewCaixa;
        this.produtos = produtos;
        this.valorTotal = valorTotal;

        this.viewCaixa.setEnabled(false);

        montaJanela();

        // Configurando a janela
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(400, 200);
    }

    private void montaJanela() {
        //PAINEL GERAL - hierarquia dos paineis
        JPanel painelPrincipal = new JPanel(new GridLayout(4, 1));
        this.setContentPane(painelPrincipal);

        JPanel blocoBotoesPagamento = new JPanel(new GridLayout(1, 2));
        painelPrincipal.add(blocoBotoesPagamento, BorderLayout.NORTH);

        JPanel blocoValorPago = new JPanel(new BorderLayout());
        painelPrincipal.add(blocoValorPago);

        JPanel blocoTroco = new JPanel(new BorderLayout());
        painelPrincipal.add(blocoTroco);

        JPanel painelBotaoFinalizar = new JPanel(new GridLayout(1, 4));
        painelPrincipal.add(painelBotaoFinalizar);

        // Botões de pagamento
        // TODO #bug - o tipo de pagamento tá indo sempre como dinheiro
        JRadioButton botaoDinheiro = new JRadioButton("Dinheiro");
        botaoDinheiro.setActionCommand("dinheiro");
        JRadioButton botaoCartao = new JRadioButton("Cartão");
        botaoCartao.setActionCommand("cartao");

        ButtonGroup grupoBotoesPagamento = new ButtonGroup();
        grupoBotoesPagamento.add(botaoCartao);
        grupoBotoesPagamento.add(botaoDinheiro);

        botaoDinheiro.setSelected(true);

        blocoBotoesPagamento.add(new JPanel());
        blocoBotoesPagamento.add(botaoDinheiro);
        blocoBotoesPagamento.add(botaoCartao);
        blocoBotoesPagamento.add(new JPanel());

        botaoDinheiro.addActionListener(
                new ControllerPagamentoDinheiroRadio(campoValorPago, campoTroco, valorTotal));
        botaoCartao.addActionListener(
                new ControllerPagamentoCartaoRadio(campoValorPago, campoTroco, valorTotal));

        // Inputs do pagamento
        campoValorPago.addKeyListener(
                new ControllerPagamentoValorPago(campoValorPago, campoTroco, valorTotal));
        blocoValorPago.add(new JLabel("Valor Pago:"), BorderLayout.NORTH);
        blocoValorPago.add(campoValorPago, BorderLayout.CENTER);

        campoTroco.setEditable(false);
        blocoTroco.add(new JLabel("Valor Troco:"), BorderLayout.NORTH);
        blocoTroco.add(campoTroco, BorderLayout.CENTER);

        // Botão confirmar pagamento
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.addActionListener(
                new ControllerPagamentoFinalizar(
                        grupoBotoesPagamento, campoValorPago, campoTroco, valorTotal,
                        viewCaixa, this, caixa, funcionario, produtos));

        painelBotaoFinalizar.add(new JPanel());
        painelBotaoFinalizar.add(botaoConfirmar);

    }

}
