package common;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class UploadController {

	
	private String upDir;
	@ResponseBody
	@RequestMapping(value="/ajaxUpload",method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file,HttpServletRequest req) throws Exception{
		upDir=req.getServletContext().getRealPath("/Upload");
		
		System.out.println("upDir=="+upDir);
		System.out.println("originalNmae="+file.getOriginalFilename());
		System.out.println("size="+file.getSize());
		System.out.println("contentType="+file.getContentType());
		
		file.transferTo(new File(upDir, file.getOriginalFilename()));
		
		return new ResponseEntity<String>(file.getOriginalFilename(),HttpStatus.OK);
	}
}
