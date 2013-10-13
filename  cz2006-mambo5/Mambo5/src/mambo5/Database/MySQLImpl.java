package mambo5.Database;

import java.sql.ResultSet;
import java.util.ArrayList;

import mambo5.Controller.DBController;
import mambo5.Entity.Canteen;

//Concrete data store object for data access in MySQL database

public class MySQLImpl implements DataStoreInterface {
	//methods
	private ArrayList<Canteen> canteenList;
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

	@Override
	public int updateCanteenDetail(int canteenID, String canteenName, String canteenDesc, String canteenAddress) {
		dbc = new DBController();
		int result = 0;
		
		String sql = "UPDATE canteen "
					+ "SET canteenName = '" + canteenName + "' , canteenDesc = '" + canteenDesc + "' , canteenAddress = '" +canteenAddress +"' "
					+ "WHERE canteenID = " + canteenID + ";";
		
		result = dbc.executeNonQuery(sql);
				
		return result;
	}
	
}