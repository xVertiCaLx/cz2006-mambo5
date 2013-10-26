package mambo5.Entity;

public class Student extends Customer{
	private String matriculationNo;
	
	public Student(String matriculationNo) {
		this.matriculationNo = matriculationNo;
	}

	public String getMatriculationNo() {
		return matriculationNo;
	}

	public void setMatriculationNo(String matriculationNo) {
		this.matriculationNo = matriculationNo;
	}
	
}
