
package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.CategoriaProductoService;
import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;
import pe.com.clinicasakura.ClinicaSakura.service.ProductoService;

@Controller
public class AlmacenController {

    @Autowired
    private ProductoService servicio;

    @Autowired
    private CategoriaProductoService categoriaProducto;

    @GetMapping("/productos")
    public String ListarProductos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<ProductoEntity> productos = servicio.findAllCustom(pageable);
        model.addAttribute("productos",
                productos.getContent());
        model.addAttribute("productosPage",
                productos);

        model.addAttribute("productos", productos.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productos.getTotalPages());
        model.addAttribute("totalItems", productos.getTotalElements());
        model.addAttribute("pageSize", size);
        return "Almacen/listadoProductos";
    }

    @GetMapping("/productos/registro")
    public String MostrarRegistroProductos(Model modelo) {
        modelo.addAttribute("producto", new ProductoEntity());
        modelo.addAttribute("categoriaProducto",
                categoriaProducto.findAll());
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
    public String MostrarActualizarProducto(@PathVariable Long id, Model modelo) {
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
    public String MostrarEliminarArtefacto(@PathVariable Long id, Model modelo) {
        ProductoEntity productoEntity = servicio.findById(id).get();
        modelo.addAttribute("producto", productoEntity);
        return "redirect:/productos";
    }
   
    @PostMapping("/productos/eliminar/{id}")
    public String EliminarProducto(@PathVariable Long id) {
        ProductoEntity productoEntity = servicio.findById(id).get();
        servicio.delete(productoEntity);
        return "redirect:/productos";
    }
}
