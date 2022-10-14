package com.neurogine.assesment.utils;

import java.util.UUID;

import com.neurogine.assesment.common.Constant;
import com.neurogine.assesment.exception.InputValidationException;

public class CommonUtils {

	public static UUID covertStringToUUID(String uuid) {
		try {
			return UUID.fromString(uuid);
		} catch (Exception e) {
			throw new InputValidationException(Constant.Responsecode.INVALID_UUID_FROMAT.getMessage(), 
					Constant.Responsecode.INVALID_UUID_FROMAT.getCode());
		}
		
	}
}
