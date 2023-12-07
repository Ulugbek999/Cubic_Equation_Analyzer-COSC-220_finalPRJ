import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


    public class main {


        public static void main(String[] args) {
            String fileName = "input.txt";
            File file = new File(fileName);    
        try{
            
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
    
            String line;
    
            while ((line = bufferedReader.readLine()) != null) {
                BinomialClass binomials = new BinomialClass(line);
                binomials.ElementsOfthePolynomial();
            }
    
            bufferedReader.close();
            fileReader.close();
    
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}


