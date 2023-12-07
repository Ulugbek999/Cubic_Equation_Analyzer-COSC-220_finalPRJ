import java.util.ArrayList;
import java.lang.Math;


public class CoordinateClass {

    
    

    //to calculate x and y-intercepts
    private ArrayList<Integer> coefficients = new ArrayList<>();

    //to calculate min and max
    private ArrayList<Integer> coefficients2 = new ArrayList<>();

    private double x1;
    private double x2;
    private double x3;
    private double y_intercept;
    private double pointOfInflection;
    private double pointOfInflection_y_coordinate;



    public CoordinateClass(){}

    public CoordinateClass(ArrayList<Integer> list){
        for(int i= 0; i<list.size(); i++){
            coefficients.add(list.get(i));
        }


    }



    public void computePoints(){

        //compute (x1, o) x-intercept:

        //change the sign of the c2
        coefficients.set(1, coefficients.get(1)*(-1)); 
        x1 = (double)coefficients.get(1)/(double)coefficients.get(0);

        //compute the (x2, 0) x - intercept:
        coefficients.set(3, coefficients.get(3)*(-1)); 
        x2 = (double)coefficients.get(3)/(double)coefficients.get(2);

        //compute the (x3, 0) x - intercept:
        coefficients.set(5, coefficients.get(5)*(-1)); 
        x3 = (double)coefficients.get(5)/(double)coefficients.get(4);


        //The SYSOUTS:

        System.out.println("\nX-intercepts:");
        System.out.print("(" + x1 + "; 0), " + "(" + x2 + "; 0), " + "(" + x3 + "; 0)" );


        //compute y-intercepts:

        y_intercept = coefficients.get(1)*coefficients.get(3)*coefficients.get(5);

        System.out.println("\n\ny-Intercept:\n(0; " + y_intercept + ")");
         System.out.println("\n--------------------------------------------------------\n\n");

    }

    public void minAndMax(ArrayList<Integer> list1){
        for(int i = 0; i<list1.size(); i++){
            coefficients2.add(list1.get(i));
        }


        System.out.println("\n\nRelative Min and Max: ");

        //compute the relative Min and Max: 

        double a, b, c;

        a = coefficients2.get(0);
        b = coefficients2.get(1);
        c = coefficients2.get(2);

        //find the 1st derivative:

        a = a*3;
        b = b*2;

        //solve the square equation to find the x values of the min and max:

        double root1 = ((-1)*b + Math.sqrt((b*b) - 4*a*c))/(2*a);
        double root2 = ((-1)*b - Math.sqrt((b*b) - 4*a*c)) /(2*a);

        // System.out.println("X1 = " + root1);
        // System.out.println("X2 = " + root2);

        //substitute the x values into the original cubic to get the y1 and y2:
        double y1 = (coefficients2.get(0) * Math.pow(root1, 3) + coefficients2.get(1) * Math.pow(root1, 2) + coefficients2.get(2)*root1 + coefficients2.get(3));
        double y2 = (coefficients2.get(0) * Math.pow(root2, 3) + coefficients2.get(1) * Math.pow(root2, 2) + coefficients2.get(2)*root2 + coefficients2.get(3));


        if(y1<y2){
            System.out.println("Min: (" + root1 +"; " + y1 +")");
            System.out.println("Max: (" + root2 +"; " + y2 + ")");

        }else{
            //y1>y2:
            System.out.println("Min: (" + root2 +"; " + y2 + ")");
            System.out.println("Max: (" + root1 +"; " + y1 + ")");
        }

        //Find the point of inflection:

            //find the 2nd derivative:
                a = a*2;
        
        pointOfInflection = (-1)*(b/a);
        pointOfInflection_y_coordinate = (coefficients2.get(0) * Math.pow(pointOfInflection, 3) + coefficients2.get(1) * Math.pow(pointOfInflection, 2) + coefficients2.get(2)*pointOfInflection + coefficients2.get(3));

       displayTheString();


    }

        private void displayTheString(){
            System.out.println(toString());
        }


        public String toString(){

            String s = "\nPoint Of Inflection:\n" + "(" + pointOfInflection +"; " + pointOfInflection_y_coordinate +") ";

            return s;
        }

}
