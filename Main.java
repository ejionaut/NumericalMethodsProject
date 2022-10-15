import java.lang.*;
import java.util.Scanner;

public class Main {
    Calculation calc = new Calculation();
    public static void main(String[] args) {
        title();
        askValue();
    }

    public static void title(){
        System.out.println("""
                *----------------------------*
                |  GAUSS JORDAN ELIMINATION  |
                *----------------------------*
                |     Current available:     |
                |    2 x 3 ; 3 x 4 ; 4 x 5   |
                *----------------------------*
                """);
    }

    public static void askValue(){
        System.out.println("Number of matrix (row, column)");
        System.out.println("Enter row: ");
        int row = number();
        System.out.println("Enter column: ");
        int column = number();

        if(row  <= 0 || row > 4 || column <= 0 || column > 5 || row > column || row + 1 != column) {
            System.out.println("Invalid Matrix. An error was found...Resetting");
            space();
            main(null);
        }

        Calculation.createMatrix(row, column);
    }

    public static int number(){
        Scanner kbd = new Scanner(System.in);
        int number = 0;

        try{
             number = kbd.nextInt();
            } catch(Exception e) {
             System.out.println("Invalid value was entered. Resetting");
          }

        return number;
    }

    public static void space(){
        System.out.println(" ");
        System.out.println(" ");
    }
}