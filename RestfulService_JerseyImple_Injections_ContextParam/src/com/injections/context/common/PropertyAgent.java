package com.injections.context.common;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriInfo;

@Path("/agent/{location}")
public class PropertyAgent {
 public PropertyAgent() {
	 System.out.println("Resource class constructor");
}
 
 @GET
 @Path("/search/{area}")
 @Produces(MediaType.TEXT_PLAIN)
 public String search(@Context UriInfo uriInfo) {
	 System.out.println("inside the resource method--> search");
	 String path = null;
	 System.out.println("path from uriInfo Object is   "+uriInfo.getPath());
	 MultivaluedMap<String, String> queryParams = null;
	 MultivaluedMap<String, String> matrixParams = null;
	 List<PathSegment> pathSegments = null;
	 queryParams =  uriInfo.getQueryParameters();
	 pathSegments = uriInfo.getPathSegments();
	 StringBuffer sb = new StringBuffer();
	 for(PathSegment pathSegment : pathSegments) {
		 path = pathSegment.getPath();
		 sb.append("Path is "+path+" ");
		 matrixParams = pathSegment.getMatrixParameters();
		 for(String key : matrixParams.keySet()) {
			 sb =sb.append(" Matrix Key  : "+key +" Matrix Value : "+matrixParams.getFirst(key).toString()+" ");
		 }
	 }
	 for(String key : queryParams.keySet() ) {
		 sb = sb.append(" Query Key : "+key+" Query Value : "+queryParams.getFirst(key)+" ");
	 }
	 return sb.toString();
	 
 }
}
