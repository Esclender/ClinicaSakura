package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.clinicasakura.ClinicaSakura.model.CategoriaProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.CategoriaProductoService;
import pe.com.clinicasakura.ClinicaSakura.service.ProductoService;

import java.util.List;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @GetMapping("/mostrar")
    public String mostrarProductos(Model model) {
        List<ProductoEntity> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "producto/mostrar_productos";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistrar(Model model) {
        List<CategoriaProductoEntity> categorias = categoriaProductoService.findAll();
        model.addAttribute("categorias", categorias);
        model.addAttribute("producto", new ProductoEntity());
        return "producto/registrar_producto";
    }

    @PostMapping("/registrar")
    public String registrarProducto(@ModelAttribute("producto") ProductoEntity producto) {
        productoService.add(producto);
        return "redirect:/producto/mostrar";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        ProductoEntity producto = productoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de producto no válido: " + id));
        List<CategoriaProductoEntity> categorias = categoriaProductoService.findAll();
        model.addAttribute("categorias", categorias);
        model.addAttribute("producto", producto);
        return "producto/actualizar_producto";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarProducto(@PathVariable Long id, @ModelAttribute("producto") ProductoEntity producto) {
        productoService.update(producto);
        return "redirect:/producto/mostrar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        ProductoEntity producto = productoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de producto no válido: " + id));
        productoService.delete(producto);
        return "redirect:/producto/mostrar";
    }

}
