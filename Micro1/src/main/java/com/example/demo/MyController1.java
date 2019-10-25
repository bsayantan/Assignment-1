package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyController1  {
	@RequestMapping("/login")
	  public ModelAndView fun () { 
		  ModelAndView  modelAndView = new ModelAndView(); 
		  modelAndView.setViewName("Login.html");
	      return modelAndView;
	  }
	  RestTemplate rest = new RestTemplate();  
	  @RequestMapping("/login/msg")
	  	  public String fun1(User user)
	  {
		  int i=0;
		  String u1 = user.getUserid();
		  String p1 = user.getPassword();
		  String temp=null;
		  temp = rest.getForObject("http://localhost:8081/second", String.class);
		   String[] strArr = temp.split(",");
		  while(i<strArr.length)
		  {
			  String u2 =strArr[i++];	    	  
	    	  String p2 =strArr[i++];
	    	  if(u1.equals(u2) && p1.equals(p2))
		    	{
		    		 return "success";
		    	}
		  }
		  i=0;
		  return "fail";
	  }
}
