package vaccine.domain;

/**
 * User object
 * 
 * @author Sharat Naik
 * 
 */
public class Vaccine {
	/*
	 * Correspond to the user table
	 */
	
	private String vaccine_name; 
	private Integer doses;
	private String type;
	

	
	public String getVaccinename() {
		return vaccine_name;
	}

	public void setVaccinename(String vaccine_name) {
		this.vaccine_name = vaccine_name;
	}

	public Integer getDoses() {
		return doses;
	}

	public void setDoses(Integer dose) {
		this.doses = dose;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	@Override
	public String toString() {
		return "User [ vaccine name=" + vaccine_name + ", doses="
				+ doses + ", type=" + type +"]";
	}
}
