package dto;

import java.sql.Date;

public class BoardDTO {
    private int bNumber;
    private String bWriter;
    private String bPassword;
    private String bTitle;
    private String bContents;
    private Date bDate;
    private int bHits;
    private String bFile;
	public String getbFile() {
		return bFile;
	}
	public void setbFile(String bFile) {
		this.bFile = bFile;
	}
	public int getbNumber() {
		return bNumber;
	}
	public void setbNumber(int bNumber) {
		this.bNumber = bNumber;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbPassword() {
		return bPassword;
	}
	public void setbPassword(String bPassword) {
		this.bPassword = bPassword;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContents() {
		return bContents;
	}
	public void setbContents(String bContents) {
		this.bContents = bContents;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public int getbHits() {
		return bHits;
	}
	public void setbHits(int bHits) {
		this.bHits = bHits;
	}
	
}
