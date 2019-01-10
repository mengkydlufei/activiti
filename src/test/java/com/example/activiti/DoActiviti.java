package com.example.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoActiviti {
    @Test
    public void creatFlow(){
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("acitiviti.cfg.xml")
                .buildProcessEngine();
        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("activiti/demo1.bpmn")
                .addClasspathResource("activiti/demo1.png")
                .deploy();
        System.out.println(deployment);
    }


    @Test
    public void startFlow(){
        //ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("acitiviti.cfg.xml")
                .buildProcessEngine();
        ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("myProcess_1");
        System.out.println(processInstance);
    }

    @Test
    public void queryMyFlow(){
       // ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("acitiviti.cfg.xml")
                .buildProcessEngine();
        String assignee = "员工";

        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                .taskCandidateOrAssigned(assignee)
                .list();
        for(Task task:tasks){
            System.out.println(task);
        }
    }
    //员工
    @Test
    public void doMyTask(){
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("acitiviti.cfg.xml")
                .buildProcessEngine();

        processEngine.getTaskService().complete("2505");
    }
    //部门负责人
    @Test
    public void doFZRTask(){
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("acitiviti.cfg.xml")
                .buildProcessEngine();

        processEngine.getTaskService().complete("5002");
    }

    //人力资源部
    @Test
    public void doRLZYBTask(){
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("acitiviti.cfg.xml")
                .buildProcessEngine();

        processEngine.getTaskService().complete("7502");
    }
}
