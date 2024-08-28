package com.company.library.screen.reader;

import com.company.library.entity.Reader;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("Reader.browse")
@UiDescriptor("reader-browse.xml")
@LookupComponent("readersTable")
public class ReaderBrowse extends StandardLookup<Reader> {
}