package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entity.Court;
import model.CourtApi;
import model.HibernateUtil;

@Path("/courts")
public class CourtService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Court> getCourts(){
		return new CourtApi().getCourts();
	}
	
	@GET
	@Path("{court}")
	@Produces(MediaType.APPLICATION_JSON)
	public Court getCourt(@PathParam("court") String title){
		return new CourtApi().getCourt(title);
	}
}
