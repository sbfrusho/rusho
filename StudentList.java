import java.io.*;
import java.text.*;
import java.util.*;



public class StudentList {

	public static Constants constants = new Constants();
	public static String studentName;
//		Write names to the file
	public static void writeFile(String readName){
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(constants.fileName));
			bufferedWriter.flush();
			bufferedWriter.write(readName);
			bufferedWriter.close();
		} catch (Exception e) {}
	}

//		Read names from the file
	public static void readFile(){
		try {
			BufferedReader bufferedReader = new BufferedReader
					(new InputStreamReader
							(new FileInputStream(constants.fileName)));
			studentName = bufferedReader.readLine();
		} catch(Exception e){}
	}
	public static void main(String[] args) {

//		Check arguments
//		Shows the list of names
		if(args[0].equals(constants.showList)) {
			System.out.println(constants.loadData);
			readFile();
			String names[] = studentName.split(constants.split);
			for (String name : names) {
				System.out.println(name);
			}
			System.out.println(constants.dataLoad);
		}

//		Displays a random name
		else if(args[0].equals(constants.randomName)) {
			System.out.println(constants.loadData);
			readFile();
			String names[] = studentName.split(constants.split);
			System.out.println(names[new Random().nextInt(names.length)]);
			System.out.println(constants.dataLoad);
		}

//		Add a name to the file
		else if(args[0].contains(constants.addName)){
			System.out.println(constants.loadData);
			readFile();
			writeFile(studentName + constants.split + args[0].substring(1) + constants.listUpdate + new SimpleDateFormat(constants.dateTime).format(new Date()));
			System.out.println(constants.dataLoad);
		}

//		Checks whether a name exists or not in the file
		else if(args[0].contains(constants.findName)) {
			System.out.println(constants.loadData);
			readFile();
			String names[] = studentName.split(constants.split);
			int idx;
			for(idx = 0; idx<names.length; idx++) {
				if(names[idx].equals(args[0].substring(1))) {
					System.out.println(args[0].substring(1) +" found at index " +idx);
					break;
				}
			}
			if(idx == names.length){
				System.out.println(args[0].substring(1) +" does not found");
			}
		}

//		Counts how many words are in the file
		else if(args[0].contains(constants.countWord)) {
			System.out.println(constants.loadData);
			readFile();
			char names[] = studentName.toCharArray();
			int count=0;
			for(char character:names) {
				if(character == constants.comma){
					count++;
				}
			}
			System.out.println((count+1) + constants.wordFound);
		}

//		To handle wrong passed argument
		else {
			System.out.println(constants.wrongArgument);
		}
	}
}