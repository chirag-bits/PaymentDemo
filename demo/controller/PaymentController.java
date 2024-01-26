package paymentproject.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

//import com.razorpay.Order;
//import com.razorpay.RazorpayClient;
import com.razorpay.*;

import paymentproject.demo.service.PaymentService;


//id = rzp_test_qM7alK4G9E8u4G
//seceret = towDW6o3GIyk6zjoLMwkFpid

@RestController

@RequestMapping(value ="/student")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/due")
	public Order createOrder(@RequestBody String studentId) throws Exception{
		// get a student due
		
		System.out.println("INSIDE CONTROLLER");
		int due = paymentService.getStudentDues(studentId);
		System.out.println("INSIDE CONTROLLER");
		// generate order
		RazorpayClient razorpayClient = new RazorpayClient("rzp_test_qM7alK4G9E8u4G", "towDW6o3GIyk6zjoLMwkFpid");
		JSONObject options = new JSONObject();
		options.put("amount", 5000);
		options.put("currency", "INR");
		options.put("receipt", "12345");
		Order order = razorpayClient.Orders.create(options);
		System.out.println(order);
		
		// add created order in DB
		return order;
	}
	// fetch all order
	// orders are recorded in razorpay portals, thats why we are creating a new table for this
	// orders details we will fetch from razor pay portal itself

	@GetMapping("/orders")
	public List<Order> getAllOrders()throws Exception {
		System.out.println("INSIDE CONTROLLER");
		RazorpayClient razorpayClient = new RazorpayClient("rzp_test_qM7alK4G9E8u4G", "towDW6o3GIyk6zjoLMwkFpid");
		JSONObject options = new JSONObject();
		options.put("count","1");
		List<Order> orders = razorpayClient.Orders.fetchAll(options);
		return orders;
	}

}

