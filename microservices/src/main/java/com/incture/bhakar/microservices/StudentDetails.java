package com.incture.bhakar.microservices;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "STUDENTDETAIL1")
public class StudentDetails {

	@Id
	@GeneratedValue(generator = "newGenerator")
	@GenericGenerator(name = "newGenerator", strategy = "foreign", parameters = { @Parameter(value = "student_Info", name = "property") })
	private int sId;
	
	private String mobileNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sId")
	private Student_Info student_Info;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Student_Info getStudent_Info() {
		return student_Info;
	}

	public void setStudent_Info(Student_Info student_Info) {
		this.student_Info = student_Info;
	}

}
