package assignment1;

import java.io.*;
import java.util.*;

class Assignment1 {
    public static void task1() {
        System.out.print("Enter the file name: ");
        Scanner scan = new Scanner(System.in);
        String fileName = scan.nextLine();
        System.out.print("Enter the text content: ");
        Scanner scan1 = new Scanner(System.in);
        String textContent = scan1.nextLine();
        try {
            FileWriter myWriter = new FileWriter(fileName + ".txt");
            myWriter.write(textContent);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    public static void task2() {
        System.out.print("Enter the relative path: ");
        Scanner scan = new Scanner(System.in);
        String relativePath = scan.nextLine();
        File file = new File(relativePath);
        if (file.exists()) {
            System.out.println("File exists");
            System.out.println("Total number of files and folders: " + countFilesInDirectory(file));
            System.out.println("Total number of files: " + countFilesInDirectory(file));
            System.out.println("Total number of folders: " + countFilesInDirectory(file));
        } else {
            System.out.println("File does not exist");
        }
    }

    public static int countFilesInDirectory(File directory) {
        int count = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                count++;
            }
            if (file.isDirectory()) {
                count += countFilesInDirectory(file);
            }
        }
        return count;
    }
    public static void main(String[] args) throws java.lang.Exception {
        System.out.println("Enter the task number: ");
        Scanner scan = new Scanner(System.in);
        int taskNumber = scan.nextInt();
        if (taskNumber == 1) {
            task1();
        } else if (taskNumber == 2) {
            task2();
        } else {
            System.out.println("Invalid task number");
     }
}

}