package com.luv2code.ecommerce.config;

import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class test implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
        HttpMethod[] unusedMethod = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};

        //disable HTTP Methods for product class

        config.getExposureConfiguration().
                forDomainType(Product.class)
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unusedMethod))
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unusedMethod));

        config.getExposureConfiguration().forDomainType(ProductCategory.class)
                .withItemExposure((metdata,httpMethods) -> httpMethods.disable(unusedMethod))
                .withCollectionExposure((metdata,httpMetods)->httpMetods.disable(unusedMethod));


    }
}
