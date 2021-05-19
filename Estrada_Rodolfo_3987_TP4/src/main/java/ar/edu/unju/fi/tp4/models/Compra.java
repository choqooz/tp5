package ar.edu.unju.fi.tp4.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "compras")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "compra")	
	private List<Producto> producto = new ArrayList <>();
	@Column(name = "comp_cantidad")
	private Integer cantidad;
	@Column(name = "comp_total")
	private Double total;
	
	//se agregó este atributo auxiliar
	//private int productoCod;
	
	public Compra() {
		super();
	}
	
	public Compra(Long id, Producto producto, Integer cantidad, Double total) {
		super();
		this.id = id;
		this.producto = (List<Producto>) producto;
		this.cantidad = cantidad;
		this.total = total;
	}
	
	
	
	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getTotal() {
		total=((Producto) producto).getPrecio()*this.cantidad;
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", total=" + total + "]";
	}
	
	
}
