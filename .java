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
			BufferedReader in = new BufferedReader(new FileReader("H:/Java/readWriteTxt/read.txt"));
			
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
			BufferedReader in = new BufferedReader(new FileReader("H:/Java/readWriteTxt/read.txt"));
				
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
		System.out.println(ammount);
		int newAmmount = 0;
		
		int tr = 0;
		
		//gets new length of array without duplicates
		for(int j = 0; j < ammount; j++) 
		{
			if(current == data[j] && !found)
			{
		        found = true;
		    }
		    else if(current != data[j])
		    {
		        current = data[j];
		        found = false;
		        newAmmount++;
		    }
		}
		newAmmount++;
		System.out.println(newAmmount);
		
		int dataOut[] = new int[newAmmount];
		
		int current2 = data[0];
		boolean found2 = false;
		for(int j = 0; j < newAmmount; j++) 
		{
			if(current2 == data[j] && !found2)
			{
		        found2 = true;
		        dataOut[j] = data[j];
		    }
		    else if(current2 != data[j])
		    {
		    	dataOut[j] = data[j];
		        current2 = data[j];
		        found2 = false;
		    }
		}
		System.out.println("***********");
		for(int p = 0; p<newAmmount; p++)
		{
			System.out.println(dataOut[p]);
		}
		
		String out;
		//write non-duplicate array into new txt file
		try
		{
			PrintWriter writer = new PrintWriter("H:/Java/readWriteTxt/write.txt");
			
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
