package com.jm.marketplace.congratulation;

import com.jm.marketplace.service.user.UserService;
import com.jm.marketplace.util.mail.MailService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Data
@Service
@NoArgsConstructor
@PropertySource(value = "classpath:birthday.properties")
public class BirthdayCongratulation extends QuartzJobBean {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    private String subject;
    private String message;

    public BirthdayCongratulation(UserService userService, MailService mailService,
                                  @Value("${subject.string}") String subject,
                                  @Value("${message.string}") String message) {
        this.userService = userService;
        this.mailService = mailService;
        this.subject = subject;
        this.message = message;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LocalDate currentDate = LocalDate.now();
        try {
            userService.findUserByBirthday(currentDate).forEach(user -> mailService.send(user, subject, message));
        } catch (Exception e) {
            throw new JobExecutionException(e);
        }
    }
}
