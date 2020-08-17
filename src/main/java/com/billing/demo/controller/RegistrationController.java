package com.billing.demo.controller;

import com.billing.demo.model.User;
import com.billing.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

/**
 * This class contains a Mail API developed using Spring Boot
 *
 * @author Sunny
 */
@RestController
public class RegistrationController {

    @Autowired
    private MailService notificationService;

    @Autowired
    private User user;

    @GetMapping(path = "send-mail")
    public String send(@RequestParam(value = "email", defaultValue = "sunnyvrm8@gmail.com") String email) {

        /*
         * Creating a User with the help of User class that we have declared. Setting
         * the First,Last and Email address of the sender.
         */
        user.setFirstName("Sunny");
        user.setLastName("Verma");
        user.setEmailAddress(email); //Receiver's email address

        /*
         * Here we will call sendEmail() for Sending mail to the sender.
         */
        try {
            notificationService.sendEmail(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }

    @GetMapping(path = "send-mail-attachment")
    public String sendWithAttachment(@RequestParam(value = "email", defaultValue = "sunnyvrm8@gmail.com") String email) throws MessagingException {

        /*
         * Creating a User with the help of User class that we have declared. Setting
         * the First,Last and Email address of the sender.
         */
        user.setFirstName("Sunny");
        user.setLastName("Verma");
        user.setEmailAddress(email); //Receiver's email address

        /*
         * Here we will call sendEmailWithAttachment() for Sending mail to the sender
         * that contains a attachment.
         */
        try {
            notificationService.sendEmailWithAttachment(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }
}
