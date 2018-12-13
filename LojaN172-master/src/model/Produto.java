/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 181720019
 */
public class Produto {
    private double preco;
    private int codigo;
    private String nome;
    private double quantidade;
    private Produto categoria;
    
    public Produto(){
    }

    public Produto(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    
    public Produto(double preco, int codigo, String nome, double quantidade ){
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
    
    public Produto getCategoria(){
        return categoria;
    }
    
    public void setCategoria(Produto categoria){
        this.categoria = categoria;
    }
    
}


