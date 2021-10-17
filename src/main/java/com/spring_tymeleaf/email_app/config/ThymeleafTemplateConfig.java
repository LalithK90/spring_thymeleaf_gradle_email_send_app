package com.spring_tymeleaf.email_app.config;


import java.nio.charset.StandardCharsets;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

//@Configuration
//public class ThymeleafTemplateConfig {
//
//  @Bean
//  public SpringTemplateEngine springTemplateEngine() {
//    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//    templateEngine.addTemplateResolver(htmlTemplateResolver());
//    return templateEngine;
//  }
//
//  @Bean
//  public SpringResourceTemplateResolver htmlTemplateResolver(){
//    SpringResourceTemplateResolver emailTemplateResolver = new SpringResourceTemplateResolver();
//    emailTemplateResolver.setPrefix("/templates/email");
//    emailTemplateResolver.setSuffix(".html");
//    emailTemplateResolver.setTemplateMode(TemplateMode.HTML);
//    emailTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
//    return emailTemplateResolver;
//  }
//}

@Configuration
public class ThymeleafTemplateConfig implements WebMvcConfigurer {
  private static final String EMAIL_TEMPLATE_ENCODING = "UTF-8";

  @Bean
  @Primary
  public TemplateEngine emailTemplateEngine() {
    final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    // Resolver for HTML emails (except the editable one)
    templateEngine.addTemplateResolver(emailTemplateResolver());

    return templateEngine;
  }

  private ITemplateResolver emailTemplateResolver() {
    final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
    templateResolver.setResolvablePatterns(Collections.singleton("*"));
    templateResolver.setPrefix("/templates/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode(TemplateMode.HTML);
    templateResolver.setCharacterEncoding(EMAIL_TEMPLATE_ENCODING);
    templateResolver.setCacheable(false);

    return templateResolver;
  }
}

