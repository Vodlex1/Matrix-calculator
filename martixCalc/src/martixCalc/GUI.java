package martixCalc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
	
	String[] optionStrings = {"Zbrajanje", "Oduzimanje", "Mnozenje", "Dijeljenje"};
	GridBagConstraints gbc = new GridBagConstraints();
	GridBagConstraints gbc1 = new GridBagConstraints();
	JPanel matrixBPanel = new JPanel();
	JPanel matrixAPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	JComboBox<String> cmbOptions = new JComboBox<>();
	TextField x_axis1 = new TextField();
	TextField y_axis1 = new TextField();
	TextField x_axis2 = new TextField();
	TextField y_axis2 = new TextField();
	JButton calculateButton = new JButton("Izracunaj");
	JButton resetButton = new JButton("Resetiraj");
	JPanel matricePanel = new JPanel();
	JTextField[][] textFieldListB;
	JTextField[][] textFieldListA;
	JTextField[][] resultTextFieldList;
	double resultMatrix[][];
	process2 obj = new process2();
	
	void window() {
		JFrame window = new JFrame("Matrice Calculator");
		window.setSize(640, 520);
		window.setLocation(1000,500);

		mainPanel.setLayout(new BorderLayout(5, 5));
		window.add(mainPanel);
		
		JLabel topLabel = new JLabel("   Matrice calculator v0.01");
		mainPanel.add(topLabel, BorderLayout.NORTH);
		
		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(null);
		optionPanel.setPreferredSize(new Dimension(140, 1));
		optionPanel.repaint();
		mainPanel.add(optionPanel, BorderLayout.WEST);
		
		mainPanel.add(matricePanel, BorderLayout.CENTER);
		matricePanel.setBackground(new Color(255, 255, 255));
		matricePanel.setLayout(new BoxLayout(matricePanel, BoxLayout.Y_AXIS));
		
		cmbOptions.setBounds(20, 25, 100, 25);
		cmbOptions.addItem("Zbrajanje");
		cmbOptions.addItem("Oduzimanje");
		cmbOptions.addItem("Mnozenje");
		cmbOptions.addItem("Dijeljenje");
		optionPanel.add(cmbOptions);
		
		JLabel matriceALabel = new JLabel("Prva matrica:");
		matriceALabel.setBounds(20, 65, 100, 25);
		optionPanel.add(matriceALabel);
		
		matrixAPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(238,238,238)));
		matrixAPanel.setBackground(new Color(255,255,255));
		matrixAPanel.setLayout(new GridBagLayout());
		matricePanel.add(matrixAPanel);

		matrixBPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, new Color(238,238,238)));
		matrixBPanel.setBackground(new Color(255,255,255));
		matrixBPanel.setLayout(new GridBagLayout());		
		matricePanel.add(matrixBPanel);
		
		x_axis1.setBounds(20, 90, 100, 25);
		optionPanel.add(x_axis1);
		
		y_axis1.setBounds(20, 130, 100, 25);
		optionPanel.add(y_axis1);
		
		JLabel matriceBLabel = new JLabel("Druga matrica:");
		matriceBLabel.setBounds(20, 165, 100, 25);
		optionPanel.add(matriceBLabel);
		
		JLabel x_letter1 = new JLabel("x");
		x_letter1.setBounds(20, 109, 100, 25);
		optionPanel.add(x_letter1);
		
		x_axis2.setBounds(20, 190, 100, 25);
		optionPanel.add(x_axis2);
		
		y_axis2.setBounds(20, 230, 100, 25);
		optionPanel.add(y_axis2);
		
		calculateButton.setBounds(20, 290, 100, 25);
		optionPanel.add(calculateButton);
		
		resetButton.setBounds(20, 325, 100, 25);
		optionPanel.add(resetButton);
		
		JLabel x_letter2 = new JLabel("x");
		x_letter2.setBounds(20, 210, 100, 25);
		optionPanel.add(x_letter2);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		mainPanel.repaint();
		
		cmbOptions.addActionListener(action);
		resetButton.addActionListener(action);
		calculateButton.addActionListener(action);
		x_axis1.addActionListener(action);
		y_axis1.addActionListener(action);
		x_axis2.addActionListener(action);
		y_axis2.addActionListener(action);
		
	}
	
	void createMatrixBoardA(int row, int col) {
		matrixAPanel.removeAll();
		textFieldListA = new JTextField[row][col];
		matrixAPanel.setBackground(new Color(255,255,255));
		matrixAPanel.setLayout(new GridBagLayout());		
		matrixAPanel.updateUI();
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				textFieldListA[i][j] = new JTextField();
				textFieldListA[i][j].addActionListener(action);
			}
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				gbc.gridx = j;
				gbc.gridy = i;
				gbc.weightx = 0.5;
				gbc.weighty = 0.5;
				textFieldListA[i][j].setPreferredSize(new Dimension(50, 35));
				matrixAPanel.add(textFieldListA[i][j], gbc);
			}
		}
	}
	
	void createMatrixBoardB(int row, int col) {
		matrixBPanel.removeAll();
		textFieldListB = new JTextField[row][col];
		matrixBPanel.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, new Color(238,238,238)));
		matrixBPanel.setBackground(new Color(255,255,255));
		matrixBPanel.setLayout(new GridBagLayout());
		matrixBPanel.updateUI();
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				textFieldListB[i][j] = new JTextField();
				textFieldListB[i][j].addActionListener(action);
			}
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				gbc.gridx = j;
				gbc.gridy = i;
				gbc.weightx = 0.5;
				gbc.weighty = 0.5;
				matrixBPanel.add(textFieldListB[i][j], gbc);
				textFieldListB[i][j].setPreferredSize(new Dimension(50, 35));
				
			}
		}
	}
	
	double array1[][];
	double array2[][];
	
	void readTextFieldA() {
		array1 = new double[Integer.parseInt(x_axis1.getText())][Integer.parseInt(y_axis1.getText())];
		for(int i=0; i<array1.length; i++) {
			for(int j=0; j<array1[0].length; j++) {
				array1[i][j] = Double.parseDouble(textFieldListA[i][j].getText());
				
			}
		}	
	}
	
	void readTextFieldB() {
		array2 = new double[Integer.parseInt(x_axis2.getText())][Integer.parseInt(y_axis2.getText())];
		for(int i=0; i<array2.length; i++) {
			for(int j=0; j<array2[0].length; j++) {
				array2[i][j] = Double.parseDouble(textFieldListB[i][j].getText());
			}
		}	
	}
	
	
	ActionListener action = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
						
			if(e.getSource() == calculateButton){
				readTextFieldA();
				obj.insertMatrix1(Integer.parseInt(x_axis1.getText()), Integer.parseInt(y_axis1.getText()), array1);
				readTextFieldB();
				obj.insertMatrix2(Integer.parseInt(x_axis2.getText()), Integer.parseInt(y_axis2.getText()), array2);
				
				String x = String.valueOf(cmbOptions.getSelectedItem());
				System.out.println(x);
				switch(x) {
				case "Zbrajanje": obj.addMatrix();
					break;
				case "Oduzimanje": obj.subtractMatrix();
					break;
				case "Mnozenje": obj.multiplyMatrix();
					break;
				case "Dijeljenje": obj.divideMatrix();
					break;
				}
				
			}else if(e.getSource() == resetButton){
				matrixAPanel.removeAll();
				matrixAPanel.setBackground(new Color(255,255,255));
				matrixAPanel.setLayout(new GridBagLayout());
				matrixAPanel.repaint();
				
				matrixBPanel.removeAll();
				matrixBPanel.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, new Color(238,238,238)));
				matrixBPanel.setBackground(new Color(255,255,255));
				matrixBPanel.setLayout(new GridBagLayout());
				matrixBPanel.repaint();
				
				x_axis1.setText("");
				y_axis1.setText("");
				x_axis2.setText("");
				y_axis2.setText("");
				
				
				
			}else if(e.getSource() == y_axis1){
				createMatrixBoardA(Integer.parseInt(x_axis1.getText()), Integer.parseInt(y_axis1.getText()));
				obj.createMatrixA(Integer.parseInt(x_axis1.getText()), Integer.parseInt(y_axis1.getText()));

			}else if(e.getSource() == y_axis2){
				createMatrixBoardB(Integer.parseInt(x_axis2.getText()), Integer.parseInt(y_axis2.getText()));
				obj.createMatrixB(Integer.parseInt(x_axis2.getText()), Integer.parseInt(y_axis2.getText()));
				
			}
		}
	};
}

