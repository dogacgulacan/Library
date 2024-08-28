package com.company.library.screen.bookorder;

import com.company.library.app.api.BookOrderService;
import com.company.library.entity.Book;
import com.company.library.entity.BookOrder;
import com.company.library.entity.Library;
import com.company.library.exceptions.AlreadyTakeBookException;
import com.company.library.exceptions.HasSameBookException;
import com.company.library.exceptions.IncorrectDatesException;
import com.company.library.exceptions.NullAmountException;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.DataGrid;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.data.datagrid.ContainerDataGridItems;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.screen.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Set;

@UiController("BookOrder.edit")
@UiDescriptor("book-order-edit.xml")
@EditedEntityContainer("bookOrderDc")
public class BookOrderEdit extends StandardEditor<BookOrder> {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BookOrderEdit.class);
    @Autowired
    private DataGrid<Book> booksDataGrid;

    @Autowired
    private CollectionContainer<Book> bookDc;

    @Autowired
    private BookOrderService bookOrderService;

    @Autowired
    private Notifications notifications;

    @Autowired
    private MessageBundle messageBundle;


    @Subscribe
    public void onInit(InitEvent event) {
        booksDataGrid.setItems(new ContainerDataGridItems<>(bookDc));
    }

    @Subscribe("libraryField")
    public void onLibraryFieldValueChange(HasValue.ValueChangeEvent<Library> event) {
        if (event.getValue() != null) {
            bookDc.setItems(event.getValue().getBooks());
            booksDataGrid.setItems(new ContainerDataGridItems<>(bookDc));
            booksDataGrid.repaint();
        }
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        BookOrder bookOrder = getEditedEntity();
        Set<Book> books = booksDataGrid.getSelected();

        if (CollectionUtils.isEmpty(books)) {
            notifications.create().withCaption(messageBundle.getMessage("bookOrderEdit.caption.selectOneBook")).show();
            event.preventCommit();
        }

        bookOrder.setBooks(books);

        try {
            bookOrderService.saveOrderToForms(bookOrder);
        }
        catch (AlreadyTakeBookException e) {
            notifications.create().withCaption(messageBundle.getMessage("bookOrderEdit.caption.hasAlreadyTakeBookFromLibrary")).show();
            event.preventCommit();
            log.error("Error", e);
            } catch (IncorrectDatesException e) {
            notifications.create().withCaption(messageBundle.getMessage("bookOrderEdit.caption.wrongDates")).show();
            event.preventCommit();
            log.error("Error", e);
            } catch (HasSameBookException e) {
            notifications.create().withCaption(messageBundle.getMessage( "bookOrderEdit.caption.sameBook")).show();
            event.preventCommit();
            log.error("Error", e);
            } catch (NullAmountException e){
            notifications.create().withCaption(messageBundle.getMessage("bookOrderEdit.caption.nullAmount")).show();
            event.preventCommit();
            log.error("Error", e);
        }
    }
}

