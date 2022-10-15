package com.neurogine.assesment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.neurogine.assesment.common.Constant;
import com.neurogine.assesment.domain.dto.request.MerchantCreateRequest;
import com.neurogine.assesment.domain.dto.response.MerchantListResponse;
import com.neurogine.assesment.domain.entity.Merchant;
import com.neurogine.assesment.exception.InputValidationException;
import com.neurogine.assesment.exception.ResourceNotFoundException;
import com.neurogine.assesment.repository.MerchantRepository;

/**
 * 
 * @author Chinthana
 *
 */

@Service
public class MerchantService {

	@Autowired
	MerchantRepository merchantRepository;

	public void createMerchant(MerchantCreateRequest merchantCreateRequest) {
		Merchant merchant = new Merchant();
		BeanUtils.copyProperties(merchantCreateRequest, merchant);

		// if merchantName is null/empty then throw InputValidationException
		if (!StringUtils.hasText(merchant.getName()))
			throw new InputValidationException(Constant.Responsecode.MERCHANT_NAME_CANNOT_NULL.getMessage(),
					Constant.Responsecode.MERCHANT_NAME_CANNOT_NULL.getCode());

		merchantRepository.save(merchant);
	}

	public void deleteMerchant(long merchantId) {		
		Merchant merchant = getMerchantById(merchantId);
		merchantRepository.delete(merchant);
	}

	public Merchant getMerchantById(long merchantId) {
		return merchantRepository.findById(merchantId)
				.orElseThrow(() -> new ResourceNotFoundException(Constant.Responsecode.MERCHANT_NOT_FOUND.getMessage(),
						Constant.Responsecode.MERCHANT_NOT_FOUND.getCode()));

	}

	public List<MerchantListResponse> getAllMerchants() {
		List<MerchantListResponse> list = new ArrayList<>();
		merchantRepository.findAll().forEach(s -> {
			MerchantListResponse merchant = new MerchantListResponse();
			BeanUtils.copyProperties(s, merchant);
			list.add(merchant);
		});
		return list;

	}

}
