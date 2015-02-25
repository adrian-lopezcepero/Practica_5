package modelo;

import modelo.beans.ProductoBean;
import modelo.beans.UsuarioBean;
import modelo.dao.CategoriaDao;
import modelo.dao.PedidoDao;
import modelo.dao.ProductoDao;
import modelo.dao.UsuarioDao;

public class Logica {

	private UsuarioDao usuarioDao;
	private PedidoDao pedidoDao;
	private ProductoDao productoDao;
	private CategoriaDao categoriaDao;

	public Logica() {
		usuarioDao = new UsuarioDao();
		pedidoDao = new PedidoDao();
		productoDao = new ProductoDao();
		categoriaDao = new CategoriaDao();
	}
	

	public UsuarioBean selectUsuario(String alias, String clave) {
		return this.usuarioDao.selectUsuario(alias, clave);
	}

	public ProductoBean setProducto(int id) {
		return this.productoDao.selectProducto(id);
	}

	public boolean deleteUsuario(int id) {
		return this.usuarioDao.deleteUsuario(id);
	}
	
	public boolean deleteProducto(int id) {
		return this.productoDao.deleteProducto(id);
	}
	
	public boolean insertProducto(ProductoBean productoBean) {
		return this.productoDao.insertProducto(productoBean);
	}
	
	public boolean insertUsuario(UsuarioBean usuarioBean) {
		return this.usuarioDao.insertUsuario(usuarioBean);
	}
	
	public boolean updateProducto(ProductoBean productoBean) {
		return this.productoDao.updateProducto(productoBean);
	}
	public boolean updateUsuario(UsuarioBean usuarioBean) {
		return this.usuarioDao.updateUsuario(usuarioBean);
	}

}
