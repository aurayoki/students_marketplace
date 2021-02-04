package com.jm.marketplace.congratulation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

@Service
public class BirthdayСongratulation implements Job {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    public void sendCongrats(String subject, String message, File file) {
        LocalDate currentDate = LocalDate.now();
        List<User> usersList = userService.findUserByBirthday(currentDate);
        usersList.stream().forEach(user -> mailService.send(user, subject, message, file));
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }
}
