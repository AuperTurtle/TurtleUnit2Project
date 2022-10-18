import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class LinearEquationRunner {
    public static void main(String[] args ) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.print("Enter coordinate 1: ");
        String firstCoord = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String secondCoord = scan.nextLine();


        int firstX = Integer.parseInt(firstCoord.substring(1, firstCoord.indexOf(",")));
        int firstY = Integer.parseInt(firstCoord.substring(firstCoord.indexOf(",") + 2, firstCoord.length()-1));
        int secondX = Integer.parseInt(secondCoord.substring(1, secondCoord.indexOf(",")));
        int secondY = Integer.parseInt(secondCoord.substring(secondCoord.indexOf(",") + 2, secondCoord.length()-1));

        LinearEquation equation = new LinearEquation(firstX, firstY, secondX, secondY);

        System.out.println(equation.distance());
        System.out.println(equation.slope());
        System.out.println(equation.yIntercept());

    }
}
