package web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
public class AuthenticationFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    public String filterType() {
    	System.err.println("this one");
        return "pre";
    }

    @Override
    public int filterOrder() {
    	System.err.println("this two");
        return 0;
    }

    @Override
    public boolean shouldFilter() {
    	System.err.println("this three");
        return true;
    }

    @Override
    public Object run() {
    	System.err.println("this four");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        LOGGER.info("{} {} {}", request.getMethod(), request.getRequestURL().toString(), request.getProtocol());

        String accessToken = request.getParameter("access_token");
        if (StringUtils.isBlank(accessToken)) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("{\"result\":\"token is not empty!\",\"resultCode\":\"1001\",\"resultMsg\":\"缺少授权的token值\"}");// 返回错误内容  
            requestContext.set("isSuccess", false);  
            HttpServletResponse response = requestContext.getResponse();
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.setLocale(new java.util.Locale("zh","CN"));
            return null;
        }
        requestContext.setSendZuulResponse(true);// 对该请求进行路由  
        requestContext.setResponseStatusCode(200);  
        requestContext.set("isSuccess", true);// 设值，让下一个Filter看到上一个Filter的状态  
        return null;
    }
}
