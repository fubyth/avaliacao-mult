package br.com.grupomult.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupomult.produtos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}