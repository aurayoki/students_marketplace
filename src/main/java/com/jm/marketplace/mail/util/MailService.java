package com.jm.marketplace.mail.util;

import com.jm.marketplace.congratulation.model.user.User;

public interface MailService {
    void send(User user, String subject, String message);
}
