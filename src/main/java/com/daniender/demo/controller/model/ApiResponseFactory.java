package com.daniender.demo.controller.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Factory for standarization of API responses
 * 
 * @param <T>
 *
 */
@Component
public class ApiResponseFactory<T> {

	public static <T> ResponseEntity<ApiResponseEntity<T>> buildOkResponse(final Iterable<T> data) {
		final ApiResponseEntity<T> apiResponseEntity = new ApiResponseEntity<T>(Boolean.TRUE, data);
		final ResponseEntity<ApiResponseEntity<T>> response = new ResponseEntity<>(apiResponseEntity, HttpStatus.OK);
		return response;
	}

	public static <T> ResponseEntity<ApiResponseEntity<T>> buildOkResponse(final T data) {
		return buildOkResponse(createListWithObject(data));
	}

	public static <T> ResponseEntity<ApiResponseEntity<T>> buildKoResponse(final Iterable<T> data) {
		final ApiResponseEntity<T> apiResponseEntity = new ApiResponseEntity<T>(false, data);
		apiResponseEntity.setAchieved(Boolean.FALSE);
		final ResponseEntity<ApiResponseEntity<T>> response = new ResponseEntity<>(apiResponseEntity, HttpStatus.OK);
		return response;
	}

	public static <T> ResponseEntity<ApiResponseEntity<T>> buildKoResponse(final T data) {
		return buildKoResponse(createListWithObject(data));
	}

	public static <T> ResponseEntity<ApiResponseEntity<T>> buildCreatedResponse(final Iterable<T> data,
			final String entityName) {
		final ApiResponseEntity<T> apiResponseEntity = new ApiResponseEntity<T>(true, data);
		final ResponseEntity<ApiResponseEntity<T>> response = new ResponseEntity<>(apiResponseEntity,
				HttpStatus.CREATED);
		return response;
	}

	public static <T> ResponseEntity<ApiResponseEntity<T>> buildCreatedResponse(final T object,
			final String entityName) {
		return buildCreatedResponse(createListWithObject(object), entityName);
	}

	public static <T> ResponseEntity<ApiResponseEntity<T>> buildUpdatedResponse(final Iterable<T> data,
			final String entityName) {
		final ApiResponseEntity<T> apiResponseEntity = new ApiResponseEntity<T>(true, data);
		final ResponseEntity<ApiResponseEntity<T>> response = new ResponseEntity<>(apiResponseEntity,
				HttpStatus.CREATED);
		return response;
	}

	public static <T> ResponseEntity<ApiResponseEntity<T>> buildUpdatedResponse(final T object,
			final String entityName) {
		return buildUpdatedResponse(createListWithObject(object), entityName);
	}

	public static ResponseEntity<ApiResponseEntity<Boolean>> buildDeletedResponse(final String entityName) {
		final List<Boolean> data = new ArrayList<>();
		data.add(Boolean.TRUE);
		final ApiResponseEntity<Boolean> apiResponseEntity = new ApiResponseEntity<Boolean>(true, data);
		final ResponseEntity<ApiResponseEntity<Boolean>> response = new ResponseEntity<>(apiResponseEntity,
				HttpStatus.OK);
		return response;
	}

	private static <T> List<T> createListWithObject(final T object) {
		List<T> retorno;
		if (object == null) {
			retorno = new ArrayList<>();
		} else {
			retorno = Stream.of(object).collect(Collectors.toCollection(ArrayList::new));
		}
		return retorno;
	}
}
