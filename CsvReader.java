package csvreader;

import java.util.*;
import java.io.*;


public class CsvReader {
	File file;
	String [] values = new String [100];
	
	
	public  CsvReader(String s){
		try{
			this.file= new File (s);
			
			Scanner scan = new Scanner (file);
			
			while(scan.hasNextLine()){
				int i=0;
				while (scan.next() != null);{
					
					String Data = scan.next();
					String[] now =  Data.split(",");
					values[i] = now[0];
					
					System.out.println(values[i]+i);
					i++;
				}
			}
		} catch (Exception ex){
				System.out.println(ex.getMessage());
				System.exit(1);
			}
			
		
	}
	
	void setSeparator(char c){
		this.setSeparator(c);
	}
	
	void AfficherCsv(){
		for(int i = 0 ;i<values.length || values[i]== null;i++){
			System.out.println("dans la case " +i+ "il y a"+this.values[i]);
		}
	}
	
	void setFile(String s){
		
	}
	
	public void readFile(String s){
		try{
			File file= new File (s);
			Scanner scan = new Scanner (file);
			
			while(scan.hasNextLine()){
				System.out.println(scan.nextLine());
			}
		} catch (Exception ex){
				System.out.println(ex.getMessage());
				System.exit(1);
			}
			
		
	}

}
