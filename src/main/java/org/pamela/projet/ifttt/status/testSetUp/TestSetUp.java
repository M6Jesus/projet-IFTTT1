package org.pamela.projet.ifttt.status.testSetUp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pamela.projet.ifttt.model.EmpyJsonResponse;
import org.pamela.projet.ifttt.model.Response;
import org.pamela.projet.ifttt.model.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/ifttt/v1/test")
public class TestSetUp {

	@RequestMapping(value = "/setup", method = RequestMethod.POST)
	public ResponseEntity<ResponseBody> post(HttpServletRequest request, HttpServletResponse response) {
		String iftttServiceKey = "23VjEuaT7ZzTthcGFaCBiUfsNAeuIlWMzmIaSk5mHQSKjTWT8fjBYGHAz34atJ6A";
		String iftttChannelKey = "INVALID";
		String tokenHazard = "aaaaaaa";
		response.setContentType("application/json");

		if (iftttServiceKey.equals(request.getHeader("IFTTT-Service-Key"))) {
			return new ResponseEntity<ResponseBody>(Response.builder(tokenHazard), HttpStatus.OK);
		} else if (request.getHeader("IFTTT-Channel-Key").equals(iftttChannelKey)) {
			return new ResponseEntity<ResponseBody>(new EmpyJsonResponse(), HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<ResponseBody>(new EmpyJsonResponse(), HttpStatus.SERVICE_UNAVAILABLE);
		}

	}

}
