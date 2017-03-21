package clients.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import clients.dao.ClientsRepository;
import clients.model.Client;

@Service
@Transactional
public class ClientsService {
	
	private final ClientsRepository clientsRepository;

	public ClientsService(ClientsRepository clientsRepository) {
		this.clientsRepository = clientsRepository;
	}
	
	public List<Client> findAll(){
		List<Client> clients = new ArrayList<>();
		for (Client client : clientsRepository.findAll()){
			clients.add(client);
		}	
		return clients;
	}
	
	public Client fintClient(int id){
		return clientsRepository.findOne(id);
	}
	
	public void save(Client client){
		clientsRepository.save(client);
	}
	
	public void delete(int id){
		clientsRepository.delete(id);
	}
	
}
