package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.PageService;
@Service
public class PageServiceImpl implements PageService{
	@Autowired
    private TbItemMapper tbItemMapper;
	@Override
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		TbItemExample tbItemExample = new TbItemExample();
		List<TbItem> itemList = tbItemMapper.selectByExample(tbItemExample);
		PageInfo<TbItem> pageInfo = new PageInfo<>(itemList);
		long total = pageInfo.getTotal();
		EUDataGridResult euDataGridResult = new EUDataGridResult();
		euDataGridResult.setRows(itemList);
		euDataGridResult.setTotal(total);
		return euDataGridResult;
	}
	

}
