package com.company.library.screen.reader;

import com.company.library.entity.Reader;
import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("Reader.edit")
@UiDescriptor("reader-edit.xml")
@EditedEntityContainer("readerDc")
public class ReaderEdit extends StandardEditor<Reader> {
}