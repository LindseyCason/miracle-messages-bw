package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "case", description = "The Case Model")
@Entity
@Table(name = "case")
public class Case extends Auditable {
    @ApiModelProperty(name = "caseId", value = "Primary ID key for each case", required = true, example = "143")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long caseId;

//    @ApiModelProperty(name = "caseCreatedBy", value = "ID of the VOL who created this case", required = false, example = "14") //set this requirement to false for the moment
//    @Column
//    private long caseCreatedBy;

    @ApiModelProperty(name = "caseFname", value = "First Name of the Case", required = true, example = "John")
    @Column
    private String caseFname;

    @ApiModelProperty(name = "caseLname", value = "Last Name of the Case", required = true, example = "Smith")
    @Column
    private String caseLname;

    @ApiModelProperty(name = "caseAge", value = "Age of the Case", required = false, example = "55")
    @Column
    private int caseAge;

    @ApiModelProperty(name = "caseHometown", value = "Hometown of the Case", required = false, example = "Gainesville, FL")
    @Column
    private String caseHometown;

    @ApiModelProperty(name = "caseCurrentTown", value = "Current Town of the Case", required = true, example = "New Orleans, LA")
    @Column
    private String caseCurrentTown;

    @ApiModelProperty(name = "caseContactInfo", value = "Way to contact the Case", required = true, example = "555-555-5555 or Know to frequent McDonalds on 3rd St.")
    @Column
    private String caseContactInfo;

    @ApiModelProperty(name = "caseNotes", value = "Notes about the Case", required = false, example = "John is a veteran and visits the VA once a month around the 5th")
    @Column
    private String caseNotes;

    @ApiModelProperty(name = "caseSensitive", value = "Sensitivity status the Case", required = true, example = "true/ is sensitive false/ not sensitive")
    @Column
    private boolean caseIsSensitive;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties(value = {"userid", "hibernateLazyInitializer"}) //?? //thsi was in restaurant/menu project
     private User userid; //this is the field named userid


    /////

    public Case() {
    }


    public Case(long caseCreatedBy, String caseFname, String caseLname, int caseAge, String caseHometown, String caseCurrentTown, String caseContactInfo, String caseNotes, boolean caseSensitive, User userid) {
        this.caseFname = caseFname;
        this.caseLname = caseLname;
        this.caseAge = caseAge;
        this.caseHometown = caseHometown;
        this.caseCurrentTown = caseCurrentTown;
        this.caseContactInfo = caseContactInfo;
        this.caseNotes = caseNotes;
        this.caseIsSensitive = caseIsSensitive;
//        this.caseCreatedBy = caseCreatedBy;
        this.userid = userid;
    }

    public long getcaseId() {
        return caseId;
    }

    public void setcaseId(long caseId) {
        this.caseId = caseId;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    //    public long getCaseCreatedBy() {
//        return caseCreatedBy;
//    }

//    public long setCaseCreatedBy(long caseCreatedBy) {
//        this.caseCreatedBy = caseCreatedBy;
//        return caseCreatedBy;
//    }

    public String getcaseFname() {
        return caseFname;
    }

    public void setcaseFname(String caseFname) {
        this.caseFname = caseFname;
    }

    public String getcaseLname() {
        return caseLname;
    }

    public void setcaseLname(String caseLname) {
        this.caseLname = caseLname;
    }

    public int getcaseAge() {
        return caseAge;
    }

    public void setcaseAge(int caseAge) {
        this.caseAge = caseAge;
    }

    public String getcaseHometown() {
        return caseHometown;
    }

    public void setcaseHometown(String caseHometown) {
        this.caseHometown = caseHometown;
    }

    public String getcaseCurrentTown() {
        return caseCurrentTown;
    }

    public void setcaseCurrentTown(String caseCurrentTown) {
        this.caseCurrentTown = caseCurrentTown;
    }

    public String getcaseContactInfo() {
        return caseContactInfo;
    }

    public void setcaseContactInfo(String caseContactInfo) {
        this.caseContactInfo = caseContactInfo;
    }

    public String getcaseNotes() {
        return caseNotes;
    }

    public void setcaseNotes(String caseNotes) {
        this.caseNotes = caseNotes;
    }

    public boolean iscaseSensitive() {
        return caseIsSensitive;
    }

    public void setcaseIsSensitive(boolean caseIsSensitive) {
        this.caseIsSensitive = caseIsSensitive;
    }
}
