package com.company.library.screen.book;

import com.company.library.entity.Book;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("Book.browse")
@UiDescriptor("book-browse.xml")
@LookupComponent("booksTable")
public class BookBrowse extends StandardLookup<Book> {
}