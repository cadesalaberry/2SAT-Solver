import java.io.*;
import java.util.*;

// Framework for assignment 2
public class Assig2 {

    // Reads input from stdin or a specified file.  Accepts an optional command-line argument,
    // a flag to indicate whether to use a simple brute-force solution
    // or not.
    public static void main(String[] args) {
        
        boolean bruteForce = true;

        Scanner inp = new Scanner(System.in);

        for (int i=0;i<args.length;i++) {
            if (args[i].equals("-nobrute"))
                bruteForce = false;  // don't use brute force, use clever algorithm
            else {
                try {
                    inp = new Scanner(new File(args[i]));
                } catch(FileNotFoundException e) {
                    System.out.println("File not found: "+args[i]);
                    System.exit(1);
                }
            }
        }

        if (bruteForce) {
        	if(bruteForce(inp)) System.out.println("yes");
        } else {
        	System.out.println("Smart method not implemented yet.");
        }
    }
    
    /**
     * Default code used as a sample.
     * 
     * @param inp
     */
    public static void bullshit(Scanner inp) {
    	Scanner intScan = new Scanner(inp.nextLine());

        // first read in number of vars involved
        int numV = intScan.nextInt();

        // then read in each disjunction
        while (inp.hasNextLine()) {
            String s = inp.nextLine();
            intScan = new Scanner(s);

            // read in a disjunction: (a \/ b) represented by 2 integers separated by whitespace
            // each variable is represented by a number in the range 1..numV, or -numV..-1
            // (negative numbers represent logically negated values)
            int a = intScan.nextInt();
            int b = intScan.nextInt();
            //System.out.println("Read "+a+" and "+b);
        }
    }
    /**
     * Make sure not to parse the input before passing it.
     * The Iterator should be at the beginning of the file in
     * order for the bruteForce to work correctly.
     * 
     * @param input
     * @return
     */
    public static boolean bruteForce(Scanner input) {
    	
    	boolean evaluatable = false;
    	
    	// first read in number of vars involved
        int numV = input.nextInt();
        
        int tries = (int) Math.pow(2, numV);
        
        for (int j = 0; j < tries; j++) {
        
        	String binaryRepresentation = Integer.toBinaryString(j);
        	System.out.println("Looping: " + binaryRepresentation);
        	
	    	for (int i = 0; i < numV && !evaluatable; i++) {
	    		
	    		int iFirst = input.nextInt();
	    		int iSecond = input.nextInt();
	    		
	    		// Assigns correct sign according to j:
	    		// ie. 10011 means true-false-false-true-true
	    		try {
	    			if (binaryRepresentation.charAt(Math.abs(iFirst)-1) == '0') {
	    				iFirst *= -1;
	    			}
	    		} catch (StringIndexOutOfBoundsException e){}
	    		try {
		    		if (binaryRepresentation.charAt(Math.abs(iSecond)-1) == '0') {
		    			iFirst *= -1;
		    		}
	    		} catch (StringIndexOutOfBoundsException e){}
	    		
	    		System.out.println("Trying: " + binaryRepresentation);
	    		evaluatable = evaluatable || evaluateOr(iFirst, iSecond);
	    		
	    	}
	    	if (evaluatable) {
	    		
	    		System.out.println(binaryRepresentation + " worked. I am proud of you.");
	    		return true;
	    	}
        }
    	return false;
    }
    
    public static boolean evaluateOr(int a, int b) {
    	 return a > 0 || b > 0;    	
    }
    
    public static boolean evaluateAnd(int a, int b) {
   	 return a > 0 && b > 0;    	
   }
}
