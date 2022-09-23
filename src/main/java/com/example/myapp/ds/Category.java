package com.example.myapp.ds;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Book> bookList=new ArrayList<>();

    private void addBook(Book book){
        book.setCategory(this);
        bookList.add(book);
    }

}
