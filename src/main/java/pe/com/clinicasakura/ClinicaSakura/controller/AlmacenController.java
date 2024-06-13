
package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.CategoriaProductoService;
import pe.com.clinicasakura.ClinicaSakura.service.ProductoService;

@Controller
public class AlmacenController {
    
    @Autowired
    private ProductoService servicio;
    
    @Autowired
    private CategoriaProductoService categoriaProducto;
    
    @GetMapping("/productos")
    public String ListarProductos(Model modelo) {
        modelo.addAttribute("productos", 
                servicio.findAllCustom());
        return "Almacen/listadoProductos";
    }
    
    
    @GetMapping("/productos/registro")
    public String MostrarRegistroProductos(Model modelo) {
        modelo.addAttribute("producto", new ProductoEntity());
        modelo.addAttribute("categoriaProducto", 
                categoriaProducto.findAllCustom());
        return "Almacen/registroProducto";
    }
    
     // modelo
    @ModelAttribute("producto")
    public ProductoEntity ModeloProducto() {
        return new ProductoEntity();
    }
    
    @PostMapping("/productos/registro")
    public String RegistroProductos(
            @ModelAttribute("producto") ProductoEntity productoEntity) {
        servicio.add(productoEntity);
        return "redirect:/productos";
    }
    
    @GetMapping("/productos/actualizar/{id}")
    public String MostrarActualizarProducto (@PathVariable Long id, Model modelo) {
        modelo.addAttribute("producto", servicio.findById(id).get());
        modelo.addAttribute("categoriaProducto", categoriaProducto.findAll());
        return "Almacen/actualizarProducto";
    }
    
    @PostMapping("/productos/actualizar/{id}")
    public String ActualizarProducto(@PathVariable Long id,
            @ModelAttribute("producto") ProductoEntity productoEntity) {
      
        servicio.update(productoEntity);
        return "redirect:/productos";
    }
    
   @GetMapping("/producto/eliminar/{id}")
    public String MostrarEliminarArtefacto(@PathVariable Long id) {
        ProductoEntity productoEntity = servicio.findById(id).get();
        servicio.delete(productoEntity);
        return "redirect:/productos";
    }
    /*
    @PostMapping("/productos/eliminar/{id}")
    public String EliminarProducto(@PathVariable Long id,
            @ModelAttribute("producto") ProductoEntity productoEntity) {
        servicio.delete(productoEntity);
        return "redirect:/productos";
    }*/
}