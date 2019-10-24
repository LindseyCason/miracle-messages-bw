package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.exceptions.ResourceFoundException;
import com.lambdaschool.starthere.models.SocialCase;
import com.lambdaschool.starthere.models.User;
import com.lambdaschool.starthere.repository.SocialCaseRepository;
import com.lambdaschool.starthere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "caseService")
public class SocialCaseServiceImpl implements SocialCaseService {

    @Override
    public List<SocialCase> findAllPageable(Pageable pageable) {
        List<SocialCase> list = new ArrayList<>(  );
        socialcaserepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Autowired
    private SocialCaseRepository socialcaserepo;
    @Autowired
    private UserRepository userrepo;

    @Override
    public ArrayList<SocialCase> findAll(Pageable unpaged){
        ArrayList<SocialCase> list = new ArrayList<>(  );
        socialcaserepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }



    @Transactional
    @Override
    public void delete(long id) throws EntityNotFoundException
    {
        if (socialcaserepo.findById(id).isPresent())
        {
            socialcaserepo.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public void deleteAll(Long id) throws EntityNotFoundException
    {
        if (findAll( Pageable.unpaged() ) == null)
        {
            socialcaserepo.deleteById(null);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }


    @Override
    public SocialCase findSocialCaseById(long id) throws ResourceFoundException
    {
        return socialcaserepo.findById(id)
                .orElseThrow(() -> new ResourceFoundException(Long.toString(id)));
    }

    @Transactional
    @Override
    public SocialCase save(SocialCase socialCase) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userrepo.findByUsername(authentication.getName());


        SocialCase newSocialCase = new SocialCase();
        newSocialCase.setsocialCaseAge(socialCase.getsocialCaseAge());
        newSocialCase.setsocialCaseContactInfo( socialCase.getsocialCaseContactInfo());
        newSocialCase.setsocialCaseCurrentTown( socialCase.getsocialCaseCurrentTown() );
        newSocialCase.setsocialCaseFname( socialCase.getsocialCaseFname() );
        newSocialCase.setsocialCaseLname( socialCase.getsocialCaseLname() );
        newSocialCase.setsocialCaseHometown( socialCase.getsocialCaseHometown() );
        newSocialCase.setSocialCaseIsSensitive( socialCase.getSocialCaseIsSensitive() );
        newSocialCase.setsocialCaseNotes( socialCase.getsocialCaseNotes());
        newSocialCase.setSocialCaseFamilyAge( socialCase.getSocialCaseFamilyAge());
        newSocialCase.setSocialCaseFamilyFName( socialCase.getsocialCaseFname() );
        newSocialCase.setSocialCaseFamilyLName( socialCase.getsocialCaseLname() );
        newSocialCase.setSocialCaseFamilyRelationship( socialCase.getSocialCaseFamilyRelationship());
        newSocialCase.setSocialCaseFamilyLastKnownLocation( socialCase.getSocialCaseFamilyLastKnownLocation());
        newSocialCase.setSocialCaseFamilyNotes( socialCase.getSocialCaseFamilyNotes() );
        newSocialCase.setUser( currentUser );

        return socialcaserepo.save( newSocialCase );

    }
    @Transactional
    @Override
    public SocialCase update(SocialCase socialCase,
                       long id)
    {
        SocialCase currentCase = socialcaserepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (socialCase.getsocialCaseAge() != null)
        {
            currentCase.setsocialCaseAge(socialCase.getsocialCaseAge());
        }
        if (socialCase.getsocialCaseContactInfo() != null) {
            currentCase.setsocialCaseContactInfo( socialCase.getsocialCaseContactInfo() );
        }
        if (socialCase.getsocialCaseCurrentTown() != null) {
            currentCase.setsocialCaseCurrentTown( socialCase.getsocialCaseCurrentTown() );
        }
        if (socialCase.getsocialCaseFname() != null) {
            currentCase.setsocialCaseFname( socialCase.getsocialCaseFname() );
        }
        if (socialCase.getsocialCaseFname() != null) {
            currentCase.setsocialCaseFname( socialCase.getsocialCaseFname() );
        }
        if (socialCase.getsocialCaseLname() != null) {
            currentCase.setsocialCaseLname( socialCase.getsocialCaseLname() );
        }

        if (socialCase.getsocialCaseHometown() != null) {
            currentCase.setsocialCaseHometown( socialCase.getsocialCaseHometown() );
        }

        if (socialCase.getsocialCaseCurrentTown() != null) {
            currentCase.setsocialCaseCurrentTown( socialCase.getsocialCaseCurrentTown() );
        }

        if (socialCase.getsocialCaseNotes() != null) {
            currentCase.setsocialCaseNotes( socialCase.getsocialCaseNotes() );
        }

        if (socialCase.getsocialCaseId() >0) {
            currentCase.setsocialCaseId( socialCase.getsocialCaseId() );
        }

        if (!socialCase.getSocialCaseIsSensitive() == socialCase.getSocialCaseIsSensitive()) {
            currentCase.setSocialCaseIsSensitive( socialCase.getSocialCaseIsSensitive() );
        }

        if (socialCase.getSocialCaseFamilyAge() != null) {
            currentCase.setSocialCaseFamilyAge( socialCase.getSocialCaseFamilyAge() );
        }

        if (socialCase.getSocialCaseFamilyFName() != null) {
            currentCase.setSocialCaseFamilyFName( socialCase.getSocialCaseFamilyFName() );
        }

        if (socialCase.getSocialCaseFamilyLName() != null) {
            currentCase.setSocialCaseFamilyLName( socialCase.getSocialCaseFamilyLName() );
        }

        if (socialCase.getSocialCaseFamilyLastKnownLocation() != null) {
            currentCase.setSocialCaseFamilyLastKnownLocation( socialCase.getSocialCaseFamilyLastKnownLocation() );
        }

        if (socialCase.getSocialCaseFamilyRelationship() != null) {
            currentCase.setSocialCaseFamilyRelationship( socialCase.getSocialCaseFamilyRelationship() );
        }

        if (socialCase.getSocialCaseFamilyNotes() != null) {
            currentCase.setSocialCaseFamilyNotes( socialCase.getSocialCaseFamilyNotes() );
        }

        return socialcaserepo.save(socialCase);
    }
}
