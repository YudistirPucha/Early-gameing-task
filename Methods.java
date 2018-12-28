import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Methods

{	
	public static int CurrentPlayer = 1;
	public static boolean won = false;
	public static void XWin(boolean W)
	{
		//If the boolean won is true a confirm dialog box will appear asking the user if they want to play again. If yes is chosen the Restart method is called and run.
		//Else the program closes.
		won = true;
		if(JOptionPane.showConfirmDialog(null,"Player X has won. Would you like to play again?" )==JOptionPane.YES_OPTION)
		{
			Restart();
		}
		else 
			if (JOptionPane.showConfirmDialog(null,"Player X has won. Would you like to play again?" )==JOptionPane.NO_OPTION)
			System.exit(0);
	}
	public static void OWin(boolean W)
	{
		//If the boolean won is true a confirm dialog box wil appear asking the user if they want to play again. If yes is chosen the Restart method is called and run.
		//Else the program closes.
		won = true;
		if(JOptionPane.showConfirmDialog(null," You win. Would you like to play again?" )==JOptionPane.YES_OPTION)
		{
			Restart();
		}
		else 
			
			System.exit(0);
	}
	public static void Restart()
	{
		//at this point the boolean won has been set to false.
		won = false;
		int i = 0;
		//if the confirm dialog box = yes the GUI class will be called and run.
		if (i == JOptionPane.YES_OPTION)
		{
			//If the restart method has been chosen a new GUI will appear. 
			TicTacToe.main(null);
		}
	}
	public static void Draw()
	{
		//Won boolean has been set to false.
		//Confirm dialog appears if yes is chosen then the restart method is called.
		//If no or cancel is chosen then the program will exit.
		won = false;
		if(JOptionPane.showConfirmDialog(new JFrame("It's a draw!"),"It's a draw! Would you like to play again?" )==JOptionPane.YES_OPTION)
		{
			Restart();
		}
		else 
			System.exit(0);
	}
	public static void PlayerChange()
	{
		//For example if the current player is CPU, then the program will change the player to the user.
		if (CurrentPlayer == 1)
		{
			CurrentPlayer = 2;
			
		}
		
		//else if the current player = 2 then the program will change the player to 1.
		else
		{
			CurrentPlayer = 1;
		}

	}	
	
	
}

