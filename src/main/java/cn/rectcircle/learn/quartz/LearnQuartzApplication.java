package cn.rectcircle.learn.quartz;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@SpringBootApplication
public class LearnQuartzApplication implements CommandLineRunner {

	@Autowired
	private Scheduler scheduler;

	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;

	public static void main(String[] args) throws InterruptedException, IOException {
		SpringApplication.run(LearnQuartzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(scheduler);
		System.out.println(schedulerFactoryBean);
	}

}
