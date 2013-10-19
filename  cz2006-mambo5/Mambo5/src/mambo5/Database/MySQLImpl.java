package mambo5.Database;

import java.sql.ResultSet;
import java.util.ArrayList;

import mambo5.Controller.DBController;
import mambo5.Entity.Canteen;
import mambo5.Entity.Stall;

//Concrete data store object for data access in MySQL database

public class MySQLImpl implements DataStoreInterface {
	//methods
	private ArrayList<Canteen> canteenList;
	private ArrayList<Stall> stallList;
	private ResultSet rs;
	
	//setup Connections
	SystemConfiguration sc;
	DBController dbc;
	
	public MySQLImpl(SystemConfiguration sysConfig) {
		this.sc = sysConfig;
		dbc = new DBController(sc.getDatabase(), sc.getDbuser(), sc.getDbpassword());
	}
	
	//-----------------------------------------Canteen-------------------------------------------
	@Override
	public ArrayList<Canteen> retrieveCanteenList() {
		Canteen c;
		canteenList = new ArrayList<Canteen>();
		
		String sql = "SELECT * FROM CANTEEN;";
		rs = dbc.executeQuery(sql);
		
		try{
			while(rs.next()) {
				c = new Canteen(rs.getInt("canteenID"),rs.getString("canteenName"),rs.getString("canteenDesc"), rs.getString("canteenAddress"), rs.getInt("maxStall"));
				canteenList.add(c);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return canteenList;
	}

	@Override
	public int updateCanteenDetail(int canteenID, String canteenName, String canteenDesc, String canteenAddress) {
		int result = 0;
		
		String sql = "UPDATE canteen "
					+ "SET canteenName = '" + canteenName + "' , canteenDesc = '" + canteenDesc + "' , canteenAddress = '" +canteenAddress +"' "
					+ "WHERE canteenID = " + canteenID + ";";
		
		result = dbc.executeNonQuery(sql);
				
		return result;
	}

	@Override
	public int deleteCanteen(int canteenID) {
		int result = 0;
		
		String sql = "DELETE FROM canteen "
					+ "WHERE canteenID = " + canteenID + ";";
	
		result = dbc.executeNonQuery(sql);
		
		return result;
	}

	@Override
	public ArrayList<Stall> retrieveStallList(int canteenID) {
		Stall s;
		stallList = new ArrayList<Stall>();
		boolean status = false; 
		String sql = "SELECT * FROM Stall WHERE canteenID = " + canteenID + " and stallStatus = 'T';";
		rs = dbc.executeQuery(sql);
		
		try{
			while(rs.next()) {
				if(rs.getString("stallStatus").equals("T")) 
					status = true;
				else
					status = false;
				s = new Stall(rs.getInt("stallID"), rs.getInt("canteenID"), rs.getString("stallUnit"),rs.getString("stallName"), rs.getString("stallDesc"),status);
				stallList.add(s);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return stallList;
	}

	//-------------------------------------------STALL----------------------------------------------------------------
	@Override
	public int createStall(int canteenID, String stallUnit, String stallName, String stallDesc, String stallStatus) {
		int result = 0;
		
		String sql = "INSERT INTO stall ( canteenID, stallUnit, stallName, stallDesc, stallStatus) "
					+ "VALUES ( '" + canteenID + "' , '" + stallUnit + "' , '" + stallName + "' , '" + stallDesc +"' , '" + stallStatus + "');";
		
		result = dbc.executeNonQuery(sql);
		return result;
	}
	
}