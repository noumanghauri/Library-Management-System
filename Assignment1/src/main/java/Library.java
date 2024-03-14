import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
public class Library {
    private static int no_of_books=0, no_of_users = 0;
    static ArrayList<User> Total_users = new ArrayList<>();
    static ArrayList<Book> Total_books = new ArrayList<>();

    public static int getNo_of_users()
    {
        return no_of_users;
    }

    public static int getNo_of_books() {
        return no_of_books;
    }
    public static void addUser() {
        User new_user =new User();
        Total_users.add(no_of_users++,new_user);
        try{
            BufferedWriter writer =new BufferedWriter(new FileWriter("Users.txt",true));
            writer.write(String.valueOf(new_user.getUser_ID()));
            writer.newLine();
            writer.write(new_user.getUser_name());
            writer.newLine();
            writer.write(String.valueOf(new_user.getContact_number()));
            writer.newLine();
            writer.write(String.valueOf(new_user.getNo_books_taken()));
            writer.newLine();
            writer.write("||");
            writer.close();

        }catch (Exception e){}
    }
    public static void addBook()
    {
        Book new_book = new Book();
        Total_books.add(no_of_books++,new_book);
        try{
        BufferedWriter writer =new BufferedWriter(new FileWriter("Books.txt",true));
        writer.write(String.valueOf(new_book.getBook_ID()));
        writer.newLine();
        writer.write(new_book.getTitle());
        writer.newLine();
        writer.write(new_book.getAuthor());
        writer.newLine();
        writer.write(new_book.getGenre());
        writer.newLine();
        writer.write(String.valueOf(new_book.getAvailability_no()));
        writer.newLine();
        writer.close();

        }catch (Exception e){}
    }
    public static void save()
    {
        for (int i=0; i<=no_of_users;i++) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt", true));
                writer.write(String.valueOf(Total_users.get(i).getUser_ID()));
                writer.newLine();
                writer.write(Total_users.get(i).getUser_name());
                writer.newLine();
                writer.write(String.valueOf(Total_users.get(i).getContact_number()));
                writer.newLine();
                writer.write(String.valueOf(Total_users.get(i).getNo_books_taken()));
                writer.newLine();
                for (int j=0; j<=Total_users.get(i).getNo_books_taken();j++) {
                    writer.write(String.valueOf(Total_users.get(i).getBook_taken().get(j)));
                    writer.newLine();
                }
                writer.write("||");
                writer.close();
                return;
            } catch (Exception e) {
                return;
            }
        }
        for (int i=0; i<=no_of_books;i++){
            try{
                BufferedWriter writer =new BufferedWriter(new FileWriter("Books.txt",true));
                writer.write(String.valueOf(Total_books.get(i).getBook_ID()));
                writer.newLine();
                writer.write(Total_books.get(i).getTitle());
                writer.newLine();
                writer.write(Total_books.get(i).getAuthor());
                writer.newLine();
                writer.write(Total_books.get(i).getGenre());
                writer.newLine();
                writer.write(String.valueOf(Total_books.get(i).getAvailability_no()));
                writer.newLine();
                writer.close();

            }catch (Exception e){}
        }
        return;
    }
}