package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import lib.Helpers;

/**
 *
 * @author maico
 */
public class ControllerPagamentoDinheiroRadio implements ActionListener {

    private final JTextField campoValorPago;
    private final JTextField campoTroco;
    private final float valorTotal;

    public ControllerPagamentoDinheiroRadio(
            JTextField campoValorPago, 
            JTextField campoTroco,
            float valorTotal) {
        this.campoValorPago = campoValorPago;
        this.campoTroco = campoTroco;
        this.valorTotal = valorTotal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        campoValorPago.setEditable(true);
        campoValorPago.setText(""); // Valor da compra
        campoTroco.setText("");
        
    }
    
}
