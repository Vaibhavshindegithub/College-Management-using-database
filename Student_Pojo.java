package Student_Data;

public class Student_Pojo {
	private int id;
	private String name;
	private String branch;
	private String address;
	private String birthDate;
	private int adharNo;
	public int getId() {
		return id;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public int getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(int adharNo) {
		this.adharNo = adharNo;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student_Pojo [id=" + id + ", name=" + name + ", branch=" + branch + ", address=" + address
				+ ", birthDate=" + birthDate + ", adharNo=" + adharNo + "]";
	}
	
	

}
