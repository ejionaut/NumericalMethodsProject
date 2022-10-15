import java.util.Scanner;

public class Calculation {
    public static void createMatrix(int row, int column){
        Scanner kbd = new Scanner(System.in);

        float[][] matrix = new float[row][column];
        int columnCounter = 1;
        int rowCounter = 1;

        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[0].length; y++){
                if(y == matrix[0].length - 1) {
                    System.out.println("Input rhs of row " +rowCounter);
                    matrix[x][y] = kbd.nextFloat();
                } else {
                    System.out.println("Input x" + columnCounter +" of row " +rowCounter);
                    matrix[x][y] = kbd.nextFloat();
                    columnCounter++;
                }
            }
            columnCounter = 1;
            rowCounter++;
        }

        CreateGauss(matrix);
    }

    private static void CreateGauss(float[][] matrix){
        float[][] newMatrix = matrix;
        String[] formula = new String[2];

        for(int x = 0; x < newMatrix.length; x++){
            for(int y = 0; y < newMatrix[0].length; y++){
               if(x == y) {
                    if (newMatrix[x][y] == 0) {
                        newMatrix = rowSwapper(newMatrix, x, x+1);
                    } 
                    
                    if (newMatrix[x][y] != 1) {
                        float temp = newMatrix[x][y];
                        for(int i = 0; i < newMatrix[0].length; i++){
                            newMatrix[x][i] = newMatrix[x][i] / temp;
                            formula[0] = Integer.toString(x);
                            formula[1] = Float.toString(newMatrix[x][i]) + " / " + Float.toString(temp);
                            StringPrinter(newMatrix, formula);
                        }
                    }
               }
            }
            StringPrinter(newMatrix);
        }
    }

    private static float[][] rowSwapper(float[][] matrix , int r1, int r2){
        float[][] newMatrix = matrix;

        for(int y = 0; y < newMatrix[0].length; y++){
            float temp = newMatrix[r1][y];
            newMatrix[r1][y] = newMatrix[r2][y];
            newMatrix[r2][y] = temp;
        }

        return newMatrix;
    }

    private static void StringPrinter(float[][] matrix , String[] formulation){
        String line = "";
        int formula = Integer.valueOf(formulation[0]);

        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[0].length; y++){
                if(y == 0) {
                    line += "| " + matrix[x][y] +" ";
                } else if (y == matrix[0].length -1) {
                    line += ": "+ matrix[x][y] + " |";
                    if(formula == x) {
                        line += "  " + formulation[1];
                    }
                } else {
                    line += matrix[x][y] + " ";
                }
            }
            System.out.println(line);
            line = "";
        }

        System.out.println(" ");
    }

    private static void StringPrinter(float[][] matrix){
        String line = "";

        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[0].length; y++){
                if(y == 0) {
                    line += "| " + matrix[x][y] +" ";
                } else if (y == matrix[0].length -1) {
                    line += ": "+ matrix[x][y] + " |";
                } else {
                    line += matrix[x][y] + " ";
                }
            }
            System.out.println(line);
            line = "";
        }

        System.out.println(" ");
    }

    private static void printFinal(float[][] matrix) {

    }

}
