package com.example.RestUSE.Services;

import com.example.RestUSE.Entity.Section;

import com.example.RestUSE.Repositories.Interfaces.SectionRepository;
import com.example.RestUSE.Services.Interfaces.ISectionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@Service
public class SectionService implements ISectionService {
    SectionRepository sectionRepository;
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public CompletableFuture<List<Section>> getSectionList() {
        Supplier<List<Section>> supplierSections =
                () -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return sectionRepository.getSectionList().orElse(new ArrayList<>());
            };
        CompletableFuture<List<Section>> cfSections = CompletableFuture.supplyAsync(supplierSections);
        return cfSections;
    }
}
