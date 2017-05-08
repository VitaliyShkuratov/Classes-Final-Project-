package data;

import java.io.*;
import java.util.ArrayList;
import business.Transaction;
import business.TransactionList;

	public final class FileHandler {

		private final static String FileTransaction = "../TXT/transaction.txt";
		static File file = new File(FileTransaction);

		public static void writeToTxtFile(ArrayList<Transaction> arrayList)
		{
			try {
				
				file.getParentFile().mkdir();
				PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
				//PrintWriter write = new PrintWriter(new FileOutputStream(file));
			    for(Transaction current : TransactionList.getTransactionList())
			    	write.println(current);
			    
			    write.close(); 
			    
			} catch(Exception ex) {
			    ex.printStackTrace();
			}
		}
		
		public static void readFromTxtFile()
		{

	        // This will reference one line at a time
	        String line = null;

	        try {
	            FileReader fileReader = new FileReader(file);

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);

	            while((line = bufferedReader.readLine()) != null) {
	                System.out.println("\t" + line);
	            }   

	            bufferedReader.close();         
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                file + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + file + "'");                  
	        }
	    }
}

