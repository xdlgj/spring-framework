package com.xdl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class SimpleOrderManager implements OrderManager{
    @Autowired
    private MailSender mailSender;
    @Resource
    private SimpleMailMessage simpleMailMessage;

    @Override
    public void placeOrder() {
        SimpleMailMessage msg = new SimpleMailMessage(simpleMailMessage);
        msg.setTo("13333759329@163.com");
        msg.setText("hello spring mail");
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -1);
        // 设置发送时间只在发送方已发送的列表中有效，接收方显示的是接收到的时间
        msg.setSentDate(calendar.getTime());
        try{
            this.mailSender.send(msg);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
