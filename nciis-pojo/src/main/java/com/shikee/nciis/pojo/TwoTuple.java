package com.shikee.nciis.pojo;

/**
 * Created by Administrator on 2014/10/21.
 */
public class  TwoTuple<T,R> {

    private T first;
    private R second;

    public TwoTuple(T first,R second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public R getSecond() {
        return second;
    }
}
