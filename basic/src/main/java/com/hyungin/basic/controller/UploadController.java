package com.hyungin.basic.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hyungin.basic.model.FileInfo;

@Controller
public class UploadController {
	
	// 클라이언트가 파일을 서버에 첨부하는 거니까 GET방식, upload1.html 페이지를 보여줌 
	// 파일을 첨부하면 받아야하니까 POST
	@GetMapping("/upload1")
	public String upload1() {
		return "upload1";
	}

	@PostMapping("/upload1")
	@ResponseBody
	public String upload1Post(MultipartHttpServletRequest mRequest) {
		String result = "";
		
		List<MultipartFile> mFiles = mRequest.getFiles("file");
		
		for (int i = 0; i < mFiles.size(); i += 1) {	
		
		//MultipartFile 형태로 받아져야 함 mFile에 업로드 된 파일 정보가 담겨있음)
		MultipartFile mFile = mFiles.get(i);
	
		//파일의 원래 명을 String으로 받으라는 코드 
		String oName = mFile.getOriginalFilename();
		result += oName + "\n";
		
		//지정 경로에 지정 파일명으로 저장하라는 명령어 transferTo
		try {
			mFile.transferTo(new File("../Users⁩/choihyoung-in⁩/work/" + oName));
//			mFile.transferTo(new File("/Users⁩/choihyoung-in⁩/work/1.tt"));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		return result;
	}

	@GetMapping("/upload2")
	public String upload2() {
		return "upload2";
	}

	@PostMapping("/upload2")
	@ResponseBody
	public String upload2Post(@RequestParam("file") MultipartFile mFile) {
		String result = "";
		String oName = mFile.getOriginalFilename();
		result += oName + "\n";
		return result;
	}

	@GetMapping("/upload3")
	public String upload3() {
		return "upload3";
	}

	@PostMapping("/upload3")
	@ResponseBody
	public String upload3Post(@ModelAttribute FileInfo info) {
		String result = "";
		String oName = info.getFile().getOriginalFilename();
		result += oName + "\n";
		return result;
	}
}