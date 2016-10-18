package nl.lemkes.example.oauth.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hans
 */
@RestController
public class GreetingController
{

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> helloWorld()
	{
		return new ResponseEntity<String>("Hello World", HttpStatus.OK);
	}

	@RequestMapping(value = "/protected", method = RequestMethod.GET)
	@ResponseBody
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> helloProtectedWorld()
	{
		return new ResponseEntity<String>("Hello protected world", HttpStatus.OK);
	}

}
