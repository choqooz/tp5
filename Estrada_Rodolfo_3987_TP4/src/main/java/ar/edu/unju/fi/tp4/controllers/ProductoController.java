package ar.edu.unju.fi.tp4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.models.Producto;
import ar.edu.unju.fi.tp4.services.IProductoService;

@Controller
public class ProductoController {
	@Autowired
	IProductoService productoService;
	@GetMapping("/producto")
	public String getProductoFormPage(Model model) {
	model.addAttribute("producto", productoService.getProducto());
	return "nuevo_producto";
}
	
	@PostMapping("/producto/guardar")
	public String getProductoResultPage(@ModelAttribute("producto") Producto unProducto) {
	productoService.addProducto(unProducto);
	return "resultado_producto";
}
	
	@GetMapping("/producto/ultimo")
	public ModelAndView getUltimploEmpleado() {
		ModelAndView mav = new ModelAndView("ultimo_producto");
		mav.addObject("producto", productoService.getUltimoProducto());
		return mav;
	}
	
	@GetMapping("/producto/listado")
	public ModelAndView getListProductoPage() {
		
		ModelAndView modelAndView = new ModelAndView("productos");
		modelAndView.addObject("productos", productoService.getListProductos());
		return modelAndView;
	}
	
}
