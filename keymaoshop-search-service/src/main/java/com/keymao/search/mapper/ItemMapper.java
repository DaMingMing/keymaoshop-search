package com.keymao.search.mapper;

import com.keymao.common.pojo.SearchItem;

import java.util.List;

public interface ItemMapper {

    List<SearchItem> getItemList();

    SearchItem getItemById(long id);
}
