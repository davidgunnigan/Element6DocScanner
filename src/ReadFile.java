/*

Author: David Gunnigan
24/05/2018

 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile implements Serializable {


    public static List<String> readFile(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        InputStreamReader inputStreamReader = new InputStreamReader(fis);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        List<String> fileList = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            fileList.add(line);
        }
        return fileList;
    }

    public static List<String> deleteEntries(List<String> fileList) {
        List<String> shortenedFile = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            shortenedFile.add(fileList.get(i));
        }
        for (int i = 2; i < fileList.size(); i = i + 3) {
            shortenedFile.add(fileList.get(i));
        }
        return shortenedFile;
    }



    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter source folder: ");

        String input = new String(scanner.nextLine());

        System.out.println("Please enter destination and name of new file: ");

        String output = new String(scanner.nextLine());

       List<String> list = readFile(input);
       File fileName = new File(output);

       List<String> newList = deleteEntries(list);

       try {
           PrintWriter pw = new PrintWriter(fileName);
           //Writer output = new BufferedWriter(pw);
           for (int i = 0; i < newList.size(); i++) {
               pw.printf(newList.get(i).toString() + "%n");
               }
               pw.close();
           } catch (Exception e) {
           System.out.println("cannot create file");
        }
    }


}
