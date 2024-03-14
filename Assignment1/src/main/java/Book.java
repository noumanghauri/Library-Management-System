import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Book{
    private int book_ID,availability_no;
    private String title,author,genre;
    Book()
    {
        assigntoBook_ID();
        title = LibraryManagementSystem.input.nextLine();
        System.out.print("Enter the name of the book : ");
        title = LibraryManagementSystem.input.nextLine();
        assigntoTitle(title);

        System.out.print("Enter the name of the author : ");
        author = LibraryManagementSystem.input.nextLine();
        assigntoAuthor(author);

        System.out.print("Enter the genre of the book : ");
        genre = LibraryManagementSystem.input.nextLine();
        assigntoGenre(genre);

        assigntoAvailability_no();
    }

    //setters
    private void assigntoAvailability_no() {
        System.out.print("Enter the number of books available : ");
        try{
            availability_no= LibraryManagementSystem.input.nextInt();}
        catch (Exception e){
            System.out.print("Invalid no of copies.");
            String temp = LibraryManagementSystem.input.nextLine();
            assigntoAvailability_no();
        }
        if (availability_no<0) {
            System.out.print("Invalid no of copies.\nRe-entry the availability number : ");
            String temp = LibraryManagementSystem.input.nextLine();
            assigntoAvailability_no();
            return;
        }
    }

    private void assigntoBook_ID() {
        System.out.print("\nEnter the ID of the book : ");
        try{
            book_ID= LibraryManagementSystem.input.nextInt();
        }
        catch (Exception e){
            System.out.print("Invalid book ID.");
            String temp = LibraryManagementSystem.input.nextLine();
            assigntoBook_ID();
        }

        if (book_ID<0) {
            System.out.print("Invalid book ID.");
            assigntoBook_ID();
            return;
        }
    }

    private void assigntoAuthor(String author) {
        if(author.isBlank()) {
            System.out.print("Invalid author name.\nRe-enter the author name : ");
            author = LibraryManagementSystem.input.nextLine();
            assigntoAuthor(author);
            return;
        }
    }

    private void assigntoTitle(String title) {
        if(title.isBlank())
        {
            System.out.print("Invalid Title.\nRe-enter the title : ");
            title = LibraryManagementSystem.input.nextLine();
            assigntoTitle(title);
            return;
        }
    }

    private void assigntoGenre(String genre) {
        if(genre.isBlank())
        {
            System.out.print("Invalid Genre.\nRe-enter the genre : ");
            genre = LibraryManagementSystem.input.nextLine();
            assigntoGenre(genre);
            return;
        }
    }

    //getters
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getBook_ID() {
        return book_ID;
    }

    public int getAvailability_no() {
        return availability_no;
    }

    public void setAvailability_no(int the_changed_number)
    {
        if (availability_no==0&&the_changed_number<0)
        {
            System.out.println("This book is already not available.");
            return;
        }
        this.availability_no+=the_changed_number;
        System.out.println("Available number of this book has been changed.");
    }

    public static void display_book(int book_index)
    {
        if(book_index<0)
            return;
        System.out.println("Title : " + Library.Total_books.get(book_index).title);
        System.out.println("Author : " + Library.Total_books.get(book_index).author);
        System.out.println("Copies Available : " + Library.Total_books.get(book_index).availability_no);
    }

    public static void update_book_file(int book_ID,int add_sub)
    {
        int temp,i;
        String line;
        try {
            BufferedReader reader=new BufferedReader(new FileReader("Books.txt"));


            for (i =1;(line = reader.readLine()) != null;i++) {

                temp=Integer.parseInt(line);
                if (temp == book_ID) {
                    break;
                }
                else
                    for (int j=i;i<j+4;i++)
                {
                    reader.readLine();
                }
            }
            BufferedWriter writer =new BufferedWriter(new FileWriter("Books.txt",true));

        }
        catch (Exception e){}
    }


    public static int book_search_by_id(int book_ID)//returns index of the book in the arraylist from the book id
    {
        int i = 0;
        for (; i <= Library.getNo_of_books(); i++) {
            if (Library.Total_books.get(i).getBook_ID() == book_ID)
                return i;
        }
        if (i > Library.getNo_of_books()) {
            System.out.println("No books by this Name");
            return -1;
        }
        return -1;
    }
    public static void book_search() {
        int temp=0;
        System.out.print("Press 1 if you want to search book by name.\n");
        System.out.print("Press 2 if you want to search book by author.\nEnter your choice : ");
        try{
            temp= LibraryManagementSystem.input.nextInt();
        }
        catch (Exception e){
            System.out.println("Invalid book ID.Try again");
            book_search();
        }
        if(temp==1){
            book_search_by_name();
        }
        else if(temp==2){
            book_search_by_author();
        }
        else
        {
            System.out.println("Invalid book ID.Try again");
            book_search();
        }
    }


    public static void book_search_by_name()
    {
        String book_name=null,temp;
        System.out.print("Enter the name of the book : ");
        temp=LibraryManagementSystem.input.nextLine();
        book_name = LibraryManagementSystem.input.nextLine();
        if(book_name.isBlank()) {
            System.out.println("Invalid title.");
            book_search_by_name();
            return;
        }
        int i = 0;

        for (; i < Library.getNo_of_books(); i++) {
            if (i >= Library.getNo_of_books()) {
                break;
            }
            if (Library.Total_books.get(i).title.compareTo(book_name)==0) {
                display_book(i);
                break;
            }
        }

    }
    public static void book_search_by_author()
    {
        String author_name=null,temp;
        System.out.print("Enter the name of the author : ");
        temp=LibraryManagementSystem.input.nextLine();
        author_name = LibraryManagementSystem.input.nextLine();
        if(author_name.isBlank()) {
            System.out.println("Invalid title.");
            book_search_by_author();
            return;
        }
        int i = 0;

        for (; i < Library.getNo_of_books(); i++) {
            if (i >= Library.getNo_of_books()) {
                break;
            }
            if (Library.Total_books.get(i).author.compareTo(author_name)==0) {
                display_book(i);
                break;
            }
        }
    }

}
