package phoneBook;

public class PhoneInfo {

	String name;
	String phoneNum;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Override
	public String toString() {
		return "PhoneInfo [name=" + name + ", phoneNum=" + phoneNum + "]";
	}
	
}
