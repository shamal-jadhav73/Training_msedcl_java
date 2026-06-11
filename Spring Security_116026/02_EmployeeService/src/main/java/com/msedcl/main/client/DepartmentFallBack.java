package com.msedcl.main.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.msedcl.main.dto.DepartmentDTO;



import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class DepartmentFallBack implements DepartmentFeignClient{@Override
	public ResponseEntity<DepartmentDTO> getDepartment(int departmentId) {
		log.info("Fallback invoked..");
		return ResponseEntity.status(HttpStatus.OK).body(new DepartmentDTO(0, "DEFAULT-SET-BY-FALLBACK-INVOKED"));
	}

}
