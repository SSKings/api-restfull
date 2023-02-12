package br.com.sskings.apirestfull.services;

import br.com.sskings.apirestfull.models.ClienteModel;
import br.com.sskings.apirestfull.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteModel save(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

    public boolean existeEmail(String email){
        return clienteRepository.existsByEmail(email);
    }

    public List<ClienteModel> listar(){
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> buscar(long clienteId){
       return clienteRepository.findById(clienteId);
    }

    public void deletar(ClienteModel clienteModel){
        clienteRepository.delete(clienteModel);
    }
}
