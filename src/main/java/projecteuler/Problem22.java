/*
 * Names Scores
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

	For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
	
	What is the total of all the name scores in the file?
 */
package projecteuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem22 {

	public static void main(String[] args) throws Exception{

		 ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		 File file = new File(classLoader.getResource("p022_names.txt").getFile());
		 BufferedReader br = new BufferedReader(new FileReader(file));
		  
		  String st;
		  String input[] = null;
		  while ((st = br.readLine()) != null) {
			  input = st.split(",");
		  }
		  List<String> sortedList = Arrays.asList(input);
		  Collections.sort(sortedList);
		  
		  long totalScore = 0;
		  for(int i=0;i<sortedList.size();i++) {
				  int score = 0;
				  int ascii = 0;
				  for(Character c : sortedList.get(i).replace("\"", "").toCharArray()) {
					  ascii = ascii + c - 64;
					  
				  }
				  score = ascii * (i+1);
				  totalScore += score;
		  }
		  System.out.println(totalScore);
		  br.close();
	}
}
