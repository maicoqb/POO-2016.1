package model;

import javax.swing.ComboBoxModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Produto {

    public static final String TIPO_QUILO = "Kg";
    public static final String TIPO_UNIDADE = "Un";

    private String codigo;
    private String nome;
    private float valor;
    private float quantidade;
    private String descricao;
    private String tipoQuantidade;

    public Produto() {
        this.nome = "<Novo Produto>";
    }
    public Produto(String codigo, String nome, Float valor, Float quantidade,String tipoQuantidade){
        this.codigo=codigo;
        this.nome=nome;
        this.valor=valor;
        this.quantidade=quantidade;
        this.tipoQuantidade=tipoQuantidade;
        this.descricao="";
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setTipoQuantidade(String tipoQuantidade) {
        this.tipoQuantidade = tipoQuantidade;
    }

    public String getTipoQuantidade() {
        return tipoQuantidade;
    }

    public static String[] getTipoQuantidadeArray() {
        String[] tipoQuantidadeArray = {TIPO_UNIDADE, TIPO_QUILO};
        return tipoQuantidadeArray;
    }

    @Override
    public String toString() {
        return nome;
    }

}
