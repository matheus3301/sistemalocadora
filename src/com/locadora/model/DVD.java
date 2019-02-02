/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locadora.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author matheus
 */
public class DVD {
    private int codigo;
    private String cod_filme;
    private String situacao;
    private String preco;
    private String data_compra;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCod_filme() {
        return cod_filme;
    }

        public void setCod_filme(String cod_filme) {
        this.cod_filme = cod_filme;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getData_compra() {
        return data_compra;
    }

    public void setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }

  
    
    
}
