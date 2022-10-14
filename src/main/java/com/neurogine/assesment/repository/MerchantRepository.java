package com.neurogine.assesment.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neurogine.assesment.domain.entity.Merchant;


@Repository
public interface MerchantRepository extends CrudRepository<Merchant, Long>{
	
	Optional<Merchant> findById(UUID id);

}
