package net.softsociety.testboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.dao.StudyCourseDAO;

@Slf4j
@Service
public class StudyCourseServiceImpl implements StudyCourseService {
	
	@Autowired
	private StudyCourseDAO dao;
	
	
}
