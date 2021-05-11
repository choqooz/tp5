package ar.edu.unju.fi.tp4.models;

import org.springframework.stereotype.Component;

@Component
public class Compra {
	private int id;
	private Producto producto;
	private int cantidad;
	private double total;
	
	//se agregó este atributo auxiliar
	private int productoCod;
	
	public Compra() {
		super();
	}
	
	public Compra(int id, Producto producto, int cantidad, double total) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}
	
	
	
	/**
	 * @param id
	 * @param producto
	 * @param cantidad
	 * @param productoCod
	 */
	public Compra(int id, Producto producto, int cantidad, int productoCod) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.productoCod = productoCod;
		this.total=cantidad*producto.getPrecio();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getTotal() {
		total=producto.getPrecio()*this.cantidad;
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	/**
	 * @return the productoCod
	 */
	public int getProductoCod() {
		return productoCod;
	}

	/**
	 * @param productoCod the productoCod to set
	 */
	public void setProductoCod(int productoCod) {
		this.productoCod = productoCod;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", total=" + total + "]";
	}
	
	
}
