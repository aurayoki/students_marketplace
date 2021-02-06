package com.jm.marketplace;

import com.jm.marketplace.congratulation.BirthdayCongratulation;
import com.jm.marketplace.congratulation.quartzconfig.JobConfiguration;
import com.mchange.v2.beans.swing.TestBean;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
@ContextConfiguration(classes = JobConfiguration.class)
@TestPropertySource(properties =
        {"spring.quartz.properties.org.quartz.scheduler.instanceId=AUTO",
                "quartz.enabled=true",
                "quartz.persistence.persisted=false"})
@DirtiesContext
public class QuartzTest {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private QuartzJobBean quartzJobBean;

    @Before
    public void before() {
        mockJobIdentifier("job-name", "group");
    }

    private void mockJobIdentifier(String jobName, String groupName) {
    }

    @Test
    public void startEnvironment() throws SchedulerException {
        assertEquals(scheduler.getSchedulerName(), "quartzScheduler");
        assertNotNull(scheduler);
        assertNotNull(quartzJobBean);
    }

    @Test
    public void schedulerFactoryBeanWithApplicationContext() throws Exception {
        TestBean tb = new TestBean();
        StaticApplicationContext ac = new StaticApplicationContext();
        final Scheduler scheduler = mock(Scheduler.class);
        SchedulerContext schedulerContext = new SchedulerContext();
        given(scheduler.getContext()).willReturn(schedulerContext);

        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean() {
            @Override
            protected Scheduler createScheduler(SchedulerFactory schedulerFactory, String schedulerName) {
                return scheduler;
            }
        };
    }

    @Test
    public void BirthdayCongratulationTest() {
        try {
//             Получить Scheduler instance(экземпляр планировщика )  из фабрики
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//             запуск
            scheduler.start();
            JobDetail job = newJob(BirthdayCongratulation.class)
                    .withIdentity("job1", "group1")
                    .build();
//             Запуск триггера и повтор каждые 40 сек
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(40)
                            .repeatForever())
                    .build();
            scheduler.scheduleJob(job, trigger);
            scheduler.shutdown();
        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
