package ar.edu.unju.fi.tp4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.models.Compra;
import ar.edu.unju.fi.tp4.models.Producto;
import ar.edu.unju.fi.tp4.services.ICompraService;
import ar.edu.unju.fi.tp4.services.IProductoService;

@Controller
public class CompraController {
	
	@Autowired
	private ICompraService compraService;
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/compra/nuevo")
	public String getPageNuevaCompra(Model model) {
		
		model.addAttribute("nuevaCompra", compraService.generarCompra());
		
		model.addAttribute("productos", productoService.getListProductos());
		return "nuevacompra";
	}
	
	@PostMapping("/compra/guardar")
	public ModelAndView postGuardarNuevaCompra(@ModelAttribute("nuevaCompra") Compra nuevaCompra) {
		
		Producto prod= productoService.findByCodigo(nuevaCompra.getProducto().getCodigo());
		nuevaCompra.setProducto(prod);
		compraService.addCompra(nuevaCompra);
		
		ModelAndView modelView= new ModelAndView("compras");
		modelView.addObject("compras",compraService.getListCompras());
		return modelView;
		
	}
	
	@GetMapping("/compra/listado")
	public ModelAndView getListaCompras() {
		ModelAndView modelView = new ModelAndView("compras");
		modelView.addObject("compras", compraService.getListCompras());
		return modelView;
		
	}
}
