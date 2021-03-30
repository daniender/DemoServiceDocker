package com.daniender.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniender.demo.model.entity.Task;
import com.daniender.demo.repository.TaskRepository;

import javassist.NotFoundException;

@Service
@Transactional
public class TaskService {

	private final Logger errorLogger = LoggerFactory.getLogger("errorLog");

	@Autowired
	private TaskRepository repository;

	/**
	 *
	 * @return list of task entities
	 * @throws NotFoundException thrown just for demo purposes
	 */
	public Iterable<Task> findAll() throws NotFoundException {
		try {
			return repository.findAll();
		} catch (final Exception e) {
			errorLogger.error(e.getLocalizedMessage());
			throw new NotFoundException(e.getLocalizedMessage());
		}
	}

	/**
	 *
	 * @param id
	 * @return task entity
	 * @throws NotFoundException thrown just for demo purposes
	 */
	public Optional<Task> findOne(final Long id) throws NotFoundException {
		try {
			return repository.findById(id);
		} catch (final Exception e) {
			errorLogger.error(e.getLocalizedMessage());
			throw new NotFoundException(e.getLocalizedMessage());
		}
	}

	/**
	 *
	 * @param entity
	 * @return task entity
	 */
	public Task saveOrUpdate(final Task entity) {
		try {
			if (entity.getStatus() == null) {
				entity.setStatus(0);
			}
			return repository.save(entity);
		} catch (final Exception e) {
			errorLogger.error(e.getLocalizedMessage());
			throw new InternalError(e.getLocalizedMessage());
		}
	}

	/**
	 *
	 * @param entity
	 * @return Boolean.TRUE if the operation is successful, false if it's not
	 */
	public Boolean delete(final Task entity) {
		try {
			repository.delete(entity);
			return Boolean.TRUE;
		} catch (final Exception e) {
			errorLogger.error(e.getLocalizedMessage());
			return false;
		}
	}

}
