
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;

public class Main{


	public static void main(String[] args) {

		HashMap index = new HashMap();
		
		populateHashMap(index, "testing/");	
		
		boolean again = true;
		
		while (again){
		
			System.out.println("Hi! What do you want to search ??");
			Scanner input = new Scanner(System.in);
			String searchString = input.nextLine();
			again = false;
			System.out.println("\n Let's see if i have found any file . \n" );
			
			search(index, searchString);
		    
			System.out.println("Enter 1 to search again? ");
			int choice = input.nextInt();
			if(choice ==1){
				again = true;
			}
		}
	}
	
	public static String search(HashMap index, String searchString){
		
		Iterator it = index.entrySet().iterator();
		String result="";
	    while (it.hasNext()) {
	    	
	        Map.Entry pair = (Map.Entry)it.next();
	        if(pair.getKey().toString().toLowerCase().contains(searchString.toLowerCase())){
	        	result = (String) pair.getValue();
	        	System.out.println(pair.getKey() + "  ===>  "+ pair.getValue()+"\n");
	        }
	    }
	    it.remove(); 
	    
	    return result;
	}
	
	public static void populateHashMap(HashMap index, String path) {
		File root = new File(path);
		File[] list = root.listFiles();	
		if (list == null) {
			return;
		}
		for (File f : list) {									
			if (f.isDirectory()) {
				index.put(f.getName(),f.getAbsolutePath());
				populateHashMap(index, f.getAbsolutePath());			
			} else {
				index.put(f.getName(),f.getAbsolutePath());
				if(f.getName().endsWith(".txt")){
					BufferedReader br;
					try {
						br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
						String line = null;
						while( (line = br.readLine())!= null ){
							
						    String [] tokens = line.split("\\s+");
						    for(int i=0; i < tokens.length ; i++){
						    	index.put(tokens[i],f.getAbsolutePath());
						    }
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				System.out.println("Indexing ... " + f.getName());
			}
		}
	}
}																	//YourPanel ends