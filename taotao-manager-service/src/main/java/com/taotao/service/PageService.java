package com.taotao.service;


import com.taotao.common.pojo.EUDataGridResult;

public interface PageService {
	
	EUDataGridResult getItemList(Integer page, Integer rows);

}
