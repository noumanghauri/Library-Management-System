import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
public class User {
    private int user_ID, no_books_taken = 0;
    private long contact_number;
    private String user_name;
    private ArrayList<Integer> book_taken = new ArrayList<Integer>();

    User() {
        assigntoUser_ID();
        System.out.print("Enter the name of the User : ");
        String temp = LibraryManagementSystem.input.nextLine();
        user_name = LibraryManagementSystem.input.nextLine();
        assigntoUser_name(user_name);
        assigntoContact_number();
    }

    public void assigntoUser_ID() {
        System.out.print("\nEnter the ID of the user : ");
        try {
            user_ID = LibraryManagementSystem.input.nextInt();
        } catch (Exception e) {
            System.out.print("Invalid user ID.");
            String temp = LibraryManagementSystem.input.nextLine();
            assigntoUser_ID();
        }

        if (user_ID < 0) {
            System.out.print("Invalid user ID.");
            assigntoUser_ID();
            return;
        }
    }

    public void assigntoContact_number() {
        System.out.print("Enter the contact number of the user : ");
        try {
            contact_number = LibraryManagementSystem.input.nextLong();
        } catch (Exception e) {
            System.out.print("Invalid contact.");
            String temp = LibraryManagementSystem.input.nextLine();
            assigntoUser_ID();
        }

        if (contact_number < 0) {
            System.out.print("Invalid user ID.");
            assigntoContact_number();
            return;
        }
    }

    private void assigntoUser_name(String user_name) {
        if (user_name.isBlank()) {
            System.out.print("Invalid author name.\nRe-enter the author name : ");
            String temp = LibraryManagementSystem.input.nextLine();
            user_name = LibraryManagementSystem.input.nextLine();
            assigntoUser_name(user_name);
            return;
        }
    }



    public int getUser_ID() {
        return user_ID;
    }

    public ArrayList<Integer> getBook_taken() {
        return this.book_taken;
    }

    public long getContact_number() {
        return contact_number;
    }

    public String getUser_name() {
        return user_name;
    }

    public int getNo_books_taken() {
        return no_books_taken;
    }

    public static int user_search(int user_ID)//returns index of the user in the arraylist from the user id
    {
        int i = 0;
        for (; i < Library.getNo_of_users(); i++) {
            if (Library.Total_users.get(i).getUser_ID() == user_ID)
                return i;
        }
        if (i > Library.getNo_of_users()) {
            System.out.println("The user doesn't exist");
            return -1;
        }
        return -1;
    }



    public static void return_book(){
        int user_id=0, book_id=0;
        System.out.println("Enter the User id ");
        try{
            user_id= LibraryManagementSystem.input.nextInt();
        }
        catch (Exception e){
            System.out.print("Invalid book ID.");
            checkout_book();
        }

        if (user_id<0) {
            System.out.print("Invalid book ID.");
            checkout_book();
            return;
        }
        System.out.println("Enter the Book id");
        try{
            book_id= LibraryManagementSystem.input.nextInt();
        }
        catch (Exception e){
            System.out.print("Invalid book ID.");
            checkout_book();
        }

        if (book_id<0) {
            System.out.print("Invalid book ID.");
            checkout_book();
            return;
        }
        int user_index = user_search(user_id);
        if (user_index<0)
        {
            System.out.println("The user doesn't exist.");
            return;
        }
        int book_index = Book.book_search_by_id(book_id);
        if (book_index<0)
        {
            System.out.println("The book doesn't exist.");
            return;
        }
        int i=0,temp=0;
        for(;i<= Library.Total_users.get(user_index).book_taken.size();i++)
        {
            temp=Library.Total_users.get(user_index).book_taken.get(book_index);
            if(temp==book_id)
                break;
        }
        if (i>Library.Total_users.get(user_index).book_taken.size())
        {
            System.out.println("The user doesn't have this book");
            return;}

        else
        {
            Library.Total_users.get(user_index).book_taken.remove(i);
            Library.Total_users.get(user_index).no_books_taken--;
            Library.Total_books.get(book_index).setAvailability_no(1);

        }
    }
    public static void checkout_book(){
        int user_id=0, book_id=0;
        System.out.println("Enter the User id ");
        try{
            user_id= LibraryManagementSystem.input.nextInt();
        }
        catch (Exception e){
            System.out.print("Invalid book ID.");
            checkout_book();
        }

        if (user_id<0) {
            System.out.print("Invalid book ID.");
            checkout_book();
            return;
        }
        System.out.println("Enter the Book id");
        try{
            book_id= LibraryManagementSystem.input.nextInt();
            System.out.print("Input ha ya");
        }
        catch (Exception e){
            System.out.print("Invalid book ID.");
            checkout_book();
        }

        if (book_id<0) {
            System.out.print("Invalid book ID.");
            checkout_book();
            return;
        }
        int user_index = user_search(user_id);
        if (user_index<0)
        {
            System.out.println("The user doesn't exist.");
            return;
        }
        int book_index = Book.book_search_by_id(book_id);
        if (book_index<0)
        {
            return;
        }
        Library.Total_users.get(user_index).book_taken.add(Library.Total_users.get(user_index).no_books_taken++, book_id);
        Library.Total_books.get(book_index).setAvailability_no(-1);
    }
}

