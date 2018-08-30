
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class App extends JFrame {
	
	public App() {
		init();
	}
	private void init() {
		this.setSize(400, 220);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		run();

		
	}
		
		private void run() {
			JLabel title = new JLabel("File Remover");
			title.setFont(new Font("Times New Roman", Font.ITALIC, 20));
			title.setBounds(124, 0, 266, 21);
			this.getContentPane().add(title);
			
			JTextField filePath = new JTextField();
			filePath.setBounds(150, 53, 220, 30);
			filePath.setFont(new Font("Times New Roman", Font.PLAIN, 21));
			this.getContentPane().add(filePath);
			

			JLabel header = new JLabel("Path:");
			header.setFont(new Font("Times New Roman", Font.PLAIN, 30));
			header.setBounds(77, 53, 66, 30);
			this.getContentPane().add(header);
			
			
			JButton button = new JButton("Submit");
			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String input = filePath.getText();
					try
			        {
			            if(Files.deleteIfExists(Paths.get(input)))
			           JOptionPane.showMessageDialog(null,"File successfully removed");
			            else
			            	JOptionPane.showMessageDialog(null,"No such file/directory exists");
			        }
			       
			        catch(DirectoryNotEmptyException e)
			        {
			        	JOptionPane.showMessageDialog(null,"Directory is not empty");
			        }
			        catch(IOException e)
			        {
			        	JOptionPane.showMessageDialog(null, "Invalid permissions!");
			        }
					
					
				}
			});
			
			button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			button.setBounds(133, 112, 100, 33);
			this.getContentPane().add(button);
			this.setVisible(true);
					
			
			
			
			
			
			
			
			
		}
			
		

	
	public static void main(String [] args) {
		App application = new App();
	}
	
	

}
