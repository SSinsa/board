package board.api.service;

import java.util.List;

import board.api.dto.NonPaymentCodeDto;

public interface NonPaymentService {
	void insertNonPaymentCode(NonPaymentCodeDto dto) throws Exception;
	
	List<NonPaymentCodeDto> selectNonPaymentCodeList() throws Exception;
}
