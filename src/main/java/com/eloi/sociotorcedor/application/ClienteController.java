package com.eloi.sociotorcedor.application;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eloi.sociotorcedor.domain.Cliente;
import com.eloi.sociotorcedor.domain.ClienteRepository;

@RestController
@RequestMapping(path = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping
	public ResponseEntity<ClienteResource> create(@RequestBody @Valid Cliente cliente){
		Cliente saved = clienteRepository.save(cliente);
		
		ClienteResource clienteResource = new ClienteResource(saved);		
		return new ResponseEntity<ClienteResource>(clienteResource, HttpStatus.CREATED);			
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteResource> getById(@PathVariable("id") Long id){

		Cliente cliente = clienteRepository.findOne(id);
				
		ClienteResource clienteResource = new ClienteResource(cliente);
				
		clienteResource.add(linkTo(methodOn(ClienteController.class).getById(cliente.getId())).withSelfRel());
		return new ResponseEntity<ClienteResource>(clienteResource, HttpStatus.OK);	
	}
}
