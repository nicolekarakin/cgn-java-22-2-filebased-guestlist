package de.neuefische.cgnjava222.guestlist;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Guestlist {

    public static final Path PATH = Path.of("guests.txt");

    public List<String> getGuests() throws IOException {
        return Files.readAllLines(PATH);
    }

    public void setGuests(List<String> guests) throws IOException {
        String fileContent;
        if (guests.isEmpty()) {
            fileContent = "";
        } else {
            fileContent = String.join("\n", guests) + "\n";
        }
        Files.writeString(PATH, fileContent);
    }

    private void toFile1(){
        String fileName = "my-file.txt";
        String encoding = "UTF-8";
        try{
            PrintWriter writer = new PrintWriter(fileName, encoding);
            writer.println("The first line");
            writer.println("The second line");
            writer.close();
        }
        catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void toFile2(){
        String fileName = "my-file.txt";
        try{
            List<String> lines = Arrays.asList("The first line", "The second line");
            Path file = Paths.get(fileName);
            Files.write(file, lines, StandardCharsets.UTF_8);
        }
        catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void toFile3(){
        Charset utf8 = StandardCharsets.UTF_8;
        List<String> list = Arrays.asList("This is the first line", "This is the second line");
        String content = "This is my content";

        try
        {
            //File name with path
            String fileName = "my-file.txt";
            File myFile = new File(fileName);
            FileOutputStream fos = new FileOutputStream(myFile);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Writer writer = new BufferedWriter(osw);
            //Write data using a String variable
            writer.write(content + "\n");

            //Write data from an ArrayList
            for (String s : list) {
                writer.write(s + "\n");
            }
        }
        catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void toFile4(){
        try {
            FileWriter myWriter = new FileWriter("my-file.txt");
            myWriter.write("We can also create a file and write to it using FileWriter");
            myWriter.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
