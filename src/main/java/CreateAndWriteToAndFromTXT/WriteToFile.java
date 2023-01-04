package CreateAndWriteToAndFromTXT;
// Class is written by Patrick Machalet s203932

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
// Inspired by w3schools.com/java/java_files_create.asp, 12.11.22

public class WriteToFile {

    public void WriteToFile(String fileName, String textToFile, int lineNumber){
        try{
            FileWriter fileWriter = new FileWriter(fileName, true);
           // FileReader fileReader = new FileReader(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
           // BufferedReader bufferedReader = new BufferedReader(fileReader);
            int i=2;
            String string ="";
            while(i<=lineNumber){
                fileWriter.append("\n");

                //fileWriter.write("\n");
                fileWriter.flush();
                System.out.println(string);
                i++;
            }
            bufferedWriter.write(textToFile);
            bufferedWriter.flush();
            //fileReader.close();
            fileWriter.close();
            bufferedWriter.close();
           // bufferedReader.close();
            System.out.println("\""+textToFile+"\" has succesfully added to the file: "+fileName);
        }catch(IOException error){
            System.out.println(error);
            error.printStackTrace();
        }


    }

}
