package com.spring_boot_mybatis.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_mybatis.project.model.ProductVO;


// 구현하고자 하는 기능의 모든 추상 메소드 선언
// 주의! : 반환값과 매개변수 잘 지정
public interface IProductService {
	public ArrayList<ProductVO> listAllProduct(); // 전체 상품 조회
	public void insertProduct(ProductVO prd); // 상품 등록 (상품 등록은 한 개만 하니까 ProductVO prd 써줌) 그리고 전체를 등록하니까 ProductVO로.
	public void updateProduct(ProductVO prd); // 상품 수정
	public void deleteProduct(String prdNo);  // 상품 삭제 (하나 삭제 하니까 String 타입으로.)
	public ProductVO detailViewProduct(String prdNo); // 상세 상품 조회 (하나의 상품에 대한 상세정보 반환)
	public String prdNoCheck(String prdNo); // 상품 번호 중복 확인
	public ArrayList<ProductVO> productSearch(HashMap<String, Object> map); //상품 검색 (1,2 둘다 있으니까 하나만 넣으려고 productSearch
	
}
