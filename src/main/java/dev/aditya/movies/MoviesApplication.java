package dev.aditya.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class MoviesApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(MoviesApplication.class, args);
	}



	//general endpoint example
	//yai framework ko batata hai ki yai get endpoint hai
//		@GetMapping("/root")
//	 	public String apiRoot()
//		{
//			return "Hello World";
//		}




}
