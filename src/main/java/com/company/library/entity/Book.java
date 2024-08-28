package com.company.library.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@JmixEntity
@Table(name = "BOOK", indexes = {
        @Index(name = "IDX_BOOK_LIBRARY_ID", columnList = "LIBRARY_ID"),
        @Index(name = "IDX_BOOK_CATEGORY_ID", columnList = "CATEGORY_ID")
})
@Entity
public class Book extends BaseEntity {

    @Column(name = "AUTHOR", nullable = false)
    @NotNull
    private String author;

    @Column(name = "TITLE", nullable = false)
    @NotNull
    private String title;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "LIBRARY_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Library library;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Category category;

    public @NotNull Category getCategory() {
        return category;
    }

    public void setCategory(@NotNull Category category) {
        this.category = category;
    }

    @Column(name = "AMOUNT", nullable = false, precision = 2, scale = 0)
    @NotNull
    private BigDecimal amount;

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @InstanceName
    @DependsOnProperties({"author", "title"})
    public String getInstanceName() {
        return String.format("%s '%s'", author, title);
    }

}