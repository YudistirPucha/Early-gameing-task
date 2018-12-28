//These are the imports that we will use for the game.

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.plaf.PanelUI;


public class TicTacToe extends JFrame implements ActionListener
{
	//what is needed for the game
	public static JButton[][] board  = new JButton[3][3];//  3 x 3 array 
	public boolean won = false;//cant win at start 
	public boolean possmove = false;//no possible moves at the start 
	public String back[][] = new String[3][3]; //this is the back end of the board
	int computerP = 0; //The Computer integer.
	int playerP = 0; //The Player integer.
	String computer = ""; //will be used to represent the computer
	String user = "";	// will be used to represent the user 
	

	
//constructor- allows me to create objects from TicTacToe class
	public TicTacToe(boolean computer)
	{
		//if true then the board frame will open.
		
		frame(computer);
	}

	//adding action listeners for the buttons 
	public void placeButtons() 
	{
		for (int i = 0; i < 3; i++)
		{
			for(int j = 0; j<3;j++)
			{
				board[i][j] = new JButton(".");//Creating the buttons that will be on the board

				board[i][j].addActionListener(this);//Adding an action listener so that java recognises when a square has been clicked on.

			}
		}
	}

	public void frame(boolean computer)
	{
		//Creating the Board using JFrame and JPanel
		JFrame Board = new JFrame();
		Board.setVisible(true); //Makes the board visible. 
		Board.setSize(600, 600);//the size of the frame 
		Board.setResizable(true);//Frame can be resized.
		JPanel Panel = new JPanel();//Creating the Panel. - this allows us to draw to the panel and hold all of the information that will be added to the frame.
		Board.setContentPane(Panel);//Holds the panel
		Panel.setLayout(new GridLayout(3,3,1,1));//GridLayout sets the board to dimension o 3,3 with spaces inbetween each box
		placeButtons();//calls method in order to show the buttons
		//Methods.CurrentPlayer = 1;
		Board.setTitle("Tic Tac Toe");
		
		// add the board to the panel
		for (int i = 0; i < 3; i++)
		{
			for(int j = 0; j<3;j++)
			{
				Panel.add(board[i][j],BorderLayout.NORTH);	
				back[i][j] = ".";//shows that the button is empty
			}		
		}

		if(computer == true)
		{
			//If computer starts then it will have the symbol "X" and the User will have the symbol "O".
			//The Computer will be Player 1 , and the User will be player 2.
			this.computer = "X";
			this.user = "O";
			computerP = 1;
			playerP = 2;
			ComputerStarts(); 
		}
		else 
		{
			//If the player starts they will have the symbol "X" and the user will have the symbol "O".
			//The User will be player 1 , and the Computer will be player 2.
			this.computer = "O";
			this.user = "X";
			playerP = 1;
			computerP = 2;
			//shows which player is which symbol
			JOptionPane.showMessageDialog(null, "Player = "+ user + "\n" +"Computer = O");

		}


	}

	public void ComputerStarts()
	{
		
		//This Message box shows which player is which.
		JOptionPane.showMessageDialog(null, "You = O" + "\n" + "Me = X");

		{
			boolean possmove = false;

			//While a valid turn has not been taken the program checks if a random place on the board is empty 
			while(possmove==false)
			{

				//This makes the computer start in a random place in the board.
				Random Start = new Random();
				int x = Start.nextInt(3);
				int y = Start.nextInt(3);

				for (int i = 0; i<3; i++)
				{
					for (int j = 0; j<3 ;j++)
					{
						//If the a random coordinate is empty then place a random symbol there, and the boolean valid turn will  be true.
						//Thus exiting the while loop.

						if (board [x][y].getText().equals("."))
						{	
							board[x][y].setText(this.computer);
							board[x][y].setEnabled(false);
							back[x][y] = computer; 
							possmove = true;
							//Once valid turn is true, this method changes the current player.
							Methods.PlayerChange();
						}
					}
				}
			}
		}
	}

