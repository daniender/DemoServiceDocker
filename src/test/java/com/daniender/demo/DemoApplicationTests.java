package com.daniender.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import com.daniender.demo.controller.TaskController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class DemoApplicationTests {

	@LocalServerPort
	private Integer port;

	@Autowired
	private TaskController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void findAll() throws Exception {
		assertThat(this.controller.findAll().getBody().getAchieved()).isTrue();
		assertThat(this.controller.findAll().getBody().getData().iterator().hasNext()).isTrue();
		assertThat(this.controller.findAll().getBody().getData().iterator().next().getId()).isEqualTo(1L);
	}

}
