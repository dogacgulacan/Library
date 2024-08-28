package com.company.library.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@JmixEntity
@Table(name = "FORM_", indexes = {
        @Index(name = "IDX_FORM_READER_ID", columnList = "READER_ID"),
        @Index(name = "IDX_FORM_WORKER_ID", columnList = "WORKER_ID"),
        @Index(name = "IDX_FORM_BOOK_ID", columnList = "BOOK_ID")
})
@Entity(name = "Form_")
public class Form extends BaseEntity {
    @Column(name = "ISSUANCE_DATE", nullable = false)
    @NotNull
    private LocalDate issuanceDate;

    @JoinColumn(name = "BOOK_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Book book;

    @JoinColumn(name = "READER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Reader reader;

    @JoinColumn(name = "WORKER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Worker worker;

    @Column(name = "RETURN_DATE", nullable = false)
    @NotNull
    private LocalDate returnDate;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getIssuanceDate() {
        return issuanceDate;
    }

    public void setIssuanceDate(LocalDate issuanceDate) {
        this.issuanceDate = issuanceDate;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}