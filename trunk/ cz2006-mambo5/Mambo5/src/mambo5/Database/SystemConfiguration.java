package mambo5.Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SystemConfiguration {
	
	private String dbpassword;
	private String access;
	private String dbuser;
	private String database;
	
	public SystemConfiguration() {
		setup();
	}
	
	public String getAccess() {
		return access;
	}
	
	public String getDbpassword() {
		return dbpassword;
	}

	public String getDbuser() {
		return dbuser;
	}

	public String getDatabase() {
		return database;
	}

	public void setup() {
    	Properties prop = new Properties();

		FileInputStream stream = null;
    	try {
            //load a properties file
    		stream = new FileInputStream("config.properties");
    		prop.load(stream);
 
            //get the property value and print it out
            this.database = (prop.getProperty("database"));
    		this.dbuser= (prop.getProperty("dbuser"));
    		this.dbpassword = (prop.getProperty("dbpassword"));
    		this.access = (prop.getProperty("access"));
    		
            System.out.println(prop.getProperty("database"));
            System.out.println(prop.getProperty("dbuser"));
            System.out.println(prop.getProperty("dbpassword"));
            System.out.println(prop.getProperty("access"));
			

 
    	}catch (IOException ex) {
    		ex.printStackTrace();
        }finally {
    	    if (null != stream) {
    	        try {
    	            stream.close();
    	        }
    	        catch (Exception e) {
    	            e.printStackTrace();
    	        }
    	    }
        }    	
	}
	
	public static void main(String[] args) {
		SystemConfiguration sc = new SystemConfiguration();
		//sc.setup();
	}
	
}
