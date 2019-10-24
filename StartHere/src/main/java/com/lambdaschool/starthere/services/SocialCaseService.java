package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.SocialCase;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public interface SocialCaseService {


    ArrayList<SocialCase> findAll(Pageable unpaged);

    List<SocialCase> findAllPageable(Pageable pageable);

    @Transactional
    void deleteAll(Long id) throws EntityNotFoundException;

    SocialCase findSocialCaseById(long id);

    SocialCase save(SocialCase socialCase);


    void delete(long id);

    SocialCase update(SocialCase updateSocialCase, long id);

}
