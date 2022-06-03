package com.example.RestUSE.Services;

import com.example.RestUSE.Entity.Section;
import com.example.RestUSE.Repositories.Interfaces.IUSESectionRepository;
import com.example.RestUSE.Services.Interfaces.IUSESectionService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SectionService implements IUSESectionService {
    IUSESectionRepository sectionRepository;

    public SectionService(IUSESectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Section getSectionById(Long idSection) {
        Section section = sectionRepository.getSectionByID(idSection);
        Optional<Section> optional = Optional.ofNullable(section);
        return optional.orElseGet(Section::new);
    }
}
