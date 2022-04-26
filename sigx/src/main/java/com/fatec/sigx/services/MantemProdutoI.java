package com.fatec.sigx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.sigx.model.Produto;
import com.fatec.sigx.ports.MantemProduto;
import com.fatec.sigx.ports.ProdutoRepository;
@Service
public class MantemProdutoI implements MantemProduto {
	@Autowired
	ProdutoRepository repository;
	/**
	 * retorna todos os produtos cadastrados na base
	 */
	@Override
	public List<Produto> consultaTodos() {
		return repository.findAll();
	}

	@Override
	public Produto consultaPorCodigoProduto(Long codigo) {
		
		return repository.findByProdutoId(codigo);
	}

	@Override
	public Optional<Produto> consultaPorId(Long id) {

		return null;
	}
	/**
	 * Cadastra o produto no banco de dados
	 * Se o codigo do produto nao estiver cadastrado (produto.isEmpty) retorna o produto cadastrado
	 * Se não retorna a classe produto vazia
	 */
	@Override
	public Produto save(Produto umProduto) {
		Optional<Produto> produto = Optional.ofNullable(consultaPorCodigoProduto(umProduto.getProdutoId()));
		if (produto.isEmpty()) {
			return repository.save(umProduto);
		} else {
			return produto.get();
		}
	}

	@Override
	public void delete(Long id) {
	}

	@Override
	public Optional<Produto> altera(Produto produto) {
		
		return null;
	}

}
