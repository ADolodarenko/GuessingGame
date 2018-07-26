import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame
{
	private static final int TRYING_LIMIT = 7;
	
	private JTextField txtGuess;
	private JLabel lblOutput;
	private JButton btnPlayAgain;
	private int theNumber;
	private int tries;

	public static void main(String[] args)
	{
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 300));
		theGame.setVisible(true);
	}

	public GuessingGame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Alex's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Alex's Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 38, 414, 19);
		getContentPane().add(lblNewLabel);

		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuessANumber.setBounds(10, 95, 246, 14);
		getContentPane().add(lblGuessANumber);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				checkGuess();
			}
		});
		txtGuess.setBounds(266, 92, 46, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				checkGuess();
			}
		});
		btnGuess.setBounds(172, 147, 89, 23);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 208, 414, 14);
		getContentPane().add(lblOutput);
		
		btnPlayAgain = new JButton("Play again");
		btnPlayAgain.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				newGame();
			}
		});
		btnPlayAgain.setBounds(167, 234, 117, 25);
		getContentPane().add(btnPlayAgain);
	}

	public void checkGuess()
	{
		String guessText = txtGuess.getText();
		String message = "";

		try
		{
			int guess = Integer.parseInt(guessText);

			tries--;
			
			if (guess == theNumber)
			{
				message = guess + " is correct. You win after " + (TRYING_LIMIT - tries) + " tries! Let's play again!";

				btnPlayAgain.setVisible(true);
			}
			else
			{
				if (guess < theNumber)
					message = guess + " is too low.";
				else
					message = guess + " is too high.";
				
				if (tries > 0)
					message = message + " Try again.";
				else
				{
					message = message + " You lost. The number was " + theNumber + ". Let's play again!";
					
					btnPlayAgain.setVisible(true);
				}
			}
		}
		catch (Exception e)
		{
			message = "Enter a whole number between 1 and 100.";
		}
		finally
		{
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}

	public void newGame()
	{
		btnPlayAgain.setVisible(false);
		
		theNumber = (int)(Math.random() * 100 + 1);
		tries = TRYING_LIMIT;
	}
}
