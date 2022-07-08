package com.lojavirtual.rottareal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.rottareal.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
