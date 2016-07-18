package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import lib.Helpers;

/**
 *
 * @author maico
 */
public class ControllerPagamentoValorPago implements KeyListener {

    private final JTextField campoValorPago;
    private final JTextField campoTroco;
    private final float valorTotal;

    public ControllerPagamentoValorPago(
            JTextField campoValorPago, 
            JTextField campoTroco, 
            float valorTotal) {
        this.campoValorPago = campoValorPago;
        this.campoTroco = campoTroco;
        this.valorTotal = valorTotal;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // DO NOTHING
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // DO NOTHING
    }

    @Override
    public void keyReleased(KeyEvent e) {
        float valorPago = Helpers.toFloat(campoValorPago.getText());
        float troco = valorPago - valorTotal;
        if(troco >= 0){
            campoTroco.setText(Helpers.toMoney(troco));
        } else {
            campoTroco.setText("Falta grana!");
        }
    }
    
}
