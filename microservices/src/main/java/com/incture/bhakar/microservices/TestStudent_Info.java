package com.incture.bhakar.microservices;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestStudent_Info {
	// public static void main(String args[]) {
	//
	// StudentAddress studentAddress = new StudentAddress();
	// studentAddress.setAddress("BLR India");
	
	//
	// Student_Info sInfo = new Student_Info();
	// // sInfo.setsId("101");
	// sInfo.setFirstName("Jyothi");
	// sInfo.setLastName("Kumar");
	// sInfo.setAddress("Marathalli Bangalore");
	// sInfo.setBirthDate(new Date());
	// sInfo.setStudentAddress(studentAddress);
	//
	// Student_Info sInfo1 = new Student_Info();
	// // sInfo1.setsId("102");
	// sInfo1.setFirstName("Sushil");
	// sInfo1.setLastName("Kumar");
	// sInfo1.setAddress("JP Nagar Bangalore");
	// sInfo1.setBirthDate(new Date());
	// sInfo1.setStudentAddress(studentAddress);
	//
	// // StudentDetails studentDetails = new StudentDetails();
	// // studentDetails.setMobileNumber("233433432");
	// // studentDetails.setStudent_Info(sInfo);
	//
	// SessionFactory sessionFactory = new Configuration().configure("com/sahu/cfgs/hibernate.cfg.xml").buildSessionFactory();
	// Session session = sessionFactory.openSession();
	// session.beginTransaction();
	// session.save(sInfo);
	// session.save(sInfo1);
	// session.getTransaction().commit();
	//
	// List<Student_Info> sList = session.createQuery("FROM Student_Info").list();
	// System.out.println("List is : " + sList.size());
	// for (Student_Info ss : sList) {
	// System.out.println("ss: " + ss.getFirstName());
	// }
	// session.close();
	// sessionFactory.close();
	// }

	public LookupResponse getRecords(String tableName) {

		LookupResponse lookupResponse = new LookupResponse();
		if (tableName != null) {
//			SessionFactory sessionFactory = new Configuration().configure("com/incture/bhakar/microservices/hibernate.cfg.xml").buildSessionFactory();
			SessionFactory sessionFactory = new Configuration().configure("com/incture/bhakar/microservices/mySql.cfg.xml").buildSessionFactory();
			Session session = sessionFactory.openSession();
			try {
				List<Object[]> rows = session.createSQLQuery("select * from " + tableName).list();
				System.out.println("Record Found Rows: " + rows.size());
				List<FieldValueRow> fieldValueRowList = new ArrayList<FieldValueRow>();
				for (Object[] row : rows) {
					if (row != null && row.length >= 1) {
						FieldValueRow fieldValueRow = new FieldValueRow();
						List<FieldValue> fieldValueList = new ArrayList<FieldValue>();
						for (int i = 0; i < row.length; i++) {
							FieldValue fieldValue = new FieldValue();
							fieldValue.setValue(row[i].toString());
							fieldValueList.add(fieldValue);
						}
						fieldValueRow.setFieldValues(fieldValueList);
						fieldValueRowList.add(fieldValueRow);
					}
				}
				System.out.println("fieldValueRowList: " + fieldValueRowList);
				lookupResponse.setFieldValueRows(fieldValueRowList);
				lookupResponse.setMessage("Success");
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				lookupResponse.setMessage("Failure");
			}
			session.close();
			sessionFactory.close();
		} else {
			lookupResponse.setMessage("Table name is empty");
		}
		return lookupResponse;
	}
}
