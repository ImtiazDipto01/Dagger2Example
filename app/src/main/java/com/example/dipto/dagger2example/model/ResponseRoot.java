package com.example.dipto.dagger2example.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

public class ResponseRoot{

	@SerializedName("server_response")
	private List<ServerResponseItem> serverResponse;

	public void setServerResponse(List<ServerResponseItem> serverResponse){
		this.serverResponse = serverResponse;
	}

	public List<ServerResponseItem> getServerResponse(){
		return serverResponse;
	}

	@Override
 	public String toString(){
		return 
			"ResponseRoot{" + 
			"server_response = '" + serverResponse + '\'' + 
			"}";
		}
}