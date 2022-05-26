package com.example.RestUSE.Controllers;

import com.example.RestUSE.Entity.TSection;
import com.example.RestUSE.Services.Interfaces.IUSESectionService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/section")
public class SectionController {
    IUSESectionService sectionService;

    public SectionController(IUSESectionService sectionService) {
        this.sectionService = sectionService;
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.PUT})
    public TSection getSection(@PathVariable Long id) {
        return sectionService.getSectionById(id);
    }
}
