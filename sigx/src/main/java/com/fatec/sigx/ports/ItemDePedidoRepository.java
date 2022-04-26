package com.fatec.sigx.ports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fatec.sigx.model.ItemDePedido;

@Repository
public interface ItemDePedidoRepository extends JpaRepository<ItemDePedido, Long>{

}
