import java.io.BufferedReader;
import java.io.FileReader;

public class CountWords {

    public static void main (String args[]) throws Exception {

       System.out.println ("Counting Words");
       FileReader fr = new FileReader ("c:\\Customer1.txt");
       BufferedReader br = new BufferedReader (fr);
       String line = br.readLin ();
       int count = 0;
       while (line != null) {
          String []parts = line.split(" ");
          for( String w : parts)
          {
            count++;
          }
          line = br.readLine();
       }
       System.out.println(count);
    }
}
