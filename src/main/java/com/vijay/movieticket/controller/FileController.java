package com.vijay.movieticket.controller;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vijay.movieticket.model.MovieDetails;
import com.vijay.movieticket.repositery.MovieDetailsRepo;

// Annotation 
@RestController
@RequestMapping("/file")
public class FileController {
	@Autowired
	private MovieDetailsRepo movieDetailsRepo;
	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadedFile) {
		if (uploadedFile.isEmpty()) {
			return new ResponseEntity<>("Please select a file!", HttpStatus.OK);
		}
		try {

			byte[] bytes = uploadedFile.getBytes();

			UUID uuid = UUID.randomUUID();
//			String uploadsLocation = env.getProperty("resource.uploads");
			String uploadsLocation = "D:/springworkspace/movieticket/src/main/resources/uploads/";
			String fileLocation =uploadsLocation + uuid+uploadedFile.getOriginalFilename();
			String filename=uuid+uploadedFile.getOriginalFilename();
			Path path = Paths.get(fileLocation );
			Files.write(path, bytes);
			MovieDetails movieDetails=new MovieDetails();
			movieDetails.setMovieImg(filename);
//			movieDetailsRepo.saveAndFlush(movieDetails);
//			File file = new File(fileLocation);
			return ResponseEntity.status(HttpStatus.OK).body(filename);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());

		}
	}

}
