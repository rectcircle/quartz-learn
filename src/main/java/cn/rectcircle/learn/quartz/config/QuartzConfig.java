package cn.rectcircle.learn.quartz.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.rectcircle.learn.quartz.SpringQuartzJob;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob().ofType(SpringQuartzJob.class)
                .storeDurably()
                .withIdentity("Qrtz_Job_Detail")
                .withDescription("Invoke Sample Job service...")
                .build();
    }

    @Bean
    public Trigger trigger(JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job).withIdentity("Qrtz_Trigger").withDescription("Sample trigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(100000)).build();
    }

}