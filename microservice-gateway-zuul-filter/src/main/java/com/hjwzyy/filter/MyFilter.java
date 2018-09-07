package com.hjwzyy.filter;

import com.netflix.zuul.ZuulFilter;

/**
 * @author jiangwei.huang@hand-china.com.
 * @version 1.0
 * @date 2018/9/6 0006.
 */
public class MyFilter extends ZuulFilter {
    /**
     * 过滤器类型
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的优先级,数字越大顺序越后
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否使用该过滤器
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体实现
     */
    @Override
    public Object run() {
        System.out.println("这里是通过ZuulFilter中打印出来的！");
        return null;
    }
}
