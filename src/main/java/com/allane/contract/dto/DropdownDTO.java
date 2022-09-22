package com.allane.contract.dto;

public class DropdownDTO {

	private Long key;
	private String label;
	private Object value;
	
	public DropdownDTO() {
		super();
	}
	public DropdownDTO(Long key, String label, Object value) {
		super();
		this.key = key;
		this.label = label;
		this.value = value;
	}
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
