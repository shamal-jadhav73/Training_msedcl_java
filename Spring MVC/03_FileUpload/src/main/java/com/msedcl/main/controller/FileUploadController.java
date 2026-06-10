package com.msedcl.main.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileUploadController {

	@Value("${file.upload-dir}")
	private String UploadDir;

	@GetMapping("upload")
	public String showUploadPage() {
		return "file-upload";
	}

	@PostMapping("upload")
	public String uploadFile(MultipartFile file, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		if (file.isEmpty()) {
			model.addAttribute("error", "File is empty");
			log.info("File is empty");
			return "file-upload";

		}
		
		try {
			String newName = LocalDate.now().toString() + file.getOriginalFilename();
			log.info("New Name:" + newName);
			File destination = new File(UploadDir + newName);
			file.transferTo(destination);
			log.info("File transfer completed");
			model.addAttribute("success", "File Uploaded Successfully!!");
		} catch (IllegalStateException | IOException e) {
			log.info("exception");
			log.info(e.getMessage());
			model.addAttribute("error", "Fail to upload File");
		}

		return "file-upload";
	}

}
