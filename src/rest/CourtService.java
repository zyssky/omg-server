package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/courts")
public class CourtService {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String index(){
		return "hello in rest";
	}
}
