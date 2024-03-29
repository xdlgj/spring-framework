package com.xdl.service;

import com.xdl.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Qualifier("bookDao")
    @Autowired
    private BookDao bookDao;
    @Override
    public String toString() {
        return "BookService [bookDao=" + bookDao + "]";
    }
}
