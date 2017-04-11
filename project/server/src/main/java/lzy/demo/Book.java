package lzy.demo;

import javax.persistence.*;
import java.io.Serializable;


/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:40
 */


@Entity
public class Book implements Serializable{
    private int id;
    private String name;
    private BookDetail bookDetail;

    public Book(){

    }

    public Book(String name){
        this.name = name;
    }

    public Book(String name, BookDetail bookDetail){
        this.name = name;
        this.bookDetail = bookDetail;
        this.bookDetail.setBook(this);
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[id=%d, name='%s', number of pages='%d']",
                id, name, bookDetail.getNumberOfPages());
    }
}