package ar.edu.unju.fi.tp4.services;

import java.util.List;

import ar.edu.unju.fi.tp4.models.Producto;

public interface IProductoService {
	
	public void addProducto(Producto producto);
	public Producto getUltimoProducto();
	public Producto getProducto();
	public Producto findByCodigo(int codigo);
	public void generarListProductos();
	public List<Producto> getListProductos();
	
}
