package com.iiht.evaluation.coronokit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.google.gson.Gson;
import com.iiht.evaluation.coronokit.dao.KitDao;
import com.iiht.evaluation.coronokit.dao.ProductMasterDao;
import com.iiht.evaluation.coronokit.model.CoronaKit;
import com.iiht.evaluation.coronokit.model.KitDetail;
import com.iiht.evaluation.coronokit.model.OrderSummary;
import com.iiht.evaluation.coronokit.model.ProductMaster;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KitDao kitDAO;
	private ProductMasterDao productMasterDao;
   
	public void setKitDAO(KitDao kitDAO) {
		this.kitDAO = kitDAO;
	}

	public void setProductMasterDao(ProductMasterDao productMasterDao) {
		this.productMasterDao = productMasterDao;
	}

	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config. getServletContext().getInitParameter("jdbcPassword");
		
		this.kitDAO = new KitDao(jdbcURL, jdbcUsername, jdbcPassword);
		this.productMasterDao = new ProductMasterDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String viewName = "";
		try {
			switch (action) {
			case "newuser":
				viewName = showNewUserForm(request, response);
				break;
			case "insertuser":
				viewName = insertNewUser(request, response);
				break;
			case "showproducts":
				viewName = showAllProducts(request, response);
				break;	
			case "addnewitem":
				viewName = addNewItemToKit(request, response);
				break;
			case "deleteitem":
				viewName = deleteItemFromKit(request, response);
				break;
			case "showkit":
				viewName = showKitDetails(request, response);
				break;
			case "placeorder":
				viewName = showPlaceOrderForm(request, response);
				break;
			case "saveorder":
				viewName = saveOrderForDelivery(request, response);
				break;	
			case "ordersummary":
				viewName = showOrderSummary(request, response);
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

	private String showOrderSummary(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "ordersummary.jsp";
	}

	private String saveOrderForDelivery(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String address = request.getParameter("address");
		HttpSession session = request.getSession();
		OrderSummary odr =  (OrderSummary) session.getAttribute("orderSummery");
		List<ProductMaster> filterProduct = (List<ProductMaster>)session.getAttribute("productDetails");
		odr.getCoronaKit().setDeliveryAddress(address);
		request.setAttribute("orderSummery", odr);
		request.setAttribute("productDetails", filterProduct);
		/*System.out.println(new Gson().toJson(odr.getCoronaKit()) );
		System.out.println(new Gson().toJson(filterProduct));*/
		return showOrderSummary(request,response);
	}

	private String showPlaceOrderForm(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		OrderSummary odr =  (OrderSummary) session.getAttribute("orderSummery");
		
		request.setAttribute("coronaKit", odr.getCoronaKit());
		/*System.out.println(new Gson().toJson(odr.getCoronaKit()) );
		System.out.println(new Gson().toJson(odr.getKitDetails()));
		*/
		return "placeorder.jsp";
	}

	private String showKitDetails(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// session.setAttribute("userDetails",
		// request.getParameter("userDetails"));
		// session.setAttribute("ProductDetails",
		// request.getParameter("ProductDetails"));

		List<ProductMaster> allProduct = productMasterDao.getAllProduct();
		List<ProductMaster> filterProduct = new ArrayList<>();
		// CoronaKit
		double totalAmt = 0.0;
		List<KitDetail> cKit = new ArrayList<>();
		for (ProductMaster product : allProduct) {
			String pid = request.getParameter(String.valueOf(product.getId()));
			int quantity = Integer.parseInt(pid);
			if (quantity > 0) {

				filterProduct.add(product);
				KitDetail kit = new KitDetail(1, product.getId(), product.getId(), quantity,
						product.getCost() * quantity);
				totalAmt = totalAmt + product.getCost() * quantity;
				cKit.add(kit);
			}

		}
		
		LocalDateTime current = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatedDateTime = current.format(format);

		CoronaKit coronaKit = new CoronaKit(1001, request.getParameter("custname"), request.getParameter("custemail"),
				request.getParameter("custcontact"), totalAmt, null, formatedDateTime, false);

		OrderSummary odr = new OrderSummary();
		odr.setCoronaKit(coronaKit);
		odr.setKitDetails(cKit);		
		session.setAttribute("orderSummery", odr);
		session.setAttribute("productDetails", filterProduct);
		
		request.setAttribute("orderSummery", odr);
		request.setAttribute("productDetails", filterProduct);
		System.out.println(filterProduct);
		return "showkit.jsp";
	}

	private String deleteItemFromKit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String addNewItemToKit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String showAllProducts(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<ProductMaster> allProduct = productMasterDao.getAllProduct();
		request.setAttribute("PRODUCT_LIST", allProduct);
		
		return "showproductstoadd.jsp";
	}

	private String insertNewUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("pname");
		String email = request.getParameter("pemail");
		String contact = request.getParameter("pcontact");
		CoronaKit coronaKit = new CoronaKit(name, email, contact);
		request.setAttribute("UserDetails", coronaKit);
		return showAllProducts(request,response);
	}

	private String showNewUserForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "newuser.jsp";
	}
}