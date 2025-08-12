package com.HashedInLibraryApplication.LibrarianBookManagement.Controller;

import com.HashedInLibraryApplication.LibrarianBookManagement.DTO.BookDTO;
import com.HashedInLibraryApplication.LibrarianBookManagement.Entity.Book;
import com.HashedInLibraryApplication.LibrarianBookManagement.Service.LibrarianBookManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/librarybook")
@RestController
public class LibrarianBookManagementController {

    @Autowired
    LibrarianBookManagementService librarianBookManagementService;

    @GetMapping("/getallbooks")
    public List<Book> getAllBooks(){
        List<Book> users = librarianBookManagementService.getAllBooks();
        return users;
    }

    @GetMapping("/getbook/{id}")
    public Book getBook(@PathVariable int id){
        Book user = librarianBookManagementService.getBook(id);
        return user;
    }

    @PostMapping("/createbook")
    public void createBook(@RequestBody List<BookDTO> bookDTOList){
        librarianBookManagementService.createBook(bookDTOList);
    }

    @PutMapping("/updatebook")
    public void updateBook(@RequestBody BookDTO bookDTO){
        librarianBookManagementService.updateBook(bookDTO);
    }

    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id){
        librarianBookManagementService.deleteBook(id);
        return ResponseEntity.ok("User Deleted Successfully");
    }



}
