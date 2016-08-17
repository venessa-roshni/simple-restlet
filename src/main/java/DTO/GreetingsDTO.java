package DTO;

public class GreetingsDTO {

	
	String greeting;
	
	
	public String getGreeting() {
		return greeting;
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	public GreetingsDTO(String greeting) {
		super();
		
		this.greeting = greeting;
	}
	
	public GreetingsDTO()
	{
		
	}
	
}
