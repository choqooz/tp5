package ar.edu.unju.fi.tp4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.models.Cliente;
import ar.edu.unju.fi.tp4.services.IClienteService;

@Controller
public class ClienteController {
	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("clienteRamImp")
	private IClienteService clienteService;
	
	
	@GetMapping("/cliente/nuevo")
	public ModelAndView getNuevoClientePage() {
		ModelAndView mav = new ModelAndView("nuevocliente");
		mav.addObject("cliente",cliente);
		return mav;
	}
	
	@PostMapping("/cliente/guardar")
	public ModelAndView getNuevoClientePage(@ModelAttribute("cliente")Cliente unCliente) {
		ModelAndView mav = new ModelAndView("clientes");
		
		clienteService.addCliente(unCliente);
		mav.addObject("clientes", clienteService.getClientes());
		return mav;
	}
	
	@GetMapping("/cliente/listado")
	public ModelAndView getListadoClientesPage() {
		ModelAndView mav = new ModelAndView("clientes");
			//if (clienteService.getClientes() == null ) {
				clienteService.generarListaClientes();
			//}
				
		mav.addObject("clientes", clienteService.getClientes());
		
		return mav;
	}

}
