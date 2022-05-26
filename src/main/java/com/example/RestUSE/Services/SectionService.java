package com.example.RestUSE.Services;

import com.example.RestUSE.Entity.TSection;
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
    public TSection getSectionById(Long idSection) {
        TSection section = sectionRepository.getSectionByID(idSection);
        Optional<TSection> optional = Optional.ofNullable(section);
        return optional.orElseGet(TSection::new);
    }
}
