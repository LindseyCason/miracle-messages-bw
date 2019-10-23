package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.SocialCase;
import com.lambdaschool.starthere.models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

public interface SocialCaseService {


    ArrayList<SocialCase> findAll(Pageable unpaged);

    List<SocialCase> findAllPageable(Pageable pageable);

    SocialCase findSocialCaseById(long id);

    SocialCase save(SocialCase socialCase);


    void delete(long id);

    SocialCase update(SocialCase updateSocialCase, long id);

}
