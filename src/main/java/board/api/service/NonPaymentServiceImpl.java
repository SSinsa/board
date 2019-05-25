package board.api.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.api.NonPaymentDamtInfo;
import board.api.dto.NonPaymentCodeDto;
//import lombok.extern.slf4j.Slf4j;
import board.api.mapper.NonPaymentCodeMapper;


@Service
public class NonPaymentServiceImpl implements NonPaymentService{

	@Autowired
	private NonPaymentCodeMapper npcMapper;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void insertNonPaymentCode(NonPaymentCodeDto dto) throws Exception{
		List<NonPaymentCodeDto> dtoList = new ArrayList<NonPaymentCodeDto>();
		dtoList = NonPaymentDamtInfo.xmlCodeDataParsing();
		//System.out.println(dtoList);
		System.out.println(dtoList.size());
		for(int i=0 ; i<dtoList.size(); i++) {
			dto = dtoList.get(i); 			
			npcMapper.insertNonPaymentCode(dto);
			log.debug("insertNonPaymentCode");
		}	
	}
	
	@Override
	public List<NonPaymentCodeDto> selectNonPaymentCodeList () throws Exception{
		return npcMapper.selectNonPaymentCodeList();
	}
}
