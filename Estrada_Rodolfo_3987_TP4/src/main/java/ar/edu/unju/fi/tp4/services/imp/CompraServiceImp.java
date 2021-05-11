package ar.edu.unju.fi.tp4.services.imp;

import java.util.List;

import ar.edu.unju.fi.tp4.models.Compra;
import ar.edu.unju.fi.tp4.services.ICompraService;
import ar.edu.unju.fi.tp4.util.TablaCompra;

public class CompraServiceImp implements ICompraService {

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
	public List<Compra> getCompra() 
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
		
	}

	
}
