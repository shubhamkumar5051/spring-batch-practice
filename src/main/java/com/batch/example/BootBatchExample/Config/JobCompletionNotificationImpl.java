package com.batch.example.BootBatchExample.Config;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationImpl implements JobExecutionListener {

    private Logger logger = LoggerFactory.getLogger(JobCompletionNotificationImpl.class);
    @Override
    public void beforeJob(JobExecution jobExecution) {
        JobExecutionListener.super.beforeJob(jobExecution);
        logger.info("job started");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        JobExecutionListener.super.afterJob(jobExecution);
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            logger.info("job completed");
        }
    }
}
