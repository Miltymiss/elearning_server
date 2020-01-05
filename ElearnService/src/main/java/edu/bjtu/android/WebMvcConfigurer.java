package edu.bjtu.android;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

/**
 * @ClassName WebMvcConfigurer
 * @Description TODO
 * @Author hedianbo
 * @Date 2019/12/26 9:13 AM
 **/

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Value("${material.location}")
    private String contentPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = new File("").getAbsolutePath();
        String vpath = "file://" + path + "/" + contentPath;
        System.out.println("vpath   " + vpath);
        registry.addResourceHandler("/files/**").addResourceLocations(vpath + File.separator);
        super.addResourceHandlers(registry);
    }

}
