package com.edms.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.domain.Configuration;
import com.edms.core.repository.ClientDomainRepository;
import com.edms.core.repository.EmpTypeRepository;
import com.edms.core.repository.EmployerRepository;
import com.edms.core.repository.EndClientRepository;
import com.edms.core.repository.JobTitleRepository;
import com.edms.core.repository.LocationRepository;
import com.edms.core.repository.ModeRepository;
import com.edms.core.repository.PayTypeRepository;
import com.edms.core.repository.PrimeVendorRepository;
import com.edms.core.repository.StatusRepository;
import com.edms.core.repository.WorkAuthorizationRepository;
import com.edms.core.service.DropdownService;

@Service
@Transactional
public class DropdownServiceImpl implements DropdownService {

    @Autowired
    EmpTypeRepository empTypeRepository;
    @Autowired
    WorkAuthorizationRepository workAuthorizationRepository;
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    JobTitleRepository jobTitleRepository;
    @Autowired
    ModeRepository modeRepository;
    @Autowired
    PayTypeRepository payTypeRepository;
    @Autowired
    EmployerRepository employerRepository;
    @Autowired
    ClientDomainRepository clientDomainRepository; 
    @Autowired
    EndClientRepository endClientRepository;
    @Autowired
    PrimeVendorRepository primeVendorRepository;
    

    @Override
    public Configuration getDropdowns(){
    	Configuration configuration=new Configuration();
		configuration.setEmpType(empTypeRepository.findAll());
    	configuration.setDomainList(clientDomainRepository.findAll());
    	configuration.setEmployer(employerRepository.findAll());
    	configuration.setEndClient(endClientRepository.findAll());
    	configuration.setJobTitle(jobTitleRepository.findAll());
    	configuration.setLocation(locationRepository.findAll());
    	configuration.setMode(modeRepository.findAll());
    	configuration.setPayType(payTypeRepository.findAll());
    	configuration.setPrimeVendor(primeVendorRepository.findAll());
    	configuration.setStatus(statusRepository.findAll());
    	configuration.setWorkAuthorization(workAuthorizationRepository.findAll());
    	return configuration;    	
    }
    
    
    
    
//    /**
//     * returns searchDropdown after filtering the dropdown data
//     */
//    @Override
//    public SearchDropdown getSearchDropdown() {
//
//        SearchDropdown searchDropdown = new SearchDropdown();
//        List<DropDownValue> ddList = professionalRepository.searchDropdown();
//        System.err.println("..........................................." + ddList.get(0).getLocation());
////        Set<String> domain = new HashSet<String>();
//        Map<Integer, String> domain = new HashMap();
//        Map<Integer, String> endClient = new HashMap();
//        Map<Integer, String> location = new HashMap();
//        Map<Integer, String> status = new HashMap();
//        Map<Integer, String> empType = new HashMap();
//
//        //------------------test purpose
//
//        empType.put(1, "C2C");
//        empType.put(2, "W2");
//
//        //-----------------------------------
//
//        Map<Integer, String> mode = new HashMap<>();
//        Map<Integer, String> employer = new HashMap<>();
//        Map<Integer, String> primeVendor = new HashMap<>();
//
//    /*    for (DropDownValue dd : ddList) {
//            domain.add(dd.getClientDomain());
//            endClient.add(dd.getEndClient());
//            location.add(dd.getLocation());
//            status.add(dd.getStatus());
//			empType.add(dd.getEmpType());
//            mode.add(dd.getMode());
//            employer.add(dd.getEmployer());
//            primeVendor.add(dd.getPrimeVendor());
//        }*/
//
//
//        searchDropdown.setDomainList(domain);
//        searchDropdown.setEndClient(endClient);
//        searchDropdown.setLocation(location);
//        searchDropdown.setStatus(status);
//        searchDropdown.setEmpType(empType);
//        searchDropdown.setMode(mode);
//        searchDropdown.setEmployer(employer);
//        searchDropdown.setPrimeVendor(primeVendor);
//
//        return searchDropdown;
//    }
//
//    /**
//     * returns Configuration for create employee dropdowns
//     * Value is hard coded for the given time as per the requirement
//     */
//    @Override
//    public Configuration getUpdateDropdown() {
//        // TODO Auto-generated method stub
//        Map<Integer, String> empType = new HashMap();
//        Map<Integer, String> workAuthorization = new HashMap();
//        Map<Integer, String> status = new HashMap();
//        Map<Integer, String> location = new HashMap();
//        Map<Integer, String> mode = new HashMap();
//        Map<Integer, String> payType = new HashMap();
//        Map<Integer, String> employer = new HashMap();
//
//        //------------------test purpose
//        empType.put(1, "C2C");
//        empType.put(2, "W2");
//        payType.put(1,"Salary");
//        payType.put(2,"Hourly");
//        payType.put(3,"Percentage");
//        status.put(1,"N/A");
//        status.put(2,"Inactive Bench");
//        status.put(3,"Active Bench");
//        employer.put(1,"N/A");
//        mode.put(1,"N/A");
//        workAuthorization.put(1,"Employment Auth Document");
//        workAuthorization.put(2,"Can work for current employer");
//        workAuthorization.put(3,"Can work for any employer");
//        workAuthorization.put(4,"US Citizenship");
//      /*  workAuthorization.put("N/A");
//        workAuthorization.put("Green Card Holder");
//        workAuthorization.put("Have H1 Visa");
//        workAuthorization.put("Employment Authorization Document");
//        workAuthorization.put("Not Specified");
//        workAuthorization.put("Need H1 Visa");
//        workAuthorization.put("US Authorized");
//        workAuthorization.put("US Citizen");
//        workAuthorization.put("Employment Auth. Document");
//        workAuthorization.put("Citizen");
//        workAuthorization.put("Canadian Citizen");
//        workAuthorization.put("TN Visa");
//        workAuthorization.put("GC-EAD");
//        workAuthorization.put("H1B Transfer");
//        workAuthorization.put("GC");
//        workAuthorization.put("CPT");
//        workAuthorization.put("OPT-EAD");
//        workAuthorization.put("H4 EAD");
//        workAuthorization.put("H1-B");
//        workAuthorization.put("L2-EAD");
//        workAuthorization.put("Sponsorship Required");
//        workAuthorization.put("TN Permit Holder");
//        workAuthorization.put("Spain Authorized");
//        workAuthorization.put("Current Employer Only");*/
//        location.put(1,"New Jersey");
//        location.put(2,"Georgia");
//        location.put(3,"Florida");
//        location.put(4,"North Carolina");
//        location.put(5,"Texas");
//        location.put(6,"California");
//       /* location.put("Kansas");
//        location.put("Ontario");
//        location.put("Wisconsin");
//        location.put("Oregon");
//        location.put("Missouri");
//        location.put("New Hampshire");
//        location.put("Tennessee");
//        location.put("Utah");
//        location.put("Washington");
//        location.put("Nevada");
//        location.put("Massachusetts");
//        location.put("Rhode Island");
//        location.put("Arizona");
//        location.put("Minnesota");
//        location.put("Indiana");
//        location.put("Maryland");
//        location.put("District of Columbia");
//        location.put("Connecticut");
//        location.put("North Dakota");
//        location.put("New York");
//        location.put("N/A");
//        location.put("Ohio");
//        location.put("Illinois");
//        location.put("Virginia");
//        location.put("Pennsylvania");
//        location.put("Michigan");
//        location.put("Colorado");
//        location.put("Kentucky");*/
//
//        //-----------------------------------
//        return new Configuration(empType, workAuthorization, status, location, mode, payType, employer);
//    }

}
