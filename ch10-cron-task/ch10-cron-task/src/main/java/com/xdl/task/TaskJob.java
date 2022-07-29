package com.xdl.task;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskJob {
    private String format = "yyyy-MM-dd hh:mm:ss";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

    public void job1() {
        System.out.println("任务1：" + simpleDateFormat.format(new Date()));
    }
    public void job2() {
        System.out.println("任务2：" + simpleDateFormat.format(new Date()));
    }
}
