package p1;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.*;

import org.junit.jupiter.api.Test;

class P1capstoneTest {

	
	@Test 
	void testCsv() throws Exception  {
		File file = P1capstone.getInput();
		String filepath = file.getAbsolutePath();
		String fileExtension = filepath.substring(filepath.length()-4);
		assertEquals(fileExtension, ".csv");
	}
	
	
	@Test 
	void testCorrectChar() {
		//get file name 
		File file = P1capstone.getInput();
		//parse file
		ArrayList<String> array = new ArrayList<String>();
		array = P1capstone.parseFile(file);
		
		int i;
		String regex = "[0-9]+"; 	//regex for numbers
		Pattern p = Pattern.compile(regex);	//pattern for numbers
		Matcher m;						//matcher to check if numbers are in the string
		boolean noNum = true;			//if there are numbers in the string
		
		for (i = 0; i < array.size(); i++) {
			//check if string has number
			m = p.matcher(array.get(i));
			//if match fail the test
			if (m.matches()) {
				noNum = false;
				assertTrue(noNum);
			}
		}
		//if no match pass test
		if (noNum) {
			assertTrue(noNum);
		}
		
	}
	
	@Test
	public void throwsException() {
	    try {
	    	File file = P1capstone.getInput();
	        P1capstone.parseFile(file);
	        fail("Oops! Something went wrong.");
	    } catch (Exception e) {
	        assertEquals(e, "Oops! Something went wrong.");
	    }
	}
}
