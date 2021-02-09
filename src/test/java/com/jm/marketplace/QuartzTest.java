package com.jm.marketplace;

import com.jm.marketplace.congratulation.BirthdayCongratulation;
import com.jm.marketplace.model.City;
import com.jm.marketplace.model.user.User;
import com.jm.marketplace.service.user.UserService;
import com.jm.marketplace.util.mail.MailService;
import com.mchange.v2.beans.swing.TestBean;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerFactory;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.File;
import java.io.IOException;
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

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void startEnvironment() {
        assertNotNull(scheduler);
        assertNotNull(quartzJobBean);
    }

    @Test
    public void birthdayCongratulationTest() throws JobExecutionException, IOException {
        JobExecutionContext jobExecutionContext = mock(JobExecutionContext.class);
        Mockito.when(jobExecutionContext.getScheduler()).thenReturn(scheduler);
        LocalDate date = LocalDate.now();
        User user = new User("Test", "Test", "123", "test@test.ts", new City(1L, "Test"), date, "123");
        List<User> list= Arrays.asList(user);
        File file =new File("birthday.properties");
        file.createNewFile();
        Mockito.when(userService.findUserByBirthday(date)).thenReturn(list);
        BirthdayCongratulation birthdayCongratulation = new BirthdayCongratulation(userService,mailService,"test", "test", file);
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
