package com.hyungin.basic.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DownloadController {
	@GetMapping("/download")
	public ResponseEntity<Resource> download() throws Exception {
		File file = new File("/Users/choihyoung-in/Desktop/스프링부트-2.pdf");
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		return ResponseEntity.ok()
				//file.getName() 다운받을 때 파일
				.header("content-disposition", "filename=" + URLEncoder.encode(file.getName(), "utf-8"))
				// application/octet-stream : 바로 다운로드
				.contentLength(file.length())
				
				.contentType(MediaType.parseMediaType("application/octet-stream"))

				// MediaType.parseMediaType("image/jpeg") : 화면에 이미지 바로 출력
//				.contentLength(file.length()).contentType(MediaType.parseMediaType("image/jpeg"))
				.body(resource);
	}
}