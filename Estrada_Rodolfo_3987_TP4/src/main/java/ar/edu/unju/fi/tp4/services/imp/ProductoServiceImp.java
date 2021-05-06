package ar.edu.unju.fi.tp4.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.models.Producto;
import ar.edu.unju.fi.tp4.services.IProductoService;

@Service
public class ProductoServiceImp implements IProductoService {
	
	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
	
	@Autowired
	Producto producto;
	
	List<Producto> productos = new ArrayList<Producto>();
	@Override
	public void addProducto(Producto producto) {
		this.productos.add(producto);
		
	}

	@Override
	public Producto getUltimoProducto() {
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
		return this.producto;
	}
	
}
