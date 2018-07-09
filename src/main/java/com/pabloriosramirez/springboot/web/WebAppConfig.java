/**
 * @author Pablo Ríos Ramírez
 * @Created 28-06-2018 2:43:46
 * @web http://www.pabloriosramirez.com
 *
 */

package com.pabloriosramirez.springboot.web;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "com.pabloriosramirez.springboot.web.controller",
    "com.pabloriosramirez.springboot.web.service"})
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                /*  Con la cabecera HTTP usando Accept: application/json */
                .ignoreAcceptHeader(false)
                /*  Utilizando la extensión de la URL, ejemplo: /customer/data.json */
                .favorPathExtension(true)
                /*  A través de un parámetro en la URL, ejemplo: /customer/data?format=json */
                .favorParameter(true)
                .parameterName("format")
                /*  Establece el contenido que se generará por defecto  */
                .defaultContentType(MediaType.TEXT_HTML)
                /*  Indicamos los tipos de contenido que soportará nuestra aplicación web   */
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("json", MediaType.APPLICATION_JSON);
                
    }
/**
    * El componente ContentNegotiatingViewResolver implementa la interface 
    * ViewResolver por lo que podemos usarla para resolver las vistas basándonos 
    * en negociación de contenido, este componente no resuelve las vistas por si 
    * mismo, su trabajo es delegar esta función a otros ViewResolver.
    * @param configurer
    * @return 
**/
    @Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager configurer) {

        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setPrettyPrint(true);

        MappingJackson2XmlView xmlView = new MappingJackson2XmlView();

        ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
        cnvr.setContentNegotiationManager(configurer);
        cnvr.setDefaultViews(Arrays.asList(jsonView, xmlView));

        return cnvr;
    }
    
    
/**
    * Este componente resuelve las salidas en formato PDF y Excel XLS.
    * El ResourceBundleViewResolver requiere el siguiente archivo: views.properties.
    * @return 
**/
    @Bean
    public ViewResolver resourceViewResolver() {
        ResourceBundleViewResolver rbvr = new ResourceBundleViewResolver();
        rbvr.setBasename("views");
        rbvr.setOrder(1);
        return rbvr;
    }

    
/**
    * Para las vistas HTML usaremos InternalResourceViewResolver
    * que generará las vistas a partir del archivo .jsp indicado por el nombre 
    * lógico devuelto por el controlador.
    * @return 
**/
    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver irvr = new InternalResourceViewResolver();
        irvr.setPrefix("/WEB-INF/views/");
        irvr.setSuffix(".jsp");
        irvr.setOrder(2);
        return irvr;
    }
}
