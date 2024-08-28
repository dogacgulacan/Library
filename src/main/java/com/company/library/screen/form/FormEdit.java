package com.company.library.screen.form;

import com.company.library.app.api.FormEditService;
import com.company.library.entity.Form;
import com.company.library.exceptions.AlreadyTakeBookException;
import com.company.library.exceptions.HasSameBookException;
import com.company.library.exceptions.IncorrectDatesException;
import com.company.library.exceptions.NullAmountException;
import io.jmix.ui.Notifications;
import io.jmix.ui.screen.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Form_.edit")
@UiDescriptor("form-edit.xml")
@EditedEntityContainer("formDc")
public class FormEdit extends StandardEditor<Form> {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(FormEdit.class);

    @Autowired
    private FormEditService formEditService;

    @Autowired
    private Notifications notifications;

    @Autowired
    private MessageBundle messageBundle;


    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Form form = getEditedEntity();
        try{
            formEditService.validateForm(form);
        }
        catch (AlreadyTakeBookException e) {
            notifications.create().withCaption(messageBundle.getMessage("formEdit.caption.hasAlreadyTakeBookFromLibrary")).show();
            event.preventCommit();
            log.error("Error", e);
        } catch (IncorrectDatesException e) {
            notifications.create().withCaption(messageBundle.getMessage("formEdit.caption.wrongDates")).show();
            event.preventCommit();
            log.error("Error", e);
        } catch (HasSameBookException e) {
            notifications.create().withCaption(messageBundle.getMessage( "formEdit.caption.sameBook")).show();
            event.preventCommit();
            log.error("Error", e);
        } catch (NullAmountException e){
            notifications.create().withCaption(messageBundle.getMessage("formEdit.caption.nullAmount")).show();
            event.preventCommit();
            log.error("Error", e);
        }
    }
}