package com.iiht.evaluation.coronokit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.coronokit.dao.ProductMasterDao;
import com.iiht.evaluation.coronokit.model.ProductMaster; 

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductMasterDao productMasterDao;
	
	
	public void setProductMasterDao(ProductMasterDao productMasterDao) {
		this.productMasterDao = productMasterDao;
	}

	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");

		this.productMasterDao = new ProductMasterDao(jdbcURL, jdbcUsername, jdbcPassword);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action =  request.getParameter("action");
		String viewName = "";
		try {
			switch (action) {
			case "login" : 
				viewName = adminLogin(request, response);
				break;
			case "newproduct":
				viewName = showNewProductForm(request, response);
				break;
			case "insertproduct":
				viewName = insertProduct(request, response);
				break;
			case "deleteproduct":
				viewName = deleteProduct(request, response);
				break;
			case "editproduct":
				viewName = showEditProductForm(request, response);
				break;
			case "updateproduct":
				viewName = updateProduct(request, response);
				break;
			case "list":
				viewName = listAllProducts(request, response);
				break;	
			case "logout":
				viewName = adminLogout(request, response);
				break;	
			default : viewName = "notfound.jsp"; break;		
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
		
		
	}

	private String adminLogout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "index.jsp";
	}

	private String listAllProducts(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<ProductMaster> allProduct = productMasterDao.getAllProduct();
		request.setAttribute("PRODUCT_LIST", allProduct);
		return "listproducts.jsp";
	}

	private String updateProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String pId = request.getParameter("productId");
		String name = request.getParameter("pname");
		String cost = request.getParameter("pcost");
		String description = request.getParameter("pdesc");
		int id = Integer.parseInt(pId);
		ProductMaster product = new ProductMaster(id,name, Double.parseDouble(cost), description);
		productMasterDao.updateProduct(product);
		//listStudents(request,response);
		return showNewProductForm(request,response);
	}

	private String showEditProductForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String productId = request.getParameter("productId");
		int id = Integer.parseInt(productId);
		try {
			ProductMaster product = productMasterDao.getProductById(id);
			request.setAttribute("THE_PRODUCT", product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "editproduct.jsp";
	}

	private String deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String productId = request.getParameter("productId");
		int id = Integer.parseInt(productId);
		try {
			productMasterDao.deleteProductById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return showNewProductForm(request,response);
	}

	private String insertProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("pname");
		String cost = request.getParameter("pcost");
		String description = request.getParameter("pdesc");
		
		ProductMaster product = new ProductMaster(name, Double.parseDouble(cost), description);
		productMasterDao.addProduct(product);
		//listStudents(request,response);
		return showNewProductForm(request,response);
	}

	private String showNewProductForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<ProductMaster> allProduct = productMasterDao.getAllProduct();
		request.setAttribute("PRODUCT_LIST", allProduct);
		return "listproducts.jsp";
	}

	private String adminLogin(HttpServletRequest request, HttpServletResponse response) {
		String userName = "admin";
		String password = "admin";
		String formUID = request.getParameter("loginid");
		String formPwd = request.getParameter("password");
		
		return formUID.equalsIgnoreCase(userName)&&formPwd.equals(password)?listAllProducts(request,response):"errorPage.jsp";
		
	}

	
}