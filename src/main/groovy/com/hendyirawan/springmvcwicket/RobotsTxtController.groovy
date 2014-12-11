package com.hendyirawan.springmvcwicket

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by ceefour on 11/12/14.
 */
@RestController
class RobotsTxtController {

    @RequestMapping(method = RequestMethod.GET, value="robots.txt")
    String robotsTxt() {
        return "User-agent: *\n";
    }

}
