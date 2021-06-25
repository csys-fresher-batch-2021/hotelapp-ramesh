package in.ramesh.model;

public class PaymentModel {

	private String hotelName;
	private String amount;
	private String status;
	private String username;
	private int paymentId;
	

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	@Override
	public String toString() {
		return "PaymentModel [hotelName=" + hotelName + ", amount=" + amount + ", status=" + status + ", username="
				+ username + ", paymentId=" + paymentId + "]";
	}
	
	public PaymentModel(String hotelName, String amount, String status, String username, int paymentId) {
		super();
		this.hotelName = hotelName;
		this.amount = amount;
		this.status = status;
		this.username = username;
		this.paymentId = paymentId;
	}
	
	public PaymentModel() {
		// default constructor
	}


}