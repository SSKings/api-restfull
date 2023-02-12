package br.com.sskings.apirestfull.repositories;

import br.com.sskings.apirestfull.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel,Long> {

    boolean existsByEmail(String email);
}
