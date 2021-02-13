package com.jm.marketplace.config.quartzconfig;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {

    /**
     *
     * создание бина для работы с классом и его идентификация
     */

    @Bean
    public JobDetail jobBirthdayBean() {
        return JobBuilder
                .newJob(BirthdayCongratulation.class).withIdentity("BirthdayCongratulation")
                .storeDurably().storeDurably().build();
    }

    /**
     *
     * создание бина планировщика, который запускается в определенное время 12 00 соответствует триггеру "0 0 12 * * ?"
     */

    @Bean
    public Trigger triggerBirthdayBean() {
        return TriggerBuilder.newTrigger().forJob(jobBirthdayBean())
                .withIdentity("BirthdayCongratulationTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 * * ?"))
                .build();
    }

    @Bean
    public JobDetail jobRemovalOfAnAdvertisementFromPublicationBean() {
        return JobBuilder
                .newJob(RemovalOfAnAdvertisementFromPublication.class).withIdentity("RemovalOfAnAdvertisementFromPublication")
                .storeDurably().build();
    }

    @Bean
    public Trigger triggerRemovalOfAnAdvertisementFromPublicationBean() {
        return TriggerBuilder.newTrigger().forJob(jobRemovalOfAnAdvertisementFromPublicationBean())
                .withIdentity("RemovalOfAnAdvertisementFromPublicationTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 * * ?"))
                .build();
    }
}
