package workingwithfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkingWithFiles {

    public static void main(String[] args) {

        createFile();
        System.out.println("------------------");
        getFileInfo();
        System.out.println("------------------");
        readFile();
        System.out.println("------------------");
        writeFile();
        System.out.println("------------------");
        readFile();

    }

    public static void createFile() {
        File file = new File("D:\\JavaDemos\\Files\\students.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Created File");
            } else {
                System.out.println("The file already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getFileInfo() {
        File file = new File("D:\\JavaDemos\\Files\\students.txt");
        if (file.exists()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("File Path: " + file.getAbsolutePath());
            System.out.println("Is the file writable?: " + file.canWrite());
            System.out.println("Is the file readable?: " + file.canRead());
            System.out.println("File Size (byte): " + file.length());

        }
    }

    public static void readFile() {
        File file = new File("D:\\JavaDemos\\Files\\students.txt");
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter("D:\\JavaDemos\\Files\\students.txt", true);
            fileWriter.write("Hello World!!");
            System.out.println("Written to File");
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
