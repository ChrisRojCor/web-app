package co.edu.unbosque.tiendagenericaback.dao;

import co.edu.unbosque.tiendagenericaback.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesDAO extends JpaRepository<Clientes, Integer> {
}
