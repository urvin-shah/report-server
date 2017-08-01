package com.report.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.report.dao.WebsiteVisitRepository;
import com.report.domain.WebsiteVisitDtls;

@Component
public class CSVUtil {

	private static final String DEFAULT_SEPARATOR ="\\|";
	@Autowired
	private WebsiteVisitRepository websiteVisitRepository;
    
	/**
	 * This method parse the CSV file and import the data in to the websitevisitdtls collection of mongodb
	 * @param csvFile
	 * @throws FileNotFoundException
	 */
	public void parseCSV(String csvFile) throws FileNotFoundException {
		String line = "";
        websiteVisitRepository.deleteAll();
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	int count = 0;
        	WebsiteVisitDtls websiteDtls = null;
            while ((line = br.readLine()) != null) {
                // use | as separator
                String[] data = line.split(DEFAULT_SEPARATOR);
                if(count == 0) {
                	count = 1;
                	continue;
                }
                websiteDtls = new WebsiteVisitDtls();
                if(data[0] != null) {
                	websiteDtls.setVisitDate(DateUtil.getDateFromString(data[0]));
                }
                if(data[1] != null) {
                	websiteDtls.setWebsite(data[1]);
                }
                if(data[2] != null) {
                	websiteDtls.setNoOfVisit(Long.parseLong(data[2]));
                }
                websiteVisitRepository.save(websiteDtls);
                //System.out.println("Date[date= " + data[0] + " , site=" + data[1]+" , Visits" + data[2] + "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
