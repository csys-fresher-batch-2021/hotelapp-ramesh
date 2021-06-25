package in.ramesh.model;

public class HotelModel {
	private String newHotel;

	public HotelModel(String newHotel) {
		super();
		this.newHotel = newHotel;

	}

	public String getNewHotel() {
		return newHotel;
	}

	public void setNewHotel(String newHotel) {
		this.newHotel = newHotel;
	}

	@Override
	public String toString() {
		return "HotelModel [newHotel=" + newHotel + "]";
	}

}
