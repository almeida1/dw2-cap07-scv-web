package com.fatec.sigx.ports;

import java.util.List;
import java.util.Optional;
import com.fatec.sigx.model.Produto;

public interface MantemProduto {
	List<Produto> consultaTodos();
	Produto consultaPorCodigoProduto(Long codigo);
	Optional<Produto> consultaPorId(Long id);
	Produto save(Produto produto);
	void delete (Long id);
	Optional<Produto> altera ( Produto produto);
}
