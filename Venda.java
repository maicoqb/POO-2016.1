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
public class Venda {
        private Date dataVenda;
        
    /**
     *
     * @return 
     */
    public Date getDataVenda(){
        return dataVenda;
    };  
    
    public void exibirMenuVenda(Venda v){
        System.out.println("Escolha a forma de pagamento:");
        System.out.println(opcoesPagamento.cartao.getOpcao() + ". Cartão");
        System.out.println(opcoesPagamento.dinheiro.getOpcao() + ". Dinheiro");
    }
    
    //public int lerOpcao(Scanner ler){
        
}