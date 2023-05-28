import java.net.MalformedURLException;
import java.rmi.*;
import java.util.Scanner;
public class Client{
public Client(){
}
public static void main(String args[]) throws RemoteException, MalformedURLException, NotBoundException{
int radius;
Scanner in = new Scanner(System.in);
System.out.println("Enter the radius of the circle");
radius=in.nextInt();
circleInterface c=(circleInterface) Naming.lookup("rmi://localhost:101/circle"); 
System.out.println("The area of the circle is "+c.Area(radius)); 
System.out.println("The perimeter of the circle is "+c.perimeter(radius));
}
}
