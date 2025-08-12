package com.HashedInLibraryApplication.BookBorrowingSystem.Service;

import com.HashedInLibraryApplication.BookBorrowingSystem.Entity.BorrowBookDtls;
import com.HashedInLibraryApplication.BookBorrowingSystem.Repository.BookBorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowingService {

    @Autowired
    BookBorrowingRepository bookBorrowingRepository;

    public List<BorrowBookDtls> getAllBorrowBookDtls() {
        List<BorrowBookDtls> borrowBookDtls = bookBorrowingRepository.findAll();
        return borrowBookDtls;
    }
}
