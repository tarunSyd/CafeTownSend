package Utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReport {
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = "\\Users\\tarunbansal\\Desktop\\Automation Results\\Reports\\TestAutomationResults"+commonMethods.GetCurrentDate()+".html";
			extent =new ExtentReports(Path, false);
			return extent;
	}
	
	
	//These below methods are not used anywhere. I am keeping these for future reference.
	public static void WriteToTextFile(String filePath)
	{
		try {
			File file = new File("\\Users\\tarunbansal\\Desktop\\Automation Results\\Reports\\filename.txt");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(filePath);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ReadTextFile()
	{
		try {
		File file = new File("\\Users\\tarunbansal\\Desktop\\Automation Results\\Reports\\filename.txt");
		// if file doesnt exists, then create it
		if (!file.exists()) {
	       file.createNewFile();
		}
           long length = file.length();
           System.out.println(length);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	
	
	public static boolean CheckFileName(String filePath)
	{
			
    	String dirName="\\Users\\tarunbansal\\Desktop\\Automation Results\\Reports\\";
	    File dir = new File(dirName);
	    File[] dir_contents = dir.listFiles();
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(filePath))
	   //     	globalPath = filePath;
	            return true;
	            }

	    return false;
	}
}


