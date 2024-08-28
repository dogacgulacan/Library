package com.company.library.screen.book;

import com.company.library.entity.Book;
import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("Book.edit")
@UiDescriptor("book-edit.xml")
@EditedEntityContainer("bookDc")
public class BookEdit extends StandardEditor<Book> {
}