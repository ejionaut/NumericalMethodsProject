import java.util.ArrayList;
import java.util.Scanner;

public class Calculation {
    intoInterface interface1 = new intoInterface();
    static ArrayList<String> words = new ArrayList<>();

    public static void CreateGauss(float[][] matrix){
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

                    if(x == 0) {
                        for(int c = 1; c < newMatrix.length; c++){
                            float tempVal = newMatrix[c][0];
                            for(int v = 0; v < newMatrix[0].length; v++){
                                newMatrix[c][v] = (newMatrix[0][v] * (-tempVal)) + newMatrix[c][v];
                            }
                        }
                    } else if(x == 1){
                        for(int c = 0; c < newMatrix.length; c++){
                            float tempVal = newMatrix[c][1];

                            for(int v = 0; v < newMatrix[0].length; v++){
                                if( c != x){
                                    newMatrix[c][v] = (newMatrix[1][v] * (-tempVal)) + newMatrix[c][v];
                                }
                            }
                        }
                    } else if(x == 2){
                        for(int c = 0; c < newMatrix.length; c++){
                            float tempVal = newMatrix[c][2];
                            

                            for(int v = 0; v < newMatrix[0].length; v++){
                                if( c != x){
                                    newMatrix[c][v] = (newMatrix[2][v] * (-tempVal)) + newMatrix[c][v];
                                }
                            }
                        }

                    } else if (x == 3){
                        for(int c = 0; c < newMatrix.length; c++){
                            float tempVal = newMatrix[c][3];

                            for(int v = 0; v < newMatrix[0].length; v++){
                                if( c != x){
                                    newMatrix[c][v] = (newMatrix[3][v] * (-tempVal)) + newMatrix[c][v];
                                }
                            }
                        }

                    }
               }

            }
            StringPrinter(newMatrix);
        }

        intoInterface.printed(words);
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

    // Zeroing value method

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
            words.add(line);
            line = "";
        }
        words.add(line);
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
            words.add(line);
            line = "";
        }
        words.add(line);
    }

    private static void printFinal(float[][] matrix) {

    }

}
