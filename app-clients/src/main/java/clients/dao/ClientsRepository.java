package clients.dao;

import org.springframework.data.repository.CrudRepository;

import clients.model.Client;

public interface ClientsRepository extends CrudRepository<Client, Integer> {

}
