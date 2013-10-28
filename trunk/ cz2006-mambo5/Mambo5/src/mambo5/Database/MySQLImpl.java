package mambo5.Database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import mambo5.Controller.DBController;
import mambo5.Entity.Admin;
import mambo5.Entity.Canteen;
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
	// private ArrayList<Order> orderList; // guohao
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

	//delete!!
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
	
	
	//int orderID, int custID, Date purchaseDate, String orderStatus, int stallID
	public ArrayList<Order> retrieveOrderList(ArrayList<Order> orderList) {
		try {
			String sql = "SELECT * FROM mambojumbo.orderdetails;";
			rs = dbc.execute(sql);

			while (rs.next()) {
				System.out.println("add once");
				orderList.add(new Order(rs.getInt("orderID"), rs
						.getInt("custID"), rs.getDate("purchaseDate"),rs.getString("orderStatus"),rs.getInt("stallID")));
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
			String sql = "SELECT * FROM mambojumbo.orderdetails;";
			rs = dbc.execute(sql);

			while (rs.next()) {
				System.out.println("add once");
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



	/*
	 * public ArrayList<OrderDetail>
	 * retrieveOrderDetailList(ArrayList<OrderDetail> orderDetailList, int
	 * orderID) { try { String sql =
	 * "SELECT od.orderID, od.actualPrice, mi.menuItemName, mi.discount " +
	 * "FROM mambojumbo.orderdetails od INNER JOIN mambojumbo.menuitem mi " +
	 * "ON mi.menuItemID = od.menuItemID WHERE orderID = " + orderID +";"; rs =
	 * dbc.execute(sql);
	 * 
	 * while(rs.next()) orderDetailList.add(new
	 * OrderDetail(rs.getInt("orderID"), rs.getDouble("actualPrice"),
	 * rs.getString("menuItemName"), rs.getDouble("discount"))); } catch
	 * (Exception e) { e.printStackTrace(); } finally { dbc.terminate(); }
	 * return orderDetailList; }
	 */

}