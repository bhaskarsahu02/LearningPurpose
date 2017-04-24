package com.incture.bhakar.microservices;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FieldValue {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "FieldValue [value=" + value + "]";
	}

}
