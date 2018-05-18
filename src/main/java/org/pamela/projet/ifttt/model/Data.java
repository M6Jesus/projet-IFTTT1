package org.pamela.projet.ifttt.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Data {

	private String accessToken;
	
	private Samples samples;

	public Data(String accessToken, Samples samples) {
		this.accessToken = accessToken;
		this.samples = samples;
	}

	public Samples getSamples() {
		return samples;
	}


	public String getAccessToken() {
		return accessToken;
	}


}
