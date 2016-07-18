package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import lib.Helpers;

/**
 *
 * @author maico
 */
public class ControllerPagamentoCartaoRadio implements ActionListener {

    private final JTextField campoValorPago;
    private final JTextField campoTroco;
    private final float valorTotal;

    public ControllerPagamentoCartaoRadio(
            JTextField campoValorPago, 
            JTextField campoTroco,
            float valorTotal) {
        this.campoValorPago = campoValorPago;
        this.campoTroco = campoTroco;
        this.valorTotal = valorTotal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        campoValorPago.setEditable(false);
        campoValorPago.setText(Helpers.toMoney(valorTotal)); // Valor da compra
        campoTroco.setText("0,00");
    }
    
}
