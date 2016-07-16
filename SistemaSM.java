/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.util.Scanner;

/**
 *
 * @author marcela.ramos
 */
public class SistemaSM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pagamento pagamento = new Pagamento();
        Venda v = new Venda();
        double troco=0;
        
       v.exibirMenuVenda(v);
        Scanner ler = new Scanner(System.in);

        pagamento.setFormaPagamento(ler.nextInt());

        
        String msg;
        if (pagamento.getFormaPagamento() == opcoesPagamento.cartao.getOpcao()) {
            msg = "Cartao";
        } else {
            if (pagamento.getFormaPagamento() == opcoesPagamento.dinheiro.getOpcao()) {
                msg = "Dinheiro";
            } else {
                msg = "Nenhuma";
            }
        }
        
        
        System.out.println("Forma de Pagamento: " + msg + ".");
        if (pagamento.getFormaPagamento() == opcoesPagamento.dinheiro.getOpcao()){
            double total = 90.90, pago=100.00;
            troco = pagamento.formaPagamentoDinheiro(total, pago);
        }
        
        System.out.println("Valor do troco:" + troco + " reais");
    }
}