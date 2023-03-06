package com.wipro.utilities;

import java.io.FileWriter;
import java.io.IOException;

public class WriteIntoFile {
	
	public static void writeData(String prodName, String prodPrize) {
		FileWriter fw;
		try {
			fw = new FileWriter("src\\test\\resources\\outputData\\Prize.txt");
			
			fw.write(prodName);
			fw.write("\t" + prodPrize);
			fw.close();
		} catch (IOException ioe) {
			System.out.println("some issue in writing into file");
		}
	}
	
}
