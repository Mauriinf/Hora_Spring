package com.example.rest.Json;

public class jsonResult {
	private Object response;
	public static jsonResult ok(Object data) {
		return new jsonResult(data);
	}
	// La clase contiene la inicialización del parámetro 1
	public jsonResult(Object data) {
        this.response = data;
    }
	public Object getData() {
        return response;
    }
    public void setData(Object data) {
        this.response = data;
    }
}
