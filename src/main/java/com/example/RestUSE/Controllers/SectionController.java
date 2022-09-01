package com.example.RestUSE.Controllers;

import com.example.RestUSE.Entity.Section;
import com.example.RestUSE.Services.Interfaces.ISectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin
@RequestMapping("/sections")
public class SectionController {
    ISectionService sectionService;

    public SectionController(ISectionService sectionService) {
        this.sectionService = sectionService;
    }

    @RequestMapping(value = "/all")
    public CompletableFuture<List<Section>> getSectionList() {
        return sectionService.getSectionList();
    }
}
