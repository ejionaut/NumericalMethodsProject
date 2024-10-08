import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.*;

/**
 * intoInterface
 */
public class intoInterface {
    Calculation calculation = new Calculation();
	static JFrame matrixFrame;

    public static void startPoint(){
		JTextField rowTextField, columnTextField;

        JFrame f = new JFrame("Gauss Jordan Elimination Calculator");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("images/calculate_FILL0_wght400_GRAD0_opsz48.png"));
		f.setTitle("View Accounts");
		f.getContentPane().setBackground(new Color(255, 255, 255));
		f.setSize(517,242);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(0, 215, 636, 16);
		f.getContentPane().add(panel);
		
		JLabel uiMainTextLogo = new JLabel("Gauss Jordan Elimination");
		uiMainTextLogo.setForeground(SystemColor.controlDkShadow);
		uiMainTextLogo.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		uiMainTextLogo.setBounds(104, 18, 360, 56);
		f.getContentPane().add(uiMainTextLogo);
		
		rowTextField = new JTextField();
		rowTextField.setBounds(35, 103, 179, 20);
		f.getContentPane().add(rowTextField);
		rowTextField.setColumns(10);
		
		JLabel rowLabel = new JLabel("Row:");
		rowLabel.setBounds(35, 83, 46, 14);
		f.getContentPane().add(rowLabel);
		
		columnTextField = new JTextField();
		columnTextField.setColumns(10);
		columnTextField.setBounds(284, 103, 179, 20);
		f.getContentPane().add(columnTextField);

