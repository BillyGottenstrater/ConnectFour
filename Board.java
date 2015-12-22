import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;

public class Board
{
	private GridLayout layout;
	public Board(int num_cols, int num_rows, JPanel boardPanel){
		this.layout = new GridLayout(num_cols, num_rows);
		layout.setHgap(0);
		layout.setVgap(0);
		boardPanel.setLayout(layout);
	}

}