public class CFour
{
	private static final int NUM_ROWS = 6;
	private static final int NUM_COLS = 7;
	private int turn;
	private Player player0;
	private Player player1;
	private Player currentPlayer;
	private Integer[][] board;
	public Integer mostRecentColumn;


	public CFour(String player0Name,String player1Name){
		this.player0 = new Player(player0Name,0);
		this.player1 = new Player(player1Name,1);
		currentPlayer = player0;
		this.board = new Integer[NUM_ROWS][NUM_COLS]; // 6 rows, 7 columns
		this.turn = 1;
		this.mostRecentColumn = null;
	}

	public void checkWin(int mostRecentColumn){
		
	}
	public boolean isFull(int column){
		boolean full = true;
		for(int i = 0;i<NUM_COLS;i++){
			if(board[i][column] != null){
				//Do Nothing
			}else{
				full = false;
				break;
			}
		}
		return full;
	}

	public int whatsInside(int row,int column){
		if(board[row][column]!=null){
			return board[row][column];
		}else{
			return -1;
		}
	}

	public void move(int column){
		if(!isFull(column)){
			for(int i = 0;i<NUM_COLS;i++){
				if(whatsInside(i,column) == -1){
					board[i][column] = currentPlayer.getID();
					break;
				}
			}
			this.mostRecentColumn = column;
		}else{
			System.out.println("The column is full");
		}
	}
}	
/*    
	   Row
    Col| | | | | | | |
	   ----------------
	   | | | | | | | |  
	   ----------------
	   | | | | | | | |
	   ----------------
	   | | | | | | | | 
	   ---------------- 
	   | | | | | | | |
	   ----------------
	   | | | | | | | |  	
*/	