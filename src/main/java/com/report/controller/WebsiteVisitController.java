package com.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.report.domain.WebsiteVisitDtls;
import com.report.service.WebsiteVisitService;
import com.report.utils.DateUtil;

/**
 * This is WebsiteVisit controller, this controller contains the REST API for visit information
 * @author root
 *
 */
@RestController
public class WebsiteVisitController {
	@Autowired
	private WebsiteVisitService websiteVisitService;
	
	/**
	 * This REST API provides the details of all website visit information
	 * @return
	 */
	@RequestMapping("/visits")
	public List<WebsiteVisitDtls> getVisitDetails() {
		List<WebsiteVisitDtls> lstVisits = websiteVisitService.getAllVisits();
		for(WebsiteVisitDtls websiteVisitDtls : lstVisits) {
			System.out.println("Website name :"+websiteVisitDtls.getWebsite()+" , date :"+websiteVisitDtls.getVisitDate()+", and noOfVisits:"+websiteVisitDtls.getNoOfVisit());
		}
		return lstVisits;
	}
	
	/**
	 * This REST api provides the top 5 website information.
	 * @param visitDate
	 * @return
	 */
	@RequestMapping("/topwebsites")
	public List<WebsiteVisitDtls> getTopWebsites(@RequestParam(value="visitDate") String visitDate) {
		List<WebsiteVisitDtls> lstVisits = websiteVisitService.getTop5VisitedSites(DateUtil.getDateFromString(visitDate));
		for(WebsiteVisitDtls websiteVisitDtls : lstVisits) {
			System.out.println("Website name :"+websiteVisitDtls.getWebsite()+" , date :"+websiteVisitDtls.getVisitDate()+", and noOfVisits:"+websiteVisitDtls.getNoOfVisit());
		}
		return lstVisits;
	}
}
