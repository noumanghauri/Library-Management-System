public class Book{
    private int book_ID,availability_no;
    private String title,author,genre;

    Book (int book_ID, int availability_no ,String title,String author, String genre){
        this.book_ID=book_ID;
        this.title=title;
        this.availability_no=availability_no;
        this.author=author;
        this.genre=genre;
    }
    public void SetAvalibility_no(int the_changed_number)
    {
        availability_no+=the_changed_number;
    }
}
