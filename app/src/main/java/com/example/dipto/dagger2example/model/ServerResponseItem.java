package com.example.dipto.dagger2example.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ServerResponseItem{

	@SerializedName("name")
	private String name;

	@SerializedName("email")
	private String email;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"ServerResponseItem{" + 
			"name = '" + name + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}