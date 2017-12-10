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
import java.util.HashSet;
import java.util.Set;

public class readWriteTxt
{
	public static void main(String[] args)throws IOException
	{
		int ammount = 0;
		
		//finds the number of lines in the .txt for the array
		try
		{
			BufferedReader in = new BufferedReader(new FileReader("C:/Users/Anthony/Documents/Eclipse/files/bin/files/read.txt"));
			
			while((in.readLine()) != null)
			{
				ammount++;
			}
			in.close();	
		}
		catch(FileNotFoundException e)
	  	{
			System.out.println("FILE NOT FOUND");
	  	}
		
		//initialize array
	  	int data[] = new int[ammount];
	  	
	  	//stores values from .txt to an array
	  	try
		{
			BufferedReader in = new BufferedReader(new FileReader("C:/Users/Anthony/Documents/Eclipse/files/bin/files/read.txt"));
			
			int value = 0;
			int i = 0;
			String line;
			
			while((line = in.readLine()) != null)
			{
				value = Integer.parseInt(line);
				data[i] = value;
				i++;	
			}
			
			in.close();
			
		}
	  	catch(FileNotFoundException e)
	  	{
			System.out.println("FILE NOT FOUND");
	  	}
  	
		//sets do not contain duplicate integers 
		//this stores the integers into a set and saves it to a new array
		Set<Integer> set = new HashSet<Integer>();
		
		for(int num : data)
		{
			set.add(num);
		}
		
		Integer[] dataOut = set.toArray(new Integer[0]);
		
		//writes new array into .txt file
		try
		{
			PrintWriter writer = new PrintWriter("C:/Users/Anthony/Documents/Eclipse/files/bin/files/write.txt");
			
			for(int h = 0; h < dataOut.length; h++)
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
