package clients.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import clients.model.Client;
import clients.service.ClientsService;

@Controller
public class MainController {
	
	@Autowired
	private ClientsService clientsService;
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("/all-clients")
	public String allClients(HttpServletRequest request){
		request.setAttribute("clients", clientsService.findAll());
		request.setAttribute("mode", "MODE_CLIENTS");
		return "index";
	}
	
	@GetMapping("/new-client")
	public String newClient(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@PostMapping("/save-client")
	public String saveClient(@ModelAttribute Client client, BindingResult bindingResult,  HttpServletRequest request){
		client.setDateCreated(new Date());
		clientsService.save(client);
		request.setAttribute("clients", clientsService.findAll());
		request.setAttribute("mode", "MODE_CLIENTS");
		return "index";
	}
	
	@GetMapping("/update-client")
	public String updateClient(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("client", clientsService.fintClient(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-client")
	public String deleteClient(@RequestParam int id, HttpServletRequest request){
		clientsService.delete(id);
		request.setAttribute("client", clientsService.fintClient(id));
		request.setAttribute("mode", "MODE_CLIENTS");
		return "index";
	}
}
