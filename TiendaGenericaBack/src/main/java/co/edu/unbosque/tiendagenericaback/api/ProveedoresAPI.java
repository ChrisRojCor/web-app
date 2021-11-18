package co.edu.unbosque.tiendagenericaback.api;

import co.edu.unbosque.tiendagenericaback.dao.ProveedoresDAO;
import co.edu.unbosque.tiendagenericaback.model.Proveedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proveedores")
public class ProveedoresAPI {

    @Autowired
    private ProveedoresDAO proveedoresDAO;

    @PostMapping("/guardar")
    public void guardar(@RequestBody Proveedores proveedor){
        proveedoresDAO.save(proveedor);
    }

    @GetMapping("/listar")
    public List<Proveedores> listar(){
        return proveedoresDAO.findAll();
    }

    @DeleteMapping("eliminar/{id}")
    public void eliminar(@PathVariable Integer id){
        proveedoresDAO.deleteById(id);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Proveedores proveedor){
        proveedoresDAO.save(proveedor);
    }

}



