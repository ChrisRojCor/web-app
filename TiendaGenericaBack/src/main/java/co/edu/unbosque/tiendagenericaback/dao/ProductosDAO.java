package co.edu.unbosque.tiendagenericaback.dao;

import co.edu.unbosque.tiendagenericaback.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosDAO extends JpaRepository<Productos, Integer> {
}
