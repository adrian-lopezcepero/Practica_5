package modelo;

import java.util.ArrayList;

import modelo.beans.CategoriaBean;
import modelo.beans.ProductoBean;
import modelo.beans.UsuarioBean;
import modelo.beans.UsuariosBean;
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

//	public UsuarioBean getLoginResponse(String alias, String clave,
//			UsuariosBean usuariosBean) {
//		// Comprueba que el usuario existe
//		ArrayList<UsuarioBean> usuariosLogeados = usuariosBean.getLoggedUsers();
//		for (int i = 0; i < usuariosLogeados.size(); i++) {
//			UsuarioBean usuarioBean = usuariosLogeados.get(i);
//			if (usuarioBean.getAlias().equals(alias)
//					&& usuarioBean.getClave().equals(clave)) {
//				return usuarioBean;
//			}
//		}
//		return null;
//	}

//	public boolean isSameSession(String ultimaSesion, String id) {
//		// TODO Auto-generated method stub
//		return ultimaSesion.equals(id);
//	}

	public UsuarioBean verificaUsuario(String alias, String clave) {
		// TODO Auto-generated method stub
		UsuarioBean selectUsuario = usuarioDao.selectUsuario(alias, clave);
		if (selectUsuario != null) {
			return selectUsuario;
		}
		return null;
	}
//
//	public boolean isAdmin(UsuarioBean usuarioBean) {
//		// TODO Auto-generated method stub
//		return usuarioBean.getAlias().equals("admin");
//	}

	public ArrayList<UsuarioBean> getUsuarios() {
		// TODO Auto-generated method stub
		return usuarioDao.selectAllUsuarios();
	}
	
	public ArrayList<ProductoBean> getProductos() {
		return productoDao.selectAllProductos();
	}
	
	public CategoriaBean getCategoria(String nombre) {
		return categoriaDao.selectCategoria(nombre);
	}

}
