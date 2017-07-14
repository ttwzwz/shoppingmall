package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.service.ItemCatService;

/**
 *
 * <p>Title:ItemCatController<p>
 * <p>Description:<p>
 * <p>Company: www.taotao.com<p>
 * @author ysy
 * @Date 2017年7月12日 下午3:35:24
 * @Version 
 *
 */
@Controller
public class ItemCatController {
	@Autowired
    private ItemCatService itemCatService;
	@ResponseBody
	@RequestMapping("/item/cat/list")
	public List<EUTreeNode> showItemCatalogue(@RequestParam(value="id",defaultValue="0") Long parentId){
		return itemCatService.getItemCatalogueByParentId(parentId);
	}
}
