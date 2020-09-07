package com.example.DEMO;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAaaApplication  {

	private final DateListMapper dateListMapper;

	public DemoAaaApplication(DateListMapper dateListMapper) {
	    this.dateListMapper = dateListMapper;
	  }

	public static void main(String[] args) {
		SpringApplication.run(DemoAaaApplication.class, args);
	}


      /*@Override
	  public void run(String... args) throws Exception {
	    System.out.println(this.dateListMapper.findByList(5));
	  }
      */
}
