import java.util.ArrayList;

public class BinomialClass {
    
    private String polynomial;

    private int c1;
    private int c2;
    private int c3;
    private int c4;
    private int exp1;
    private int exp2;
    private char sign1 = ' ';
    private char sign2 = ' ';
    private char sign3 = ' ';
    
    private ArrayList<Integer> coefficients = new ArrayList<>();
    private boolean lineOfCoefficients = false;

    public BinomialClass(String polynomial1){
        polynomial = polynomial1;
    }

    public void ElementsOfthePolynomial() {
        int coefficientCounter = 0;
        int exponentCounter = 0;
        
        boolean parenthesysExist = false;

        char[] polynomialChars = polynomial.toCharArray();
        
        boolean containsParenthesesOrX = false;

        for (int i = 0; i < polynomialChars.length; i++) {
            if (polynomialChars[i] == '(' || polynomialChars[i] == 'x') {
                containsParenthesesOrX = true;
                break; // Exit the loop if '(' or 'x' is found
            }
        }
        
        if (!containsParenthesesOrX) {
            lineOfCoefficients = true;
        }

        for (int i = 0; i < polynomialChars.length; i++) {
            if(polynomialChars[i] == '('){
                parenthesysExist = true;
            }
        }

        if (lineOfCoefficients) {
            String[] terms = polynomial.split(" ");
            
        
            for (String term : terms) {
                if (!term.isEmpty()) {
                    coefficients.add(Integer.parseInt(term));
                }
            }
    
        
            // Displaying the coefficients 
            System.out.println("Input data: " + polynomial);
        

            //My algorithm to display three binomials:
            int parenthesysCounter = 0;
            int xCounter = 0;
            for(int i = 0; i<coefficients.size(); i++){

            if(parenthesysCounter == 0){
                System.out.print("(");
                parenthesysCounter++;
            }
            if (coefficients.get(i)>0 && parenthesysCounter!=1) {
                System.out.print("+");

            }else{
                System.out.print(coefficients.get(i));
            }
            if(i%2==0){
                System.out.print("x");
                xCounter++;
                if(coefficients.get(i+1)>0){
                    System.out.print("+");
                }
            }
            if(i%2!=0){
                System.out.print(")");
                parenthesysCounter=0;
            }
        }

        PolynomialClass sendCoefficients = new PolynomialClass(coefficients);
        sendCoefficients.multiplyBinomials();

        CoordinateClass sendCoefficients2 = new CoordinateClass(coefficients);
        sendCoefficients2.computePoints();



    }






    
        //Unfinished methods:
        //A cubic equation factored into two binomials:
        
        if(parenthesysExist == true){

            
            String[] binomials = polynomial.split("\\*"); // Splitting into separate binomials

            for (String binomial : binomials) {
                String[] terms = binomial.split("(?=[+\\-])"); // Splitting terms within each binomial
    
                for (String term : terms) {
                    //System.out.println("Term: " + term);
    
                    boolean foundX = false;
                    boolean foundParenthesis = false;
        
                    char[] termChars = term.toCharArray();
        
                    for (char c : termChars) {
                        if (Character.isDigit(c) && !foundX && !foundParenthesis) {
                            if (coefficientCounter == 0) {
                                c1 = c1 * 10 + (c - '0');
                            } else if (coefficientCounter == 1) {
                                c2 = c2 * 10 + (c - '0');
                            } else if (coefficientCounter == 2) {
                                c3 = c3 * 10 + (c - '0');
                            } else if (coefficientCounter == 3) {
                                c4 = c4 * 10 + (c - '0');
                            }
                        } else if (c == 'x' || c == ')') {
                            foundParenthesis = true;
                            foundX = true;
                            coefficientCounter++;
                        } else if (c == '^' && foundX) {
                            // Handle the exponent
                            exponentCounter++;
                            int index = term.indexOf('^') + 1; // index to start from '^'
                            String exponentChars = term.substring(index).trim();
                            if (exponentCounter == 1) {
                                exp1 = Integer.parseInt(exponentChars);
                            } else if (exponentCounter == 2) {
                                exp2 = Integer.parseInt(exponentChars);
                            }
                        }
                    }
        
                    
                    // Extract signs
                    char[] signs = term.replaceAll("[^+-]", "").toCharArray(); // Extract only '+' and '-' characters

                    // Ensure signs are assigned properly
                    if (signs.length > 0 && sign1 == ' ') {
                        sign1 = signs[0];
                    } else if (signs.length > 0 && sign2 == ' ') {
                        sign2 = signs[0];
                    } else if (signs.length > 0 && sign3 == ' ') {
                        sign3 = signs[0];
                    }               

                }

            }
            
            System.out.println("c1 = " + c1 + " c2 = " + c2 + " c3 = " + c3 + " c4 = " + c4);
            System.out.println("Exponent 1 = " + exp1 + ";" );
            System.out.println("Sign1 = " + sign1 + " Sign2 = " + sign2);
            System.out.println();
        }



        //Factoring the cubic equation:
        
        if (!lineOfCoefficients) {
            
            String[] terms = polynomial.split("(?=\\+|\\-)"); // Splitting the polynomial by + or -
        
            for (String term : terms) {

                boolean foundX = false;
                char[] termChars = term.toCharArray();

                for (char c : termChars) {
                    if (Character.isDigit(c) && !foundX) {
                        if(coefficientCounter==0){
                            c1 = c1 * 10 + (c - '0');
                        }
                        if(coefficientCounter == 1){
                            c2 = c2 * 10 + (c - '0');
                        }
                        if(coefficientCounter == 2){
                            c3 = c3 * 10 + (c - '0');
                        }
                        if (coefficientCounter==3) {
                            c4 = c4 * 10 + (c - '0');                       
                        }

                    } else if (c == 'x') {
                        foundX = true;
                        coefficientCounter++;
                    } else if (c == '^' && foundX) {
                    // Handle the exponent
                        exponentCounter++;
                        int index = 0;
                        char[] exponentChars = new char[termChars.length - (term.indexOf('^') + 1)];
                    for (int i = term.indexOf('^') + 1; i < termChars.length; i++) {
                        exponentChars[index++] = termChars[i];
                    }
                    if(exponentCounter==1){
                        exp1 = Integer.parseInt(new String(exponentChars).trim());
                    }
                    if (exponentCounter==2) {
                        exp2 = Integer.parseInt(new String(exponentChars).trim());
                    }
                }
            }

            }
            System.out.println(polynomial);
            System.out.println("c1 = " + c1 + " c2 = " + c2 + " c3 = " + c3 + " c4 = " + c4);
            System.out.println("Exponent 1 = " + exp1 + "; " + " Exponent 2 = " + exp2);

            //Handling the signs:

            char[] signs = polynomial.toCharArray();
            int signCounter = 0;


            for(char s : signs){
                if(s=='+'||s=='-'){
                    if(signCounter == 0){
                        sign1 = s;
                    }
                    if(signCounter == 1){
                        sign2 = s;
                    }
                    if(signCounter == 2){
                        sign3 = s;

                    }
                    signCounter++;
                } 
            }
            System.out.println("sign1 = " + sign1 + " sign2 = " + sign2 + " sign3 = " + sign3);
            System.out.println("\n");

                FactorPolynomial();

        
        }

        


    }

    

