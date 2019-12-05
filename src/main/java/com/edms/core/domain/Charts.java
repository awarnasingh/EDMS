package com.edms.core.domain;

import java.util.List;

public class Charts {

	    private String innerSize;

	    private List<Data> data;
	    
	    List<StatusData> statusData;

		private String name;

	    private String title;

	    private String graph;

		public String getInnerSize() {
			return innerSize;
		}

		public void setInnerSize(String innerSize) {
			this.innerSize = innerSize;
		}

		public List<Data> getData() {
			return data;
		}

		public void setData(List<Data> data) {
			this.data = data;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTitle() {
			return title;
		}
		

	    public List<StatusData> getStatusData() {
			return statusData;
		}

		public void setStatusData(List<StatusData> statusData) {
			this.statusData = statusData;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getGraph() {
			return graph;
		}

		public void setGraph(String graph) {
			this.graph = graph;
		}

		@Override
		public String toString() {
			return "Charts [innerSize=" + innerSize + ", data=" + data + ", name=" + name + ", title=" + title
					+ ", graph=" + graph + "]";
		}


}




//package com.edms.core.domain;
//
//import java.util.List;
//
//public class Charts {
//
//	    private String innerSize;
//
//	    private List<Data> data;
//
//	    private String name;
//
//	    private String title;
//
//	    private String graph;
//
//		public String getInnerSize() {
//			return innerSize;
//		}
//
//		public void setInnerSize(String innerSize) {
//			this.innerSize = innerSize;
//		}
//
//		public List<Data> getData() {
//			return data;
//		}
//
//		public void setData(List<Data> data) {
//			this.data = data;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public String getTitle() {
//			return title;
//		}
//
//		public void setTitle(String title) {
//			this.title = title;
//		}
//
//		public String getGraph() {
//			return graph;
//		}
//
//		public void setGraph(String graph) {
//			this.graph = graph;
//		}
//
//		@Override
//		public String toString() {
//			return "Charts [innerSize=" + innerSize + ", data=" + data + ", name=" + name + ", title=" + title
//					+ ", graph=" + graph + "]";
//		}
//
//
//}
