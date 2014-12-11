package com.hendyirawan.springmvcwicket

import groovy.transform.CompileStatic
import org.apache.wicket.protocol.http.WicketFilter
import org.apache.wicket.spring.SpringWebApplicationFactory
import org.springframework.boot.context.embedded.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by ceefour on 11/12/14.
 */
@CompileStatic
@Configuration
class WicketConfig {

    @Bean
    MyWebApplication webApp() {
        return new MyWebApplication();
    }

    @Bean
    FilterRegistrationBean wicketFilter() {
        final reg = new FilterRegistrationBean(new WicketFilter());
        reg.addInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
        reg.addInitParameter(WicketFilter.APP_FACT_PARAM, SpringWebApplicationFactory.class.name)
        reg.addInitParameter("applicationBean", "webApp");
//        reg.addInitParameter("applicationClassName", MyWebApplication.class.name);
        return reg;
    }
}
