package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.StartHereApplication;
import com.lambdaschool.starthere.models.SocialCase;
import com.lambdaschool.starthere.models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartHereApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SocialCaseServiceImplTest {
    @Autowired
    private SocialCaseService socialCaseService;

    @Before
    public void AsetUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void BtearDown() throws Exception {

    }

    @Test
    public void CfindAll()
    {
        assertEquals(0, socialCaseService.findAll(Pageable.unpaged()).size());
        //zero because there is no seed data
    }


}
