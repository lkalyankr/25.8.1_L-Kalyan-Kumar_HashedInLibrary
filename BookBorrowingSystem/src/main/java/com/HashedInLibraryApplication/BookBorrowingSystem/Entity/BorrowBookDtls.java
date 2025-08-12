package com.HashedInLibraryApplication.BookBorrowingSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "borrow_book")
public class BorrowBookDtls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private Date returnedDate;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long bookId;
}

