package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(value = "socialCase", description = "The Case Model")
@Entity
@Table(name = "socialCase")
public class SocialCase {

    @ApiModelProperty(name = "socialCaseId", value = "Primary ID key for each socialCase", required = true, example = "143")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long socialCaseId;

    @ApiModelProperty(name = "socialCaseFname", value = "First Name of the Case", required = true, example = "John")
    private String socialCaseFname;

    @ApiModelProperty(name = "socialCaseLname", value = "Last Name of the Case", required = true, example = "Smith")
    private String socialCaseLname;

    @ApiModelProperty(name = "socialCaseAge", value = "Age of the Case", required = false, example = "55")
    private String socialCaseAge;

    @ApiModelProperty(name = "socialCaseHometown", value = "Hometown of the Case", required = false, example = "Gainesville, FL")
    private String socialCaseHometown;

    @ApiModelProperty(name = "socialCaseCurrentTown", value = "Current Town of the Case", required = true, example = "New Orleans, LA")
    private String socialCaseCurrentTown;

    @ApiModelProperty(name = "socialCaseContactInfo", value = "Way to contact the Case", required = true, example = "555-555-5555 or Know to frequent McDonalds on 3rd St.")
    private String socialCaseContactInfo;

    @ApiModelProperty(name = "socialCaseNotes", value = "Notes about the Case", required = false, example = "John is a veteran and visits the VA once a month around the 5th")
    private String socialCaseNotes;

    @ApiModelProperty(name = "socialCaseIsSensitive", value = "Sensitivity status the Case", required = true, example = "true/ is sensitive false/ not sensitive")
    private boolean socialCaseIsSensitive;

    @ApiModelProperty(name = "socialCaseFamilyFName", value = "First Name of potential family member", required = true, example = "Jane or Unknown")
    private String socialCaseFamilyFName;

    @ApiModelProperty(name = "socialCaseFamilyLName", value = "Last Name of potential Family Member", required = true, example = "Doe or Unknown")
    private String socialCaseFamilyLName;

    @ApiModelProperty(name = "socialCaseFamilyAge", value = "Approx Age of potential Family Member", required = true, example = "67 or Unknown")
    private String socialCaseFamilyAge;

    @ApiModelProperty(name = "socialCaseRelationshipToCase", value = "Relationship of Family Member to Social Case", example = "Mother")
    private String socialCaseFamilyRelationship;

    @ApiModelProperty(name = "socialCaseFamilyLastKnownLocation", value = "Last known location of family member", example = "Hollywood")
    private String socialCaseFamilyLastKnownLocation;

