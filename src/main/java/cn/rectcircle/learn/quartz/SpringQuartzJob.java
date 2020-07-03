package cn.rectcircle.learn.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import cn.rectcircle.learn.quartz.service.MyServiceImpl;


public class SpringQuartzJob implements Job {

    @Autowired
    private MyServiceImpl testServiceImpl;

    public MyServiceImpl getTestServiceImpl() {
        return testServiceImpl;
    }

    public void setTestServiceImpl(MyServiceImpl testServiceImpl) {
        this.testServiceImpl = testServiceImpl;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        testServiceImpl.testMethod();
    }
}