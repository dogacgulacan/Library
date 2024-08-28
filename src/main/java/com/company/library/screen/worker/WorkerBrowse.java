package com.company.library.screen.worker;

import com.company.library.entity.Worker;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("Worker.browse")
@UiDescriptor("worker-browse.xml")
@LookupComponent("workersTable")
public class WorkerBrowse extends StandardLookup<Worker> {
}