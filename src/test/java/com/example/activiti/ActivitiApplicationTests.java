package com.example.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Test
    public void creatTable(){
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("acitiviti.cfg.xml")
                .buildProcessEngine();
    }
}

