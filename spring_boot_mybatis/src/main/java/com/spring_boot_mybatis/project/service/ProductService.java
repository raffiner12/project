package com.spring_boot_mybatis.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_boot_mybatis.project.dao.IProductDAO;
import com.spring_boot_mybatis.project.model.ProductVO;


@Service // 넣어주고 cmd + shift + O
public class ProductService implements IProductService {
	// MyBatis 사용하는 경우
	@Autowired
	@Qualifier("IProductDAO") //따옴표는 컴파일러가 못찾아주고, 실행했을 때 오류난다.
	IProductDAO dao; //다른 패키지에 있으니까 import 시킴. 

	@Override
	public ArrayList<ProductVO> listAllProduct() {
		// IProductDAO의 listAllProduct() 호출 : DI 필요
		// ArrayList<Product> prdList = dao.listAllProduct();  return prdList; (원칙인데 한줄뿐이니까)
		return dao.listAllProduct(); // 객체라서 리턴값이 있음. dao 호출되면 Mapper 호출됨.
		
	}

	@Override
	public void insertProduct(ProductVO prd) {
		dao.insertProduct(prd);

	}

	@Override
	public void updateProduct(ProductVO prd) {
		dao.updateProduct(prd);

	}

	@Override
	public void deleteProduct(String prdNo) {
		dao.deleteProduct(prdNo); // 없으면 삭제해도 삭제가 안된다.

	}

	@Override
	public ProductVO detailViewProduct(String prdNo) {
		return dao.detailViewProduct(prdNo);
	}

	@Override
	public String prdNoCheck(String prdNo) {
		return dao.prdNoCheck(prdNo);
	}

	@Override
	public ArrayList<ProductVO> productSearch(HashMap<String, Object> map) {
		return dao.productSearch(map);
	}

}
