/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.it320.prz.service;

import com.mycompany.it320.prz.Userrole;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Korsn
 */
@javax.ws.rs.ApplicationPath("webresources")

public class ApplicationConfig extends Application {

    public ApplicationConfig() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:9485");
        beanConfig.setBasePath("/IT320-PRZ/webresources");
        beanConfig.setResourcePackage("com.mycompany.it320.prz");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(com.mycompany.it320.prz.service.ProdavnicaFacadeREST.class);
        resources.add(com.mycompany.it320.prz.service.ProizvodFacadeREST.class);
        resources.add(com.mycompany.it320.prz.service.UserFacadeREST.class);
        resources.add(com.mycompany.it320.prz.service.UserroleFacadeREST.class);
        resources.add(AuthenticationServiceREST.class);

        //swagger
        resources.add(ApiListingResource.class);
        resources.add(SwaggerSerializers.class);
        resources.add(SwaggerSerializers.class);

        
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mycompany.it320.prz.service.AuthenticationServiceREST.class);
        resources.add(com.mycompany.it320.prz.service.ProdavnicaFacadeREST.class);
        resources.add(com.mycompany.it320.prz.service.ProizvodFacadeREST.class);
        resources.add(com.mycompany.it320.prz.service.UserFacadeREST.class);
        resources.add(com.mycompany.it320.prz.service.UserroleFacadeREST.class);
    }

}
