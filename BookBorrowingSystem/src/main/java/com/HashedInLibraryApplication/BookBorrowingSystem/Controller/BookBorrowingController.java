package com.HashedInLibraryApplication.BookBorrowingSystem.Controller;

import com.HashedInLibraryApplication.BookBorrowingSystem.Entity.BorrowBookDtls;
import com.HashedInLibraryApplication.BookBorrowingSystem.Service.BookBorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/borrowbook")
@RestController
public class BookBorrowingController {

    @Autowired
    BookBorrowingService bookBorrowingService;

    @GetMapping("/getallborrowbookdtls")
    public List<BorrowBookDtls> getAllBorrowBookDtls(){
        List<BorrowBookDtls> users = bookBorrowingService.getAllBorrowBookDtls();
        return users;
    }


}
