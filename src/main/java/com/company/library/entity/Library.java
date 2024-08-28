package com.company.library.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@JmixEntity
@Table(name = "LIBRARY")
@Entity
public class Library extends BaseEntity {
    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @JoinTable(name = "LIBRARY_WORKER_LINK",
            joinColumns = @JoinColumn(name = "LIBRARY_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Worker> workers = new ArrayList<>();

    @JoinTable(name = "LIBRARY_READER_LINK",
            joinColumns = @JoinColumn(name = "LIBRARY_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "READER_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Reader> readers = new ArrayList<>();

    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "library")
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}