package com.neurogine.assesment.domain.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Audit extends BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private Status status;
		
	@Enumerated(EnumType.STRING)
	private Action action;
	
	private String remark;
	
	private Audit(Status status,  Action action, String remark) {
		this.status = status;
		this.action = action;
		this.remark = remark;
	}
	
	
	public enum Action {
		ADD_PRODUCT("ADD_PRODUCT"), DELETE_PRODUCT("DELETE_PRODUCT"),UPDATE_PRODUCT("UPDATE_PRODUCT"),
		ADD_MERCHANT("ADD_MERCHANT"), DELETE_MERCHANT("DELETE_MERCHANT"),UPDATE_MERCHANT("UPDATE_MERCHANT");
		
		private String value;
	
		Action(String value) {
			this.value = value;
		}
	
		public String getValue() {
			return value;
		}
	}
	
	
	public enum Status {		
		SUCCESS("SUCCESS"), FAILED("FAILED");
	
		private String value;
	
		Status(String value) {
			this.value = value;
		}
	
		public String getValue() {
			return value;
		}
	}
	
	public static Audit of(final Status status,  final Action action, final String remark) {
		return new Audit(status,  action, remark);
	}

}
