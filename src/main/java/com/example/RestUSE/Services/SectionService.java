package com.example.RestUSE.Services;

import com.example.RestUSE.Entity.TSection;
import com.example.RestUSE.Repositories.Interfaces.IUSESectionRepository;
import com.example.RestUSE.Services.Interfaces.IUSESectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SectionService implements IUSESectionService {
    IUSESectionRepository sectionRepository;

    @Autowired
    public void setInjectedBean(IUSESectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public TSection getSectionById(Long idSection) {
        TSection section = sectionRepository.getSectionByID(idSection);
        Optional<TSection> optional = Optional.ofNullable(section);
        return optional.orElse(new TSection());
    }
}
