package sp25_bcs_058;
class Cinema{
	private String name;
	private Screen screen[];
	int sizeCounter = 0;
	//int totalseat =0;
	//int totalA_seat = 0;
	//int totalO_seat = 0;

	Cinema(String name){
		this.name = name;
		screen = new Screen[3];
		for(int i =0;i<screen.length;i++){
			screen[i] = new Screen("Screen: "+(i+1));
			sizeCounter++; 
		}
	}

	public void addScreen(int a){
		if(a<0){
		System.out.println("Invalid number!");	
		}
		Screen newScreen[];
		newScreen = new Screen[screen.length + a];
		for(int i =0;i<screen.length;i++){
			newScreen[i] = screen[i];
		}
		for(int i =screen.length;i<newScreen.length;i++){
			newScreen[i] = new Screen("Screen: "+(i+1));
		}
		screen = newScreen;
		
	}
//getter for screen
	public Screen[] getScreen(){
		return screen;
	}

//getter for name
	public String getName(){
		return name;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		for(int i =0;i<screen.length;i++){
		sb.append(screen[i].toString()+"\n");
		}
		return sb.toString();
	}
//Method for compact layout
	public String compactLayout(){
		StringBuilder sb = new StringBuilder();
		sb.append("===Cinema: "+name+" | Layouts==="+"\n");
		for(int i =0;i<screen.length;i++){
			sb.append(screen[i].compactLayout()+"\n");
		}
		return sb.toString();
		
	}
//Method to book a screen
	public Screen bookScreen(int s){
		for(int i =0;i<screen.length;i++){
			if(i==s){
				System.out.println("SCREEN FOUND!");
				return screen[i];	
			}
		}
		return null;
	}
//Method to cancel screen
	public Screen cancelScreen(int s){	
		for(int i=0;i<screen.length;i++){
			if(i==s){
				System.out.println("SCREEN FOUND!");
				return screen[i];
			}
		}
		return null;
	}
//Method to count total seats in one cinema
	public void totalSeat(){
		int totalseat =0;
		int totalA_seat = 0;
		int totalO_seat = 0;
		for(int i =0;i<screen.length;i++){
			totalseat = totalseat + screen[i].getTotalSeat();
			totalA_seat = totalA_seat + screen[i].getTotal_Aseat();
			totalO_seat = totalO_seat + screen[i].getTotal_Oseat();
			
		}
		System.out.println("Total Screens: " + screen.length);
		System.out.println("Total Seats: " + totalseat);
		System.out.println("Total Available Seats: " + totalA_seat);
		System.out.println("Total Occupied Seats: " + totalO_seat);
	}
//Method to return total available seats
	public int totalA_seat(){
		int totalA_seat = 0;
		for(int i =0;i<screen.length;i++){
			totalA_seat = totalA_seat + screen[i].getTotal_Aseat();
		}
		return totalA_seat;
	}

//Method to return total seats
	public int returntotalSeat(){
		int totalSeat = 0;
		for(int i =0;i<screen.length;i++){
			totalSeat = totalSeat + screen[i].getTotalSeat();
		}
		return totalSeat;
	}

//Method to return total Occupied seats
	public int totalO_seat(){
		int totalO_seat = 0;
		for(int i =0;i<screen.length;i++){
			totalO_seat = totalO_seat + screen[i].getTotal_Oseat();
		}
		return totalO_seat;
	}


//Method for single line description
	public String compactDescription(){
		int totalseat =0;
		int totalA_seat = 0;
		for(int i =0;i<screen.length;i++){
			totalseat = totalseat + screen[i].getTotalSeat();
			totalA_seat = totalA_seat + screen[i].getTotal_Aseat();
		}
		StringBuilder sb = new StringBuilder();
		sb.append(name +"\n");
		sb.append("Number of screens: " + screen.length + " | Total Seats: " + totalseat + " | Available seats: " +totalA_seat);
		return sb.toString();
	}
	
}