package com.example.myapp.service;

import com.example.myapp.dao.AuthorDao;
import com.example.myapp.dao.BookDao;
import com.example.myapp.dao.CategoryDao;
import com.example.myapp.ds.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private CategoryDao categoryDao;

    public void saveCategory(Category category){
        categoryDao.save(category);

    }

    public List<Category> findAllCategory(){
        return categoryDao.findAll();
    }

    public Category findCategoryById(int id){
        return categoryDao.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
