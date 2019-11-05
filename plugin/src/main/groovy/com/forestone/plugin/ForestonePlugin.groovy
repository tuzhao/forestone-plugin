package com.forestone.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author tuzhao
 */
class ForestonePlugin implements Plugin<Project> {

    private static final String TASK_SCAN = "Forestone"

    private Project mProject

    @Override
    void apply(Project project) {
        mProject = project

        log("<<--------------------------------------------------------------------------------------->>")
        log("<<----------------------------------ForestonePlugin-------------------------------------->>")
        log("<<--------------------------------------------------------------------------------------->>")

        project.getExtensions().create(TASK_SCAN, TaskScanExtension.class)
        project.task("testTaskOne") {
            group = "test"
            description = "test task one"
            doLast {
                println '**************************************'
                println "$project.testTaskOne.description"
                println '**************************************'
            }
        }

        log(">>---------------------------------------------------------------------------------------<<")
        log(">>----------------------------------ForestonePlugin--------------------------------------<<")
        log(">>---------------------------------------------------------------------------------------<<")
    }

    class TaskScanExtension {
        String description = "This is scan task des."
    }

    private void log(String msg) {
        if (null != mProject) {
            mProject.logger.debug(msg)
        }
    }
}
