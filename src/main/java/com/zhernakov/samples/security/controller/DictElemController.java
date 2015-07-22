package com.zhernakov.samples.security.controller;

import com.zhernakov.samples.security.model.DictElem;
import com.zhernakov.samples.security.service.DictElemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Misha on 21.07.2015.
 */
@Controller
@RequestMapping("/dict")
public class DictElemController {

    @Autowired
    @Qualifier("dictElemService")
    DictElemService<DictElem> dictElemService;

    @RequestMapping(value = "/{dictId}", method = RequestMethod.GET)
    public String getElements(@PathVariable("dictId") long dictId, Model model) {
        model.addAttribute("dict", DictElem.PARENT_ELEM);
        model.addAttribute("elements", dictElemService.getAll(dictId));
        return "index";
    }

    @RequestMapping(value = "/{dictId}/{id}", method = RequestMethod.POST)
    public String updateElementPost(@ModelAttribute("elem") DictElem elem,
                                    @PathVariable("dictId") long dictId,
                                    @PathVariable("id") long id,
                                    Model model) {
        boolean allowed = 0 == id ? dictElemService.add(elem) : dictElemService.update(elem);
        model.addAttribute("elem", elem);
        return "redirect:/dict/{dictId}";
    }

    @RequestMapping(value = "/{dictId}/{id}", method = RequestMethod.GET)
    public String updateElement(@PathVariable("dictId") long dictId,
                                @PathVariable("id") long id,
                                Model model) {
        DictElem elem;
        if (0 == id) {
            elem = new DictElem();
            elem.setParent(DictElem.PARENT_ELEM);
        } else {
            elem = dictElemService.getById(id, dictId);
        }
        model.addAttribute("elem", elem);
        return "edit";
    }

}
