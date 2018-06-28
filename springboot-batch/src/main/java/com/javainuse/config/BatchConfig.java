package com.javainuse.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javainuse.listener.JobCompletionListener;
import com.javainuse.step.Processor;
import com.javainuse.step.Reader;
import com.javainuse.step.Writer;


//first class
// when we run it goes to this class because of @configuration.

@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job processJob() {
		System.out.println("Process Job()");

		// it reads the data one at a time 
		return jobBuilderFactory.get("processJob()")
				.incrementer(new RunIdIncrementer())    //incrementer creates new job instances everytime when incrementer is called... New job instances creation is extremely useful if there are serious issues in a JobExecution and the Job needs to be started over again from the beginning.
						//RunIdIncrementer will have JobParameters.. JobParameters is something which trigger to create a new job instances.
				.listener(listener())		//listener will listen that is always notices what is done by us even for single minute of time.
				.flow(orderStep1())	 //flow(orderStep1)//calling writer.
				.end()
				.build();            
	}

	@Bean
	public Step orderStep1() {
		System.out.println(" Order step1()");
		return stepBuilderFactory.get("orderStep1").<String, String> chunk(1)	
		//chunk is solid piece of something(general meaning).
		// in writer, it will return chunk of read data... chunk depends on chunk interval... chunk 
		//interval is nothing bust the number given inside chunk()... so it will write one data... if chunk(10) is present then it writes 10 data at atime but in reader part it reads the data one at a time.
		//writer()  //first string represents input and second string represents output(converted)


				.reader(new Reader())          //calls reader() and it passes argument by creating object for  Reader.java 
				.processor(new Processor())  // calls processor() and it passes argument by creating object for  Processor.java 
				.writer(new Writer()).build();   // calls writer() and it passes argument by creating object for  Writer.java 
	}

	@Bean
	public JobExecutionListener listener() {  
		System.out.println("listener() ");     
		return new JobCompletionListener();		 // finally calls JobCompletionListener
	}

}
