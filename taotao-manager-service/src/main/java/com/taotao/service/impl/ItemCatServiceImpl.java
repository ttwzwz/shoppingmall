package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;
@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
    private TbItemCatMapper tbItemCatMapper;
	@Override
	public List<EUTreeNode> getItemCatalogueByParentId(Long parentId) {
		//查询
		TbItemCatExample tbItemCatExample = new TbItemCatExample();
		Criteria criteria = tbItemCatExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(tbItemCatExample);
		//遍历封装
		List<EUTreeNode> eUTreeNodeList = new ArrayList<>();
		for (TbItemCat tbItemCat : tbItemCats) {
			EUTreeNode euTreeNode = new EUTreeNode();
			euTreeNode.setId(tbItemCat.getId());
			euTreeNode.setText(tbItemCat.getName());
			euTreeNode.setState(tbItemCat.getIsParent()?"closed":"open");
			eUTreeNodeList.add(euTreeNode);
		}
		return eUTreeNodeList;
	}

}
