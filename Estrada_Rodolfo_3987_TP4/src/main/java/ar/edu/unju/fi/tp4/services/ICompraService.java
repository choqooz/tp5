package ar.edu.unju.fi.tp4.services;

import java.util.List;

import ar.edu.unju.fi.tp4.models.Compra;

public interface ICompraService {
	
	public void addCompra(Compra compra);

	public List<Compra> getListCompras();
	
	public void generarListaCompra();
	
	public Compra generarCompra();

}
