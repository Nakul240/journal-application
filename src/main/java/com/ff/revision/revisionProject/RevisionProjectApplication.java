package com.ff.revision.revisionProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

import java.sql.DriverManager;

@SpringBootApplication
public class RevisionProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevisionProjectApplication.class, args);

	}
}


