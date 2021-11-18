package co.edu.unbosque.tiendagenericaback.api;

import co.edu.unbosque.tiendagenericaback.dao.ClientesDAO;
import co.edu.unbosque.tiendagenericaback.model.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClientesAPI {

    @Autowired
    private ClientesDAO clientesDAO;

    @PostMapping("/guardar")
    public void guardar(@RequestBody Clientes cliente){
        clientesDAO.save(cliente);
    }

    @GetMapping("/listar")
    public List<Clientes> listar(){
        return clientesDAO.findAll();
    }

    @DeleteMapping("eliminar/{id}")
    public void eliminar(@PathVariable Integer id){
        clientesDAO.deleteById(id);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Clientes cliente){
        clientesDAO.save(cliente);
    }

}
