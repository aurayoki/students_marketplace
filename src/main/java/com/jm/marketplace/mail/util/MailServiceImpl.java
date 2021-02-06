package com.jm.marketplace.mail.util;

import com.jm.marketplace.congratulation.model.user.User;
import com.jm.marketplace.mail.util.MailService;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class MailServiceImpl implements MailService {

    @Override
    public void send(User user, String subject, String message) {

    }
}
