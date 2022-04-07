package com.example.RestUSE.Repositories;
import com.example.RestUSE.Repositories.Interfaces.IUSESectionRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.example.RestUSE.Entity.TSection;
import org.springframework.stereotype.Component;

import static com.example.RestUSE.RestUseApplication.sessionFactory;

@Component
public class DBSectionRepository implements IUSESectionRepository {
    @Override
    public TSection getSectionByID(Long idSection) {
        Session session = null;
        Object section = null;
        try {
            session = sessionFactory.openSession();
            section = (TSection)session.get(TSection.class,idSection);//load(TSection.class, idSection);
            Hibernate.initialize(section);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return (TSection) section;
    }
}
