package com.incture.bhakar.microservices;

import java.util.ArrayList;

public class StudentResponse {
	private String message;
	private ArrayList<Student_Info> student_Infos;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<Student_Info> getStudent_Infos() {
		return student_Infos;
	}

	public void setStudent_Infos(ArrayList<Student_Info> student_Infos) {
		this.student_Infos = student_Infos;
	}

	@Override
	public String toString() {
		return "StudentResponse [message=" + message + ", student_Infos=" + student_Infos + "]";
	}
	
	

}
