package com.neurogine.assesment.common;

public class Constant {

	public enum Responsecode {
		
		INTERNAL_SERVER_ERROR("Internal Server Error", "99999"),
		INVALID_ARGUMENT("Invalid Argument", "10001"),
		MERCHANT_NAME_CANNOT_NULL("Merchant Name Cannot be empty/null", "10002"),
		MERCHANT_NOT_FOUND("Merchant Not Found", "10003"),
		CATEGORY_NOT_FOUND("Category Not Found", "10004"),
		INVALID_UUID_FROMAT("Invalid UUID Format", "10005"),
		PRODUCT_NOT_FOUND("Product Not Found", "10006");
		
		private String message;

		private String code;

		Responsecode(String message, String code) {
			this.message = message;
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public String getCode() {
			return code;
		}

	}

}
