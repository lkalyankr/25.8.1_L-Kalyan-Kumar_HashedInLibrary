package com.HashedInLibraryApplication.LibrarianBookManagement.Repository;

import com.HashedInLibraryApplication.LibrarianBookManagement.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibrarianBookManagementRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findByTitleAndAuthor(String title, String author);
}
