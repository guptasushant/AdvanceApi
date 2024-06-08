package com.advance.api.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advance.api.apiexception.ApiException;
import com.advance.api.dto.ApiDto;
import com.advance.api.entity.ApiEntity;
import com.advance.api.repository.ApiRepository;
import com.advance.api.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {

	@Autowired
	private ApiRepository apiRepository;

	public ApiDto insert(ApiDto dto) {
		ApiEntity entity = this.apiEntity(dto);
		ApiEntity save = this.apiRepository.save(entity);
		ApiDto apiDto = this.apiDto(save);
		return apiDto;

	}

	public ApiEntity apiEntity(ApiDto apiDto) {
		ApiEntity apiEntity = new ApiEntity();
		apiEntity.setName(apiDto.getName());
		apiEntity.setEmail(apiDto.getEmail());
		apiEntity.setPassword(apiDto.getPassword());
		return apiEntity;
	}

	public ApiDto apiDto(ApiEntity entity) {
		ApiDto apidto = new ApiDto();
		apidto.setId(entity.getId());
		apidto.setName(entity.getName());
		apidto.setEmail(entity.getEmail());
		apidto.setPassword(entity.getPassword());
		return apidto;
	}

	public ApiDto getData(int id) {
		ApiEntity orElseThrow = this.apiRepository.findById(id).orElseThrow(() -> new ApiException("id not found !"));
		ApiDto apiDto = this.apiDto(orElseThrow);
		return apiDto;
	}

	public List<ApiDto> getAllData() {
		List<ApiEntity> all = this.apiRepository.findAll();
		List<ApiDto> list = new ArrayList<>();
		for (ApiEntity a : all) {
			ApiDto apiDto = this.apiDto(a);
			list.add(apiDto);
		}
		return list;
	}

	// Updating the existing data based on the provided ID
	public ApiDto updateData(ApiDto dto, int id) {
		// Fetch the existing entity from the database using the provided ID
		ApiEntity existingEntity = this.apiRepository.findById(id)
				.orElseThrow(() -> new ApiException("Entity with id " + id + " not found!"));

		// Update the entity's fields with values from the DTO
		existingEntity.setName(dto.getName());
		existingEntity.setEmail(dto.getEmail());
		existingEntity.setPassword(dto.getPassword());

		// Save the updated entity back to the database
		ApiEntity updatedEntity = this.apiRepository.save(existingEntity);

		// Convert the updated entity back to a DTO
		ApiDto updatedDto = this.apiDto(updatedEntity);
		return updatedDto;
	}
	
	  public ApiDto deleteData(int id) {
	        ApiEntity existingEntity = this.apiRepository.findById(id)
	            .orElseThrow(() -> new ApiException("Entity with id " + id + " not found!"));

	        ApiDto apiDto = this.apiDto(existingEntity);
	        this.apiRepository.delete(existingEntity);
	        return apiDto;
	    }

}
