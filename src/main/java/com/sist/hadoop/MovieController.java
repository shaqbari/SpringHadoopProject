package com.sist.hadoop;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.sist.manager.MovieManager;
import com.sist.vo.MovieVO;

@Controller
public class MovieController {
	@Autowired
	private MovieManager mgr;
	
	@RequestMapping("movie/main.do")
	public String movie_main(Model model){
		List<MovieVO> list=mgr.cgvMainData();
		
		model.addAttribute("list", list);
		
		//RedirectView와 RedirectModel를 이용해서 redirect에서도 값을 보낼 수 있다.
		return "movie/main"; //forward
	}
	
}
