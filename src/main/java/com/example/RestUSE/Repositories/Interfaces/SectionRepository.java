package com.example.RestUSE.Repositories.Interfaces;

import com.example.RestUSE.Entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface SectionRepository extends JpaRepository<Section,Long>
{
    @Transactional(readOnly = true)
    @Query("SELECT s FROM Section s")
    Optional<List<Section>> getSectionList();
}
