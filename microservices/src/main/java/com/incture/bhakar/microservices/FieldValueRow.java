package com.incture.bhakar.microservices;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FieldValueRow {
	private List<FieldValue> fieldValues;

	public List<FieldValue> getFieldValues() {
		return fieldValues;
	}

	public void setFieldValues(List<FieldValue> fieldValues) {
		this.fieldValues = fieldValues;
	}

	@Override
	public String toString() {
		return "FieldValueRow [fieldValues=" + fieldValues + "]";
	}

}
