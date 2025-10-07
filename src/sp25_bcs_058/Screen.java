package sp25_bcs_058;
class Screen{
	private Seat seat[][];
	private String name;

	Screen(String name){
		this.name = name;
		seat = new Seat[5][];
		for(int i =0;i<seat.length;i++){
		seat[i] = new Seat[10+i];
			for(int j =0; j<seat[i].length;j++){
				if(i==0){
				seat[i][j]= new Seat(String.format("%d-%03d",i,j),true,SeatType.REGULAR);
				}
				else if(i>=1 && i<=2){
				seat[i][j] = new Seat(String.format("%d-%03d",i,j),true,SeatType.PREMIUM);
				}
				else if(i==3){
				seat[i][j] = new Seat(String.format("%d-%03d",i,j),true,SeatType.VIP);
				}
				else if(i==4){
				seat[i][j] = new Seat(String.format("%d-%03d",i,j),true,SeatType.RECLINER);
				}
				else{};
			}
		}
	}

//getter for name
	public String getName(){
		return name;
	}
//getter for seat
	public Seat[][] getSeat(){
		return seat;
	}


	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append(name);
		sb.append("\n");
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				sb.append(seat[i][j].toString()+"\n");
			}
		//sb.append("\n");
		}
		return sb.toString();
		}

	public String compactLayout(){
		int totalCounter = 0;
		int A_counter = 0;
		int O_counter = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("=== "+name+ " | " +"Layouts ===");
		sb.append("\n");
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				if(seat[i][j].getAvailable() == true){
					sb.append("["+seat[i][j].getId()+": A]" + "  ");
					totalCounter++;
					A_counter++;
				}
				else{
					sb.append("["+seat[i][j].getId()+": O]"+"  ");
					totalCounter++;
					O_counter++;
				}
			}
			sb.append("\n");
		}
	
		        sb.append("Total: " + totalCounter +"\n");
			sb.append("Available: " + A_counter + " | " + "Occupied: " + O_counter);
			sb.append("\n");

		return sb.toString();
	}
//Getters for total seats
	public int getTotalSeat(){
		int totalSeat = 0;
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				totalSeat++;
			}
		}
		return totalSeat;
	}

	public int getTotal_Aseat(){
		int total_Aseat = 0;
		for(int i =0;i<seat.length;i++){
			for(int j = 0;j<seat[i].length;j++){
				if(seat[i][j].getAvailable() == true){
					total_Aseat++;
				}
			}
		}
		return total_Aseat;
	}
	public int getTotal_Oseat(){
		int total_Oseat = 0;
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				if(seat[i][j].getAvailable() == false){
					total_Oseat++;
				}
			}
		}
		return total_Oseat;
	}
//Method to book seat
	public void bookSeat(int r, int c){
		if(seat[r][c].getAvailable()==true){
			seat[r][c].setAvailable(false);
			System.out.println("Seat booked successfully!");
		}
		else{
		        System.out.println("Seat already booked!");
		}
	}
//Method to cancel booking
	public void cancelSeat(int r, int c){
		if(seat[r][c].getAvailable()==false){
			seat[r][c].setAvailable(true);
			System.out.println("Seat cancelled successfully!");
		}
		else{
		        System.out.println("Seat already available!");
		}
	}
//Method to get screen name
	public String getScreenName(){
		return name;
	}

//Method for number of available and occupied seats
	public void getAO_count(){
		int A_counter = 0;
		int O_counter = 0;
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				if(seat[i][j].getAvailable()==true){
					A_counter++;				
				}
				else if(seat[i][j].getAvailable()==false){
					O_counter++;
				}
				else{};
			}
		}
		System.out.println("Available seats: " + A_counter);
		System.out.println("Occupied seats: " + O_counter);
	}

/*
//Method
	public void displayVerbose(int r, int c){
		System.out.println("=======INFO=======");
		System.out.println(seat[r][c].toString());
	}*/
	
//Method to locate a seat via ID
	public void locateById(String id){
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				if(seat[i][j].getId().equals(id)){
					System.out.print("Seat Found...");
					System.out.print(seat[i][j].toString());
					break;
				}
				
			}
		}
			
	}
//Method to count seats by type
	public void getSeatType_count(){
		int regularCounter = 0;
		int premiumCounter = 0;
		int vipCounter = 0;
		int reclinerCounter = 0;
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				if(seat[i][j].getType()==SeatType.REGULAR){
					regularCounter++;				
				}
			else if(seat[i][j].getType()==SeatType.PREMIUM){
					premiumCounter++;
				}
			else if(seat[i][j].getType()==SeatType.VIP){
					vipCounter++;
				}
			else if(seat[i][j].getType()==SeatType.RECLINER){
					reclinerCounter++;
				}
			}
		}

		System.out.println("Regular seats: " + regularCounter);
		System.out.println("Premium seats: " + premiumCounter);
		System.out.println("VIP seats: " + vipCounter);
		System.out.println("Recliner seats: " + reclinerCounter);	
	}

//Method to return Regular seats
	public Seat[] regularSeat(){
		int regularCounter =0;
		int index = 0;
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				if(seat[i][j].getType()==SeatType.REGULAR){
					regularCounter++;				
				}
			}
		}
		Seat regularSeat[];
		regularSeat = new Seat[regularCounter];
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				if(seat[i][j].getType()==SeatType.REGULAR){
					regularSeat[index++]= seat[i][j];
				}
			}
		}
		return regularSeat;
	}
//Method to return Premium Seats
	public Seat[] premiumSeat(){
		int premiumCounter = 0;
		int index = 0;
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				if(seat[i][j].getType()==SeatType.PREMIUM){
					premiumCounter++;				
				}
			}
		}
		Seat premiumSeat[];
		premiumSeat = new Seat[premiumCounter];
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				if(seat[i][j].getType()==SeatType.PREMIUM){
					premiumSeat[index++]= seat[i][j];
				}
			}
		}
		return premiumSeat;
	}
//Method to return VIP seats
	public Seat[] vipSeat(){
		int vipCounter =0;
		int index =0;
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				if(seat[i][j].getType()==SeatType.VIP){
					vipCounter++;				
				}
			}
		}
		Seat vipSeat[];
		vipSeat = new Seat[vipCounter];
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				if(seat[i][j].getType()==SeatType.VIP){
					vipSeat[index++]= seat[i][j];
				}
			}
		}
		return vipSeat;
	}
//Method to return Recliner seats
	public Seat[] reclinerSeat(){
		int reclinerCounter = 0;
		int index = 0;
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				if(seat[i][j].getType()==SeatType.RECLINER){
					reclinerCounter++;				
				}
			}
		}
		Seat reclinerSeat[];
		reclinerSeat = new Seat[reclinerCounter];
		for(int i =0;i<seat.length;i++){
			for(int j =0;j<seat[i].length;j++){
				if(seat[i][j].getType()==SeatType.RECLINER){
					reclinerSeat[index++]= seat[i][j];
				}
			}
		}
		return reclinerSeat;
	}


		
}