package com.company.library.screen.form;

import com.company.library.entity.Form;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("Form_.browse")
@UiDescriptor("form-browse.xml")
@LookupComponent("formsTable")
public class FormBrowse extends StandardLookup<Form> {
}