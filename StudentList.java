import java.io.*;
import java.text.*;
import java.util.*;



public class StudentList {

	public static Constants constants = new Constants();
	public static String studentName;
	public static void writeFile(String readName){
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(constants.fileName));
			bufferedWriter.flush();
			bufferedWriter.write(readName);
			bufferedWriter.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static void readFile(){
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(constants.fileName)));
			studentName = bufferedReader.readLine();
			//bufferedReader.close();

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals(constants.showList)) {
			System.out.println(constants.loadData);
			readFile();
			String names[] = studentName.split(constants.split);
			for(String n : names) {
				System.out.println(n);
			}
			System.out.println(constants.dataLoad);
		}
		else if(args[0].equals(constants.randomName)) {
			System.out.println(constants.loadData);
			readFile();
			String names[] = studentName.split(constants.split);
			Random randName = new Random();
			int ind = randName.nextInt(names.length);
			System.out.println(names[ind]);
			System.out.println(constants.dataLoad);
		}
		else if(args[0].contains(constants.numAdd)){
			System.out.println(constants.loadData);
			readFile();
			String name = args[0].substring(1);
			studentName = studentName + constants.split + name;
			//bufferedReader.close();
			Date date = new Date();
			//String dateTime = "dd/mm/yyyy-hh:mm:ss a";
			DateFormat dateFormat = new SimpleDateFormat(constants.dateTime);
			String formattedDate= dateFormat.format(date);
			String readName = studentName + constants.listUpdate + formattedDate;
			writeFile(readName);
			//System.out.println(constants.loadData);
			System.out.println(constants.dataLoad);
		}
		else if(args[0].contains(constants.findName)) {
			System.out.println(constants.loadData);
			readFile();
			String names[] = studentName.split(constants.split);
			boolean done = false;
			String substring = args[0].substring(1);
			for(int idx = 0; idx<names.length && !done; idx++) {
				if(names[idx].equals(substring)) {
					System.out.println(constants.dataFound);
					done = true;
				}
			}
			System.out.println(constants.dataLoad);
		}
		else if(args[0].contains(constants.countWord)) {
			System.out.println(constants.loadData);
			readFile();
			char names[] = studentName.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char character:names) {
				if(character == constants.comma) {
					if (!in_word) {
						count++;
						in_word =true;
					}
					else {
						in_word=false;
					}
				}
			}
			System.out.println(count + constants.wordFound);
			System.out.println(constants.dataLoad);
		}
	}
}
