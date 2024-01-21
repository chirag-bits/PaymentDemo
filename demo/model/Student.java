package paymentproject.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "studenr_dues")
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public Integer getDue() {
		return Due;
	}
	public void setDue(Integer due) {
		Due = due;
	}
	private String student_id;
	private Integer Due;
    
    

}
