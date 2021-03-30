package com.daniender.demo.controller;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniender.demo.constants.EntityConstants;
import com.daniender.demo.controller.model.ApiResponseEntity;
import com.daniender.demo.controller.model.ApiResponseFactory;
import com.daniender.demo.model.entity.Task;
import com.daniender.demo.service.TaskService;

import javassist.NotFoundException;

@RestController
@RequestMapping(value = "/api/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {

	private TaskService service;

	public TaskController(@Autowired TaskService service) {
		this.service = service;
	}

	@GetMapping(value = "/findAll")
	public ResponseEntity<ApiResponseEntity<Task>> findAll() throws NotFoundException {
		final Iterable<Task> result = this.service.findAll();
		if (StreamSupport.stream(result.spliterator(), false).count() == 0) {
			return ApiResponseFactory.buildKoResponse(result);
		}
		return ApiResponseFactory.buildOkResponse(result);
	}

	@GetMapping(value = "/findOne")
	public ResponseEntity<ApiResponseEntity<Optional<Task>>> findOne(@RequestParam(name = "id") final Long id)
			throws NotFoundException {
		final Optional<Task> result = this.service.findOne(id);
		if (result.isEmpty()) {
			return ApiResponseFactory.buildKoResponse(result);
		}
		return ApiResponseFactory.buildOkResponse(result);
	}

	@PostMapping
	public ResponseEntity<ApiResponseEntity<Task>> insert(@RequestBody final Task entity) {
		final Task result = this.service.saveOrUpdate(entity);
		return ApiResponseFactory.buildCreatedResponse(result, EntityConstants.TASK);
	}

	@PutMapping
	public ResponseEntity<ApiResponseEntity<Task>> update(@RequestBody final Task entity) {
		final Task result = this.service.saveOrUpdate(entity);
		return ApiResponseFactory.buildUpdatedResponse(result, EntityConstants.TASK);
	}

	@DeleteMapping
	public ResponseEntity<ApiResponseEntity<Boolean>> delete(@RequestBody final Task entity) {
		final Boolean result = this.service.delete(entity);
		if (result) {
			return ApiResponseFactory.buildDeletedResponse(EntityConstants.TASK);
		}
		return ApiResponseFactory.buildKoResponse(result);
	}
}
