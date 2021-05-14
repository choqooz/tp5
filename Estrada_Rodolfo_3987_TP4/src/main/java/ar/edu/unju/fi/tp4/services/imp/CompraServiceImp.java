package ar.edu.unju.fi.tp4.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.models.Producto;
import ar.edu.unju.fi.tp4.models.Compra;
import ar.edu.unju.fi.tp4.services.ICompraService;
import ar.edu.unju.fi.tp4.services.IProductoService;
import ar.edu.unju.fi.tp4.util.TablaCompra;
@Service
public class CompraServiceImp implements ICompraService {

	@Autowired
	private IProductoService productoService;
	@Autowired
	private Compra compra;
	
	private List<Compra> compras;
	
	@Override
	public void addCompra(Compra compra) 
	{
		if (compras==null)
		{
			generarListaCompra();
		}
		compras.add(compra);
		
	}

	@Override
	public List<Compra> getListCompras() 
	{
		if (compras==null)
		{
			generarListaCompra();
		}
		
		return compras;
	}

	@Override
	public void generarListaCompra() 
	{
		compras= TablaCompra.compras;
		Producto producto = productoService.getUltimoProducto();
		int cantidad=6 ,id=1;
		
		Compra compra =new Compra();
		compra.setCantidad(cantidad);
		compra.setProducto(producto);
		compra.setId(id);
		//compra.setProductoCod(id);
		compras.add(compra);
	}

	@Override
	public Compra generarCompra() {
		Compra compra = new Compra();
		return compra;
	}

	
}
