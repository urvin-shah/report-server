package com.report.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * This is WebsiteVisitDtls domain object.
 * This domain object contains the various website visit related data.
 * @author root
 *
 */
public class WebsiteVisitDtls {
	@Id
	String id;
	Date visitDate;
	String website;
	Long noOfVisit;
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getVisitDate() {
		return visitDate;
	}
	
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public Long getNoOfVisit() {
		return noOfVisit;
	}
	
	public void setNoOfVisit(Long noOfVisit) {
		this.noOfVisit = noOfVisit;
	}
}
