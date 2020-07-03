package cn.rectcircle.learn.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class CoreInterface {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        // name "myJob", group "group1"
        JobDetail job = JobBuilder
                .newJob(DumbJob.class)
                .withIdentity("myJob", "group1")
                .storeDurably(true)
                .requestRecovery(true)
                .usingJobData("jobSays", "Hello World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();

        scheduler.start();
        scheduler.addJob(job, false);
        scheduler.triggerJob(JobKey.jobKey("myJob", "group1"));
        Thread.sleep(100);
        scheduler.triggerJob(JobKey.jobKey("myJob", "group1"));
        Thread.sleep(100);

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(40).repeatForever()).build();

        scheduler.shutdown();
    }
}