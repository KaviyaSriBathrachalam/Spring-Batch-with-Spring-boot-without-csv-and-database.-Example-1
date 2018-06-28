package com.javainuse.controller;
 
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class JobInvokerController {
 
    @Autowired
    JobLauncher jobLauncher;
 
    @Autowired
    Job processJob;
 
    @RequestMapping("/invokejob")
    public String handle() throws Exception {
        System.out.println("handle() Job Invoke Controller");
            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters();            //Job parameters creates new job instances... why we are creating job instances because when there is error in job Exceution  then new job instances will be useful for resolving errors in job exceution.
            jobLauncher.run(processJob, jobParameters);        //Lob launcher is the first thing in architecture of Spring Batch
 
        return "Batch job has been invoked";
    }
}