	public void makingMoves(int i, int j)
	{				
		//If the current player is the user. 
		if(Methods.CurrentPlayer == playerP)
		{
			//when the player clicks the square (button) it will show the players symbol 
			board[i][j].setText(user);
			board[i][j].setEnabled(false);
			back[i][j] = user;
			//This method is called from the Methods. Class
			Methods.PlayerChange();
		}



	}

	public void RandomComputerMove()
	{
		
 
		boolean possmove = false;

		//This For loop checks if a position is empty. 
		//If a position is empty then the computer will make a move

		for (int i = 0; i<3; i++)
		{
			for (int j = 0; j<3 ;j++)
			{
				if (board[i][j].getText()=="." && !(board[i][j].getText()==computer) && !(board[i][j].getText() == user))
				{
					//While a valid computer  move has not been made the computer's AI will run. 
					while(possmove== false)
					{
						RandomMove();
						possmove = true;
						//If a valid turn has been made then the valid turn boolean is true then the while loop will exit.
					}
				}
			}
		}
	}

	public static void whoseWon()

	{
//check if X has won horizontally 

		if ((board[0][0].getText().equals("X") && board[0][1].getText().equals("X") && board[0][2].getText().equals("X")))
		{
			Methods.XWin(true);
		}

		if ((board[1][0].getText().equals("X") && board[1][1].getText().equals("X") && board[1][2].getText().equals("X")))
		{
			Methods.XWin(true);
		}

		if ((board[2][0].getText().equals("X") && board[2][1].getText().equals("X") && board[2][2].getText().equals("X")))
		{
			Methods.XWin(true);
		}

// check if X has won horizontally 

		if ((board[0][0].getText().equals("X") && board[1][0].getText().equals("X") && board[2][0].getText().equals("X")))
		{
			Methods.XWin(true);
		}

		if ((board[0][1].getText().equals("X") && board[1][1].getText().equals("X") && board[2][1].getText().equals("X")))
		{
			Methods.XWin(true);
		}

		if ((board[0][2].getText().equals("X") && board[1][2].getText().equals("X") && board[2][2].getText().equals("X")))
		{
			Methods.XWin(true);
		}

//check if X has won diagonally
		if ((board[0][0].getText().equals("X") && board[1][1].getText().equals("X") && board[2][2].getText().equals("X")))
		{
			Methods.XWin(true);
		}

		if ((board[0][2].getText().equals("X") && board[1][1].getText().equals("X") && board[2][0].getText().equals("X")))
		{
			Methods.XWin(true);
		}

// checks if O has won in all ways 
//		horizontal each row
		if ((board[0][0].getText().equals("O") && board[0][1].getText().equals("O") && board[0][2].getText().equals("O")))
		{
			Methods.OWin(true);
		}

		if ((board[1][0].getText().equals("O")&& board[1][1].getText().equals("O") && board[1][2].getText().equals("O"))) {
			Methods.OWin(true);
		}

		if ((board[2][0].getText().equals("O") && board[2][1].getText().equals("O") && board[2][2].getText().equals("O")))
		{
			Methods.OWin(true);
		}


//		check vertically if O has won 

		if ((board[0][0].getText().equals("O") && board[1][0].getText().equals("O") && board[2][0].getText().equals("O")))
		{
			Methods.OWin(true);
		}

		if ((board[0][1].getText().equals("O") && board[1][1].getText().equals("O") && board[2][1].getText().equals("O")))
		{
			Methods.OWin(true);
		}

		if ((board[0][2].getText().equals("O") && board[1][2].getText().equals("O") && board[2][2].getText().equals("O")))
		{
			Methods.OWin(true);
		}

//	check diagonally if O has won 
		

		if ((board[0][0].getText().equals("O") && board[1][1].getText().equals("O") && board[2][2].getText().equals("O")))
		{
			Methods.OWin(true);
		}

		if ((board[0][2].getText().equals("O") && board[1][1].getText().equals("O") && board[2][0].getText().equals("O")))
		{
			Methods.OWin(true);
		}

//		if no winnings were found then the draw Method will run
		else if (!board[0][0].isEnabled() && !board[0][1].isEnabled() && !board[0][2].isEnabled() && !board[1][0].isEnabled() && !board[1][1].isEnabled() && !board[1][2].isEnabled() && !board[2][0].isEnabled() && !board[2][1].isEnabled() && !board[2][2].isEnabled())
		{
			//Draw method called from the Methods class.
			Methods.Draw();

		}
	}

