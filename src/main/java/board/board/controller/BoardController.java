package board.board.controller;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.board.dto.BoardDto;
import board.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j //로거대신 사용하는 어노테이션
@Controller
public class BoardController {
	    //private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BoardService boardService;
	
	
	    //@RequestMapping("/board/openBoardList.do")
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public ModelAndView openBoardList() throws Exception{
		log.debug("openBoardList");
		ModelAndView mv = new ModelAndView("/board/restBoardList");
		
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	    //@RequestMapping("/board/openBoardWrite.do")
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String openBoardWrite() throws Exception{
		//return "/board/boardWrite";
		return "/board/restBoardWrite";
	}
	
	     //@RequestMapping("/board/insertBoard.do")
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String insertBoard(BoardDto board) throws Exception{
		boardService.insertBoard(board);
		//return "redirect:/board/openBoardList.do";
		return "redirect:/board";
	}
	
	     //@RequestMapping("/board/openBoardDetail.do")
	@RequestMapping(value="/board/{boardIdx}", method=RequestMethod.GET)
	     //public ModelAndView openBoardDetail (@RequestParam int boardIdx) throws Exception{
	public ModelAndView openBoardDetail (@PathVariable("boardIdx") int boardIdx) throws Exception{
		ModelAndView mv = new ModelAndView("/board/restBoardDetail");
		
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		
		return mv;
		
	}
	
        //@RequestMapping("/board/updateBoard.do")
	@RequestMapping(value="/board/{boardIdx}", method=RequestMethod.PUT)
	public String updateBoard(BoardDto board) throws Exception{
		boardService.updateBoard(board);
		//return "redirect:/board/openBoardList.do";
		return "redirect:/board";
	}
	
	    //@RequestMapping("/board/deleteBoard.do")
	@RequestMapping(value="/board/{boardIdx}", method=RequestMethod.DELETE)
	    //public String deleteBoard(int boardIdx) throws Exception{
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		//return "redirect:/board/openBoardList.do";
		return "redirect:/board";
	}
}
