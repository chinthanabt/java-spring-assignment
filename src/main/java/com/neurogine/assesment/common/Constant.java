package com.neurogine.assesment.common;

/**
 * 
 * @author Chinthana
 *
 */

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
	
	/**
     * HTTP related constants.
     */
    public static final class HttpCodes {
        public static final int HTTP_200_CODE = 200;
        public static final String HTTP_200_MESSAGE = "Resource Created Successfully";
        public static final String HTTP_200_OK_MESSAGE = "OK";
        public static final int HTTP_201_CODE = 201;
        public static final String HTTP_201_MESSAGE = "Entity created";
        public static final int HTTP_204_CODE = 204;
        public static final String HTTP_204_MESSAGE = "Requested Entity Not Found";
        public static final int HTTP_400_CODE = 400;
        public static final String HTTP_400_MESSAGE = "Bad Request";
        public static final int HTTP_401_CODE = 401;
        public static final String HTTP_401_MESSAGE = "Unauthorized request";
        public static final int HTTP_403_CODE = 403;
        public static final String HTTP_403_MESSAGE = "Access Denied for the Service";
        public static final int HTTP_404_CODE = 404;
        public static final String HTTP_404_MESSAGE = "Resource Not Found";
        public static final int HTTP_409_CODE = 409;
        public static final String HTTP_409_MESSAGE = "Conflict";
        public static final int HTTP_415_CODE = 415;
        public static final String HTTP_415_MESSAGE = "Unsupported media type";
        public static final int HTTP_429_CODE = 429;
        public static final String HTTP_429_MESSAGE = "Rate limiting - user has sent too many requests in a "
                + "given amount of time";
        public static final int HTTP_500_CODE = 500;
        public static final String HTTP_500_MESSAGE = "Internal Server Errors";
        public static final int HTTP_405_CODE = 405;
        public static final String HTTP_405_MESSAGE = "Method Not Allowed";

        private HttpCodes() {
            throw new IllegalStateException("Utility Class");
        }
    }

}
