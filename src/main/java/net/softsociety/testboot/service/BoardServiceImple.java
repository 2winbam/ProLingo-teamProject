package net.softsociety.testboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.dao.BoardDAO;

@Slf4j
@Service
public class BoardServiceImple implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
}
