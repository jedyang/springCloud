package com.yunsheng.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        /* 过滤时机
        pre：路由之前
        routing：路由之时
        post： 路由之后
        error：发送错误调用
        */
        return "pre";
    }

    /**
     * 过滤器的优先级
     * 数字越大优先级越低
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 该过滤器开关
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器方法
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String username = request.getParameter("name");// 获取请求的参数
        if (null != username && username.equals("yunsheng")) {// 如果请求的参数不为空，且值为chhliu时，则通过
            ctx.setSendZuulResponse(true);// 对该请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);// 设值，让下一个Filter看到上一个Filter的状态
            return null;
        } else {
            ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
            ctx.setResponseStatusCode(401);// 返回错误码
            ctx.setResponseBody("{\"result\":\"name is not correct!\"}");// 返回错误内容
            ctx.set("isSuccess", false);
            return null;
        }
    }
}
