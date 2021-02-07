package com.jm.marketplace.congratulation.quartzconfig;

import com.jm.marketplace.congratulation.BirthdayCongratulation;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {
    @Bean
    public JobDetail jobBean() {
        return JobBuilder
                .newJob(BirthdayCongratulation.class).withIdentity("BirthdayCongratulation")
                .storeDurably().build();
    }

    @Bean
    public Trigger triggerBean(JobDetail jobDetails) {
        return TriggerBuilder.newTrigger().forJob(jobDetails)
                .withIdentity("BirthdayCongratulationTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 * * ?"))
                .build();
    }
}
