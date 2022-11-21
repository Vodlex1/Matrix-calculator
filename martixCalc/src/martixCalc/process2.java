package martixCalc;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class process2 {
	GridBagConstraints gbc1 = new GridBagConstraints();
	Scanner s = new Scanner(System.in);
	double temp1;
	int col1;
	int row1;
	int col2;
	int row2;
	
	double matrix1[][];
	double matrix2[][];
	double resultMatrix[][]; 
	
	public void createMatrixA(int colOne, int rowOne) {
		col1 = rowOne;
		row1 = colOne;
		matrix1 = new double[row1][col1];
	}
	public void createMatrixB(int colTwo, int rowTwo) {
		col2 = rowTwo;
		row2 = colTwo;
		matrix2 = new double[row2][col2];
	}		
	
	///////////////////////////////////////////////////////////// PRINT MATRIX
	void printMatrix() {
		System.out.println("End result: ");
		System.out.println(Arrays.deepToString(resultMatrix));
	}
	///////////////////////////////////////////////////////////// INSERT MATRIX
	void insertMatrix1(int row, int col, double array[][]) {
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				matrix1[i][j] = array[i][j];
				System.out.print(matrix1[i][j] + " ");
			}
		}	System.out.println();
	}

	void insertMatrix2(int row, int col, double array[][]) {		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				matrix2[i][j] = array[i][j];
				System.out.print(matrix2[i][j] + " ");
			}
		}	System.out.println();
	}
	
	///////////////////////////////////////////////////////// COMPATABILITY CHECK
	Boolean arithmeticCheck() {
		if((row1 == row2) && (col2 == col1)) {
			return true;
		}
		else {
			System.out.println("Matricies not compatible for addition/subtraction!");
			JOptionPane.showMessageDialog(null, "Matrice nisu kompatabilne!");
			return false;
		}
	}
	
	Boolean multiplicationCheck() {
		if(row2 == col1) {
			return true;
		} else {
			System.out.println("Matricies not compatible for multiplication/divison!");
			JOptionPane.showMessageDialog(null, "Matrice nisu kompatabilne!");
			return false;
		}
	}
	
	///////////////////////////////////////////////////////// CALCULATIONS
	
	
	void addMatrix() {
		if(!arithmeticCheck()) return;
		resultMatrix = new double[row1][col2];
		for(int i=0; i<row1; i++) {
			for(int j=0; j<col1; j++) {
				resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		ResultWindow(row1, col2);
		printMatrix();
	}
	
	void subtractMatrix() {
		if(!arithmeticCheck()) return;
		resultMatrix = new double[row1][col1];
		for(int i=0; i<row1; i++) {
			for(int j=0; j<col1; j++) {
				resultMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
			}
		}
		ResultWindow(row1, col1);
		printMatrix();
	}
	
	void multiplyMatrix(){
		if(multiplicationCheck()) {
		resultMatrix = new double[row1][col2];
			for(int i=0; i<row1; i++) {
				for(int j=0; j<col2; j++) {
					for(int z=0; z<row2; z++) {
						resultMatrix[i][j] += matrix1[i][z] * matrix2[z][j];

					}
				}
			}
		}else return;
		ResultWindow(row1, col2);
		printMatrix();
	}

	void divideMatrix(){
		resultMatrix = new double[row1][col2];
		for(int i=0; i<row1; i++) {
			for(int j=0; j<col2; j++) {
					resultMatrix[i][j] = matrix1[i][j] / matrix2[i][j];		
			}
		}
		ResultWindow(row1, col2);
		printMatrix();
	}

////////////////////////////////////////////////////////////////// OPEN RESULT WINDOW
	
	void ResultWindow(int a, int b) {
		
		JLabel[][] resultTextFieldList;
		JFrame resultWindow = new JFrame("Rezultat");
		resultWindow.setSize(320, 260);
		resultWindow.setLocation(1100,570);
		JPanel resultPanel = new JPanel();
		resultTextFieldList = new JLabel[a][b];
		
		resultPanel.setLayout(new GridBagLayout());
		resultPanel.setBackground(new Color(255,255,255));
		
		for(int i=0; i<a; i++) {
			for(int j=0; j<b; j++) {
				resultTextFieldList[i][j] = new JLabel();
			}
		}
		
		for(int i=0; i<a; i++) {
			for(int j=0; j<b; j++) {
				gbc1.gridx = j;
				gbc1.gridy = i;
				gbc1.weightx = 0.5;
				gbc1.weighty = 0.5;
				resultTextFieldList[i][j].setPreferredSize(new Dimension(70, 35));
				temp1 = resultMatrix[i][j];
				resultTextFieldList[i][j].setText(Double.toString(temp1));
				resultPanel.add(resultTextFieldList[i][j], gbc1);
			}
		}
	
		resultWindow.add(resultPanel);
		resultWindow.setVisible(true);
	}
}
