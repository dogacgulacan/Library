package com.company.library.screen.library;

import com.company.library.entity.Library;
import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("Library.edit")
@UiDescriptor("library-edit.xml")
@EditedEntityContainer("libraryDc")
public class LibraryEdit extends StandardEditor<Library> {
}