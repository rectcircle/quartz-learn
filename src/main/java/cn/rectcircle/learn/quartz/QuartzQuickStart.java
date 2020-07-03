package cn.rectcircle.learn.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.JobBuilder;


public class QuartzQuickStart {

    public static void main(String[] args) throws InterruptedException {

        try {
            // 从工厂获取Scheduler实例
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // 然后开始
            scheduler.start();
            scheduler.clear();

            // 定义工作并将其绑定到我们的HelloJob类
            JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();

            // 触发作业立即运行，然后每40秒重复一次
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow()
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(40).repeatForever()).build();

            // 告诉 quartz 使用我们的 trigger 调度 job
            scheduler.scheduleJob(job, trigger);

            Thread.sleep(60000);

            // 停止
            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}