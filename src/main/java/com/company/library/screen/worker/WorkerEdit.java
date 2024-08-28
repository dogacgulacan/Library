package com.company.library.screen.worker;

import com.company.library.entity.Worker;
import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("Worker.edit")
@UiDescriptor("worker-edit.xml")
@EditedEntityContainer("workerDc")
public class WorkerEdit extends StandardEditor<Worker> {
}