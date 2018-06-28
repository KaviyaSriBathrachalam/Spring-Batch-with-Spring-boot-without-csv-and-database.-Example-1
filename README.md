# Spring-Batch-with-Spring-boot-without-csv-and-database.-Example-1



To Run: 

1. mvn clean install

2. mvn spring-boot:run

--------------------------------------
PROGRAM FLOW :


 1. Process Job()
 2.  listener()                                   //in process job method we have called .listener() and .orderStep1() so it exceutes like this
 3.  Order step1()
 
 [now, waits for us to type localhost:8080/invokejob]
 
 now, check the terminal
 
 4. handle() Job Invoke Controller  // goes to controller class with requestmapping of invoker job and checks whether we have db,TaskExecutor..
                                   //in this program we dont ahave those two now, it exceutes the job.
     
  5. reader() in Reader.java
process() in processor.java
writer() in writer.java
**************************************
Writing the data JAVAINUSE.COM
**************************************
reader() in Reader.java
process() in processor.java
writer() in writer.java
**************************************
Writing the data WELCOME TO SPRING BATCH EXAMPLE
**************************************
reader() in Reader.java
process() in processor.java
writer() in writer.java
**************************************
Writing the data WE USE H2 DATABASE FOR THIS EXAMPLE
**************************************
reader() in Reader.java                     //look here after reading entire messages.. when there is nothing, it gives status COMPLTED and goes to afterJob() method              
after job()
BATCH JOB COMPLETED SUCCESSFULLY



2018-06-28 11:08:28.369  INFO 115956 --- [nio-8080-exec-1] o.s.b.c.l.support.SimpleJobLauncher      : Job: [FlowJob: [name=processJob()]] completed with the following parameters: [{time=1530164308139}] and the following status: [COMPLETED]
                                   
   
