package com.example.demo;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }



    public List<Client> getClient(){
        return clientRepository.findAll();
    }




    public void addClient(ClientController.NewClientRequest request){
        Client client= new Client();
        client.setId(request.id());
        client.setName(request.name());
        client.setNumber(request.Number());

        clientRepository.save(client);
    }

    public void deleteClient( Integer id){
        clientRepository.deleteById(id);
    }


    public void updateClient(@PathVariable("clientId")  Integer id, @RequestBody ClientController.NewClientRequest request){
        Client client= clientRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Client not found with id"+ id));
        client.setNumber(request.Number());
        client.setName(request.name());
        client.setId(id);
        clientRepository.deleteById(id);
        clientRepository.save(client);

    }
}
