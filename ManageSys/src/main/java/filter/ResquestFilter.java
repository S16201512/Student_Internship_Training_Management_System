package filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ResquestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletrequest;
        HttpServletResponse response = (HttpServletResponse) servletresponse;
        String currentURL = request.getRequestURI();
        String targetURL2=" ";
        //截取到当前文件名用于比较
        String targetURL = currentURL.substring(currentURL.indexOf("/"), currentURL.length());
        if(currentURL.indexOf("/",1)!=-1)
             targetURL2 = currentURL.substring(currentURL.indexOf("/",1), currentURL.length());
        //System.out.println(targetURL);
        //如果session不为空就返回该session，如果为空就返回null
        System.out.println("targetURL:"+targetURL);
        HttpSession session = request.getSession(false);
        if (!"/index.jsp".equals(targetURL)&&!"/500.jsp".equals(targetURL2)&&!"/404.jsp".equals(targetURL2)) {
            //判断当前页面是否是重顶次昂后的登陆页面页面，如果是就不做session的判断，防止死循环
            if (session == null || (session.getAttribute("admin_no") == null && session.getAttribute("teacher_no") == null && session.getAttribute("student_no") == null)) {
                //如果session为空表示用户没有登陆就重定向到login.jsp页面
                System.out.println("request.getContextPath()=" + request.getContextPath());
                response.sendRedirect("/error/404.jsp");
                return;
            }

            chain.doFilter( request , response );
       /* if(request1.getSession().getAttribute("user")!=null){
            chain.doFilter( request , response );
chain.doFilter( request , response );
        }else{
            response1.sendRedirect("/error/404.jsp");
        }*/
        }else
        chain.doFilter( request , response );
    }

    @Override
    public void destroy() {

    }
}
