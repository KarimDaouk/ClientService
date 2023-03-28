package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController {


    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //JSON DATA
    public record NewClientRequest(
            Integer id,
            String name,
            Integer Number
    ){ }













    @GetMapping
    public List<Client> getClient(){
        return  clientService.getClient();
    }

    @PostMapping
    public void addClient(@RequestBody NewClientRequest request){
        clientService.addClient(request);

    }

    @DeleteMapping("{clientId}")
    public void deleteClient(@PathVariable("clientId")  Integer id){
        clientService.deleteClient(id);
    }


    @PutMapping("{clientId}")

    public void updateClient(@PathVariable("clientId")  Integer id, @RequestBody ClientController.NewClientRequest request) {

        clientService.updateClient(id,request);
    }




}
