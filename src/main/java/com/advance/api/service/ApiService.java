package com.advance.api.service;

import java.util.List;

import com.advance.api.dto.ApiDto;
import com.advance.api.entity.ApiEntity;


public interface ApiService {
	ApiDto insert(ApiDto dto);
	
	ApiEntity apiEntity(ApiDto apiDto);
	
	ApiDto apiDto(ApiEntity entity);
	
	ApiDto getData(int id);
	
	List<ApiDto> getAllData();
	
	ApiDto updateData(ApiDto dto, int id);
	
	ApiDto deleteData(int id);
}
