package com.iiht.evaluation.coronokit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iiht.evaluation.coronokit.model.ProductMaster;


public class ProductMasterDao {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public ProductMasterDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}


	public List<ProductMaster> getAllProduct(){

		ArrayList<ProductMaster> arrayList = new ArrayList<>();

		try{
			connect();
			Statement createStatement = jdbcConnection.createStatement();
			ResultSet executeQuery = createStatement.executeQuery("select * from product order by product_name");

			while(executeQuery.next()) {
				int id = executeQuery.getInt(1);
				String pname = executeQuery.getString(2);
				double pcost = executeQuery.getDouble(3);
				String pdescr = executeQuery.getString(4);

				arrayList.add(new ProductMaster(id,pname, pcost, pdescr));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				disconnect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arrayList;
	}
	// add DAO methods as per requirements

	public void addProduct(ProductMaster product) {
		// TODO Auto-generated method stub

		try {
			connect();
			String sql = "insert into product (product_name,cost,product_description) "
					+ "values(?,?,?)";
			PreparedStatement insertStmt = jdbcConnection.prepareStatement(sql);
			insertStmt.setString(1, product.getProductName());
			insertStmt.setDouble(2, product.getCost());
			insertStmt.setString(3, product.getProductDescription());
			insertStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				disconnect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	public ProductMaster getProductById(int id) throws Exception {
		// TODO Auto-generated method stub
		ProductMaster product=null;
		try {
			
			connect();
			String sql = "select product_name,cost,product_description from product where id=?";
			PreparedStatement insertStmt = jdbcConnection.prepareStatement(sql);
			insertStmt.setInt(1, id);
			ResultSet executeQuery = insertStmt.executeQuery();
			if(executeQuery.next()){
				String pName = executeQuery.getString(1);
				double pCost = executeQuery.getDouble(2);
				String pDesc = executeQuery.getString(3);
				product = new ProductMaster(id,pName, pCost, pDesc);
			}else{
				throw new Exception("Product id not present. id= "+id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				disconnect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return product;
	}

	public void updateProduct(ProductMaster product) {
		// TODO Auto-generated method stub
		
		try {
			connect();
			String sql = "update product "
					+ " set product_name=?, cost=?, product_description=? where id=?";
			
			PreparedStatement insertStmt = jdbcConnection.prepareStatement(sql);
			insertStmt.setString(1, product.getProductName());
			insertStmt.setDouble(2, product.getCost());
			insertStmt.setString(3, product.getProductDescription());
			insertStmt.setInt(4, product.getId());
			insertStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				disconnect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		try {
			connect();
			String sql = "delete from product where id=?";
			
			PreparedStatement insertStmt = jdbcConnection.prepareStatement(sql);
			insertStmt.setInt(1, id);
			insertStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				disconnect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



}