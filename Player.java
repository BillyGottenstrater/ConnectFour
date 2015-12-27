public class Player
{
	private int wins;
	private String name;
	private int id;

	public Player(String name, int id){
		this.name = name;
		this.wins = 0;
		this.id = id;
	}

	public int getID(){
		return this.id;
	}

	public void setID(int id){
		this.id = id; 
	}

	public String getName(){
		return this.name;
	}


}