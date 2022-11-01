import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class LinearEquationRunner {
    public static void main(String[] args ) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome!"); //welcomes the user
        System.out.print("Enter coordinate 1: "); //first coord
        String firstCoord = scan.nextLine();
        System.out.print("Enter coordinate 2: "); //second coord
        String secondCoord = scan.nextLine();


        int firstX = Integer.parseInt(firstCoord.substring(1, firstCoord.indexOf(",")));
        int firstY = Integer.parseInt(firstCoord.substring(firstCoord.indexOf(",") + 2, firstCoord.length()-1));
        int secondX = Integer.parseInt(secondCoord.substring(1, secondCoord.indexOf(",")));
        int secondY = Integer.parseInt(secondCoord.substring(secondCoord.indexOf(",") + 2, secondCoord.length()-1));
        //parses the values out of the string (x,y) format into int values

        if (firstX != firstY) { //checks whether firstX is equal to firstY and doesn't initialize if they're equal
            LinearEquation obj = new LinearEquation(firstX, firstY, secondX, secondY);
            System.out.println(obj.lineInfo());
            System.out.println("Enter an x coordinate: ");
            double tempX = scan.nextDouble();
            System.out.println("The x coordinate in a point is " + obj.coordinateForX(tempX));
        }

        if (firstX == firstY) { //if firstX and firstY are equal it returns a vertical equation and ends
            System.out.println("The line is a vertical: x = " + firstX);
        }




    }
}
