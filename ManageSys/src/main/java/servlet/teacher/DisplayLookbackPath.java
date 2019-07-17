package servlet.teacher;

import service.teather.TeacherService;
import util.DistanceUtil;
import util.Tsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/teacher/displayLookBackPath")
public class DisplayLookbackPath extends HttpServlet {
    private String tno;
    private ArrayList<String> pointList;
    private TeacherService service;
    private Tsp tsp;
    private String bestPath;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service=new TeacherService();

        if(request.getSession().getAttribute("teacher_no")!=null){
            tno=(String)request.getSession().getAttribute("teacher_no");
            pointList=service.loadLookBackPoint(tno);
            for(String e:pointList){
                System.out.println("hewenyong"+e);
            }
            //pointList.add(0,"南昌");
        }
        int[][] pointPath=new int[pointList.size()][pointList.size()];
        String pointOne;
        String pointTwo;
        if(pointList!=null){
            for (int i=0;i<pointList.size();i++){
                pointOne=pointList.get(i);
                System.out.println();
                for(int j=0;j<pointList.size();j++){
                    pointTwo=pointList.get(j);
                    pointPath[i][j]=DistanceUtil.getDistance(pointOne,pointTwo);
                }

            }
            tsp=new Tsp(pointPath,pointList.size(),pointList);
            bestPath=tsp.run();
        }
        if(bestPath!=null){
            request.getSession().setAttribute("bestPath",bestPath);
            response.sendRedirect("/city_pathServlet");
        }

    }
}
