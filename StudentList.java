import java.io.*;
import java.text.*;
import java.util.*;



public class StudentList {

	public static Constants constants = new Constants();
	public static String studentName;
	public static void writeFile(String readName){
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(constants.fileName));
			bufferedWriter.flush();
			bufferedWriter.write(readName);
			bufferedWriter.close();
		} catch (Exception e) {}
	}
	public static void readFile(){
		try {
			BufferedReader bufferedReader = new BufferedReader
					(new InputStreamReader
							(new FileInputStream(constants.fileName)));
			studentName = bufferedReader.readLine();
			//bufferedReader.close();
		} catch(Exception e){}
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
			System.out.println(names[new Random().nextInt(names.length)]);
			System.out.println(constants.dataLoad);
		}
		else if(args[0].contains(constants.numAdd)){
			System.out.println(constants.loadData);
			readFile();
			writeFile(studentName + constants.split + args[0].substring(1) + constants.listUpdate + new SimpleDateFormat(constants.dateTime).format(new Date()));
			System.out.println(constants.dataLoad);
		}
		else if(args[0].contains(constants.findName)) {
			System.out.println(constants.loadData);
			readFile();
			String names[] = studentName.split(constants.split);
			int idx;
			for( idx = 0; idx<names.length; idx++) {
				if(names[idx].equals(args[0].substring(1))) {
					System.out.println(args[0].substring(1) +" found at index " +idx);
					break;
				}
			}
			if(idx == names.length){
				System.out.println(args[0].substring(1) +" does not found");
			}

		}
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
	}
}