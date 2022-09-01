package com.example.RestUSE.Repositories.Interfaces;

import com.example.RestUSE.Entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface ProfileRepository extends JpaRepository<Profile,Long> {
    // https://sysout.ru/annotatsiya-query/
    // список профайлов
    @Transactional(readOnly = true)
    @Query("SELECT p FROM Profile p")
    Optional<List<Profile>> getProfileList();

    // список профайлов по ID секции
    @Transactional(readOnly = true)
    @Query("SELECT p FROM Profile p Where p.idSection.id = :id")
    Optional<List<Profile>> getProfileListByIDSection(long id);

    // профайл по ID
    @Transactional(readOnly = true)
    @Query("SELECT p FROM Profile p WHERE p.id = :iD")
    Optional<Profile> getProfileById(long iD);

    // Новый профайл
    @Modifying
    @Transactional
    @Query(value ="INSERT into Profile (id_section,name_profile,num_tickets) values(?1,?2,?3)",nativeQuery = true)
    int newProfile(long idSection,String nameProfile, int numTickets);

    // Новый профайл
    @Modifying
    @Transactional
    @Query(value ="Update Profile set id_section = ?2,name_profile = ?3,num_tickets = ?4 where id = ?1",nativeQuery = true)
    int updateProfile(long id, long idSection,String nameProfile, int numTickets);
}
