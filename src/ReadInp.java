import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReadInp {
	   public static void main(String args[]) throws IOException {
	      // Create a BufferedReader using System.in
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      String str;
	      System.out.println("Enter lines of text. Enter 'end' to quit.");
	      do {
	         str = br.readLine();
	         System.out.println(str);
	      } while(!str.equals("end"));
	   }
}
