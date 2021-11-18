package co.edu.unbosque.tiendagenericaback.api;

import co.edu.unbosque.tiendagenericaback.dao.UsuariosDAO;
import co.edu.unbosque.tiendagenericaback.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuariosAPI {

    @Autowired
    private UsuariosDAO usuariosDAO;

    @PostMapping("/guardar")
    public void guardar(@RequestBody Usuarios usuarios){
        usuariosDAO.save(usuarios);
    }

    @GetMapping("/listar")
    public List<Usuarios> listar(){
        return usuariosDAO.findAll();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        usuariosDAO.deleteById(id);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Usuarios usuarios){
        usuariosDAO.save(usuarios);
    }
}