package paymentproject.demo.service;
import paymentproject.demo.model.Student;
import paymentproject.demo.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import paymentproject.demo.repository.*;

@Service
public class PaymentService{
	@Autowired
	private PaymentRepository repository;
	
	public int getStudentDues(String studentId) {

			 return repository.getDues(studentId); 
			 
			
	}
}
