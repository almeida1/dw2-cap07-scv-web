package com.fatec.sigx;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sigx.model.Cliente;
import com.fatec.sigx.ports.ClienteRepository;


@SpringBootTest
class REQ02ConsultaCEP {

	@Autowired
	ClienteRepository repository;

	@Test
	public void testRepository()
	{
		Cliente c = new Cliente("Jose", "01/12/1966","M", "99504993052",  "04280130", "1234");
		repository.save(c);

		Optional<Cliente> cliente = repository.findByCep("04280130");

		assertTrue(cliente.isPresent());
	}

}
