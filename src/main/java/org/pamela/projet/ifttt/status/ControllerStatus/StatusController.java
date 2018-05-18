package org.pamela.projet.ifttt.status.ControllerStatus;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/ifttt/v1")
public class StatusController {

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ResponseEntity<String> statusCheck(HttpServletRequest request) {
		String iftttServiceKey = "23VjEuaT7ZzTthcGFaCBiUfsNAeuIlWMzmIaSk5mHQSKjTWT8fjBYGHAz34atJ6A";
		String iftttChannelKey = "INVALID";
		if (iftttServiceKey.equals(request.getHeader("IFTTT-Service-Key"))) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}else if (request.getHeader("IFTTT-Channel-Key").equals(iftttChannelKey)) {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		}
		
		else {
			return new ResponseEntity<String>(HttpStatus.SERVICE_UNAVAILABLE);

		}
	}

}
