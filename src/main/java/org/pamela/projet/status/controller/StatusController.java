package org.pamela.projet.status.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/ifttt/v1")
public class StatusController {

	@RequestMapping(value = "/status", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> statusCheck(HttpServletRequest request) {
		String IftttServiceKey = "23VjEuaT7ZzTthcGFaCBiUfsNAeuIlWMzmIaSk5mHQSKjTWT8fjBYGHAz34atJ6A";
		if(request.getHeader("IFTTT-Service-Key") == IftttServiceKey) {
		    return new ResponseEntity<String>(HttpStatus.OK);
		}	
		else {
		    return new ResponseEntity<String>(HttpStatus.SERVICE_UNAVAILABLE);

		}
	}

}
