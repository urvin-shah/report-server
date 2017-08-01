package com.report.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.report.domain.WebsiteVisitDtls;

public interface WebsiteVisitRepository extends MongoRepository<WebsiteVisitDtls, String>{
	public List<WebsiteVisitDtls> findByVisitDate(Date visitDate);
}
