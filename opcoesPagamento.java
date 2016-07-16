/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

/**
 *
 * @author marcela.ramos
 */
public enum opcoesPagamento {
    cartao(1),
    dinheiro(2)
    ;
    private int opcao;

    opcoesPagamento(int opcao) {
        this.opcao = opcao;
    }

    public int getOpcao() {
        return this.opcao;
    }
}
