package com.zhernakov.samples.security.controller;

import com.zhernakov.samples.security.model.DictElem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Misha on 22.07.2015.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/dict/" + DictElem.PARENT_ELEM.getId();
    }
}
