package martixCalc;

/*import java.util.ArrayList;
import java.util.Scanner;

public class process {
	
	Scanner test = new Scanner(System.in);
	
	ArrayList<ArrayList<Double>> matrix1 = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Double>> matrix2 = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Double>> resultMatrix = new ArrayList<ArrayList<Double>>();
	
	
	double doubleOne;
	double doubleTwo;
	double doubleSum;
	double doubleTemp1;
	double doubleTemp2;
	
	int col1=2;
	int row1=3;
	int col2=4;
	int row2=2;
	
	void createMatrix1() {
		for(int i = 0; i<col1; i++) {
			ArrayList<Double> y_axis1 = new ArrayList<>();
			matrix1.add(y_axis1);
		}
	}
	void createMatrix2() {
		for(int i = 0; i<col2; i++) {
			ArrayList<Double> y_axis2 = new ArrayList<>();
			matrix2.add(y_axis2);
			
		}
	}
	void createResultMatrix() {
		for(int i = 0; i<col2; i++) {
			ArrayList<Double> y_axis3 = new ArrayList<>();
			resultMatrix.add(y_axis3);
		}
	}
	
	void insertNumber1() {
		for(int i=0; i<col1; i++) {
			for(int j=0; j<row1; j++) {
				matrix1.get(i).add(j, test.nextDouble());
			}
		}
		System.out.println("Matrix(1) has been entered!");
	}
	void insertNumber2() {
		for(int i=0; i<col2; i++) {
			for(int j=0; j<row2; j++) {
				matrix2.get(i).add(j, test.nextDouble());
			}
		}
		System.out.println("Matrix(2) has been entered!");
	}
	void insertNumber3() {
		for(int i=0; i<col2; i++) {
			for(int j=0; j<row1; j++) {
				resultMatrix.get(i).add(j, (double) 0);
			}
		}
		System.out.println("ResultMatrix loaded!");
	}
	
	ArrayList<ArrayList<Double>> addMatrix() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				doubleOne = matrix1.get(i).get(j);
				doubleTwo = matrix2.get(i).get(j);
				doubleSum = doubleOne + doubleTwo;
				matrix1.get(i).set(j, doubleSum);
			}
		}
		System.out.println(matrix1);
		return matrix1;
	}
	
	ArrayList<ArrayList<Double>> subtractMatrix() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				doubleOne = matrix1.get(i).get(j);
				doubleTwo = matrix2.get(i).get(j);
				doubleSum = doubleOne - doubleTwo;
				matrix1.get(i).set(j, doubleSum);
			}
		}
		System.out.println("\r\n" + "End result: \r\n" + matrix1);
		return matrix1;
	}
	
	ArrayList<ArrayList<Double>> multiplyMatrix() {
		
		if(row2 == col1) {
			System.out.println(matrix1);
			System.out.println(matrix2);
			for(int i=0; i<row1; i++) {
				for(int j=0; j<col2; j++) {
					for(int z=0; z<col1; z++) {
						doubleTemp1 = matrix1.get(i).get(z) * matrix2.get(z).get(j);
						doubleTemp2 += doubleTemp1;
					}
					resultMatrix.get(i).add(j, doubleTemp2);
					doubleTemp2 = 0;
				}
			}
			System.out.println("\r\n" + "End result: \r\n" + resultMatrix);
		}else {
			System.out.println("Invalid compatability!");
		}
		
		return resultMatrix;
	}
	
} */
