package com.finahub.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.finahub.dao.ApiResponse;

public class ResponseUtil {

	ResponseUtil() {
	}

	public static ResponseEntity<ApiResponse> getResponse(final HttpStatus statusCode, final String message,
			final Object result) {
		return ResponseEntity.ok().body(new ApiResponse(statusCode.value(), message, result));
	}

	public static ResponseEntity<ApiResponse> getResponse(final HttpStatus statusCode, final String message) {
		return getResponse(statusCode, message, null);
	}

	public static ResponseEntity<ApiResponse> getResponse(final int responseCode, final String message,
			final Object result) {
		return ResponseEntity.ok().body(new ApiResponse(responseCode, message, result));
	}

}
