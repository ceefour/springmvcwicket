package com.hendyirawan.springmvcwicket

import groovy.transform.CompileStatic
import org.apache.wicket.Page
import org.apache.wicket.protocol.http.WebApplication

/**
 * Created by ceefour on 11/12/14.
 */
@CompileStatic
class MyWebApplication extends WebApplication {
    @Override
    Class<? extends Page> getHomePage() {
        return HomePage.class
    }
}
