package by.bsuir.lab1.classes;

import java.util.Objects;

public class Book implements Cloneable, Comparable<Book> {
    private static int edition;
    private String title;
    private String author;
    private int price;
    private String isbn;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getEdition() {
        return edition;
    }

    public static void setEdition(int edition) {
        Book.edition = edition;
    }

    @Override
    public int hashCode() {
        return (title + author + price).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return Objects.equals(title, book.title)
                && Objects.equals(author, book.author)
                && (price == book.price);
    }

    @Override
    public String toString() {
        return "Title: " + title +
                ", author: " + author +
                ", price: " + price +
                ", edition: " + edition;
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int compareTo(Book book) {
        return isbn.compareTo(book.isbn);
    }
}
