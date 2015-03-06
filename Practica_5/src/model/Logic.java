package model;

import java.util.ArrayList;

import model.beans.CategoryBean;
import model.beans.PedidoBean;
import model.beans.ProductoBean;
import model.beans.UserBean;
import model.dao.CategoryDao;
import model.dao.PurchaseDao;
import model.dao.ProductDao;
import model.dao.UserDao;

public class Logic {

	private UserDao userDao;
	private PurchaseDao purchaseDao;
	private ProductDao productDao;
	private CategoryDao categoryDao;

	public Logic() {
		userDao = new UserDao();
		purchaseDao = new PurchaseDao();
		productDao = new ProductDao();
		categoryDao = new CategoryDao();
	}

	public UserBean selectUsuario(String alias, String clave) {
		return this.userDao.selectUsuario(alias, clave);
	}

	public ProductoBean setProducto(int id) {
		return this.productDao.selectProducto(id);
	}

	public boolean deleteUsuario(int id) {
		return this.userDao.deleteUsuario(id);
	}

	public boolean deleteProducto(int id) {
		return this.productDao.deleteProducto(id);
	}

	public boolean insertProducto(ProductoBean productoBean) {
		return this.productDao.insertProducto(productoBean);
	}

	public boolean insertUsuario(UserBean userBean) {
		return this.userDao.insertUsuario(userBean);
	}

	public boolean updateProducto(ProductoBean productoBean) {
		return this.productDao.updateProducto(productoBean);
	}

	public boolean updateUsuario(UserBean userBean) {
		return this.userDao.updateUsuario(userBean);
	}

	public UserBean verificaUsuario(String alias, String clave) {
		// TODO Auto-generated method stub
		UserBean selectUsuario = userDao.selectUsuario(alias, clave);
		if (selectUsuario != null) {
			return selectUsuario;
		}
		return null;
	}

	public ArrayList<UserBean> getUsuarios() {
		// TODO Auto-generated method stub
		return userDao.selectAllUsuarios();
	}

	public ArrayList<ProductoBean> getProductos() {
		return productDao.selectAllProductos();
	}

	public CategoryBean selectCategoria(int idCat) {
		// TODO Auto-generated method stub
		return categoryDao.selectCategoria(idCat);
	}

	// ANTONIO

	// Productos
	public ArrayList<ProductoBean> getNovedades(int cantidad) {
		return productDao.selectProductosNovedades(cantidad);
	}

	public ArrayList<ProductoBean> getProductos(int idCategoria) {
		return productDao.selectProductos(idCategoria);
	}

	public ProductoBean setProducto(int id, int cantidad) {
		ProductoBean producto = this.productDao.selectProducto(id);
		producto.setCantidad(cantidad);
		return producto;
	}

	// Categorias
	public ArrayList<CategoryBean> getCategorias() {
		return categoryDao.selectAllCategorias();
	}

	// Orders
	public boolean insertPedido(PedidoBean pedido) {
		return this.purchaseDao.insertPedido(pedido);
	}
}
