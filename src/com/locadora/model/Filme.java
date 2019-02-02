/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locadora.model;

/**
 *
 * @author matheus
 */
public class Filme {
    
    private int codigo;
    private String titulo;
    private String ano;
    private String duracao;
    private String cod_cartegoria;
    private String cod_classificacao;
    private String capa;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getCod_cartegoria() {
        return cod_cartegoria;
    }

    public void setCod_cartegoria(String cod_cartegoria) {
        this.cod_cartegoria = cod_cartegoria;
    }

    public String getCod_classificacao() {
        return cod_classificacao;
    }

    public void setCod_classificacao(String cod_classificacao) {
        this.cod_classificacao = cod_classificacao;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }
    
}
