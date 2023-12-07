import java.util.ArrayList;

public class MonomialClass {

    private ArrayList<Integer> coefficientsToDisplay = new ArrayList<>();
    private String c1;
    private String c2;
    private String c3;
    private String c4;

    public MonomialClass(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            coefficientsToDisplay.add(list.get(i));
        }

        String plus = "+ ";

        //turning integer coefficients into strings to display the cubic equation:

        //First coefficient:
        c1 = Integer.toString(coefficientsToDisplay.get(0));
        
        //not displaying coefficients if they are equal to '1';
        if (c1.equals("1")) {
            c1 = " ";
        }

        //not display the '1' in the '-1', only the sign;
        if (c1.equals("-1")) {
            c1 = "-";
        }

        //adding the x with the exponent:
        c1 = c1 + "x^3 ";
        

        c2 = Integer.toString(coefficientsToDisplay.get(1));

        //if the character is not negative, then the '+' sign would not be displayed, so we need to add the sign manually:
        if (c2.charAt(0) != '-') { 
            c2 = plus + c2;
        }

        //initializing the coefficient to an empty String, if it is equal to 1:
        if (c2.equals("1")) {
            c2 = " ";
        }

        //initializing the coefficient to an empty String with the '-' sign, if it is equal to a '-1':
        if (c2.equals("-1")) {
            c2 = "- ";
        }

        //manually adding the variable with the exponent:
        c2 = c2 + "x^2 ";


        //Repeating the previous steps for the other two coefficients:        
        c3 = Integer.toString(coefficientsToDisplay.get(2));
        if (c3.charAt(0) != '-') { 
            c3 = plus + c3;
        }
        if (c3.equals("1")) {
            c3 = " ";
        }
        if (c3.equals("-1")) {
            c3 = "-";
        }
        c3 = c3 + "x ";

        c4 = Integer.toString(coefficientsToDisplay.get(3));
        if (c4.charAt(0) != '-') { // Check if the first character of c4 is not '-'
            c4 = plus + c4;
        }
        
        printCubicEquation();
    }


    private void printCubicEquation() {
        System.out.println("\n\nTHE CUBIC EQUATION: \n");
        System.out.println(toString());
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String s = c1 + c2 + c3 + c4;
        return s;
    }

}
