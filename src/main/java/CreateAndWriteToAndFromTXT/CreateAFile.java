package CreateAndWriteToAndFromTXT;
// Class is written by Patrick Machalet s203932
import java.io.File;
import java.io.IOException;

//This method is inspired by https://www.w3schools.com/java/java_files_create.asp, 12.11.22
public class CreateAFile {
   // public static void main(String[] args){
        //CreateAFile("FuckOff");
    //}

    public void CreateAFile(String name){
        try{
            File file = new File(name+".txt");
            if(file.createNewFile()){
                System.out.println("File has been created: "+name+".txt");
            }else{
                System.out.println("File already exists");
            }
        }catch (IOException error){
            System.out.println(error);
            error.printStackTrace();
        }


    }

}
