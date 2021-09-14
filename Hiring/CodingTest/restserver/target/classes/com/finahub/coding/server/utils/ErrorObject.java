package com.finahub.coding.server.utils;

import org.json.JSONObject;

public class ErrorObject {
	
	static ErrorObject reposnseObject = new ErrorObject();
	JSONObject error = new JSONObject();
	
	public static ErrorObject getErrorObject() {
		return reposnseObject;
	}
	
	public JSONObject createJSONErrorObject(int id, String description,Exception trace) {
		error.append("errorCode", id).append("errorResponse", description).append("RootCause", trace);
		return error;
	}
}
