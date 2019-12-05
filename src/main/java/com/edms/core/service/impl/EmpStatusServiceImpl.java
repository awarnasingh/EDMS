package com.edms.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edms.core.constants.ConstantUtils;
import com.edms.core.domain.Charts;
import com.edms.core.domain.Data;
import com.edms.core.domain.StatusData;
import com.edms.core.repository.EmpStatusRepository;
import com.edms.core.service.EmpStatusService;

/**
 * @author anurag
 *
 */
@Service
@Transactional
public class EmpStatusServiceImpl implements EmpStatusService{

	@Autowired
	EmpStatusRepository empStatusRepository;
	
	/**
	 * Setting the {@link Charts} data and 
	 * @returns chart data 
	 */
	@Override
	public List<Charts> getEmpStatus(){
		List<Data> c2c=empStatusRepository.getC2CStatus();
		List<Data> w2 =empStatusRepository.getW2Status();
		List<StatusData> employerC2c = empStatusRepository.getEmployerC2CStatus();
		List<StatusData> employerW2 = empStatusRepository.getEmployerW2Status();
		List<Charts> chartsList =new ArrayList<Charts>();
		Charts chart = new Charts();
		chart.setData(w2);
		chart.setGraph(ConstantUtils.PIE);
		chart.setInnerSize(ConstantUtils.CHART_INNER_SIZE);
		chart.setTitle(ConstantUtils.CHART_TITLE);
		chart.setName(ConstantUtils.CHART_NAME);
		chart.setStatusData(employerW2);
		
		Charts chart1 = new Charts();
		chart1.setData(c2c);
		chart1.setGraph(ConstantUtils.PIE);
		chart1.setInnerSize(ConstantUtils.CHART_INNER_SIZE);
		chart1.setTitle(ConstantUtils.CHART_TITLE);
		chart1.setName(ConstantUtils.CHART_NAME);
		chart1.setStatusData(employerC2c);
		
		chartsList.add(chart);
		chartsList.add(chart1);
		
		return chartsList;
	}
}
