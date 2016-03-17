package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoController {

	private final PhotoLibrary library; 
	private final DogePhotoManipulator manipulator;

	@Autowired
	public PhotoController(PhotoLibrary library)
	{
		this.library = library;
		this.manipulator = new DogePhotoManipulator();
	}
	
	@RequestMapping(value = "/", produces = "image/jpeg")
	public byte[] doge() throws Exception 
	{
		byte[] photo = library.getFromStorageAccount("doge.jpeg");		
		return manipulator.overLay(photo,"Azure", "Love", "Java");
	}
}
