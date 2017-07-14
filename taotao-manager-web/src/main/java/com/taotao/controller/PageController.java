package com.taotao.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.PageService;

/**
 *
 * <p>Title:PageController<p>
 * <p>Description:<p>
 * <p>Company: www.taotao.com<p>
 * @author ysy
 * @Date 2017年7月11日 下午8:44:49
 * @Version 1.0
 *
 */
@Controller
public class PageController {
	@Autowired
	private PageService pageService;
	@RequestMapping("/{pageName}")
	public String showPage(@PathVariable("pageName") String pageName){
		return pageName;
	}
	@ResponseBody
	@RequestMapping("/item/list")
	public EUDataGridResult showItemList(@RequestParam("page") Integer page,
			                   @RequestParam("rows") Integer rows){
		EUDataGridResult itemList = pageService.getItemList(page, rows);
		return itemList;
	}

}
