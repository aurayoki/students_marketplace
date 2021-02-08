package com.jm.marketplace.congratulation.quartzconfig;

import com.jm.marketplace.congratulation.BirthdayCongratulation;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {

    // создание бина для работы с классом и его идентификация
    @Bean
    public JobDetail jobBean() {
        return JobBuilder
                .newJob(BirthdayCongratulation.class).withIdentity("BirthdayCongratulation")
                .storeDurably().build();
    }

    // создание бина планировщика, который запускается в определенное время 12 00 соответствует триггеру "0 0 12 * * ?"
    @Bean
    public Trigger triggerBean(JobDetail jobDetails) {
        return TriggerBuilder.newTrigger().forJob(jobDetails)
                .withIdentity("BirthdayCongratulationTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 * * ?"))
                .build();
    }
}
