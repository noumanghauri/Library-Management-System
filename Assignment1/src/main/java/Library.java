import java.util.ArrayList;

public class Library {
    private static int no_of_books=0, no_of_users = 0;
    static ArrayList<User> Total_users = new ArrayList<>();
    static ArrayList<Book> Total_books = new ArrayList<>();
    public static void addUser(User new_user) {
        Total_users.add(no_of_users++,new_user);
    }
    public static int getNo_of_users()
    {
        return no_of_users;
    }
    public static void addBook(Book new_book)
    {
        Total_books.add(no_of_books++,new_book);
    }
    public static void check_out_books(int user_id,int book_id)
    {

    }
}