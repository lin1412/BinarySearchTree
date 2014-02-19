package Minor.P2.DS;
// This is a reduced version of the test driver I'm actually using.
// To use it, you need to put your BST.java file in the Minor/P2/DS
// folder.  
//
// To run this initially, you also need to specify the argument "-prof",
// either on the command-line or via Run Configurations/Arguments dialog 
// in Eclipse.
//
// The test class Monk uses random number generation to vary the data
// values that are used on each run.  If you want to repeat testing with
// the same data used on the previous run, omit the argument "-prof"
// and the driver will retrieve the old random seed and use to initialize
// the test class to reproduce the same test data as on the previous run.
//

import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;


public class testDriver {
	
	public static void main( String[] args ) throws IOException {
		
		String logName = new String("Summary.txt");
		boolean profMode = false;
		if ( args.length > 0 )
			profMode = true;
		if ( profMode ) {
			logName = "prof" + logName;
		}
		FileWriter Log;
		try {
			Log = new FileWriter(logName);
		}
		catch ( IOException e ) {
			System.out.println("Error creating log file: " + logName);
			System.out.println("Exiting...");
			return;
		}
		
		long randSeed = 0;
		if ( profMode ) {
			randSeed = System.currentTimeMillis();
			FileOutputStream f = new FileOutputStream("Seed.txt");
			DataOutputStream Seed = new DataOutputStream(f);
			Seed.writeLong(randSeed);
			Seed.close();
		}
		else {
            try {
			   FileInputStream Seed = new FileInputStream("Seed.txt");
			   DataInputStream Sd = new DataInputStream(Seed);
			   randSeed = Sd.readLong();
			   Seed.close();
            }
            catch ( FileNotFoundException e ) {
               System.out.println("Error: no seed file found.");
               System.out.println("Execute first with a command-line parameter to generate a seed file.");
               return;
            }
		}
		Monk M = new Monk( profMode, randSeed);
   	    String Prefix = null;
	    Prefix = M.writePoints(0);
		
		// wrap each test call in a try block to catch bad pointer exceptions locally
		try {
		   try {
	          if ( M.checkTreeInitialization() ) {
			     Log.write(Prefix + "Passed:  check of BST initialization.\n");
		      }
		      else {
			     Log.write(Prefix + "Failed:  check of BST initialization.\n");
			     Log.write(Prefix + "Aborting remainder of BST testing due to this error.\n");
				 Log.close();
		      }
		   }
		   catch ( Exception e ) {
			  Log.write(Prefix + "Unexpected exception caught during test of BST initialization.\n");
			  Log.write(Prefix + "Likely cause would be a bad pointer.\n");
			  Log.write(Prefix + "Aborting remainder of BST testing due to this error.\n");
			  Log.close();
			  return;
		   }
		   
		   try {
		      if ( M.checkInsertion() ) {
			     Log.write(Prefix + "Passed:  check of BST insertion.\n");
		      }
		      else {
			     Log.write(Prefix + "Failed:  check of BST insertion.\n");
			     Log.write(Prefix + "Aborting remainder of BST testing due to this error.\n");
				 Log.close();
		      }
		   }
		   catch ( Exception e ) {
				  Log.write(Prefix + "Unexpected exception caught during test of BST insertion.\n");
				  Log.write(Prefix + "Likely cause would be a bad pointer.\n");
				  Log.write(Prefix + "Aborting remainder of BST testing due to this error.\n");
				  Log.close();
				  return;
		   }		
		}
		catch ( IOException e ) {
			System.out.println("IOException occurred during testing.\n");
			return;
		}
		catch ( Exception e ) {
			System.out.println("Exception occurred during testing.\n");
			return;
		}
		
		try {
			Log.close();
		}
		catch ( IOException e ) {
			System.out.println("Error closing log file.");
		}
	}
}
