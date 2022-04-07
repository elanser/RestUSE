package com.example.RestUSE.Controllers;

import com.example.RestUSE.Entity.TSection;
import com.example.RestUSE.Services.Interfaces.IUSESectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SectionController {
    IUSESectionService sectionService;

    @Autowired
    public void setInjectedBean(IUSESectionService sectionService) {
           this.sectionService = sectionService;
    }

    @RequestMapping("/section/{id}")
    public TSection getSection(@PathVariable Long id) {

        return sectionService.getSectionById(id);
    }




}
