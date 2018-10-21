package com.hackathon.controller;


import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.hackathon.model.StructureModel;

@Controller
@RequestMapping("/")
public class StructureController {
	
	public StructureModel strucModel = new StructureModel();
	
	public StructureController() {
		strucModel.getColumnList().add("TES");
	}
	
	@RequestMapping(path="/Structure", method=RequestMethod.GET)
	public ModelAndView getStructure(HttpSession session) 
	{
		if(session != null && session.getAttribute("user") != null)
		{
			ModelAndView mav = new ModelAndView("structure");

			System.out.println(strucModel.getColumnList());
			
			mav.addObject("strucModel", strucModel);
			
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("error");
			
			return mav;
		}
	}
}
