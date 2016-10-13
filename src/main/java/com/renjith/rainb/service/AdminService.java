package com.renjith.rainb.service;

import org.springframework.web.multipart.MultipartFile;

import com.renjith.rainb.dto.ProductDto;

public interface AdminService {

	public boolean addProduct(ProductDto productDto, MultipartFile file);

}
