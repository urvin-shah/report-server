package com.report.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.dao.WebsiteVisitRepository;
import com.report.domain.WebsiteVisitDtls;
/**
 * This is WebsiteVisitService class which contains various API to get Website details.
 * @author root
 *
 */
@Service
public class WebsiteVisitService {
	static final int TOP_WEBSITE_NO = 5;
	@Autowired
	private WebsiteVisitRepository websiteVisitRepository;
	
	/**
	 * This service provide all website visit information
	 * @return
	 */
	public List<WebsiteVisitDtls> getAllVisits() {
		return websiteVisitRepository.findAll();
	}
	
	/**
	 * This service provider top5 visited site's information.
	 * @param date
	 * @return
	 */
	public List<WebsiteVisitDtls> getTop5VisitedSites(Date date) {
		List<WebsiteVisitDtls> filteredList = websiteVisitRepository.findByVisitDate(date);
		if(filteredList != null) {
			filteredList.sort((a,b)-> b.getNoOfVisit().compareTo(a.getNoOfVisit()));
			if(filteredList.size() > TOP_WEBSITE_NO) {
				return filteredList.subList(0, TOP_WEBSITE_NO);
			} else {
				return filteredList;
			}
		}
		return null;
	}
}
