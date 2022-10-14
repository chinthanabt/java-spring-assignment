package com.neurogine.assesment.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neurogine.assesment.domain.dto.request.MerchantCreateRequest;
import com.neurogine.assesment.domain.dto.response.MerchantListResponse;
import com.neurogine.assesment.service.MerchantService;


@RestController
@RequestMapping(value = "/merchant", produces = { APPLICATION_JSON_VALUE })
public class MerchantContoller {
	
	@Autowired
	MerchantService merchantService;
	
	@PostMapping   
    public ResponseEntity<Void> createMerchant(@RequestBody MerchantCreateRequest merchantCreateRequest) {
		 merchantService.createMerchant(merchantCreateRequest);
		 return new ResponseEntity<Void>(HttpStatus.CREATED);     
    }
	
	@DeleteMapping   
    public ResponseEntity<Void> deleteMerchant(@PathVariable String merchantId) {		
		 merchantService.deleteMerchant(merchantId);
		 return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
	@GetMapping
	public ResponseEntity<List<MerchantListResponse>> listMerchants() {
		return ResponseEntity.ok(merchantService.getAllMerchants());
	}

}
