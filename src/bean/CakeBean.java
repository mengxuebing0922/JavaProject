package bean;

public class CakeBean {
	private int cakeId;
	private String cakeName;
	private String cakeSize;
	private double cakePrice;
	private String cakeImageUrl;
	private int cakeTypeId;
	public CakeBean(int cakeId, String cakeName, String cakeSize, double cakePrice, String cakeImageUrl,
			int cakeTypeId) {
		super();
		this.cakeId = cakeId;
		this.cakeName = cakeName;
		this.cakeSize = cakeSize;
		this.cakePrice = cakePrice;
		this.cakeImageUrl = cakeImageUrl;
		this.cakeTypeId =cakeTypeId;
	}

	public int getCakeId() {
		return cakeId;
	}
	public void setCakeId(int cakeId) {
		this.cakeId = cakeId;
	}
	public String getCakeName() {
		return cakeName;
	}
	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}
	public String getCakeSize() {
		return cakeSize;
	}
	public void setCakeSize(String cakesize) {
		this.cakeSize = cakesize;
	}
	public double getCakePrice() {
		return cakePrice;
	}
	public void setCakePrice(double cakePrice) {
		this.cakePrice = cakePrice;
	}
	public String getCakeImageUrl() {
		return cakeImageUrl;
	}
	public void setCakeImageUrl(String cakeImageUrl) {
		this.cakeImageUrl = cakeImageUrl;
	}
	public int getCakeTypeId() {
		return cakeTypeId;
	}

	public void setCakeTypeId(int cakeTypeId) {
		this.cakeTypeId = cakeTypeId;
	}
	
     
}
