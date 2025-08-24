package com.batch.example.BootBatchExample.Config;

import com.batch.example.BootBatchExample.model.Product;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class BatchConfig {


    @Bean
    public Job jobBean(JobRepository jobRepository, JobCompletionNotificationImpl listener, Step steps){
        return new JobBuilder("job", jobRepository)
                .listener(listener)
                .start(steps)
                .build();
    }
    @Bean
    public Step steps(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
                      ItemReader<Product> reader, ItemProcessor<Product, Product> processor){
        return new StepBuilder("step", jobRepository).
                chunk(5, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer()
                .build();
    }
    @Bean
    public FlatFileItemReader<Product> reader(){
        return new FlatFileItemReaderBuilder<Product>()
                .name("itemReader")
                .resource(new ClassPathResource("data.csv"))
                .delimited()
                .names("product_id", "title", "description", "price", "discount")
                .targetType(Product.class)
                .build();
    }

    public ItemProcessor<Product, Product> itemProcessor(){
         return new CustomItemProcessor();
    }
}
