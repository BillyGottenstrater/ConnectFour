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
	public Integer mostRecentRow;


	public CFour(String player0Name,String player1Name){
		this.player0 = new Player(player0Name,0);
		this.player1 = new Player(player1Name,1);
		currentPlayer = player0;
		this.board = new Integer[NUM_ROWS][NUM_COLS]; // 6 rows, 7 columns
		this.turn = 1;
		this.mostRecentColumn = null;
		this.mostRecentRow = null;
	}
	/* Should it simply tell the win
	*/
	public int checkWin(){
		int count;
		int topCount;
		int color = currentPlayer.getID();
		int x = mostRecentColumn;
		int y = mostRecentRow;
		int leftBound;
		int rightBound;
		int upBound;
		int downBound;
		if(x - 4 < 0){
			leftBound = 0;
		}else{
			leftBound = x-4;
		}
		if(x + 4 >= NUM_COLS){
			rightBound = NUM_COLS - 1;
		}else{
			rightBound = x+4;
		}
		if(y - 4 < 0){
			downBound = 0;
		}else{
			downBound = y-4;
		}
		if(y + 4 >= NUM_COLS){
			upBound = NUM_COLS - 1;
		}else{
			upBound = y+4;
		}
		
		//check the row where the most recent piece is
		count = 0;
		topCount = 0;
		for(int i = leftBound;i<=rightBound;i++){
			if(board[y][i] == color){
				count++;
			}else{
				count = 0;
			}
			if(count > topCount){
				topCount = count;
			}
		}
		if(topCount >= 4){
			return color;
		}

		//check the column where the most recent piece is
		count = 0;
		topCount = 0;
		for(int i = downBound;i<=upBound;i++){
			if(board[i][x] == color){
				count++;
			}else{
				count = 0;
			}
			if(count > topCount){
				topCount = count;
			}
		}
		if(topCount >= 4){
			return color;
		}

		//Diagonal going down, left-right

		count = 0;
		topCount = 0;
		for(int i = upBound, j = leftBound ;i>=downBound && j<=rightBound;i--,j++){
			if(board[j][i] == color){
				count++;
			}else{
				count = 0;
			}
			if(count > topCount){
				topCount = count;
			}
		}
		if(topCount >= 4){
			return color;
		}

		//Diagonal going down, left-right

		count = 0;
		topCount = 0;
		for(int i = downBound, j = leftBound ;i<=upBound && j<=rightBound;i++,j++){
			if(board[j][i] == color){
				count++;
			}else{
				count = 0;
			}
			if(count > topCount){
				topCount = count;
			}
		}
		if(topCount >= 4){
			return color;
		}

		return -1;


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
					this.mostRecentRow = i;
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