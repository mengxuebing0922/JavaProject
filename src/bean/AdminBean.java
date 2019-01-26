package bean;

public class AdminBean {
	private int adminId;
	private String adminName;
	private String adminpassword;
	private String adminrealName;
	private String adminemail;
	public AdminBean(int adminId, String adminName, String adminpassword, String adminrealName, String adminemail) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminpassword = adminpassword;
		this.adminrealName = adminrealName;
		this.adminemail = adminemail;
	}

	public AdminBean() {
		super();
		// TODO Auto-generated constructor stub
	}
   
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	public String getAdminrealName() {
		return adminrealName;
	}
	public void setAdminrealName(String adminrealName) {
		this.adminrealName = adminrealName;
	}
	public String getAdminemail() {
		return adminemail;
	}
	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}
	
}
