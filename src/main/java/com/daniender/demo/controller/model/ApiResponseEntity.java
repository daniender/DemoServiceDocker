package com.daniender.demo.controller.model;

/**
 * Model for all REST controllers response
 * 
 * @param <T>
 */
public class ApiResponseEntity<T> {

	private Iterable<T> data;
	private Boolean achieved;

	public ApiResponseEntity(final Boolean achieved) {
		this(achieved, null);
	}

	public ApiResponseEntity(final Boolean achieved, final Iterable<T> data) {
		this.achieved = achieved;
		this.data = data;
	}

	public Iterable<T> getData() {
		return this.data;
	}

	public void setData(final Iterable<T> data) {
		this.data = data;
	}

	public Boolean getAchieved() {
		return this.achieved;
	}

	public void setAchieved(final Boolean achieved) {
		this.achieved = achieved;
	}

}
