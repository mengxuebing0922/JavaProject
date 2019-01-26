package bean;

public class CakeTypeBean {
	static CakeTypeBean cakeTypeId;
	private String cakeTypeName;
	public CakeTypeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static CakeTypeBean getCakeTypeId() {
		return cakeTypeId;
	}
	public static void setCakeTypeId(CakeTypeBean cakeTypeId) {
		CakeTypeBean.cakeTypeId = cakeTypeId;
	}
	public String getCakeTypeName() {
		return cakeTypeName;
	}
	public void setCakeTypeName(String cakeTypeName) {
		this.cakeTypeName = cakeTypeName;
	}
	
	
}
