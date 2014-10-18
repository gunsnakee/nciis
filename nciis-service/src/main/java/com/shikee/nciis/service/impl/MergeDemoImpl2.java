package com.shikee.nciis.service.impl;

import com.shikee.nciis.service.api.MergeDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/10/18.
 */
public class MergeDemoImpl2 implements MergeDemo {
    @Override
    public List<String> merge() {
        List<String> strings = new ArrayList<String>();
        strings.add("MergeDemoImpl2-1");
        strings.add("MergeDemoImpl2-2");
        return strings;
    }
}
