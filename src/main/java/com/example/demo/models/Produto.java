package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 200, nullable = false)
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoriaProdutos_id")
    private Categoria categoriaProdutos;

    public Produto() {
    }

    public Produto(Long id, String nome, Double preco, Categoria categoriaProdutos) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoriaProdutos = categoriaProdutos;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", preço=" + preco + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoriaProdutos() {
        return categoriaProdutos;
    }

    public void setCategoriaProdutos(Categoria categoriaProdutos) {
        this.categoriaProdutos = categoriaProdutos;
    }
}
