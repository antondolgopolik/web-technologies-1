package by.bsuir.lab1.classes;

import java.util.Comparator;

public class TitleAuthorComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        int temp = new TitleComparator().compare(book1, book2);
        if (temp == 0) {
            temp = book1.getAuthor().compareTo(book2.getAuthor());
        }
        return temp;
    }
}
