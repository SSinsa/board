package board.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import board.api.dto.NonPaymentCodeDto;

@Mapper
public interface NonPaymentCodeMapper {
	void insertNonPaymentCode(NonPaymentCodeDto dto) throws Exception;
	
	List<NonPaymentCodeDto> selectNonPaymentCodeList() throws Exception;
}
