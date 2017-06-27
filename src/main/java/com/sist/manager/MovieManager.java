package com.sist.manager;

import	java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.sist.vo.MovieVO;

import java.net.*;

@Component
public class MovieManager {
	
	public static void main(String[] args) {
		MovieManager mm=new MovieManager();
		mm.cgvMainData();
	}
	
	
	/**
	 * @return
	 * 
	 * HTML(web) : JSoup
	 * XML, JSON : JAXB
	 * txt => log4j
	 * 
	 * Croller4j
	 * R에서 CSV파일을 잘 읽는다.
	 */
	public List<MovieVO> cgvMainData(){
		List<MovieVO> list=new ArrayList<MovieVO>();
		
		try {
			Document doc=Jsoup.connect("http://www.cgv.co.kr/movies/").get();
			//타이틀
			Elements telem=doc.select("div.box-contents a strong.title");
			//poster
			Elements pelem=doc.select("div.box-image span.thumb-image img");
			//reserve
			Elements relem=doc.select("div.score strong.percent span");
			//regdate
			Elements delem=doc.select("span.txt-info strong");
			//link
			Elements lelem=doc.select("div.box-contents a");
			//like
			Elements felem=doc.select("span.count strong i");
			
			int j=0;
			for (int i = 0; i < 7; i++) {
				Element title=telem.get(i);
				Element poster=pelem.get(i);
				Element reserve=relem.get(i);
				Element regdate=delem.get(i);
				Element link=lelem.get(j);
				Element like=felem.get(i);
				
				System.out.println(
					title.text()+" "
					+poster.attr("src")+" "
					+reserve.text()+" "
					+regdate.text()+" "
					+link.attr("href")+" "
					+like.text()
						
				);	
				
				MovieVO vo=new MovieVO();
				vo.setMno(i+1);
				vo.setTitle(title.text());
				vo.setPoster(poster.attr("src"));
				vo.setReserve(reserve.text().replace("%", ""));//%같은 문자가 들어가면 그래프를 못그린다.
				vo.setRegdate(regdate.text().substring(0, regdate.text().indexOf("개")).trim());//개봉을 지운다. 공백을 지운다.				
				vo.setLink(link.attr("href"));
				vo.setLike(like.text().replace(",", ""));//,가 들어가면 그래프를 못그린다. 지우자
				
				list.add(vo);				
				
				j+=2;
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return list;
	}
}
