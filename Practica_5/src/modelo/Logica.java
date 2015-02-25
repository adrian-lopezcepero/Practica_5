package modelo;

import modelo.beans.Producto;
import modelo.beans.Usuario;
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
	

	public Usuario selectUsuario(String alias, String clave) {
		return this.usuarioDao.selectUsuario(alias, clave);
	}

	public Producto setProducto(int id) {
		return this.productoDao.selectProducto(id);
	}

	public boolean deleteUsuario(int id) {
		return this.usuarioDao.deleteUsuario(id);
	}
	
	public boolean deleteProducto(int id) {
		return this.productoDao.deleteProducto(id);
	}
	
	public boolean insertProducto(Producto producto) {
		return this.productoDao.insertProducto(producto);
	}
	
	public boolean insertUsuario(Usuario usuario) {
		return this.usuarioDao.insertUsuario(usuario);
	}
	
	public boolean updateProducto(Producto producto) {
		return this.productoDao.updateProducto(producto);
	}
	public boolean updateUsuario(Usuario usuario) {
		return this.usuarioDao.updateUsuario(usuario);
	}

}