		JButton calcButton = new JButton("Calculate");
		calcButton.setBounds(35, 146, 179, 23);
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				try{
					int row = Integer.parseInt(rowTextField.getText());
					int column = Integer.parseInt(columnTextField.getText());
					if(row  > 0 && row <= 4 && column > 0 && column <= 5 && row < column && row + 1 == column) {
						matrix(column,row);
						f.setVisible(false);
					} else {
						errorInput(0);
					}
				} catch(Exception c){
					errorInput(0);
				}
                
            }
        });
		f.getContentPane().add(calcButton);
		
		JLabel columnLabel = new JLabel("Column:");
		columnLabel.setBounds(284, 84, 46, 14);
		f.getContentPane().add(columnLabel);
		
		JButton helpButton = new JButton("How it works");
		helpButton.setBounds(284, 147, 179, 23);
		f.getContentPane().add(helpButton);
		f.setVisible(true);
        f.setResizable(false);
    }

    private static void errorInput(int error){
        JFrame f = new JFrame("Panel test");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("images/calculate_FILL0_wght400_GRAD0_opsz48.png"));
		f.setTitle("View Accounts");
		f.getContentPane().setBackground(new Color(255, 255, 255));
		f.setSize(517,242);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
        f.setDefaultCloseOperation(f.HIDE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(1, 187, 506, 16);
		f.getContentPane().add(panel);
		
		JLabel uiMainTextLogo = new JLabel("Gauss Jordan Elimination");
		uiMainTextLogo.setForeground(SystemColor.controlDkShadow);
		uiMainTextLogo.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		uiMainTextLogo.setBounds(90, 22, 360, 56);
		f.getContentPane().add(uiMainTextLogo);
		
		JTextPane errorText = new JTextPane();
		errorText.setEditable(false);
		errorText.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		if (error == 0) {
			errorText.setText("An error has been found ! Please check the values that were inputed. \r\n\r\nAvailable sizes : 2x3 | 3x4 | 4x5");
		} else {
			errorText.setText("An error has been found ! Please check the values that were inputed. \r\n\r\nOnly positive or negative values are accepted. Any other input is rejected");
		}
		errorText.setBounds(90, 72, 305, 88);
		f.getContentPane().add(errorText);
		f.setResizable(false);
		f.setVisible(true);
    }

    /**
     *  Matrix formation
     */

	 // matrix
	 private static void matrix(int column, int row) {
		JTextField textField_r1x2, textField_r2x2, textField_r2x1, textField_r1x1,textField_r1RHS,
		 textField_r2RHS;
		
		float[][] values = new float[row][column];

		matrixFrame = new JFrame("Matrix Setting");
		matrixFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/calculate_FILL0_wght400_GRAD0_opsz48.png"));
		matrixFrame.setTitle("View Accounts");
		matrixFrame.getContentPane().setBackground(new Color(255, 255, 255));
		matrixFrame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));

		JButton solveButton = new JButton("Solve");
		JButton btnReenterMatrix = new JButton("Re-enter Matrix");
		JLabel uiMainTextLogo = new JLabel("Gauss Jordan Elimination");
		uiMainTextLogo.setForeground(SystemColor.controlDkShadow);
		uiMainTextLogo.setFont(new Font("Segoe UI", Font.PLAIN, 24));

		JLabel RHSLabel = new JLabel("RHS");
		textField_r2RHS = new JTextField();
		textField_r1RHS = new JTextField();

		textField_r1x2 = new JTextField();
		textField_r1x2.setColumns(10);
		textField_r1x2.setBounds(146, 96, 109, 29);
		matrixFrame.getContentPane().add(textField_r1x2);
		
		textField_r2x2 = new JTextField();
		textField_r2x2.setColumns(10);
		textField_r2x2.setBounds(146, 139, 109, 29);
		matrixFrame.getContentPane().add(textField_r2x2);
		
		textField_r2x1 = new JTextField();
		textField_r2x1.setColumns(10);
		textField_r2x1.setBounds(27, 139, 109, 29);
		matrixFrame.getContentPane().add(textField_r2x1);
		
		textField_r1x1 = new JTextField();
		textField_r1x1.setColumns(10);
		textField_r1x1.setBounds(27, 96, 109, 29);
		matrixFrame.getContentPane().add(textField_r1x1);
		
		textField_r1RHS.setColumns(10);
		textField_r2RHS.setColumns(10);
		matrixFrame.getContentPane().add(textField_r1RHS);
		matrixFrame.getContentPane().add(RHSLabel);
		matrixFrame.getContentPane().add(textField_r2RHS);

		if(column == 3) {
			matrixFrame.setSize(415,281);
			panel.setBounds(0, 229, 418, 16);

			uiMainTextLogo.setBounds(70, 6, 360, 56);
			btnReenterMatrix.setBounds(225, 178, 149, 29);
			solveButton.setBounds(27, 178, 149, 29);

			textField_r1RHS.setBounds(265, 96, 109, 29);
			textField_r2RHS.setBounds(265, 139, 109, 29);
			RHSLabel.setBounds(309, 72, 46, 14);

			solveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						values[0][0] = Float.parseFloat(textField_r1x1.getText());
						values[0][1] = Float.parseFloat(textField_r1x2.getText());
						values[0][2] = Float.parseFloat(textField_r1RHS.getText());
						values[1][0] = Float.parseFloat(textField_r1x1.getText());
						values[1][1] = Float.parseFloat(textField_r2x2.getText());
						values[1][2] = Float.parseFloat(textField_r2RHS.getText());
						Calculation.CreateGauss(values);
					} catch (Exception c) {
						errorInput(1);
					}
				}
			});
		} else if (column == 4) {
			JTextField  textField_r3x1, textField_r3x2, textField_r3x3, textField_r3RHS, textField_r1x3, 
			textField_r2x3;

			matrixFrame.setSize(535,325);
			RHSLabel.setBounds(428, 72, 46, 14);
			uiMainTextLogo.setBounds(122, 10, 360, 56);
			textField_r1RHS.setBounds(384, 96, 109, 29);
			textField_r2RHS.setBounds(384, 139, 109, 29);
			panel.setBounds(0, 272, 535, 16);

			solveButton.setBounds(24, 230, 186, 29);
			btnReenterMatrix.setBounds(309, 230, 186, 29);

			textField_r1x3 = new JTextField();
			textField_r1x3.setColumns(10);
			textField_r1x3.setBounds(265, 96, 109, 29);
			matrixFrame.getContentPane().add(textField_r1x3);
			
			textField_r2x3 = new JTextField();
			textField_r2x3.setColumns(10);
			textField_r2x3.setBounds(265, 139, 109, 29);
			matrixFrame.getContentPane().add(textField_r2x3);

			JLabel x3Label = new JLabel("X3");
			x3Label.setBounds(309, 72, 46, 14);
			matrixFrame.getContentPane().add(x3Label);
			
			textField_r3x1 = new JTextField();
			textField_r3x1.setColumns(10);
			textField_r3x1.setBounds(27, 182, 109, 29);
			matrixFrame.getContentPane().add(textField_r3x1);
			
			textField_r3x2 = new JTextField();
			textField_r3x2.setColumns(10);
			textField_r3x2.setBounds(146, 182, 109, 29);
			matrixFrame.getContentPane().add(textField_r3x2);
			
			textField_r3x3 = new JTextField();
			textField_r3x3.setColumns(10);
			textField_r3x3.setBounds(265, 182, 109, 29);
			matrixFrame.getContentPane().add(textField_r3x3);
			
			textField_r3RHS = new JTextField();
			textField_r3RHS.setColumns(10);
			textField_r3RHS.setBounds(384, 182, 109, 29);
			matrixFrame.getContentPane().add(textField_r3RHS);	
			
			solveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						values[0][0] = Float.parseFloat(textField_r1x1.getText());
						values[0][1] = Float.parseFloat(textField_r1x2.getText());
						values[0][2] = Float.parseFloat(textField_r1x3.getText());
						values[0][3] = Float.parseFloat(textField_r1RHS.getText());
						values[1][0] = Float.parseFloat(textField_r1x1.getText());
						values[1][1] = Float.parseFloat(textField_r2x2.getText());
						values[1][2] = Float.parseFloat(textField_r2x3.getText());
						values[1][3] = Float.parseFloat(textField_r2RHS.getText());
						values[2][0] = Float.parseFloat(textField_r3x1.getText());
						values[2][1] = Float.parseFloat(textField_r3x2.getText());
						values[2][2] = Float.parseFloat(textField_r3x3.getText());
						values[2][3] = Float.parseFloat(textField_r3RHS.getText());
						Calculation.CreateGauss(values);
					} catch (Exception c) {
						errorInput(1);
					}
				}
			});

		} else if (column == 5) {
			JTextField textField_r1x4, textField_r2x4, textField_r3x1, textField_r3x2, textField_r3x3,
			textField_r3x4, textField_r3RHS, textField_r4x1,textField_r4x2,textField_r4x3,textField_r4x4, 
			textField_r4RHS, textField_r1x3, textField_r2x3;

			matrixFrame.setSize(653,375);
			panel.setBounds(0, 322, 639, 16);

			uiMainTextLogo.setForeground(SystemColor.controlDkShadow);
			uiMainTextLogo.setFont(new Font("Segoe UI", Font.PLAIN, 24));
			uiMainTextLogo.setBounds(190, 10, 360, 56);

			solveButton.setBounds(27, 283, 186, 29);
			RHSLabel.setBounds(547, 72, 46, 14);
			btnReenterMatrix.setBounds(426, 283, 186, 29);
			textField_r1RHS.setBounds(503, 96, 109, 29);
			textField_r2RHS.setBounds(503, 139, 109, 29);

			JLabel x3Label = new JLabel("X3");
			x3Label.setBounds(309, 72, 46, 14);
			matrixFrame.getContentPane().add(x3Label);

			JLabel x4Label = new JLabel("X4");
			x4Label.setBounds(436, 72, 46, 14);
			matrixFrame.getContentPane().add(x4Label);

			textField_r1x3 = new JTextField();
			textField_r1x3.setColumns(10);
			textField_r1x3.setBounds(265, 96, 109, 29);
			matrixFrame.getContentPane().add(textField_r1x3);
			
			textField_r2x3 = new JTextField();
			textField_r2x3.setColumns(10);
			textField_r2x3.setBounds(265, 139, 109, 29);
			matrixFrame.getContentPane().add(textField_r2x3);

			textField_r1x4 = new JTextField();
			textField_r1x4.setColumns(10);
			textField_r1x4.setBounds(384, 96, 109, 29);
			matrixFrame.getContentPane().add(textField_r1x4);

			textField_r2x4 = new JTextField();
			textField_r2x4.setColumns(10);
			textField_r2x4.setBounds(384, 139, 109, 29);
			matrixFrame.getContentPane().add(textField_r2x4);

			textField_r4x1 = new JTextField();
			textField_r4x1.setColumns(10);
			textField_r4x1.setBounds(27, 225, 109, 29);
			matrixFrame.getContentPane().add(textField_r4x1);
			
			textField_r3x1 = new JTextField();
			textField_r3x1.setColumns(10);
			textField_r3x1.setBounds(27, 182, 109, 29);
			matrixFrame.getContentPane().add(textField_r3x1);
			
			textField_r3x2 = new JTextField();
			textField_r3x2.setColumns(10);
			textField_r3x2.setBounds(146, 182, 109, 29);
			matrixFrame.getContentPane().add(textField_r3x2);
			
			textField_r4x2 = new JTextField();
			textField_r4x2.setColumns(10);
			textField_r4x2.setBounds(146, 225, 109, 29);
			matrixFrame.getContentPane().add(textField_r4x2);
			
			textField_r4x3 = new JTextField();
			textField_r4x3.setColumns(10);
			textField_r4x3.setBounds(265, 225, 109, 29);
			matrixFrame.getContentPane().add(textField_r4x3);
			
			textField_r3x3 = new JTextField();
			textField_r3x3.setColumns(10);
			textField_r3x3.setBounds(265, 182, 109, 29);
			matrixFrame.getContentPane().add(textField_r3x3);
			
			textField_r3x4 = new JTextField();
			textField_r3x4.setColumns(10);
			textField_r3x4.setBounds(384, 182, 109, 29);
			matrixFrame.getContentPane().add(textField_r3x4);
			
			textField_r4x4 = new JTextField();
			textField_r4x4.setColumns(10);
			textField_r4x4.setBounds(384, 225, 109, 29);
			matrixFrame.getContentPane().add(textField_r4x4);
			
			textField_r4RHS = new JTextField();
			textField_r4RHS.setColumns(10);
			textField_r4RHS.setBounds(503, 225, 109, 29);
			matrixFrame.getContentPane().add(textField_r4RHS);
			
			textField_r3RHS = new JTextField();
			textField_r3RHS.setColumns(10);
			textField_r3RHS.setBounds(503, 182, 109, 29);
			matrixFrame.getContentPane().add(textField_r3RHS);

			solveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						values[0][0] = Float.parseFloat(textField_r1x1.getText());
						values[0][1] = Float.parseFloat(textField_r1x2.getText());
						values[0][2] = Float.parseFloat(textField_r1x3.getText());
						values[0][3] = Float.parseFloat(textField_r1x4.getText());
						values[0][4] = Float.parseFloat(textField_r1RHS.getText());
						values[1][0] = Float.parseFloat(textField_r1x1.getText());
						values[1][1] = Float.parseFloat(textField_r2x2.getText());
						values[1][2] = Float.parseFloat(textField_r2x3.getText());
						values[1][3] = Float.parseFloat(textField_r2x4.getText());
						values[1][4] = Float.parseFloat(textField_r2RHS.getText());
						values[2][0] = Float.parseFloat(textField_r3x1.getText());
						values[2][1] = Float.parseFloat(textField_r3x2.getText());
						values[2][2] = Float.parseFloat(textField_r3x3.getText());
						values[2][3] = Float.parseFloat(textField_r3x4.getText());
						values[2][4] = Float.parseFloat(textField_r3RHS.getText());
						values[3][0] = Float.parseFloat(textField_r4x1.getText());
						values[3][1] = Float.parseFloat(textField_r4x2.getText());
						values[3][2] = Float.parseFloat(textField_r4x3.getText());
						values[3][3] = Float.parseFloat(textField_r4x4.getText());
						values[3][4] = Float.parseFloat(textField_r4RHS.getText());
						Calculation.CreateGauss(values);
					} catch (Exception c) {
						errorInput(1);
					}
				}
			});
		}
		matrixFrame.setVisible(true);
		matrixFrame.getContentPane().add(uiMainTextLogo);
		matrixFrame.getContentPane().add(panel);
		matrixFrame.setLocationRelativeTo(null);

		btnReenterMatrix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startPoint();
				matrixFrame.setVisible(false);
			}
		});
		matrixFrame.getContentPane().add(btnReenterMatrix);
		

		JLabel x1Label = new JLabel("X1");
		x1Label.setBounds(70, 72, 46, 14);
		matrixFrame.getContentPane().add(x1Label);
		
		JLabel x2Label = new JLabel("X2");
		x2Label.setBounds(190, 72, 46, 14);
		matrixFrame.getContentPane().add(x2Label);
		matrixFrame.setResizable(false);
		matrixFrame.getContentPane().add(solveButton);
	 }

	 public static void printed(ArrayList<String> test) {
		JFrame f = new JFrame("Solution");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("images/calculate_FILL0_wght400_GRAD0_opsz48.png"));
		f.setTitle("View Accounts");
		f.getContentPane().setBackground(new Color(255, 255, 255));
		f.setSize(517,732);
		f.setLocationRelativeTo(matrixFrame);
		f.getContentPane().setLayout(null);
        f.setDefaultCloseOperation(f.HIDE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(0, 679, 506, 16);
		f.getContentPane().add(panel);
		
		JLabel uiMainTextLogo = new JLabel("Gauss Jordan Elimination");
		uiMainTextLogo.setForeground(SystemColor.controlDkShadow);
		uiMainTextLogo.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		uiMainTextLogo.setBounds(112, 10, 360, 56);
		f.getContentPane().add(uiMainTextLogo);
		
		JTextPane errorText = new JTextPane();
		errorText.setEditable(false);
		errorText.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		String line = " ";
		for (String string : test) {
			line += string;
			line += "\n";
		}
		errorText.setText(line);
		errorText.setBounds(10, 65, 483, 604);
		f.getContentPane().add(errorText);
		f.setVisible(true);
	 }
}
