package com.neurogine.assesment.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neurogine.assesment.domain.entity.Merchant;
/**
 * 
 * @author Chinthana
 *
 */
@Repository
public interface MerchantRepository extends CrudRepository<Merchant, Long>{
	
	Optional<Merchant> findById(long id);

}
