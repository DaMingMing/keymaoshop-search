package com.keymao.search.service;

import com.keymao.common.pojo.SearchResult;

public interface SearchService {
    /**
     *  根据输入条件返回搜索结果
     * @param keyWord 输入的关键字
     * @param page 页数
     * @param rows 行数
     * @return
     */
    public SearchResult search(String keyWord, int page, int rows) throws Exception;
}
