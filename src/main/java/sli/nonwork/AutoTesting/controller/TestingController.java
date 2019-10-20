package sli.nonwork.AutoTesting.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sli.nonwork.AutoTesting.model.Testing;
import sli.nonwork.AutoTesting.service.TestingService;

@Controller
public class TestingController {
	@Autowired
	TestingService testingService;
	
	private static String UPLOADED_FOLDER = "/Users/Priscilla/Documents/AutoTestFile/";
	
	@PostMapping("/createTesting")
	public ModelAndView createTesting(@ModelAttribute("testingForm") Testing testingForm,
			@RequestParam("file") MultipartFile file) {
		
		try {
			byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            System.out.println("File: "+ file.getOriginalFilename() +" has been saved in " + UPLOADED_FOLDER);
		}catch(Exception e) {e.printStackTrace();}
		
		Testing testing = testingForm;
		testing.setDate(new Date());
		testing.setFileName(file.getOriginalFilename());
		
		testingService.save(testingForm);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("createTesting");
		
		boolean result = true;
		/* write code to use jar files here*/
		testing.setResult(result?"Success":"Failed");
		if(result) {
			mv.addObject("message", "Test Success!");
		} else {
			mv.addObject("message", "Test Failed :(");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/testingHistory", method = RequestMethod.GET)
    public ModelAndView testingHistory(Principal principal) {
		
		ModelAndView mv = new ModelAndView();
        
		Testing[] testings = testingService.findTestingByUserName(principal.getName());
		
		mv.setViewName("testingHistory");
		mv.addObject("testingHistory", testings);

        return mv;
    }
	
	@RequestMapping(value = "/testingHistory", method = RequestMethod.POST)
    public String createTesting(Model model) {
        

        return "createTesting";
    }
	
}
