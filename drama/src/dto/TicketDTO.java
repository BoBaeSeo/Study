package dto;

import java.util.Date;

public class TicketDTO {
private int tnum;
private String tmcode;
private String tdcode;
private Date buydate;
private int tcode;
public Date getBuydate() {
	return buydate;
}
public void setBuydate(Date buydate) {
	this.buydate = buydate;
}
public int getTcode() {
	return tcode;
}
public void setTcode(int tcode) {
	this.tcode = tcode;
}
public int getTnum() {
	return tnum;
}
public void setTnum(int tnum) {
	this.tnum = tnum;
}
public String getTmcode() {
	return tmcode;
}
public void setTmcode(String tmcode) {
	this.tmcode = tmcode;
}
public String getTdcode() {
	return tdcode;
}
public void setTdcode(String tdcode) {
	this.tdcode = tdcode;
}
}
