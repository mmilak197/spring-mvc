package com.mmilak;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.mmilak")
public class WebConfig implements WebMvcConfigurer {


    public void configureViewResolvers(ViewResolverRegistry registry) {
        //registry.jsp(); //domyślny producent widoków
        //domyślny prefix to /WEB-INF dlatego nasze widoki wrzucamy do katalogu WEB-INF

        //możemy również sami skonfigurować prefix i suffix
        registry.jsp("/", ".jsp"); //wtedy nasze widoki możemy wrzucać bezpośrednio do katalogu webapp
    }

}
