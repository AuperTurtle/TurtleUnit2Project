public class LinearEquation {
    //initializes instance variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private double roundResult;
    private double distance;
    private double slope;
    private double yIntercept;
    private String chosenPoint;
    private double tempDouble;
    private String tempString;
    private int firstSlopePart;
    private int secondSlopePart;


    //linear equation method uses parsed values
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }



    public double distance() {
        distance = roundedToHundredth(Math.sqrt((Math.pow((x2 - x1), 2) + (Math.pow((y2 - y1), 2)))));
        return distance;
    } //calculates distance using square root and squaring the numbers and then rounds the numbers


    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double yIntercept() {
        yIntercept = roundedToHundredth(y1 - (slope() * x1));
        return yIntercept;
    } //calculates the y intercept by subtracting the firstY by slope * x1


    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double slope() {
        slope = roundedToHundredth(((double) y2 - y1) / ((double) x2 - x1));
        return slope;
    } //calculates the slope by subtracting the y2-y1 and dividing it by the x2-x1 then rounding it


    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

        Here are non-examples of "printable" y-intercepts:
           - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!
     */
    public String equation() {
        firstSlopePart = (y2 - y1);
        secondSlopePart = (x2 - x1);
        //separates the parts of the slope part of the equation

        if (firstSlopePart == 0) {
            return "y = " + (int) yIntercept();
        } //checks if the slope is 0 if it is, then returns the y intercept as the equation

        if (secondSlopePart < 0 && firstSlopePart > 0) {
            secondSlopePart = Math.abs(secondSlopePart);
            firstSlopePart = firstSlopePart * -1;
        } //if the second part of the slope is negative, makes it positive and makes the first part negative

        if (secondSlopePart < 0 && firstSlopePart < 0) {
            firstSlopePart = Math.abs(firstSlopePart);
            secondSlopePart = Math.abs(secondSlopePart);
        } //checks if both the slope parts are negative, if they are then sets them both to positive

        if (firstSlopePart % secondSlopePart == 0) {
            firstSlopePart = firstSlopePart / secondSlopePart;
            secondSlopePart = 1;
        } //if the second slope part is a factor of the first slope part it simplifies the slope

        String tempYIntercept = "";
        if (yIntercept() == 0) {
            tempYIntercept = "";
        } //blank yintercept if yintercept = 0
        if (yIntercept() > 0) {
            tempYIntercept = " + " + yIntercept();
        } //positive y intercept display
        if (yIntercept() < 0) {
            tempYIntercept = " - " + Math.abs(yIntercept());
        } //negative y intercept display

        if (secondSlopePart != 1) {
            if (firstSlopePart == 1) {
                return "y = x" + tempYIntercept;
            } //returns no number next to the slope if it equals 1
            if (firstSlopePart == -1) {
                return "y = -x" + tempYIntercept;
            } //returns a negative slope of 1 if the slope equals -1
            return "y = " + firstSlopePart + "/" + secondSlopePart + "x" + tempYIntercept;
        }
        if (firstSlopePart == 1) {
            return "y = x" + tempYIntercept;
        } //returns no number next to the slope if it equals 1
        if (firstSlopePart == -1) {
            return "y = -x" + tempYIntercept;
        } //returns a negative slope of 1 if the slope equals -1
        return "y = " + firstSlopePart + "x" + tempYIntercept;
    } //end return value if the equation has a positive slope and yintercept


    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue) {
        tempDouble = (slope() * xValue) + yIntercept();
        chosenPoint = "(" + xValue + ", " + tempDouble + ")";
        return chosenPoint;
    } //calculates a yvalue given the xvalue point and puts it in (x,y)


    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth

        HINT:  the Math.round method can help with this!
     */
    public double roundedToHundredth(double toRound) {
        roundResult = ((double) Math.round(toRound * 100)) / 100;
        return roundResult;
    } //rounds the number inputted to the nearest hundredth and returns it as a double


    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method)

      This method should call all other appropriate methods to get the info it needs:
      equation(), slope(), yIntercept(), distance().

      */
    public String lineInfo() {
        String tempString = "The two points are: " + "(" + x1 + ", " + y1 + ") and " + "(" + x2 + ", " + y2 + ")\n";
        tempString += "The equation of the line between these points is: " + equation() + "\n";
        tempString += "The slope of this line is: " + slope() + "\n";
        tempString += "The y-intercept of this line is: " + yIntercept() + "\n";
        tempString += "The distance between the two points is: " + distance();
        return tempString;
    } //combines all the other methods into one to display all the points information
}
