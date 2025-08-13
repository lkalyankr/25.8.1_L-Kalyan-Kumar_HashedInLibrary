package com.HashedInLibraryApplication.LibrarianBookManagement.Service;

import com.HashedInLibraryApplication.LibrarianBookManagement.DTO.BookDTO;
import com.HashedInLibraryApplication.LibrarianBookManagement.Entity.Book;
import com.HashedInLibraryApplication.LibrarianBookManagement.ExceptionHandling.BookException;
import com.HashedInLibraryApplication.LibrarianBookManagement.Repository.LibrarianBookManagementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrarianBookManagementService {
    
    @Autowired
    LibrarianBookManagementRepository librarianBookManagementRepository;

    public List<Book> getAllBooks() {
        List<Book> Books = librarianBookManagementRepository.findAll();
        return Books;
    }

    public BookDTO getBook(int id) throws BookException {
        BookDTO bookDTO = new BookDTO();
        Optional<Book> Books = librarianBookManagementRepository.findById(id);
        if(Books.isPresent()){
            BeanUtils.copyProperties(Books.get(), bookDTO);
            return bookDTO;
        } else {
            throw new BookException("Book Not Found with id " + id);
        }
    }

    public void createBook(List<BookDTO> BookDTOList) {

        BookDTOList.forEach(BookDTO -> {
            Book Book = new Book();
            BeanUtils.copyProperties(BookDTO, Book);
            Book book = librarianBookManagementRepository.save(Book);
        });

    }

    public void updateBook(BookDTO BookDTO) throws BookException {

        Optional<Book> Book = librarianBookManagementRepository.findByTitleAndAuthor(BookDTO.getTitle(), BookDTO.getAuthor());
        if(Book.isPresent()){
            Book updatedBook = Book.get();
            updatedBook.setCount(BookDTO.getCount());
            librarianBookManagementRepository.save(updatedBook);
        } else{
            throw  new BookException("Cannot update, Book not found ");
        }

    }

    public void deleteBook(int id) throws BookException {
        Optional<Book> Book = librarianBookManagementRepository.findById(id);
        if(Book.isPresent()) {
            librarianBookManagementRepository.delete(Book.get());
        } else {
            throw new BookException("Cannot delete, Book not found with id " + id);
        }
    }
}
