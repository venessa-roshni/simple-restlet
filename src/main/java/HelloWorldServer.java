import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import DAO.GreetingsDAOImpl;
import DAO.GreetingsReponse;
import DTO.GreetingsDTO;


public class HelloWorldServer extends ServerResource{
	
	public static GreetingsDAOImpl greetingsDAO;
	
	@Post("json")
		public Representation represent(Representation requestJson) {
		GreetingsDTO greeting = new GreetingsDTO();
		greeting.setGreeting("hello");
		greetingsDAO= new GreetingsDAOImpl();
		GreetingsReponse response= greetingsDAO.insertRow(greeting);
		Representation result = null;
		result = new JsonRepresentation(response);
		return result;
		
	}
	
}
