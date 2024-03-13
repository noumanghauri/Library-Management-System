import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
public class User{
    private int user_ID,contact_number,no_books_taken=0;
    private String user_name;
    private static ArrayList<Integer> book_taken=new ArrayList<Integer>();

    User(int user_ID,int contact_number,String user_name){
        this.user_ID=user_ID;
        this.contact_number=contact_number;
        this.user_name=user_name;
    }
    public static void display_user_info(int user_id)
    {
        int user_index=user_serach(user_id);
        if (user_index==-1)
            return;
        else
        {
            System.out.println("The name of the user is : "+ Library.Total_users.get(user_index).user_name);
            System.out.println("The books taken by this user are : "+ Library.Total_users.get(user_index).user_name);


        }
    }
    public static int user_serach(int user_ID)//returns index of the user in the arraylist from the user id
    {
        int i = 0;
        for (; i <= Library.getNo_of_users(); i++) {
            if (Library.Total_users.get(i).getUser_ID() == user_ID)
                return i;
        }
        if (i > user_ID) {
            System.out.println("The user doesn't exist");
            return -1;
        }
    }
    public int getUser_ID(){
        return user_ID;
    }

    public void add_book_to_user(int...books_ID){

        for(int i= no_books_taken;i<no_books_taken+books_ID.length;i++)
        {
            book_taken.add(i,books_ID[i]);
        }
        no_books_taken+=books_ID.length;
    }
}
