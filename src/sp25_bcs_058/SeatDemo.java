package sp25_bcs_058;
public class SeatDemo{
	public static void main(String[] args){
		Seat s1 = new Seat("3",true,SeatType.PREMIUM);
		System.out.println(s1);
		s1.bookSeat();
		s1.cancelBooking();
		System.out.println(s1.getAvailable());
		System.out.println(s1.getPrice());
	}

}