package mambo5.Entity;

import java.sql.ResultSet;
import java.util.ArrayList;

import mambo5.Controller.DBController;

public class Canteen {
	private int canteenID;
	private String canteenName;
	private String canteenDesc;
	private String canteenAddress;
	private DBController dbc;
	private ArrayList<Canteen> canteenList;
	private ResultSet rs;
	
	public Canteen(){}
	
	public Canteen(String canteenName, String canteenDesc, String canteenAddress) {
		this.canteenName = canteenName;
		this.canteenDesc = canteenDesc;
		this.canteenAddress = canteenAddress;
	}
	
	public Canteen(int canteenID, String canteenName, String canteenDesc, String canteenAddress) {
		this.canteenID = canteenID;
		this.canteenName = canteenName;
		this.canteenDesc = canteenDesc;
		this.canteenAddress = canteenAddress;
	}

	public String getCanteenName() {
		return canteenName;
	}
	
	public int createCanteen() {
		dbc = new DBController();
		int result = 0;
		
		String sql = "INSERT INTO canteen ( canteenName, canteenDesc, canteenAddress) "
					+ "VALUES ( '" + canteenName + "' , '" + canteenDesc + "' , '" +canteenAddress +"');";
		
		result = dbc.executeNonQuery(sql);
				
		return result;
	}
	
	public ArrayList<Canteen> retrieveCanteenList() {
		dbc = new DBController();
		Canteen c;
		canteenList = new ArrayList<Canteen>();
		
		String sql = "SELECT * FROM CANTEEN;";
		
		rs = dbc.executeQuery(sql);
		
		try{
			while(rs.next()) {
				c = new Canteen(rs.getInt("canteenID"),rs.getString("canteenName"),rs.getString("canteenDesc"), rs.getString("canteenAddress"));
				canteenList.add(c);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return canteenList;
	}

}
