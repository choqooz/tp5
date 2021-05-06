package ar.edu.unju.fi.tp4.services;

import java.util.List;

import ar.edu.unju.fi.tp4.models.Cliente;

public interface IClienteService {
	public void addCliente(Cliente cliente);
	public List<Cliente> getClientes();
	public void generarListaClientes();
}
