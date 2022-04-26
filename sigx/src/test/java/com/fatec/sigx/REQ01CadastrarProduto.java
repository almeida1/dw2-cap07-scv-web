package com.fatec.sigx;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sigx.model.Produto;
import com.fatec.sigx.ports.MantemCliente;
import com.fatec.sigx.ports.MantemPedido;
import com.fatec.sigx.ports.ProdutoRepository;
@SpringBootTest
class REQ01CadastrarProduto {
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private MantemCliente mantemCliente;

	@Autowired
	private MantemPedido pedidoServico;
	@Test
	void ct01_cadastrar_3_produtos_na_base() {
		Produto produto1 = new Produto(4L, "parafuso", 10, 30); // descricao, custo e quantidade no estoque
		Produto produto2 = new Produto(5L, "tijolo", 15, 60);
		Produto produto3 = new Produto(6L, "bucha", 5, 50);
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		assertEquals(6, produtoRepository.count());
		Optional<Produto> umProduto = produtoRepository.findById(1L);
		Produto produtoComprado1 = umProduto.get();
		assertEquals("parafuso", produtoComprado1.getDescricao());
	}

}
