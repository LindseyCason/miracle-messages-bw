package com.lambdaschool.starthere.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.starthere.models.SocialCase;
import com.lambdaschool.starthere.models.User;
import com.lambdaschool.starthere.services.SocialCaseService;
import com.lambdaschool.starthere.services.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SocialCaseController.class, secure = false)
public class SocialCaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SocialCaseService socialCaseService;
    private ArrayList<SocialCase> socialCaseList;
    private ArrayList<User> thisUser;
    private UserService userService;


    @Before
    public void setUp() throws Exception {

        // build a socialcase array
        socialCaseList = new ArrayList<>();

        //build a user array
        thisUser = new ArrayList<>();

        User u1 = new User(); //name a new user
        u1.setUserid( 7 );
        u1.setUsername( "Amanda" );
        u1.setPrimaryemail( "email@email.com" );
        u1.setPassword( "password" );
        thisUser.add(u1); //add your user to your user array

        SocialCase c1 = new SocialCase(); //name a new social case
        c1.setsocialCaseId( 14 );
        c1.setsocialCaseFname( "Lindsey" );
        c1.setsocialCaseLname("Cason");
        c1.setsocialCaseAge( "31" );
        c1.setsocialCaseHometown( "Gainesville, FL" );
        c1.setsocialCaseCurrentTown( "NOLA" );
        c1.setsocialCaseContactInfo( "555-555-5555" );
        c1.setsocialCaseNotes( "This is a note" );
        c1.setSocialCaseIsSensitive( false );
        c1.setSocialCaseFamilyFName( "Gina" );
        c1.setSocialCaseFamilyLName( "Cason" );
        c1.setSocialCaseFamilyAge( "56" );
        c1.setSocialCaseFamilyRelationship( "Mother" );
        c1.setSocialCaseFamilyLastKnownLocation( "Alachua, FL" );
        c1.setSocialCaseFamilyNotes( "This is a family testing note" );
        c1.setUser( u1 ); //<=add your user above to your social case

        SocialCase c12 = new SocialCase(); //name a new social case
        c12.setsocialCaseId( 16 );
        c12.setsocialCaseFname( "Lindsey" );
        c12.setsocialCaseLname("Cason");
        c12.setsocialCaseAge( "31" );
        c12.setsocialCaseHometown( "Gainesville, FL" );
        c12.setsocialCaseCurrentTown( "NOLA" );
        c12.setsocialCaseContactInfo( "555-555-5555" );
        c12.setsocialCaseNotes( "This is a note" );
        c12.setSocialCaseIsSensitive( false );
        c12.setSocialCaseFamilyFName( "Gina" );
        c12.setSocialCaseFamilyLName( "Cason" );
        c12.setSocialCaseFamilyAge( "56" );
        c12.setSocialCaseFamilyRelationship( "Mother" );
        c12.setSocialCaseFamilyLastKnownLocation( "Alachua, FL" );
        c12.setSocialCaseFamilyNotes( "This is a family testing note" );
        c12.setUser( u1 ); //<=add your user above to your social case

        socialCaseList.add( c12); //add the complete social case to the social case array
        socialCaseList.add( c1); //add the complete social case to the social case array

    }

    @After
    public void tearDown() throws Exception {

    }

    ///////
    @Test //PASSING
    public void listAllCases() throws Exception {

        String apiUrl = "/socialCases/socialCases";

        Mockito.when(socialCaseService.findAll(Pageable.unpaged())).thenReturn(socialCaseList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get( apiUrl ).accept( MediaType.APPLICATION_JSON );

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String testresult = result.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper(  );
        String expectedresult = mapper.writeValueAsString( socialCaseList );
        assertEquals("unit text adding controller test", expectedresult,testresult );
    }


    @Test //PASSING
    public void addNewSocialCase() throws Exception {

        String apiUrl = "/socialCases/socialCases/add";
        //your endpoint goes here

        User u1 = new User(); //name a new user
        u1.setUserid( 7 );
        u1.setUsername( "Amanda" );
        u1.setPrimaryemail( "email@email.com" );
        u1.setPassword( "password" );
        thisUser.add(u1); //add your user to your user array


        SocialCase c12 = new SocialCase(); //name a new social case
        c12.setsocialCaseId( 16 );
        c12.setsocialCaseFname( "Lindsey" );
        c12.setsocialCaseLname("Cason");
        c12.setsocialCaseAge( "31" );
        c12.setsocialCaseHometown( "Gainesville, FL" );
        c12.setsocialCaseCurrentTown( "NOLA" );
        c12.setsocialCaseContactInfo( "555-555-5555" );
        c12.setsocialCaseNotes( "This is a note" );
        c12.setSocialCaseIsSensitive( false );
        c12.setSocialCaseFamilyFName( "Gina" );
        c12.setSocialCaseFamilyLName( "Cason" );
        c12.setSocialCaseFamilyAge( "56" );
        c12.setSocialCaseFamilyRelationship( "Mother" );
        c12.setSocialCaseFamilyLastKnownLocation( "Alachua, FL" );
        c12.setSocialCaseFamilyNotes( "This is a family testing note" );
        c12.setUser(u1); //<=add your user above to your social case

        socialCaseList.add(c12); //add the complete social case to the social case array

        ObjectMapper mapper = new ObjectMapper();
        String caseString = mapper.writeValueAsString(c12);

        Mockito.when(socialCaseService.save(any(SocialCase.class))).thenReturn(c12);
        RequestBuilder rb = MockMvcRequestBuilders.post(apiUrl)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(caseString);

        mockMvc.perform(rb).andExpect(status().isCreated()).andDo( MockMvcResultHandlers.print());

    }


    @Test //PASSING
    public void BupdateSocialCase() throws Exception {

        String apiUrl = "/socialCases/socialCase/{socialCaseid}";

        SocialCase c2 = new SocialCase( //name a new social case
                "GILMORE", "Happy", "31", "NeverNever Land", null, null,null,true,null,null,null,null,null,null);

        Mockito.when(socialCaseService.update(c2, 14L)).thenReturn(c2);

        ObjectMapper mapper = new ObjectMapper(  );
        String socialCaseString = mapper.writeValueAsString( c2 );

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put( apiUrl, 14L ).contentType( MediaType.APPLICATION_JSON ).accept( MediaType.APPLICATION_JSON ).content( socialCaseString );

        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

    }

    @Test //PASSING
    public void ZZZdeleteSocialCaseById() throws Exception
    {
        String apiUrl = "/socialCases/socialCases/{socialCaseid}";


        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(apiUrl, 14L).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }



    @Test //PASSING
    public void ZgetSocialCaseById() throws Exception
    {
        String apiUrl = "/socialCases/socialCases/14";


        Mockito.when(socialCaseService.findSocialCaseById(14)).thenReturn(socialCaseList.get(1));

        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);
        MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(socialCaseList.get(1));

        assertEquals("Rest API Returns List", er, tr);
    }





}