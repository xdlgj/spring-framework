package com.xdl.service;

import com.xdl.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class BookService2 {

    //@Resource(name = "bookDao")
    @Inject
    private BookDao bookDao;
    @Override
    public String toString() {
        return "BookService [bookDao=" + bookDao + "]";
    }
}
