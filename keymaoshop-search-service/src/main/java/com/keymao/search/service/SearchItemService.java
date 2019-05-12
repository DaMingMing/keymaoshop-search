package com.keymao.search.service;

import com.keymao.common.utils.E3Result;

public interface SearchItemService {
    /**
     * 导入索引
     * @return 导入状态
     */
    public E3Result importItmes();
}
