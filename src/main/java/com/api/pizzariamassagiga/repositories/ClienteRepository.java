package com.api.pizzariamassagiga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.pizzariamassagiga.models.ClienteModel;



@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

	boolean existsByCpf(String cpf);
}
