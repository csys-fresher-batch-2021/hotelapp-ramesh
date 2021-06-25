package in.ramesh.model;

public class BillCalculatorModel {

	public BillCalculatorModel() {
		super();

	}

	private String hotelName;
	private String contactNo;
	private String cityName;
	private String district;
	private String rooms;
	private String hotelId;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	@Override
	public String toString() {
		return "BillCalculatorModel [hotelName=" + hotelName + ", contactNo=" + contactNo + ", cityName=" + cityName
				+ ", district=" + district + ", rooms=" + rooms + ", hotelId=" + hotelId + "]";
	}

	public BillCalculatorModel(String hotelName, String contactNo, String cityName,
			String district, String roms, String hotelId) {
		super();
		this.hotelName = hotelName;
		this.contactNo = contactNo;
		this.cityName = cityName;
		this.district = district;
		this.rooms = roms;
		this.hotelId = hotelId;
	}
}
