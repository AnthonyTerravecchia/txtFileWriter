/**
 * Title: txtFileReader
 *
 * Program: This file will read integers text from one 
 * .txt file, remove the repeats, and write
 * them to a new .txt file, it is assumed that,
 * the integers are sorted.
 *
 *Author: Anthony Terravecchia
 *
 */
 
//Anthony Terravecchia
import java.io.*;

public class readWriteTxt
{
	public static void main(String[] args)throws IOException
	{
		int ammount = 0;
		int value = 0;
		int i = -1;
		int max=0 , avg=0 , min=99999999;
		
		//get number of lines in txt 
		//because need it for array length
		try
		{
			BufferedReader in = new BufferedReader(new FileReader("C:/Users/Anthony/Documents/Eclipse/files/src/files/read.txt"));
			
			String line;
			while((line = in.readLine()) != null)
			{
				ammount++;
			}
			in.close();	
		}
		catch(FileNotFoundException e)
	  	{
			System.out.println("FILE NOT FOUND");
	  	}
  	
	  	int data[] = new int[ammount];
	  	
	  	//saves values from txt to array
	  	try
		{
			BufferedReader in = new BufferedReader(new FileReader("C:/Users/Anthony/Documents/Eclipse/files/src/files/read.txt"));
				
			String line;
			while((line = in.readLine()) != null)
			{
				value = Integer.parseInt(line);
				i++;
				data[i] = value;
					
			}
			
			in.close();
			
		}
	  	catch(FileNotFoundException e)
	  	{
			System.out.println("FILE NOT FOUND");
	  	}
  	
	  	int current = data[0];
		boolean found = false;
		
		int newAmmount = ammount;
		
		int tr = 0;
		
		//gets new length of array without duplicates
		for(int j = 0; j < ammount; j++) 
		{
			if(current == data[j] && !found)
			{
		        found = true;
		        newAmmount--;
		    }
		    else if(current != data[j])
		    {
		        current = data[j];
		        found = false;
		    }
		}
		newAmmount++;
		
		int dataOut[] = new int[newAmmount];
		
		int current2 = data[1];
		boolean found2 = false;
		dataOut[0] = data[0];
		for(int j = 1; j < newAmmount; j++) 
		{
			if(current2 == data[j] && !found2)
			{
		        found2 = true;
		        tr++;
		        dataOut[j] = data[j+tr];
		        
		    }
		    else if(current2 != data[j+tr])
		    {
		    	
		    	dataOut[j] = data[j+tr];
		        current2 = data[j+tr];
		        found2 = false;
		    }
		}
		
		String out;
		//write non-duplicate array into new txt file
		try
		{
			PrintWriter writer = new PrintWriter("C:/Users/Anthony/Documents/Eclipse/files/src/files/write.txt");
			
			for(int h = 0; h < newAmmount; h++)
			{
				writer.println(dataOut[h]);
				System.out.println("ONE");
			}		
			
			writer.close();
		}
		catch(FileNotFoundException e)
	  	{
			System.out.println("FILE NOT FOUND");
	  	}
  	
	}
		
}
