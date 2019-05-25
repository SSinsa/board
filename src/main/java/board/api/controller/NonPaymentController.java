package board.api.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.api.dto.NonPaymentCodeDto;
import board.api.service.KakaoAPI;
import board.api.service.NonPaymentService;

//@Slf4j //로거대신 사용하는 어노테이션
@Controller
public class NonPaymentController {

	@Autowired
	private NonPaymentService npcService;
	
	@Autowired
    private KakaoAPI kakao;

	
	@RequestMapping(value="/api/apiData", method=RequestMethod.GET)
	public void insertNonPaymentCode() throws Exception{
		NonPaymentCodeDto dto = new NonPaymentCodeDto();
		npcService.insertNonPaymentCode(dto);
	}
	
	@RequestMapping(value="/api/apiTree", method=RequestMethod.GET)
	public ModelAndView openNonpaymentCode() throws Exception{
		ModelAndView mv = new ModelAndView("/api/restApiTree");
		List<NonPaymentCodeDto> apilist = npcService.selectNonPaymentCodeList();
		mv.addObject("list", apilist);
		return mv;
	}
	
    @RequestMapping(value="/")
    public String index() throws Exception {
        return "/api/index";
    }
    
    @RequestMapping(value="/login")
    public String login(@RequestParam("code") String code, HttpSession session) {
        String access_Token = kakao.getAccessToken(code);
        HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
        System.out.println("login Controller : " + userInfo);
        
        //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
        if (userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("access_Token", access_Token);
        }
        return "/api/index";
    }
    
    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        kakao.kakaoLogout((String)session.getAttribute("access_Token"));
        
        session.removeAttribute("access_Token");
        session.removeAttribute("userId");
        return "/api/index";
    }



	/*
	 * @RequestMapping(value="/api/apiLogin", method=RequestMethod.GET) public
	 * String simpleLogin() throws Exception{ return
	 * "redirect:https://kauth.kakao.com/oauth/authorize?client_id=baa78c11ba12e19b7960b68a308d7a00&redirect_uri=http://localhost:8088/api/kakao_oauth&response_type=code";
	 * }
	 * 
	 * 
	 * @RequestMapping(value="/api/kakao_oauth/{code}", method=RequestMethod.POST)
	 * public String kakaoOauth(@PathVariable("code") String code) throws Exception{
	 * return
	 * "redirect:/https://kauth.kakao.com/oauth/token?grant_type=authoriztion_code&client_id=baa78c11ba12e19b7960b68a308d7a00&redirect_uri=http://localhost:8088/api/kakao_oauth?code="
	 * +code; }
	 */
}
