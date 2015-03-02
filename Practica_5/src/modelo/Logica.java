package modelo;

import java.util.ArrayList;

import modelo.beans.CategoriaBean;
import modelo.beans.PedidoBean;
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

	public UsuarioBean verificaUsuario(String alias, String clave) {
		// TODO Auto-generated method stub
		UsuarioBean selectUsuario = usuarioDao.selectUsuario(alias, clave);
		if (selectUsuario != null) {
			return selectUsuario;
		}
		return null;
	}

	public ArrayList<UsuarioBean> getUsuarios() {
		// TODO Auto-generated method stub
		return usuarioDao.selectAllUsuarios();
	}

	public ArrayList<ProductoBean> getProductos() {
		return productoDao.selectAllProductos();
	}

	public CategoriaBean selectCategoria(int idCat) {
		// TODO Auto-generated method stub
		return categoriaDao.selectCategoria(idCat);
	}

	// ANTONIO

	// Productos
	public ArrayList<ProductoBean> getNovedades(int cantidad) {
		return productoDao.selectProductosNovedades(cantidad);
	}

	public ArrayList<ProductoBean> getProductos(int idCategoria) {
		return productoDao.selectProductos(idCategoria);
	}

	public ProductoBean setProducto(int id, int cantidad) {
		ProductoBean producto = this.productoDao.selectProducto(id);
		producto.setCantidad(cantidad);
		return producto;
	}

	// Categorias
	public ArrayList<CategoriaBean> getCategorias() {
		return categoriaDao.selectAllCategorias();
	}

	// Pedidos
	public boolean insertPedido(PedidoBean pedido) {
		return this.pedidoDao.insertPedido(pedido);
	}
}
