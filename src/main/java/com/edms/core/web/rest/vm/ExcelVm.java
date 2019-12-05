package com.edms.core.web.rest.vm;

import com.edms.core.domain.Colunm;

/**
 * @author anurag
 *
 */
public class ExcelVm {
	
	SearchVm searchVm;
	Colunm colunm;
	
	public SearchVm getSearchVm() {
		return searchVm;
	}
	public void setSearchVm(SearchVm searchVm) {
		this.searchVm = searchVm;
	}
	public Colunm getColunm() {
		return colunm;
	}
	public void setColunm(Colunm colunm) {
		this.colunm = colunm;
	}
}
