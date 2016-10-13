package com.renjith.rainb.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.renjith.rainb.dao.ProductDao;
import com.renjith.rainb.dto.ProductDto;
import com.renjith.rainb.model.Product;
import com.renjith.rainb.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	ProductDao productDao;

	@Autowired
	Environment env;

	@Override
	@Transactional
	public boolean addProduct(ProductDto productDto, MultipartFile file) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		int productId = productDao.save(product);
		if (file != null) {
			product.setImagePath(saveProductImage(file, productId));
			productDao.save(product);
		}
		return true;
	}

	private String saveProductImage(MultipartFile file, int productId) {
		String relativePath = "product/" + productId;
		String imageDir = env.getProperty("product.image_path") + relativePath;
		File filePath = new File(imageDir);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		String fileName = generateImgName();
		relativePath += fileName;
		String imageFilePath = imageDir + fileName;
		File imageFile = new File(imageFilePath);
		try {
			byte[] bytes = file.getBytes();
			FileOutputStream out = new FileOutputStream(imageFile);
			out.write(bytes);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return relativePath;
	}

	private String generateImgName() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date d = new Date();
		String dStr = sdf.format(d);
		return "/" + dStr.replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "") + ".jpg";
	}

}
