/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.util.Date;

/**
 *
 * @author marcela.ramos
 */
public class Pagamento {

    private Date dataVenda;
    private int formaPagamento;
    

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public double formaPagamentoDinheiro(double valorTotal, double valorPago) {
        return valorPago - valorTotal;
    }
}


