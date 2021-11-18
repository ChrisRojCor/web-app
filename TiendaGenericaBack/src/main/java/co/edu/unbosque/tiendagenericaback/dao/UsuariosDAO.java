package co.edu.unbosque.tiendagenericaback.dao;

import co.edu.unbosque.tiendagenericaback.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosDAO extends JpaRepository<Usuarios, Integer> {
}
