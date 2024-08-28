package com.company.library.screen.category;

import com.company.library.entity.Category;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("Category.browse")
@UiDescriptor("category-browse.xml")
@LookupComponent("categoriesTable")
public class CategoryBrowse extends StandardLookup<Category> {
}
