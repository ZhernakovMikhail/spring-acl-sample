package com.zhernakov.samples.security.controller;

import com.zhernakov.samples.security.model.Dict;
import com.zhernakov.samples.security.model.DictElem;
import com.zhernakov.samples.security.service.DictElemService;
import com.zhernakov.samples.security.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

/**
 * Created by Misha on 21.07.2015.
 */
@Controller
public class DictElemController {

    @Autowired
    @Qualifier("dictElemService")
    DictElemService<DictElem> dictElemService;
    @Autowired
    @Qualifier("dictService")
    DictService<Dict> dictService;

    @RequestMapping(value = "/dict/", method = RequestMethod.GET)
    public String getIndex(Model model) {
        model.addAttribute("dicts", dictService.getAll());
        return "index";
    }

    @RequestMapping(value = "/dict/{dictId}", method = RequestMethod.GET)
    public String getDict(@PathVariable("dictId") long dictId, Model model) {
        final Dict dict = Objects.equals(0L, dictId) ? new Dict(dictId) : dictService.getById(dictId);
        model.addAttribute("dict", dict);
        model.addAttribute("elements", dictElemService.getAll(dictId));
        return "dict";
    }

    @RequestMapping(value = "/dict/{dictId}", method = RequestMethod.POST)
    public String updateDict(@PathVariable("dictId") long dictId, @ModelAttribute("dict") Dict dict, Model model) {
        boolean allowed = Objects.equals(0L, dictId) ? dictService.add(dict) : dictService.update(dict);
        model.addAttribute("dict", dict);
        model.addAttribute("elements", dictElemService.getAll(dictId));
        return "redirect:/dict/" + dict.getId();
    }

    @RequestMapping(value = "/dict/{dictId}/{id}", method = RequestMethod.POST)
    public String updateElement(@ModelAttribute("elem") DictElem elem,
                                @PathVariable("dictId") long dictId,
                                @PathVariable("id") long id,
                                Model model) {
        boolean allowed = Objects.equals(0L, id) ? dictElemService.add(elem) : dictElemService.update(elem);
        model.addAttribute("elem", elem);
        return "redirect:/dict/{dictId}";
    }

    @RequestMapping(value = "/dict/{dictId}/{id}", method = RequestMethod.GET)
    public String getElement(@PathVariable("dictId") long dictId,
                             @PathVariable("id") long id,
                             Model model) {
        final DictElem elem = Objects.equals(0L, id) ? new DictElem(id, dictId) : dictElemService.getById(id, dictId);
        model.addAttribute("elem", elem);
        return "edit_elem";
    }

}
