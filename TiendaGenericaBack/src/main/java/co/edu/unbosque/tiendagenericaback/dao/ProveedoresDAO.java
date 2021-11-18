package co.edu.unbosque.tiendagenericaback.dao;

import co.edu.unbosque.tiendagenericaback.model.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedoresDAO extends JpaRepository <Proveedores, Integer> {
}
