package com.jm.marketplace;

import com.jm.marketplace.congratulation.BirthdayCongratulation;
import com.jm.marketplace.model.City;
import com.jm.marketplace.model.user.User;
import com.jm.marketplace.service.user.UserService;
import com.jm.marketplace.util.mail.MailService;
import com.mchange.v2.beans.swing.TestBean;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.quartz.*;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class QuartzTest {

    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    private Scheduler scheduler;

    @Autowired
    private QuartzJobBean quartzJobBean;

    @Mock
    private UserService userService;

    @Mock
    JobFactory jobFactory;

    @Autowired
    private MailService mailService;

    @Test
    public void startEnvironment() {
        assertNotNull(scheduler);
        assertNotNull(quartzJobBean);
    }

    @Test
    public void birthdayCongratulationTest() throws JobExecutionException {
        JobExecutionContext jobExecutionContext = mock(JobExecutionContext.class);
        Mockito.when(jobExecutionContext.getScheduler()).thenReturn(scheduler);
        LocalDate date = LocalDate.now();
        User user = new User("Test", "Test", "123", "test@test.ts", new City(1L, "Test"), date, "123");
        List<User> list= Arrays.asList(user);
        Mockito.when(userService.findUserByBirthday(date)).thenReturn(list);
        BirthdayCongratulation birthdayCongratulation = new BirthdayCongratulation(userService,mailService,"test", "test");
        birthdayCongratulation.execute(jobExecutionContext);
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
}
