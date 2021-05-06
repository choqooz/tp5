package ar.edu.unju.fi.tp4.services;

import ar.edu.unju.fi.tp4.models.Producto;

public interface IProductoService {
	public void addProducto(Producto producto);
	public Producto getUltimoProducto();
	public Producto getProducto();
}
