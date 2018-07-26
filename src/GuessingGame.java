import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GuessingGame extends JFrame
{
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	
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
		txtGuess.setBounds(266, 92, 46, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.setBounds(172, 147, 89, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 208, 414, 14);
		getContentPane().add(lblOutput);
	}
	
	public void checkGuess()
	{
		String guessText = txtGuess.getText();
		String message = "";
		
		int guess = Integer.parseInt(guessText);
		
		if (guess < theNumber)
			message = guess + " is too low. Try again";
		else if (guess > theNumber)
			message = guess + " is too high. Try again.";
		else
			message = guess + " is correct. You win!";
		
		lblOutput.setText(message);
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
}
