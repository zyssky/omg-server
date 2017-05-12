package rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import entity.Order;
import entity.User;
import model.OrderApi;
import model.UserApi;

@Path("/order")
public class OrderService {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrders(@FormParam("token") String token){
		long userId = new UserApi().getUserIdFromToken(token);
		if(userId<0)
			return null;
		List<Order> list = new OrderApi().getOrders(userId);
		return list;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delete")
	public String deleteOrder(@FormParam("token") String token , @FormParam("id") String idString){
		long userId = new UserApi().getUserIdFromToken(token);
		if(userId<0)
			return "{\"status\":0}";
		long id = Long.parseLong(idString);
		int res = new OrderApi().deleteOrder(id);
		if(res == 1)
			return "{\"status\":1}";
		else {
			return "{\"status\":0}";
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("submit")
	public String submitOrder(@FormParam("token") String token , @FormParam("total") String totalString , 
			@FormParam("sporttype") String title , @FormParam("count") String countString , @FormParam("date") String dateString,
			@FormParam("time") String time){
		long userId = new UserApi().getUserIdFromToken(token);
		if(userId<0)
			return "{\"status\":0}";
		SimpleDateFormat simpleDateFormatForDay = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormatForHour = new SimpleDateFormat("yyyy-MM-dd,HH:mm");
		
		String[] temp = time.split("-");
		String startTime = dateString+","+temp[0];
		String endTime = dateString+","+temp[1];
		Date sDate = null;
		Date date = null;
		Date eDate = null;
		double total = 0;
		int count = 0;
		try {
			total = Double.parseDouble(totalString);
			count = Integer.parseInt(countString);
			date = simpleDateFormatForDay.parse(dateString);
			sDate = simpleDateFormatForHour.parse(startTime);
			eDate = simpleDateFormatForHour.parse(endTime);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = new UserApi().getUser(userId);
		if(null==user)
			return "{\"status\":0}";
		
		if(user.getBalance()<total)
			return "{\"status\":0}";
		
		JSONObject jsonObject = new JSONObject();
		if(sDate!=null && eDate!=null && date!=null && title!=null && count>0 && total>0){
			
			Order order = new Order(userId, title, count, date, sDate, eDate,total);
			order.setId(Math.abs(new Random().nextLong()));
			int res = new OrderApi().addOrder(order);
			int res2 = 0;
			if(res==1){
				user.setBalance(user.getBalance()-total);
				user.setCredit(user.getCredit()+(int) total); 
				res2 = new UserApi().updateUser(user);
			}
			else{
				return "{\"status\":0}";
			}
			if(res==1 && res2==0){
				new OrderApi().deleteOrder(order.getId());
				return "{\"status\":0}";
			}
			return "{\"status\":1}";
			
			
		}
		return "{\"status\":0}";
	}
	
}
