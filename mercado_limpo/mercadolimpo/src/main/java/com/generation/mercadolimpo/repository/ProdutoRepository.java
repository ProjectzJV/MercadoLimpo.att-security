package com.generation.mercadolimpo.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.mercadolimpo.model.Categoria;
import com.generation.mercadolimpo.model.Produto;
import com.generation.mercadolimpo.model.Usuario;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	public List<Produto> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	public List<Produto> findByPrecoIn(Collection<Double> preco);
	
	public List<Produto> findAllByCategoria(Categoria categoria);
	public List<Produto> findAllByUsuario(Usuario usuario);
	
}
