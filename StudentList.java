import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String name = bufferedReader.readLine();
				String names[] = name.split(", ");
				for(String n : names) {
					System.out.println(n);
				}
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String name = bufferedReader.readLine();
				//System.out.println(r);
				String names[] = name.split(", ");
				Random randName = new Random();
				int ind = randName.nextInt(names.length);
				System.out.println(names[ind]);
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String names = bufferedReader.readLine();
				String name = args[0].substring(1);
				names = names + ", " + name;
				bufferedReader.close();

				BufferedWriter bufferedWriter = new BufferedWriter(
						new FileWriter("students.txt", false));
				bufferedWriter.flush();
				Date date = new Date();
				String dateTime = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateTime);
				String formattedDate= dateFormat.format(date);
				bufferedWriter.write(names + "\nList last updated on "+formattedDate);
				bufferedWriter.close();
			} catch (Exception e){

			}

			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String name = bufferedReader.readLine();
				String names[] = name.split(",");
				boolean done = false;
				String substring = args[0].substring(1);
				for(int idx = 0; idx<names.length && !done; idx++) {
					if(names[idx].equals(substring)) {
						System.out.println("We found it!");
						done=true;
					}
				}
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("c")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String name = bufferedReader.readLine();
				char names[] = name.toCharArray();
				boolean in_word = false;
				int count=0;
				for(char character:names) {
					if(character ==',') {
						if (!in_word) {
							count++;
							in_word =true;
						}
						else {
							in_word=false;
						}
					}
				}
				System.out.println(count +" word(s) found ");
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
	}
}