	public static void main(String args[])
	{
		
		int i=JOptionPane.showConfirmDialog(null," Would you like to start first?");
		if (i == JOptionPane.YES_OPTION)
		{	
			
			TicTacToe g = new TicTacToe(true);
			
		}
		
		else
			//exit the window then cancel is pressed 
			if (i == JOptionPane.CANCEL_OPTION)
			{
				System.exit(0);
			}
			
			else if(i == JOptionPane.NO_OPTION)
			{
				//Computer Starts first.
				
				TicTacToe g = new TicTacToe(true);
			}
		
		

	}


	public void actionPerformed(ActionEvent e) 
	{

		//Checks if the board is empty.
		for (int i = 0; i<3; i++)
		{
			for (int j = 0; j<3 ;j++)
			{
				//if the a button on the board has been pressed and it is empty then the makeMove method will be called and it will then check if a win combination is present.
				if(e.getSource()==board[i][j])
				{
					if(board[i][j].getText()==".")
					{
						makingMoves(i,j);
						whoseWon();
					}

				}

			}

		}

		//if the current player is a computer, then the CPU will take it's turn and check if there has been a win.
		if(Methods.CurrentPlayer == computerP)
		{
			RandomComputerMove();
			whoseWon();
			//If there is no win combination and it's not a draw  then the program will change player and a message will appear saying it is the players turn.
		
			JOptionPane.showMessageDialog(null, "Your Turn.");
			Methods.PlayerChange();
		}


	}

	public void RandomMove()

	{

		Random Start = new Random();
		int x = Start.nextInt(3);
		int y = Start.nextInt(3);
	
		//I have created and new random variable and two random integers within the limits of 0 and 2.

		/*if the random integers x and y are co-ordinates for an empty square then
		the square will set the text as the computers symbol and a valid turn would have been taken.*/
		if(board[x][y].getText()==".")
		{

			board[x][y].setText(computer);
			board[x][y].setEnabled(false);
			back[x][y] = computer;
			possmove = true;
		}

		
//if it is computers move, random generate co-ordinates until the co-ordinate is the right one to play by using the possmove method
		else if((board[x][y].getText().equals(computer)) || (board[x][y].getText().equals(user)))
		{
			//if the coordinates x, y == a computer or a player symbol then possmove = false
			possmove = false;

//			if poss move is false then create another set of co-ordinate
			//while possmove is false create other random integers to use as moves. repeat this until a valid turn has been made
			while (possmove == false)
			{
				Random move = new Random();
				int x1 = move.nextInt(3);
				int y1 = move.nextInt(3);

				Random move2 = new Random();
				int x2 = move2.nextInt(3);
				int y2 = move2.nextInt(3);

				Random move3 = new Random();
				int x3 = move3.nextInt(3);
				int y3 = move3.nextInt(3);

				if (board[x1][y1].getText().equals(computer) || board[x1][y1].getText() == user)
				{
					if(board[x2][y2].getText() == ".")
					{

						board[x2][y2].setText(computer);
						board[x2][y2].setEnabled(false);
						back[x2][y2] = computer;
						possmove = true;

					}
				}
				else if (board[x2][y2].getText().equals(computer) || board[x2][y2].getText().equals(user))
				{
					if(board[x3][y3].getText() == ".")
					{

						board[x3][y3].setText(computer);
						board[x3][y3].setEnabled(false);
						back[x3][y3] = computer;
						possmove = true;
					}
				}

			}

		}
	}
}