    @ApiModelProperty(name = "socialCaseFamilyNotes", value = "Helpful notes to locate the family", example = "They addend Holy Cross Church on Sunday")
    private String socialCaseFamilyNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = {"socialCases", "hibernateLazyInitializer"})
    private User user; //this is correct


    public SocialCase() {
    }

    public SocialCase(String socialCaseFname, String socialCaseLname, String socialCaseAge, String socialCaseHometown, String socialCaseCurrentTown, String socialCaseContactInfo, String socialCaseNotes, boolean socialCaseIsSensitive, String socialCaseFamilyFName, String socialCaseFamilyLName, String socialCaseFamilyAge, String socialCaseFamilyRelationship, String socialCaseFamilyLastKnownLocation, String socialCaseFamilyNotes, long posterID, User user) {
        this.socialCaseFname = socialCaseFname;
        this.socialCaseLname = socialCaseLname;
        this.socialCaseAge = socialCaseAge;
        this.socialCaseHometown = socialCaseHometown;
        this.socialCaseCurrentTown = socialCaseCurrentTown;
        this.socialCaseContactInfo = socialCaseContactInfo;
        this.socialCaseNotes = socialCaseNotes;
        this.socialCaseIsSensitive = socialCaseIsSensitive;
        this.socialCaseFamilyFName = socialCaseFamilyFName;
        this.socialCaseFamilyLName = socialCaseFamilyLName;
        this.socialCaseFamilyAge = socialCaseFamilyAge;
        this.socialCaseFamilyRelationship = socialCaseFamilyRelationship;
        this.socialCaseFamilyLastKnownLocation = socialCaseFamilyLastKnownLocation;
        this.socialCaseFamilyNotes = socialCaseFamilyNotes;
        this.user = user;
    }

    public SocialCase(String gilmore, String happy, String s, String neverNever_land, Object o, Object o1, Object o2, boolean b, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8) {
    }


    public String getSocialCaseFamilyFName() {
        return socialCaseFamilyFName;
    }

    public void setSocialCaseFamilyFName(String socialCaseFamilyFName) {
        this.socialCaseFamilyFName = socialCaseFamilyFName;
    }

    public String getSocialCaseFamilyLName() {
        return socialCaseFamilyLName;
    }

    public void setSocialCaseFamilyLName(String socialCaseFamilyLName) {
        this.socialCaseFamilyLName = socialCaseFamilyLName;
    }

    public String getSocialCaseFamilyAge() {
        return socialCaseFamilyAge;
    }

    public void setSocialCaseFamilyAge(String socialCaseFamilyAge) {
        this.socialCaseFamilyAge = socialCaseFamilyAge;
    }

    public String getSocialCaseFamilyRelationship() {
        return socialCaseFamilyRelationship;
    }

    public void setSocialCaseFamilyRelationship(String socialCaseFamilyRelationship) {
        this.socialCaseFamilyRelationship = socialCaseFamilyRelationship;
    }

    public String getSocialCaseFamilyLastKnownLocation() {
        return socialCaseFamilyLastKnownLocation;
    }

    public void setSocialCaseFamilyLastKnownLocation(String socialCaseFamilyLastKnownLocation) {
        this.socialCaseFamilyLastKnownLocation = socialCaseFamilyLastKnownLocation;
    }

    public String getSocialCaseFamilyNotes() {
        return socialCaseFamilyNotes;
    }

    public void setSocialCaseFamilyNotes(String socialCaseFamilyNotes) {
        this.socialCaseFamilyNotes = socialCaseFamilyNotes;
    }

    public long getsocialCaseId() {
        return socialCaseId;
    }

    public void setsocialCaseId(long socialCaseId) {
        this.socialCaseId = socialCaseId;
    }

    public User getUser() {
        return user;
    }//This is correct

    public void setUser(User user) {
        this.user = user;
    }

    public String getsocialCaseFname() {
        return socialCaseFname;
    }

    public void setsocialCaseFname(String socialCaseFname) {
        this.socialCaseFname = socialCaseFname;
    }

    public String getsocialCaseLname() {
        return socialCaseLname;
    }

    public void setsocialCaseLname(String socialCaseLname) {
        this.socialCaseLname = socialCaseLname;
    }

    public String getsocialCaseAge() {
        return socialCaseAge;
    }

    public void setsocialCaseAge(String socialCaseAge) {
        this.socialCaseAge = socialCaseAge;
    }

    public String getsocialCaseHometown() {
        return socialCaseHometown;
    }

    public void setsocialCaseHometown(String socialCaseHometown) {
        this.socialCaseHometown = socialCaseHometown;
    }

    public String getsocialCaseCurrentTown() {
        return socialCaseCurrentTown;
    }

    public void setsocialCaseCurrentTown(String socialCaseCurrentTown) {
        this.socialCaseCurrentTown = socialCaseCurrentTown;
    }

    public String getsocialCaseContactInfo() {
        return socialCaseContactInfo;
    }

    public void setsocialCaseContactInfo(String socialCaseContactInfo) {
        this.socialCaseContactInfo = socialCaseContactInfo;
    }

    public String getsocialCaseNotes() {
        return socialCaseNotes;
    }

    public void setsocialCaseNotes(String socialCaseNotes) {
        this.socialCaseNotes = socialCaseNotes;
    }

    public boolean getSocialCaseIsSensitive() {
        return socialCaseIsSensitive;
    }

    public void setSocialCaseIsSensitive(boolean socialCaseIsSensitive) {
        this.socialCaseIsSensitive = socialCaseIsSensitive;
    }

}
