package clients.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import clients.model.Client;
import clients.service.ClientsService;

@RestController
public class ClientsRestController {
	
	@Autowired
	private ClientsService clientsService;
	
	@GetMapping("/hello")
	public String hello(){
		return "Hello Word";
	}
	
//	@GetMapping("/all-clients")
//	public String allClients(){
//		
//		return clientsService.findAll().toString();
//		
//	}
//	
//	@GetMapping("/save-client")
//	public String saveClient(@RequestParam String first_name,
//							@RequestParam String last_name,
//							@RequestParam String email){
//		Client client = new Client (first_name, last_name, email, new Date());
//		clientsService.save(client);
//		return "Client saved";
//	}
//	
//	@GetMapping("/delete-client")
//	public String saveClient(@RequestParam int id){
//		clientsService.delete(id);
//		return "Client deleted";
//	}

}
