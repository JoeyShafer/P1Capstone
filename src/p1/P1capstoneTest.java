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
		File file = P1capstone.getInput();
		ArrayList<String> array = new ArrayList<String>();
		array = P1capstone.parseFile(file);
		int i;
		String regex = "[0-9]+";
		Pattern p = Pattern.compile(regex);
		Matcher m;
		for (i = 0; i < array.size(); i++) {
			m = p.matcher(array.get(i));
			if (m.matches()) {
				fail("Contains incorrect characters");
			}
		}
		
	}
}
