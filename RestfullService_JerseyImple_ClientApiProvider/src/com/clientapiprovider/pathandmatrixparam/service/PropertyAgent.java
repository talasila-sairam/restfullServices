package com.clientapiprovider.pathandmatrixparam.service;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/agent/{location}")
public class PropertyAgent {
    
	public PropertyAgent() {
		System.out.println("inside PropertyAgent class constructor");
  }
	@GET
	@Path("/search/{type}/{areaName}")
	public String search(@PathParam("location") String location ,@PathParam("type") String type ,@PathParam("areaName") String areaName ,@MatrixParam("flatType")String flatType ,@QueryParam("minBudget") double minBudget ,@QueryParam("maxBudget") double maxBudget ) {
		System.out.println("inside search resource method");
		StringBuffer sb = null;
		sb = new StringBuffer();
		sb.append("location : "+location).append(" ,PropertyType : ").append(type).append(" ,AreaName : ").append(areaName).append(" flatType : ").append(flatType).append(" minBudget : ").append(minBudget+"").append(" maxBudget : ").append(maxBudget +"");
		return sb.toString();
	}
}
