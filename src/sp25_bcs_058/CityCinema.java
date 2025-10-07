package sp25_bcs_058;
class CityCinema{
	private String name;
	Cinema cinema[];
	
	CityCinema(String name){
		this.name = name;
		cinema = new Cinema[3];
		for(int i =0;i<cinema.length;i++){
			cinema[i] = new Cinema("Cinema: " +(i+1));
		}
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(name + "\n");
		for(int i =0;i<cinema.length;i++){
			sb.append(cinema[i].toString());
		}
		return sb.toString();
	}
//Method to add cinema
	public void addCinema(int a){
		if(a<0){
			System.out.println("Invalid input!");
		}
		Cinema newCinema[];
		newCinema = new Cinema[cinema.length+a];
		for(int i =0;i<cinema.length;i++){
			newCinema[i]=cinema[i];
		}
		for(int i = cinema.length;i<newCinema.length;i++){
			newCinema[i] = new Cinema("Cinema: "+(i+1));
		}
		cinema=newCinema;
		System.out.print(a + " cinemas added!");
	}
//Method to remove cinema
	public void removeCinema(int a){
		if(a<0 || a>cinema.length){
			System.out.println("Invalid input!");
		}
		Cinema newCinema[];
		newCinema = new Cinema[cinema.length-a];
		for(int i =0;i<cinema.length-a;i++){
			newCinema[i] = cinema[i];
		}
		cinema = newCinema;
		System.out.println(a + " cinemas removed!");
	}
//Method to find a cinema by name
	public Cinema findCinema(String name){
		for(int i =0;i<cinema.length;i++){
			if(cinema[i].getName().equals(name)){
				System.out.println("Cinema found!");
				return cinema[i];
			}
		}
		return null;
	}
//Method to book a cinema
	public Cinema bookCinema(int a){
		for(int i=0;i<cinema.length;i++){
			if(i==a){
				System.out.println("Cinema found for booking!");
				return cinema[i];
			}
		}
		System.out.println("Cinema not found");
		return null;
	}
///Method to cancel booking
	public Cinema cancelCinema(int a){
		for(int i=0;i<cinema.length;i++){
			if(i==a){
				System.out.println("Cinema found for booking cancellation");
				return cinema[i];
			}
		
		}
		System.out.println("Cinema not found");
		return null;
	}
//Method for compact layout
	public String compactLayout(){
		StringBuilder sb = new StringBuilder();
		sb.append("===City: " + name+" | All Cinema Layouts===" +"\n");
		for(int i =0;i<cinema.length;i++){
			sb.append(cinema[i].compactLayout()+"\n");
		}
		return sb.toString();
	}
//Method for total seats
	public void totalSeat(){
		int totalSeat = 0;
		int A_seat = 0;
		int O_seat = 0;
		for(int i =0;i<cinema.length;i++){
			totalSeat = totalSeat + cinema[i].returntotalSeat();
			A_seat = A_seat + cinema[i].totalA_seat();
			O_seat = O_seat + cinema[i].totalO_seat();
		}
		System.out.println("Total seats: " + totalSeat);
		System.out.println("Total Available seats: " + A_seat);
		System.out.println("Total Occupied seats: " + O_seat);
	}
//Method to find first available vip seat
	public void searchVip(){
		for(int i =0;i<cinema.length;i++){
			Screen screen[] = cinema[i].getScreen();
			for(int j =0;j<screen.length;j++){
			Seat seat[][] = screen[j].getSeat();
				for(int k =0;k<seat.length;k++){
					for(int l =0;l<seat[k].length;l++){
						if(seat[k][l].getType()==SeatType.VIP){
							System.out.println("Cinema "+i+">Screen"+j+">Seat"+seat[k][l].toString());
							return;
						}
					}
				}
			}
		}
	System.out.println("Not found!");
	}
	
}