package com.incture.bhakar.microservices;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LookupResponse {
	private String message;
	private List<FieldValueRow> fieldValueRows;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<FieldValueRow> getFieldValueRows() {
		return fieldValueRows;
	}

	public void setFieldValueRows(List<FieldValueRow> fieldValueRows) {
		this.fieldValueRows = fieldValueRows;
	}

}
