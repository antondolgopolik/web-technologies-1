package by.bsuir.lab1.classes;

import java.util.Comparator;

public class AuthorTitlePriceComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        int temp = new AuthorTitleComparator().compare(book1, book2);
        if (temp == 0) {
            temp = Integer.compare(book1.getPrice(), book2.getPrice());
        }
        return temp;
    }
}
