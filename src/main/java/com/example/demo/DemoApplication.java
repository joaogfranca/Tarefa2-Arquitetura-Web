package com.example.demo;

import java.util.List;

import com.example.demo.models.Categoria;
import com.example.demo.models.Produto;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner init(
      @Autowired ProdutoRepository produtoRepository,
      @Autowired CategoriaRepository categoriaRepository) {
    return args -> {
      Categoria categoria1 = new Categoria(1L, "Vestuário");
      Categoria categoria2 = new Categoria(2L, "Alimentos");
      Categoria categoria3 = new Categoria(3L, "Eletrônicos");

      categoriaRepository.save(categoria1);
      categoriaRepository.save(categoria2);
      categoriaRepository.save(categoria3);

      Produto produto1 = new Produto(0L, "Chinelo de dedo", 40.0, categoria1);
      Produto produto2 = new Produto(0L, "Salgadinho de milho", 10.0, categoria2);
      Produto produto3 = new Produto(0L, "Televisão média", 900.0, categoria3);
      Produto produto4 = new Produto(0L, "Blusa de couro", 180.0, categoria1);
      Produto produto5 = new Produto(0L, "Refrigerante 2 litros", 8.0, categoria2);
      Produto produto6 = new Produto(0L, "Celular novo", 1600.0, categoria3);

      produtoRepository.save(produto1);
      produtoRepository.save(produto2);
      produtoRepository.save(produto3);
      produtoRepository.save(produto4);
      produtoRepository.save(produto5);
      produtoRepository.save(produto6);

      List<Produto> metodo1 = produtoRepository.findByNomeStartingWith("C");
      for (Produto p : metodo1) {
        System.out.println("Produtos que nome começam com C: " + p.getNome());
      }

      List<Produto> metodo2 = produtoRepository.findByPrecoLessThanEqual(200.0);
      for (Produto p : metodo2) {
        System.out.println("Produtos com preço menor ou igual a 200: " + p.getNome());
      }

      List<Produto> metodo3 = produtoRepository.findByPrecoGreaterThan(170.0);
      for (Produto p : metodo3) {
        System.out.println("Produtos com preço maior que 170: " + p.getNome());
      }

      List<Categoria> metodo4 = categoriaRepository.findByNomeStartingWith("V");
      for (Categoria c : metodo4) {
        System.out.println("Categorias que começam com V: " + c.getNome());
      }

      Categoria metodo5 = categoriaRepository.findCategoriaFetchCursos(1L);
      for (Produto p : metodo5.getProdutos()) {
        System.out.println("Produtos de categoria ID 1: " + p.getNome() + " / " + "Preço: " + p.getPreco());
      }
    };
  }
}
