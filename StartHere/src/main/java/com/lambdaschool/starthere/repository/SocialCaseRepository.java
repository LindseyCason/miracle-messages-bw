package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.SocialCase;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;

public interface SocialCaseRepository extends PagingAndSortingRepository<SocialCase, Long> {

    ArrayList<SocialCase> findCasesBySocialCaseLnameIsStartingWith(String caseLname);

    SocialCase save(SocialCase newSocialCase);
}