    public void FactorPolynomial(){

        int gcf1;
        int gcf2;
        int newC1;
        int newC2;
        int newC3;
        int newC4;

        char[] polynomialChars = polynomial.toCharArray();

        if (Character.isDigit(polynomialChars[0]) && !lineOfCoefficients) {
            //1 - check if we can factor by grouping:

            if(((c2/c1) != 0) && ((c4/c3) != 0)){

                if(c2/c1 == c4/c3){

                gcf1 = findGCD(c2, c1);
                gcf2 = findGCD(c4, c3);
                
                newC1 = c1/gcf1;
                newC2 = c2/gcf1;
                newC3 = c3/gcf2;
                newC4 = c4/gcf2;

                
                
                System.out.println("Factoring STEP1: ");
                System.out.println(gcf1+"x^2"+"*("+newC1+"x^2"+sign1 + newC2+")" + sign2 + gcf2 + "*(" + newC3 + "x" + sign3 + newC4 + ")\n");
                System.out.println("Factoring STEP2: ");
                System.out.println("(" + newC1 + "x" + sign1 + newC2+")"+"*"+"("+gcf1+"x^2"+sign2+gcf2+")\n\n");
            }

          }  


        }else{
            //write a method to multiply two binomials by each other to get a cubic in a standart form:
        }
    }

    //FindGCD
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

   

    
}
