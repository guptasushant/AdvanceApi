package com.advance.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advance.api.dto.ApiDto;
import com.advance.api.service.ApiService;

import jakarta.validation.Valid;

@RestController
public class ApiController {
	@Autowired
	private ApiService apiService;

	@PostMapping("/insert")
	public ResponseEntity<ApiDto> Insert(@Valid @RequestBody ApiDto apiDto) {
		ApiDto insert = this.apiService.insert(apiDto);
		return new ResponseEntity<>(insert, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiDto> get(@PathVariable("id") int id) {
		ApiDto data = this.apiService.getData(id);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping("/fetch")
	public ResponseEntity<List<ApiDto>> getAll() {
		List<ApiDto> allData = this.apiService.getAllData();
		return new ResponseEntity<>(allData, HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	 public ResponseEntity<ApiDto> updateData(@RequestBody @Valid ApiDto apiDto, @PathVariable("id")int id)
	{
		ApiDto updateData = this.apiService.updateData(apiDto,id);
		return new ResponseEntity<>(updateData,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiDto> deleteData(@PathVariable int id){
		
		ApiDto deleteData = this.apiService.deleteData(id);
		return new ResponseEntity<>(deleteData,HttpStatus.OK);
	}
}
