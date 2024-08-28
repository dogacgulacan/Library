package com.company.library.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.JmixProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@JmixEntity
public class BookOrder {
    @JmixGeneratedValue
    @JmixId
    private UUID id;

    @JmixProperty(mandatory = true)
    @NotNull
    private Library library;

    @JmixProperty(mandatory = true)
    @NotNull
    private Reader reader;

    @JmixProperty(mandatory = true)
    @NotNull
    private Set<Book> books = new HashSet<>();

    @JmixProperty(mandatory = true)
    @NotNull
    private LocalDate issuanceDate;

    @JmixProperty(mandatory = true)
    @NotNull
    private LocalDate returnDate;

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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}