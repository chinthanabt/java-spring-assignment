package com.neurogine.assesment.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neurogine.assesment.domain.entity.Audit;
import com.neurogine.assesment.exception.InputValidationException;
import com.neurogine.assesment.exception.ResourceNotFoundException;
import com.neurogine.assesment.service.AuditService;

/**
 * 
 * @author Chinthana
 *
 */

@Aspect
@Component
public class MerchantServiceInterceptor {
	@Autowired
	AuditService auditService;

	@AfterThrowing(pointcut = "execution(public void com.neurogine.assesment.service.MerchantService.createMerchant(com.neurogine.assesment.domain.dto.request.MerchantCreateRequest))", throwing = "ex")
	public void addAuditForCreateMerchantWhenThrowingException(InputValidationException ex) {
		Audit audit = Audit.of(Audit.Status.FAILED, Audit.Action.ADD_MERCHANT, ex.getMessage());
		auditService.createAudit(audit);
	}

	@AfterThrowing(pointcut = "execution(public void com.neurogine.assesment.service.MerchantService.deleteMerchant(long))", throwing = "ex")
	public void addAuditForDeleteMerchantWhenThrowingException(ResourceNotFoundException ex) {
		Audit audit = Audit.of(Audit.Status.FAILED, Audit.Action.DELETE_MERCHANT, ex.getMessage());
		auditService.createAudit(audit);
	}

}
