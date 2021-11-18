package co.edu.unbosque.tiendagenericaback.api;

import co.edu.unbosque.tiendagenericaback.dao.ProductosDAO;
import co.edu.unbosque.tiendagenericaback.model.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productos")
public class ProductosAPI {

    @Autowired
    private ProductosDAO productosDAO;

    @PostMapping("/guardar")
    public void guardar(@RequestBody Productos producto){
        productosDAO.save(producto);
    }

    @GetMapping("/listar")
    public List<Productos> listar(){
        return productosDAO.findAll();
    }

    @DeleteMapping("eliminar/{id}")
    public void eliminar(@PathVariable Integer id){
        productosDAO.deleteById(id);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Productos producto){
        productosDAO.save(producto);
    }
}
