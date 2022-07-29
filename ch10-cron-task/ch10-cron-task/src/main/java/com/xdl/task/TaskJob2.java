package com.xdl.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskJob2 {
    private String format = "yyyy-MM-dd hh:mm:ss";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    @Scheduled(cron = "0/2 * * * * ?")
    public void job1() {
        System.out.println("任务1：" + simpleDateFormat.format(new Date()));
    }
    @Scheduled(cron = "0/5 * * * * ?")
    public void job2() {
        System.out.println("任务2：" + simpleDateFormat.format(new Date()));
    }
}
