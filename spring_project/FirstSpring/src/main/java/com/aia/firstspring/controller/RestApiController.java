package com.aia.firstspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.firstspring.domain.MemberRegRequest;
import com.aia.firstspring.member.domain.Member;
import com.aia.firstspring.member.service.MemberListService;
import com.aia.firstspring.member.service.MemberRegService;
import com.aia.firstspring.member.service.MemberRestService;

@RestController // jsp파일 경로를 찾지않고 반환하는 문자열 그대로 응답처리
@RequestMapping("/rest/ver01/members")
public class RestApiController {

	@Autowired
	private MemberRestService restService;
	
	@Autowired
	private MemberListService listService;
	
	@Autowired
	private MemberRegService regService;

//	@GetMapping("/{idx}") // GET방식,  /rest/ver01/members/39 경로로 들어오면 응답처리
//	@GetMapping
//	public String getRest(
//			@PathVariable("idx") int idx
//			) {
//		return "@RestController 사용한 응답 처리 : " + idx;
//	}
	
	@GetMapping  //   /rest/ver01/members
	public List<Member> getMemberList(){
		return listService.getMemberList();
	}
	
	@GetMapping("/map")  //   /rest/ver01/members/map
	public Map<Integer, Member> getMemberListMap(){
		
		Map<Integer, Member> memberMap = new HashMap<Integer, Member>();
		
		for (Member member : listService.getMemberList()) {
			memberMap.put(member.getIdx(), member);
		}
		return memberMap;
	}
	
	@GetMapping("/{idx}")
	public Member getMemberInfo(
			@PathVariable("idx") int idx
			) {
		return restService.getMember(idx);
	}
	
	
	// @RequestMapping(method = RequestMethod.POST)
	@PostMapping 
	public String insertMember(
			@RequestBody MemberRegRequest regRequest // 통째로 받아서 자바객체로
			) {
		
		// String result = "N";
		
		System.out.println(regRequest);
		System.out.println(regRequest.getToMember());
		
		// regService.insertMember(regRequest.getToMember());
		
		return regService.insertMember(regRequest.getToMember())>0 ? "Y" : "N";
	}
	
}
