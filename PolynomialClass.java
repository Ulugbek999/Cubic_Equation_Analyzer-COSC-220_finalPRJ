import java.util.ArrayList;


public class PolynomialClass {

    private    int newC1;
    private    int newC2;
    private    int newC3;
    private    int newC4;
    private    int newC2C3;
    private    int newC1C5;
    private    int newC1C6;
    private    int newC2C3C5;
    private    int newC2C3C6;
    private    int newC4C5;
    private    int newC4C6;
    private    int finalC2;
    private    int finalC3;

    private ArrayList<Integer> coefficients = new ArrayList<>();
    private ArrayList<Integer> finalCoefficient = new ArrayList<>();

    public PolynomialClass(){}

    public PolynomialClass(ArrayList<Integer> list){

        for (int i = 0; i < list.size(); i++) {
            coefficients.add(list.get(i));
        }
    }

    public void multiplyBinomials(){

        newC1 = coefficients.get(0) * coefficients.get(2);
        newC2 = coefficients.get(0) * coefficients.get(3);
        newC3 = coefficients.get(1) * coefficients.get(2);
        newC4 = coefficients.get(1) * coefficients.get(3);
        newC2C3 = newC2+newC3;

        newC1C5 = newC1*coefficients.get(4);
        newC1C6 = newC1*coefficients.get(5);
        newC2C3C5 = newC2C3 * coefficients.get(4);
        newC2C3C6 = newC2C3 * coefficients.get(5);
        newC4C5 = newC4 * coefficients.get(4);
        newC4C6 = newC4 * coefficients.get(5);
        finalC2 = newC1C6 + newC2C3C5;
        finalC3 = newC2C3C6 + newC4C5;

        finalCoefficient.add(newC1C5);
        finalCoefficient.add(finalC2);
        finalCoefficient.add(finalC3);
        finalCoefficient.add(newC4C6);

        //send each coefficient to the MonomialClass, to check them before displaying:
        MonomialClass sendFinalCoefficients = new MonomialClass(finalCoefficient);

        //send the final coefficients to the CoordinateClass:
        CoordinateClass sendCoefficientsTo = new CoordinateClass();
        sendCoefficientsTo.minAndMax(finalCoefficient);
        
    }

}