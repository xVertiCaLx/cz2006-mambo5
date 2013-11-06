package mambo5.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import mambo5.Controller.DBController;
import mambo5.Entity.Admin;
import mambo5.Entity.Canteen;
import mambo5.Entity.Customer;
import mambo5.Entity.Menu;
import mambo5.Entity.MenuItem;
import mambo5.Entity.Order;
import mambo5.Entity.OrderDetail;
import mambo5.Entity.Stall;

//Concrete data store object for data access in MySQL database
public class MySQLImpl implements DataStoreInterface {
	// declaration
	private ArrayList<Canteen> canteenList;
	private ArrayList<Stall> stallList;
	private ArrayList<Admin> adminList;
	private ResultSet rs;

	// setup Connections
	SystemConfiguration sc;
	DBController dbc;

	public MySQLImpl(SystemConfiguration sysConfig) {
		this.sc = sysConfig;
		dbc = new DBController(sc.getDatabase(), sc.getDbuser(),
				sc.getDbpassword());
	}

	// -----------------------------------------Canteen-------------------------------------------
	@Override
	public int createCanteen(String canteenName, String canteenDesc, String canteenAddress, int maxStall) {
		// TODO Auto-generated method stub
		int result = 0;
		
		String sql = "INSERT INTO canteen ( canteenName, canteenDesc, canteenAddress, maxStall) "
					+ "VALUES ( '" + canteenName + "' , '" + canteenDesc + "' , '" + canteenAddress + "' , '" + maxStall +"');";
		
		result = dbc.executeNonQuery(sql);
		return result;
	}
	@Override
	public ArrayList<Canteen> retrieveCanteenList() {
		Canteen c;
		canteenList = new ArrayList<Canteen>();

		String sql = "SELECT * FROM CANTEEN;";
		rs = dbc.execute(sql);

		try {
			while (rs.next()) {
				c = new Canteen(rs.getInt("canteenID"),
						rs.getString("canteenName"),
						rs.getString("canteenDesc"),
						rs.getString("canteenAddress"), rs.getInt("maxStall"));
				canteenList.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return canteenList;
	}

	@Override
	public int updateCanteenDetail(int canteenID, String canteenName,
			String canteenDesc, String canteenAddress, int maxStall) {
		int result = 0;

		String sql = "UPDATE canteen " + "SET canteenName = '" + canteenName
				+ "' , canteenDesc = '" + canteenDesc
				+ "' , canteenAddress = '" + canteenAddress + "' , maxStall = "
				+ maxStall + " " + "WHERE canteenID = " + canteenID + ";";

		result = dbc.executeNonQuery(sql);

		return result;
	}

	@Override
	public int deleteCanteen(int canteenID) {
		int result = 0;

		String sql = "DELETE FROM canteen " + "WHERE canteenID = " + canteenID
				+ ";";

		result = dbc.executeNonQuery(sql);

		return result;
	}

	@Override
	public ArrayList<Stall> retrieveStallList(int canteenID) {
		Stall s;
		stallList = new ArrayList<Stall>();
		boolean status = false;
		String sql = "SELECT * FROM Stall WHERE canteenID = " + canteenID
				+ " and stallStatus = 'T';";
		rs = dbc.execute(sql);

		try {
			while (rs.next()) {
				if (rs.getString("stallStatus").equals("T"))
					status = true;
				else
					status = false;
				s = new Stall(rs.getInt("stallID"), rs.getInt("canteenID"),
						rs.getString("stallUnit"), rs.getString("stallName"),
						rs.getString("stallDesc"), status);
				stallList.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return stallList;
	}

	// -------------------------------------------Stall----------------------------------------------------------------
	@Override
	public int createStall(int canteenID, String stallUnit, String stallName,
			String stallDesc, String stallStatus) {
		int result = 0;

		String sql = "INSERT INTO stall ( canteenID, stallUnit, stallName, stallDesc, stallStatus) "
				+ "VALUES ( '"
				+ canteenID
				+ "' , '"
				+ stallUnit
				+ "' , '"
				+ stallName
				+ "' , '"
				+ stallDesc
				+ "' , '"
				+ stallStatus
				+ "');";

		result = dbc.executeNonQuery(sql);
		return result;
	}

	@Override
	public int updateStallDetail(int stallID, String stallName,
			String stallDesc, String stallStatus) {
		int result = 0;

		String sql = "UPDATE stall " + "SET stallName = '" + stallName
				+ "' , stallDesc = '" + stallDesc + "' , stallStatus = '"
				+ stallStatus + "' WHERE stallID = " + stallID + ";";

		result = dbc.executeNonQuery(sql);
		return result;
	}

	@Override
	public int deleteStall(int stallID) {
		int result = 0;

		String sql = "DELETE FROM stall " + "WHERE stallID = " + stallID + ";";

		result = dbc.executeNonQuery(sql);

		return result;
	}

	// -------------------------------------------Admin-----------------------------------------------------------------
	@Override
	public ArrayList<Admin> retrieveAdminList() {
		Admin admin;
		adminList = new ArrayList<Admin>();

		String sql = "SELECT * FROM admin;";
		rs = dbc.execute(sql);

		try {
			while (rs.next()) {
				admin = new Admin(rs.getInt("adminID"), rs.getInt("accessID"),
						rs.getInt("stallID"), rs.getString("adminName"),
						rs.getString("password"));
				adminList.add(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return adminList;
	}

	// ------------------------------------------Menu-----------------------------------------------------------------------
	@Override
	public ArrayList<Menu> retrieveMenu(ArrayList<Stall> stallList) {
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		try {
			if (stallList.size() > 0) {
				String sql = "SELECT * FROM MENU WHERE stallID in (";
				for (int i = 0; i < stallList.size(); i++) {
					sql += "'" + stallList.get(i).getStallId() + "'";
					if (i + 1 < stallList.size())
						sql += ",";
				}
				sql += ");";
				rs = dbc.execute(sql);
				while (rs.next()) {
					Menu m = new Menu(rs.getInt("menuID"),
							rs.getInt("stallID"), rs.getString("menuType"));
					menuList.add(m);
				}
				dbc.terminate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}
	
	public ArrayList<Menu> retrieveMenuList(ArrayList<Menu> menuList) {
		try {
				String sql = "SELECT * FROM MENU;";
				rs = dbc.execute(sql);
				while (rs.next()) {
					menuList.add(new Menu(rs.getInt("menuID"),
							rs.getInt("stallID"), rs.getString("menuType")));
					System.out.println(rs.getInt("menuID") + " " + 
							rs.getInt("stallID") + " " + rs.getString("menuType"));
				}
				dbc.terminate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}
	
	@Override
	public int createMenu(int stallID, String menuType) {
		int result = 0;
		String sql = "INSERT INTO menu (stallID, menuType)"
					+ "VALUES ( '"+ stallID +"', '"+ menuType +"');";
		dbc.executeNonQuery(sql);
		
		try {
			sql = "SELECT MENUID FROM MENU WHERE STALLID = '"
					+ stallID + "';";
			rs = dbc.execute(sql);

			if(rs.next())
				result = rs.getInt("menuID");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		
		return result;
	}
	
	//------------------------------------MENU ITEM------------------------------------------------
	

	@Override
	public int createMenuItem(int menuID, String menuItemName,
			double menuItemPrice, double discount) {
		int result = 0;
		String sql = "INSERT INTO menuitem (menuID, menuItemName, menuItemPrice, discount)"
					+ "VALUES ( '"+ menuID +"', '"+ menuItemName +"', '" + menuItemPrice + "' , '" + discount + "');";
		
		result = dbc.executeNonQuery(sql);
		
		return result;
	}
	
	public int updateMenuItem(String menuItemName,double menuItemPrice, 
			double discount, int menuItemID) {
		
		int result = 0;
		String sql = "UPDATE menuitem SET menuItemName = '" + menuItemName + "',"
				+ "menuItemPrice = '" + menuItemPrice + "', discount = '" + discount + "' WHERE menuItemID = '" + menuItemID + "';";
				
		result = dbc.executeNonQuery(sql);
		return result;
		
	}
	
	public int deleteMenuItem(int menuItemID) {
		
		int result = 0;
		
		String sql = "DELETE FROM menuitem WHERE menuItemID = " + menuItemID + ";";
				
		result = dbc.executeNonQuery(sql);
		return result;
		
	}
	
	@Override
	public ArrayList<MenuItem> retrieveMenuItem(
			ArrayList<MenuItem> menuItemList, int menuItemID) {
		try {
			System.out.println("got error in retrieve sql?");
			String sql = "SELECT * FROM MENUITEM WHERE menuItemID = '"
					+ menuItemID + "';";
			rs = dbc.execute(sql);

			while (rs.next())
				menuItemList.add(new MenuItem(rs.getInt("menuItemID"), rs
						.getInt("menuID"), rs.getString("menuItemName"), rs
						.getDouble("menuItemPrice"), rs.getDouble("discount")));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return menuItemList;
	}
	
	public ArrayList<MenuItem> retrieveMenuItem(ArrayList<MenuItem> menuItemList) {
		try {
			String sql = "SELECT * FROM menuitem;";
			rs = dbc.execute(sql);

			while (rs.next())
				menuItemList.add(new MenuItem(rs.getInt("menuItemID"), rs
						.getInt("menuID"), rs.getString("menuItemName"), rs
						.getDouble("menuItemPrice"), rs.getDouble("discount")));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		
		return menuItemList;
	}

	//----------------------------------------------Order------------------------------------------------------
		
	@Override
	public int createOrder(int custID, Date purchaseDate, String orderStatus,
			int stallID) {
		int result = 0;
		String sql = "INSERT INTO orders (custID, purchaseDate, orderStatus, stallID) "
					+ "VALUES ( '" + custID + "' , '" + purchaseDate + "' , '" + orderStatus +"', '" + stallID +"');";
		
		result = dbc.executeNonQuery(sql);
		
		if(result==1)
		{
			sql = "Select orderID from orders order by orderID desc limit 1;";
			
			try {
				rs = dbc.execute(sql);
				rs.next();
				result = rs.getInt("orderID"); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
			result = -1;
		
		return result;
	}
	
	@Override
	public int refundOrder(int orderID) {
		int result = 0;
		String sql = "UPDATE orders SET orderStatus = '" + "Refunded" + "' WHERE orderID = '" + orderID + "';";
				
		result = dbc.executeNonQuery(sql);
		return result;
	}
	
	@Override
	public int confirmOrder(int orderID) {
		int result = 0;
		String sql = "UPDATE orders SET orderStatus = '" + "Completed" + "' WHERE orderID = '" + orderID + "';";
				
		result = dbc.executeNonQuery(sql);
		return result;
	}
	
	public ArrayList<Order> retrieveOrderID(ArrayList<Order> orderIDList,
			int stallID, String orderStatus) {
		try {
			String sql = "SELECT * FROM orders WHERE stallID = '" + stallID
					+ "' AND orderStatus = '" + orderStatus + "';";
			rs = dbc.execute(sql);

			while (rs.next())
				orderIDList.add(new Order(rs.getInt("orderID"), rs
						.getInt("custID"), rs.getDate("purchaseDate"), rs
						.getString("orderStatus"), rs.getInt("stallID")));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return orderIDList;
	}

	//---------------------------------------OrderDetail--------------------------------------------------
	@Override
	public int createOrderDetail(int orderID, int menuItemID,
			double actualPrice, int quantity) {
		int result = 0;
		String sql = "INSERT INTO orderdetails (orderID, menuItemID, actualPrice, quantity)"
					+ "VALUES ( '"+ orderID +"', '" + menuItemID + "' , '" + actualPrice + "' , '" + quantity + "');";
		
		result = dbc.executeNonQuery(sql);
		return result;
	}
	
	public ArrayList<Order> retrieveOrderList(ArrayList<Order> orderList) {
		try {
			String sql = "SELECT * FROM orders;";
			rs = dbc.execute(sql);

			while (rs.next()) {
				orderList.add(new Order(rs.getInt("orderID"), rs.getInt("custID"), rs.getDate("purchaseDate"),rs.getString("orderStatus"),rs.getInt("stallID")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return orderList;
	}
	
	public ArrayList<OrderDetail> retrieveOrderDetailList(ArrayList<OrderDetail> orderDetailList) {
		try {
			String sql = "SELECT * FROM orderdetails;";
			rs = dbc.execute(sql);

			while (rs.next()) {
				orderDetailList.add(new OrderDetail(rs.getInt("menuItemID"), rs
						.getInt("orderID"), rs.getDouble("actualPrice"),rs.getInt("quantity")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return orderDetailList;
	}
	
	//For retrieving total price when refunding order
	public ArrayList<OrderDetail> retrieveOrderDetailTotalPrice(ArrayList<OrderDetail> orderDetailList, int orderID) {
		try {

			String sql = "SELECT * FROM orderdetails WHERE orderID = " + orderID + ";";
			rs = dbc.execute(sql);

			while (rs.next()) {
				orderDetailList.add(new OrderDetail(rs.getInt("menuItemID"), rs
						.getInt("orderID"), rs.getDouble("actualPrice"),rs.getInt("quantity")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return orderDetailList;
	}
	//--------------------------------------------------Customer---------------------------------------------------
	@Override
	public int createCustomer(double cardBalance, String fullName, int accessID) {
		int result = 0;
		
		String sql = "INSERT INTO customer (fullName, cardBalance, accessID) "
					+ "VALUES ( '" + fullName + "' , '" + cardBalance + "' , " + accessID + ");";
		
		result = dbc.executeNonQuery(sql);
				
		return result;
	}

	@Override
	public int updateCustomerCardValue(int custID, double cardBalance) {
		int result = 0;
		
		String sql = "UPDATE customer SET cardBalance = '" + cardBalance + "' WHERE custID = " + custID + ";";
				
		result = dbc.executeNonQuery(sql);
				
		return result;
	}

	@Override
	public int refundCustomerCard(int custID) {
		int result = 0;
		
		String sql = "DELETE FROM customer WHERE custID = " + custID + ";";
				
		result = dbc.executeNonQuery(sql);
		return result;
	}

	@Override
	public Customer retrieveCustomerDetail(int custID) {
		Customer cust = null;
		String sql = "SELECT * FROM Customer WHERE custID = " + custID + ";";
		rs = dbc.execute(sql);
		
		if(rs != null) {
	        try {
	        	if(rs.next()) {   // Move the cursor to the next row
	        		cust = new Customer(rs.getInt("custID"),rs.getDouble("cardBalance"),rs.getString("fullName"),rs.getInt("accessID"), rs.getString("Email"));				    
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cust;
	}

	@Override
	public ArrayList<String> retrieveCustomerPurchaseDate(int custID) {
		ArrayList<String> customerPurchaseDate = new ArrayList<String>();
		
		String sql = "SELECT purchaseDate FROM orders where custID =" + custID + " Order By purchaseDate DESC LIMIT 5;";
		
		rs = dbc.execute(sql);
		try {
			while(rs.next()) {
				String purchaseDate = rs.getTimestamp("purchaseDate").toString();
				customerPurchaseDate.add(purchaseDate);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return customerPurchaseDate;
	}

	@Override
	public ArrayList<MenuItem> retrieveSpecificPurchaseDate(
			String purchaseDate, int custID) {
		ArrayList<MenuItem> itemList = new ArrayList<MenuItem>();
		ResultSet rs = null;
		
		String sql = "SELECT customer.custID, orders.orderID, menuitem.menuItemName, menuitem.menuItemPrice" +
					" FROM customer" + 
					" INNER JOIN ((menuitem INNER JOIN orderdetails ON menuitem.menuItemID = orderdetails.menuitemID)" + 
					" INNER JOIN orders ON orderdetails.orderID = orders.orderID) ON customer.custID = orders.custID" +
					" WHERE orders.purchaseDate = '" +purchaseDate+ "' and customer.custID = "+custID+ ";";
		rs = dbc.execute(sql);
		try {
			while(rs.next()) {
				MenuItem mi = new MenuItem(rs.getString("menuItemName"), rs.getDouble("menuItemPrice"));
				itemList.add(mi);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return itemList;
	}
	
}