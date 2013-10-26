package mambo5.Entity;

public class Faculty extends Customer{
	private String facultyID;
	
	public Faculty(String facultyID)  {
		this.facultyID = facultyID;
	}

	public String getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(String facultyID) {
		this.facultyID = facultyID;
	}
	
}
