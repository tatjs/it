
import java.io.*;
import java.text.Collator;
import java.util.*;

public class StartClient {

    private static final String NamingContextExtHelper = null;

	public static <NamingContextExt> void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            Collator addobj = (Collator) CalculatorImpl.narrow(((Object) ncRef).resolve_str("ABC"));

            Scanner c = new Scanner(System.in);
            System.out.println("Welcome to the Calculator:");
            for (;;) {
                System.out.println("Enter a:");
                String aa = c.nextLine();
                System.out.println("Enter b:");
                String bb = c.nextLine();
                int a = Integer.parseInt(aa);
                int b = Integer.parseInt(bb);
                System.out.println();
                System.out.println("Choose your Calculator operation");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                String op = c.nextLine();
                int opt = Integer.parseInt(op);
                int r;
                switch(opt){
                    case 1:
                        r = ((CalculatorImpl) addobj).add(a, b);
                        System.out.println("The result for addition is : " + r);
                        System.out.println("-----------------------------------");
                        break;
                    
                    case 2:
                        r = ((CalculatorImpl) addobj).subtract(a, b);
                        System.out.println("The result for subtraction is : " + r);
                        System.out.println("-----------------------------------");
                        break;

                    case 3:
                        r = ((CalculatorImpl) addobj).multiply(a, b);
                        System.out.println("The result for multiplication is : " + r);
                        System.out.println("-----------------------------------");
                        break;

                    case 4:
                        r = ((CalculatorImpl) addobj).divide(a, b);
                        System.out.println("The result for division is : " + r);
                        System.out.println("-----------------------------------");
                        break;
                    
                    default:
                        System.out.println("Invalid Option");
                }

                
            }
        } catch (Exception e) {
            System.out.println("Hello Client exception: " + e);
            e.printStackTrace();
        }

    }

}
