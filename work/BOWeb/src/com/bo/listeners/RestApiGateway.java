package com.bo.listeners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;

import com.bo.commons.constants.BoConstants;
import com.bo.commons.converters.DataHolderToJsonConverter;
import com.bo.commons.converters.DataholderConverter;
import com.bo.commons.converters.jsonToDataholderConverter;
import com.bo.commons.holder.DataHolder;
import com.bo.request.ProcessRequest;
import com.bo.web.core.BoApiController;





@Path("/")
public class RestApiGateway {

  @Context
  UriInfo uriInfo;
  public RestApiGateway()
  {
	System.out.println("In Constructor");  
  }
  
  @Path("{path:.*}")
  @GET
  public String  invokegateway(@PathParam("path") String path , @Context HttpServletRequest request) {
	  DataHolder inputdataHolder = new DataHolder();
	  JSONObject json=new JSONObject();
	  String req_type;
	  HashMap<String, List<String>> hashmap=new HashMap<String, List<String>>();
	  try {
			
			 req_type=request.getHeader(BoConstants.Request_Type);
			 BoApiController controller=new BoApiController();
			 hashmap.putAll(uriInfo.getQueryParameters());
			 for(Entry<String, List<String>> entry:  hashmap.entrySet() )
				{
					if(entry.getValue().size()>1)
					{
						
					}
					else
					{
						inputdataHolder.setValue(entry.getKey(), entry.getValue().get(0));
					}
				}
			 DataHolder outdataholder=controller.Invoke(req_type, inputdataHolder);
			 DataHolderToJsonConverter dataHolderToJsonConverter= new DataHolderToJsonConverter();
			json=dataHolderToJsonConverter.Process(outdataholder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return json.toString();
     
  }
 
  @Path("{path:.*}")
  @POST
  public String  request(@PathParam("path") String path , @Context HttpServletRequest request) {
	
	  String message="";
	  Scanner sc;
	  StringBuffer vendor = new StringBuffer();
	  DataholderConverter  dataholderConverter;
	  DataHolder inputdataHolder;
	  JSONObject json=new JSONObject();
	  String req_type;
	try {
		sc = new Scanner(request.getInputStream());
		 while(sc.hasNext())
		  {
			  message+=sc.nextLine();
		  }
		 req_type=request.getHeader(BoConstants.Request_Type);
		 dataholderConverter=jsonToDataholderConverter.class.newInstance();
		  inputdataHolder=dataholderConverter.convertToDataholder(message);
		 BoApiController controller=new BoApiController();
		 DataHolder outdataholder=controller.Invoke(req_type, inputdataHolder);
		 DataHolderToJsonConverter dataHolderToJsonConverter= new DataHolderToJsonConverter();
		json=dataHolderToJsonConverter.Process(outdataholder);
		sc.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	return json.toString();
     
  }
 
}