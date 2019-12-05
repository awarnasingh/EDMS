package com.edms.core.web.rest.vm;

import java.io.Serializable;
import java.util.List;

/**
 * @author anurag
 *
 */
public class Inventory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Long> id;

	public List<Long> getId() {
		return id;
	}

	public void setId(List<Long> id) {
		this.id = id;
	}
}
