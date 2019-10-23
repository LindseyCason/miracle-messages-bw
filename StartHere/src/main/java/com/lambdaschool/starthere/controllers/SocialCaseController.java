package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.SocialCase;
import com.lambdaschool.starthere.models.ErrorDetail;
import com.lambdaschool.starthere.services.SocialCaseService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/socialCases")
public class SocialCaseController {

    @Autowired
    private SocialCaseService socialCaseService;

    private static final Logger logger = LoggerFactory.getLogger(SocialCaseController.class);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})


    @ApiOperation(value = "Returns all socialCases", response = SocialCase.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "SocialCases Found", response = SocialCase.class),
            @ApiResponse(code = 404, message = "SocialCases Not Found", response = ErrorDetail.class)})
    @GetMapping(value = "/socialCases", produces = {"application/json"})
    public ResponseEntity<?> listAllSocialCases()
    {
        logger.info("endpoint /socialCases has been accessed");
        ArrayList<SocialCase> userSocialCases = socialCaseService.findAll( Pageable.unpaged() );
        return new ResponseEntity<>(userSocialCases, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns socialCases by page", response = SocialCase.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "SocialCases Found", response = SocialCase.class),
            @ApiResponse(code = 404, message = "SocialCases Not Found", response = ErrorDetail.class)})
    @GetMapping(value = "/socialCases/paging", produces = {"application/json"})
    public ResponseEntity<?> listAllSocialCasesByPage(@PageableDefault(page=0, size=5) Pageable pageable){
        List<SocialCase> userSocialCases = socialCaseService.findAllPageable(pageable);
        return new ResponseEntity<>( userSocialCases, HttpStatus.OK );
    }


    @ApiOperation(value = "Deletes socialCase by id", response = SocialCase.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "SocialCase Found", response = SocialCase.class),
            @ApiResponse(code = 404, message = "SocialCase Not Deleted", response = ErrorDetail.class)})
    @DeleteMapping("/socialCases/{socialCaseid}")
    public ResponseEntity<?> deleteSocialCaseById(@PathVariable long socialCaseid)
    {
        logger.info("Delete endpoint /socialCases/:id has been accessed" + socialCaseid);
        socialCaseService.delete(socialCaseid);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @ApiOperation(value = "Returns a socialCase by ID", response = SocialCase.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "SocialCase ID Found", response = SocialCase.class),
            @ApiResponse(code = 404, message = "SocialCase ID Not Found", response = ErrorDetail.class)})
    @GetMapping(value = "/socialCases/{socialCaseid}",
            produces = {"application/json"})
    public ResponseEntity<?> getSocialCaseById(
            @ApiParam(value = "SocialCase ID number", required = true, example = "3")
            @PathVariable long socialCaseid) {
        logger.info( "GET endpoint /socialCases/" + socialCaseid + " has been accessed" );
        SocialCase r = socialCaseService.findSocialCaseById( socialCaseid );
        return new ResponseEntity<>( r, HttpStatus.OK );
    }


    @PostMapping(value = "/socialCases/add",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewSocialCase(@Valid
                                          @RequestBody
                                                  SocialCase newSocialCase) throws URISyntaxException {
        logger.info( "POST endpoint /socialCases/add has been accessed" );
        newSocialCase = socialCaseService.save( newSocialCase );
        return new ResponseEntity<>( HttpStatus.CREATED );
    }



    @ApiOperation(value = "Updates social case information",
            notes = "updates social case information",
            response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Update Successful",
                    response = void.class)
    })
    @PutMapping(value = "/socialCase/{id}")
    public ResponseEntity<?> updateSocialCase(
            @RequestBody SocialCase updateSocialCase,
            @ApiParam(value = "SocialCaseID",
                    required = true,
                    example = "12")
            @PathVariable long id, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        socialCaseService.update(updateSocialCase, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
