package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderItem;

public class DeleteOrderItemServlet extends HttpServlet{

	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int pid=Integer.parseInt(request.getParameter("pid"));
		List<OrderItem> ois=(List<OrderItem>)request.getSession().getAttribute("ois");
		List<OrderItem> ois4Delete=new ArrayList<OrderItem>();
		if(null!=ois){
			for(OrderItem oi:ois){
				if(oi.getProduct().getId()==pid){
					ois4Delete.add(oi);
				}
			}
		}
		ois.removeAll(ois4Delete);
		response.sendRedirect("/listOrderItem");
	}
}
