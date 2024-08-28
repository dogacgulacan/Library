package com.company.library.screen.library;

import com.company.library.entity.Library;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("Library.browse")
@UiDescriptor("library-browse.xml")
@LookupComponent("librariesTable")
public class LibraryBrowse extends StandardLookup<Library> {
}