package com.hanul.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.MemberVO;

@Controller
public class TestController {

	@RequestMapping("/login_result")
	public String login(String id, String pw) {
		//hanul / 0000 이면 로그인 성공 아니면 로그인 실패
		//로그인 성공시 홈화면으로 연결
		//      실패시 로그인화면으로 연결
		if( id.equals("hanul") 
					&& pw.equals("0000") ) {
			//return "home";//forward
			return "redirect:/"; 
		}else {
			//return "member/login"; //forward
			return "redirect:login";
		}
	}
	
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	
	
	@RequestMapping(
		"/joinPath/{name}/{gender}/{email}/{age}")
	public String join( Model model
						, @PathVariable String name
						, @PathVariable String gender
						, @PathVariable String email
						, @PathVariable int age
						) {
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("email", email);
		model.addAttribute("age", age);
		model.addAttribute("method", "@PathVariable");
		return "member/myInfo";
	}
	
	@RequestMapping("/joinDataObject")
	public String join(MemberVO vo, Model model) {
		model.addAttribute("vo", vo);
		model.addAttribute("method", "데이터객체");
		return "member/myInfo";
	}
	
	
	@RequestMapping("/joinRequestParam")
	public String join(@RequestParam("name") String n
			, @RequestParam String gender
			, String email, int age, Model model
			) {
		model.addAttribute("name", n);
		model.addAttribute("gender", gender);
		model.addAttribute("email", email);
		model.addAttribute("age", age);
		model.addAttribute("method", "@RequestParam");
		return "member/myInfo";
	}
	
	
	@RequestMapping("/joinRequest")
	public String join(HttpServletRequest request
						, Model model) {
//		model.addAttribute("속성명", 데이터);
		model.addAttribute("name"
					, request.getParameter("name") );
		model.addAttribute("gender"
					, request.getParameter("gender") );
		model.addAttribute("email"
					, request.getParameter("email") );
		//String -> int
		//Wrapper: Integer.valueOf : Integer -> int: auto Unboxing
		//         Integer.parseInt : int  
		int age = request.getParameter("age")==null ? 0 : 
			Integer.parseInt(request.getParameter("age"));
		model.addAttribute("age", age==0? "" : age);
		model.addAttribute("method", "HttpServletRequest");
		return "member/myInfo";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member/join";
	}
	
	@RequestMapping("/second")
	public ModelAndView second() {
		ModelAndView model = new ModelAndView();
		SimpleDateFormat df 
			= new SimpleDateFormat("a hh시 mm분 ss초");
		String now = df.format( new Date() );
		model.addObject("now", now);
		model.setViewName("view");
		return model;
	}
	
	
	@RequestMapping("/first")
	public String aaaaaa(Model m) {
		SimpleDateFormat sdf 
			= new SimpleDateFormat("yyyy년 MM월 dd일");
		String today = sdf.format( new Date() );
		
		m.addAttribute("today", today);
//		m.addAttribute("today", "홍길동");
		return "view";
	}
	
}
