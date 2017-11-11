package com.eloi.sociotorcedor.application;

import org.springframework.hateoas.ResourceSupport;

import com.eloi.sociotorcedor.domain.Cliente;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteResource extends ResourceSupport {

	final private Cliente content;
	
	@JsonCreator
	public ClienteResource(@JsonProperty("content") Cliente content) {
		this.content = content;		
	}
	
	public Cliente getContent(){
		return content;
	}


}
