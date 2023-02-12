package br.com.sskings.apirestfull.controllers;

import br.com.sskings.apirestfull.dtos.ClienteDto;
import br.com.sskings.apirestfull.models.ClienteModel;
import br.com.sskings.apirestfull.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @PostMapping
    public ResponseEntity<Object> salvarCliente(@RequestBody @Valid ClienteDto clienteDto){
        if (clienteService.existeEmail(clienteDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já existe");
        }
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> listarClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarCliente(@PathVariable(value = "id") Long clienteId){
        Optional<ClienteModel> optionalCliente = clienteService.buscar(clienteId);
        if(!optionalCliente.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalCliente.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCliente(@PathVariable(value = "id") Long clienteId){
        Optional<ClienteModel> optionalCliente = clienteService.buscar(clienteId);
        if (!optionalCliente.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("não encontrado");
        }
        clienteService.deletar(optionalCliente.get());
        return ResponseEntity.status(HttpStatus.OK).body("cliente deletado");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable(value = "id") long clienteId,
                                                   @RequestBody @Valid ClienteDto clienteDto){
        Optional<ClienteModel> optionalCliente = clienteService.buscar(clienteId);
        if (!optionalCliente.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("não encontrado");
        }
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto,clienteModel);
        clienteModel.setId(optionalCliente.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));
    }
}
