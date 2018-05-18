package org.pamela.projet.ifttt.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Response implements ResponseBody{

	private Data data;
	
	public Response(Data data) {
		this.data = data;
	}

	public Data getData() {
		return data;
	}

	public static Response builder(String token) {
		Samples samples = new Samples();
		Data data = new Data(token, samples);
		return new Response(data);
	}
}
