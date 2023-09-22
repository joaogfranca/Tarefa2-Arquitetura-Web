package com.example.demo.repository;

import com.example.demo.models.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
  List<Produto> findByPrecoGreaterThan(Double valor);

  List<Produto> findByPrecoLessThanEqual(Double valor);

  List<Produto> findByNomeStartingWith(String nome);
}
