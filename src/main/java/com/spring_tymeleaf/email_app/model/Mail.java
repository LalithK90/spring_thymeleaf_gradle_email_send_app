package com.spring_tymeleaf.email_app.model;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class Mail {

  private String from;
  private String mailTo;
  private String subject;
  private List<Object> attachments;
  private Map<String, Object> props;

}

