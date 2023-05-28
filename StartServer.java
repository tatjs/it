import java.util.Properties;

class CalculatorImpl extends CalculatorPOA {
private ORB orb;

    public void setORB(ORB orb_val) {
    orb = orb_val; 
    }

    // implement add() method
    public int add(int a, int b) {
        int r=a+b;
        return r;
    }

// implement subtract() method
    public int subtract(int a, int b) {
        int r=a-b;
        return r;
    }

    // implement multiply() method
    public int multiply(int a, int b) {
        int r=a*b;
        return r;
    }

    // implement divide() method
    public int divide(int a, int b) {
        int r=a/b;
        return r;
    }

    // implement shutdown() method
    public void shutdown() {
    orb.shutdown(false);
    }
}   



/*---------------------------------*/

 
public class StartServer {
 
  public static void main(String args[]) {
    try{
      // create and initialize the ORB //// get reference to rootpoa &amp; activate the POAManager
      ORB orb = ORB.init(args, null);      
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();
 
      // create servant and register it with the ORB
      CalculatorImpl addobj = new CalculatorImpl();
      addobj.setORB(orb); 
 
      // get object reference from the servant
      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(addobj);
      Calculator href = CalculatorHelper.narrow(ref);
 
      org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
 
      NameComponent path[] = ncRef.to_name( "ABC" );
      ncRef.rebind(path, href);
 
      System.out.println("Calculator Server ready and waiting ...");
 
      // wait for invocations from clients
      for (;;){
      orb.run();
      }
    } 
 
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
 
      System.out.println("HelloServer Exiting ...");
 
  }
}
