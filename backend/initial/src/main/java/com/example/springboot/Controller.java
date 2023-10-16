package com.example.springboot;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@RestController
public class Controller {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/encrypt", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MyResponse encryptMessage(@RequestBody MyRequest request) {
		String originalString = request.getValue();
		int shift = 3;

		String encryptedString = caesarCipherEncrypt(originalString, shift);
		MyResponse response = new MyResponse(encryptedString);
		return response;
	}

	private String caesarCipherEncrypt(String text, int shift) {
		StringBuilder result = new StringBuilder();

		for (char character : text.toCharArray()) {
			if (Character.isLetter(character)) {
				char base = Character.isLowerCase(character) ? 'a' : 'A';
				result.append((char) (base + (character - base + shift) % 26));
			} else {
				result.append(character);
			}
		}

		return result.toString();
	}

}
