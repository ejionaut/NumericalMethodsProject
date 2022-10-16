import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

import javax.swing.*;

/**
 * intoInterface
 */
public class intoInterface {
    Calculation calculation = new Calculation();
	static JTextField textField_r1x3, textField_r2x3, textField_r1x2, textField_r2x2, textField_r2x1,
				textField_r1x1, textField_r1RHS, textField_r2RHS;

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
                int row = Integer.parseInt(rowTextField.getText());
                int column = Integer.parseInt(columnTextField.getText());
                if(row  > 0 && row <= 4 && column > 0 && column <= 5 && row < column && row + 1 == column) {
                    if(row == 2 && column == 3) {
						matrix2x3();
						f.setVisible(false);
					}
                } else {
                    errorInput();
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

    private static void errorInput(){
        JFrame f = new JFrame("Panel test");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\63928\\Desktop\\sageorbLS.png"));
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
		errorText.setText("An error has been found ! Please check the values that were inputed. \r\n\r\nAvailable sizes : 2x3 | 3x4 | 4x5");
		errorText.setBounds(90, 72, 305, 88);
		f.getContentPane().add(errorText);
		f.setVisible(true);
    }

    /**
     *  Matrix formation
     */

	 // 2x3 matrix
	 private static void matrix2x3() {

		JFrame f = new JFrame("Panel test");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\63928\\Desktop\\sageorbLS.png"));
		f.setTitle("View Accounts");
		f.getContentPane().setBackground(new Color(255, 255, 255));
		f.setSize(534,286);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(0, 233, 520, 16);
		f.getContentPane().add(panel);
		
		JLabel uiMainTextLogo = new JLabel("Gauss Jordan Elimination");
		uiMainTextLogo.setForeground(SystemColor.controlDkShadow);
		uiMainTextLogo.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		uiMainTextLogo.setBounds(122, 10, 360, 56);
		f.getContentPane().add(uiMainTextLogo);
		
		textField_r1x3 = new JTextField();
		textField_r1x3.setColumns(10);
		textField_r1x3.setBounds(265, 96, 109, 29);
		f.getContentPane().add(textField_r1x3);
		
		textField_r2x3 = new JTextField();
		textField_r2x3.setColumns(10);
		textField_r2x3.setBounds(265, 139, 109, 29);
		f.getContentPane().add(textField_r2x3);
		
		textField_r1x2 = new JTextField();
		textField_r1x2.setColumns(10);
		textField_r1x2.setBounds(146, 96, 109, 29);
		f.getContentPane().add(textField_r1x2);
		
		textField_r2x2 = new JTextField();
		textField_r2x2.setColumns(10);
		textField_r2x2.setBounds(146, 139, 109, 29);
		f.getContentPane().add(textField_r2x2);
		
		textField_r2x1 = new JTextField();
		textField_r2x1.setColumns(10);
		textField_r2x1.setBounds(27, 139, 109, 29);
		f.getContentPane().add(textField_r2x1);
		
		textField_r1x1 = new JTextField();
		textField_r1x1.setColumns(10);
		textField_r1x1.setBounds(27, 96, 109, 29);
		f.getContentPane().add(textField_r1x1);
		
		textField_r1RHS = new JTextField();
		textField_r1RHS.setColumns(10);
		textField_r1RHS.setBounds(384, 96, 109, 29);
		f.getContentPane().add(textField_r1RHS);
		
		textField_r2RHS = new JTextField();
		textField_r2RHS.setColumns(10);
		textField_r2RHS.setBounds(384, 139, 109, 29);
		f.getContentPane().add(textField_r2RHS);
		
		JButton solveButton = new JButton("Solve");
		solveButton.setBounds(27, 194, 186, 29);
		f.getContentPane().add(solveButton);
		
		JButton btnReenterMatrix = new JButton("Re-enter Matrix");
		btnReenterMatrix.setBounds(309, 194, 186, 29);
		btnReenterMatrix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startPoint();
				f.setVisible(false);
			}
		});
		f.getContentPane().add(btnReenterMatrix);
		
		JLabel RHSLabel = new JLabel("RHS");
		RHSLabel.setBounds(420, 72, 46, 14);
		f.getContentPane().add(RHSLabel);
		
		JLabel x1Label = new JLabel("X1");
		x1Label.setBounds(70, 72, 46, 14);
		f.getContentPane().add(x1Label);
		
		JLabel x2Label = new JLabel("X2");
		x2Label.setBounds(190, 72, 46, 14);
		f.getContentPane().add(x2Label);
		
		JLabel x3Label = new JLabel("X3");
		x3Label.setBounds(309, 72, 46, 14);
		f.getContentPane().add(x3Label);
		f.setVisible(true);
	 }
}