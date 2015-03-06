package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import model.conection.MySQLDB;

import javax.servlet.http.HttpSession;

import model.Logic;
import model.beans.CategoryBean;
import model.beans.ProductoBean;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private MySQLDB mySQLDB;
	private int maxFileSize;
	private int maxMemSize;
	private ServletContext context;
	private String filePath;
	private File file;
	private String relativePath;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFile() {
		super();
		// TODO Auto-generated constructor stub
		// mySQLDB = new MySQLDB("jdbc:mysql://localhost/ficha_alumno", "root",
		// "");
		maxFileSize = 5000 * 1024;
		maxMemSize = 5000 * 1024;
		relativePath = "img";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// System.out.print(filePath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		context = getServletContext();
		filePath = context.getRealPath("/" + relativePath + "/");
		// System.out.println(filePath);
		file = new File(filePath);
		file.mkdir();
		String contentType = request.getContentType();

		if (contentType.indexOf("multipart/form-data") >= 0) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(maxMemSize);
			factory.setRepository(new File("/tmp"));
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(maxFileSize);
			List<FileItem> fileItems;
			try {
				fileItems = upload.parseRequest(request);
				ArrayList<FileItem> parameters = getParameters(request, upload,
						fileItems);
				uploadFiles(request, upload, fileItems);
				insertIntoDatabase(parameters, request.getSession());
				response.sendRedirect("Products?getAllProducts=true");
			}
			catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * @param request
	 * @param formFields
	 * @param upload
	 * @param fileItems
	 */
	private ArrayList<FileItem> getParameters(HttpServletRequest request,
			ServletFileUpload upload, List<FileItem> fileItems) {

		ArrayList<FileItem> formFields = new ArrayList<FileItem>();
		Iterator<FileItem> i = fileItems.iterator();

		while (i.hasNext()) {
			FileItem fi = (FileItem) i.next();
			if (fi.isFormField()) {
				formFields.add(fi);
			}
		}
		return formFields;
	}

	public void uploadFiles(HttpServletRequest request,
			ServletFileUpload upload, List<FileItem> fileItems) {
		Iterator<FileItem> i = fileItems.iterator();

		while (i.hasNext()) {
			FileItem fi = (FileItem) i.next();
			if (!fi.isFormField()) { // It must be a File
				// String fieldName = fi.getFieldName();
				String fileName = fi.getName();
				file = new File(filePath + "/" + fileName);
				System.out.println(file.getAbsolutePath());
				try {
					fi.write(file);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param formFields
	 * @param session
	 */
	private void insertIntoDatabase(ArrayList<FileItem> formFields,
			HttpSession session) {
		String action = formFields.get(formFields.size() - 1).getFieldName();
		Logic logic = new Logic();

		// Crea el ProductoBean
		CategoryBean categoria = logic.selectCategoria(Integer
				.parseInt(formFields.get(3).getString()));
		ProductoBean producto = new ProductoBean(0, formFields.get(0)
				.getString(), formFields.get(1).getString(),
				Double.parseDouble(formFields.get(2).getString()), relativePath
						+ "/" + file.getName(), categoria);
		if (action.equals("sendNew")) {
			logic.insertProducto(producto);
		}
		else if (action.equals("sendModify")) {
			ProductoBean productoBean = (ProductoBean) session
					.getAttribute("productoModificar");
			producto.setId(productoBean.getId());
			logic.updateProducto(producto);
		}

	}
}
