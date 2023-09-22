package com.example.demo.repository;

import com.example.demo.models.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
  List<Categoria> findByNomeStartingWith(String nome);

  @Query("select cc from Categoria cc left join fetch cc.produtos c where cc.id = :id ")
  Categoria findCategoriaFetchCursos(@Param("id") Long id);
}
