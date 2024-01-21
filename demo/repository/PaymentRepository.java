package paymentproject.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import paymentproject.demo.model.Student;
import paymentproject.demo.repository.*;
import org.springframework.stereotype.Service;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
//@Service
public interface PaymentRepository extends CrudRepository<Student,Integer>{
	
		@Query(value = "SELECT Due from studenr_dues d where d.student_id=?1",nativeQuery = true)
	    public int getDues(String student_id);
	
}