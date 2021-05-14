package ar.edu.unju.fi.tp4.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.models.Producto;
import ar.edu.unju.fi.tp4.services.IProductoService;
import ar.edu.unju.fi.tp4.util.TablaProducto;

@Service
public class ProductoServiceImp implements IProductoService {
	
	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
	
	@Autowired
	Producto producto;
	
	List<Producto> productos;
	@Override
	public void addProducto(Producto producto) {
		this.productos.add(producto);
		
	}

	@Override
	public Producto getUltimoProducto() {
		if (productos==null)
			generarListProductos();
		int indUltProd = productos.size() -1;
		Producto producto = productos.get(indUltProd);
		return producto;
	}

	@Override
	public Producto getProducto() {
		LOGGER.info("Service: IPersonaService -> PersonaServiceImp");
		LOGGER.info("Method: getProducto()");
		LOGGER.info("Result: object Producto");
		//LOGGER.info("Se ha guardado un producto: "+getUltimoProducto());
		Producto producto= new Producto();
		return producto;
	}

	@Override
	public Producto findByCodigo(int codigo) {
		Producto producto = new Producto();
		for (int i=0;i<getListProductos().size();i++) {
			if (codigo==getListProductos().get(i).getCodigo()) {
				producto.setCodigo(getListProductos().get(i).getCodigo());
				producto.setMarca(getListProductos().get(i).getMarca());
				producto.setNombre(getListProductos().get(i).getNombre());
				producto.setPrecio(getListProductos().get(i).getPrecio());
				producto.setStock(getListProductos().get(i).getStock());
			}
		}
		return producto;
	}

	@Override
	public void generarListProductos() {
		productos=TablaProducto.listaProductos;
		Producto producto = new Producto(10,"Pasta Dental",250d,"Colgate",100);
		productos.add(producto);
		
	}

	@Override
	public List<Producto> getListProductos() {
		if (productos==null)
			generarListProductos();
		return productos;
	}
	
	
}
