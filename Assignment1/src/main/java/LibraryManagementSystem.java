import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
public class LibraryManagementSystem{
    public static Scanner input = new Scanner(System.in);
    public static void main(String args[]) {

        int temp=0;
        String temp2;
        while (temp!=6) {
            System.out.println("\nPress 1 if you want to add a book");
            System.out.println("Press 2 if you want to add a user");
            System.out.println("Press 3 if you want to search a book");
            System.out.println("Press 4 if you want to checkout a book");
            System.out.println("Press 5 if you want to return a book");
            System.out.print("Press 6 if you want to exit : ");
            try {
                temp = input.nextInt();
            }
            catch (Exception e){
                temp2=input.nextLine();
                System.out.println("Invalid Input");
                continue;
            }
            if (temp == 1)
                Library.addBook();
            else if (temp == 2)
                Library.addUser();
            else if (temp == 3)
                Book.book_search();
            else if (temp == 4) {
                User.checkout_book();
            } else if (temp == 5) {
                User.return_book();
            } else if (temp == 6) {
                continue;
            }
            else System.out.println("Invalid Input");
        }
        Library.save();
    }
}