package com.mmilak;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

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


    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false); //do korzystania ze zmiennych tablicowych, aby pobierane wartości były bez znaku
        // średnika ';'
        configurer.setUrlPathHelper(urlPathHelper);
    }

}
