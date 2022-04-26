package com.fatec.sigx;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sigx.model.Produto;
import com.fatec.sigx.ports.ProdutoRepository;
@SpringBootTest
class REQ02ConsultaPedidoTests {
	@Autowired
	ProdutoRepository repository;
	@Test
	void test() {
		Optional<Produto> produto = Optional.ofNullable(repository.findByProdutoId(1L));
		assertTrue(produto.isPresent());
	}

}
