package com.company.library.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.InstanceName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "CATEGORY")
@Entity
public class Category extends BaseEntity {
    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}