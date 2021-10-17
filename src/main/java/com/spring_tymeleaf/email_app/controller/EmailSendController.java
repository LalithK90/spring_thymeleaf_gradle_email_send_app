package com.spring_tymeleaf.email_app.controller;

import com.spring_tymeleaf.email_app.model.Mail;
import com.spring_tymeleaf.email_app.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class EmailSendController {
  private final EmailSenderService emailService;
  private static final Logger log = LoggerFactory.getLogger(EmailSendController.class);

  @GetMapping( "/sample" )
  public String sample() throws Exception {

    log.info("START... Sending email");

    Mail mail = new Mail();
    mail.setFrom("asakahatapitiya@gmail.com");//replace with your desired email
    mail.setMailTo("asakahatapitiya@gmail.com");//replace with your desired email
    mail.setSubject("Email with Spring boot and thymeleaf template!");

    Map< String, Object > model = new HashMap<  >();
    model.put("name", "Developer!");
    model.put("location", "United States");
    model.put("sign", "Java Developer");
    mail.setProps(model);

    emailService.sendEmail(mail);
    log.info("END... Email sent success");
    return "successMessage/success";
  }

}
