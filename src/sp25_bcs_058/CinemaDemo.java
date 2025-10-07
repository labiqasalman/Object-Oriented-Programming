package sp25_bcs_058;
public class CinemaDemo{
	public static void main(String[] args){
		CityCinema c1 = new CityCinema("Lahore");
		CityCinema c2 = new CityCinema("Karachi");
		CityCinema c3 = new CityCinema("Islamabad");

		System.out.println(c1.compactLayout());
		System.out.println(c2.compactLayout());
		System.out.println(c3.compactLayout());

		c1.bookCinema(2).bookScreen(2).bookSeat(2,2);
		System.out.println(c1.compactLayout());

		c1.bookCinema(2).bookScreen(2).bookSeat(2,2);
		c1.cancelCinema(2).cancelScreen(2).cancelSeat(2,2);
		System.out.println(c1.compactLayout());

		c1.totalSeat();

		c1.addCinema(1);
		System.out.println(c1.compactLayout());

		c1.removeCinema(1);
		System.out.println(c1.compactLayout());
	
		System.out.println(c1.findCinema("Cinema: 2"));
		
		/*Seat regularSeat[] = s1.regularSeat();
		for(int i=0; i<regularSeat.length ;i++){
			System.out.println(regularSeat[i]);
		}
		Seat premiumSeat[] = s1.premiumSeat();
		for(int i=0; i<premiumSeat.length ;i++){
			System.out.println(premiumSeat[i]);
		}*/
		
	
	}
}