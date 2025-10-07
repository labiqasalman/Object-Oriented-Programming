package sp25_bcs_058;
class Seat{
	private double price;
	private String id;
	private boolean isAvailable;
	private SeatType type;


	Seat(String id, boolean isAvailable, SeatType type){
		
		this.id = id;
		setAvailable(isAvailable);
		setType(type);	
	}

	public String getId(){
		return id;
	}

	public SeatType getType(){
		return type;
	}

	public void setType(SeatType type){
		this.type = type;
	}

	public double getPrice(){
		return type.getPrice();
	}

	public void setAvailable(boolean isAvailable){
		this.isAvailable = isAvailable; 
	}

	public boolean getAvailable(){
		return isAvailable;
	}
	

	@Override
	public String toString(){
		return String.format("%s-%s-%.2f-%b",id,type,type.getPrice(),isAvailable);
	}

	public void bookSeat(){
		if(isAvailable == true ){
			isAvailable = false;
			System.out.println("Seat Booked Succesfully!");
		}
		else{
			System.out.print("Seat already occupied!");
		    }
		
	}

	public void cancelBooking(){
		if(isAvailable == false){
			isAvailable = true;
			System.out.println("Booking Cancelled SuccessFully!");
		}
	}

}