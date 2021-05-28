package controller;

import model.Classed;
import model.Student;
import service.classjdbc.ClassConnect;
import service.classjdbc.ClassConnectInterface;
import service.studentjdbc.StudentConnect;
import service.studentjdbc.StudentConnectI;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = "/student")
public class Servlet extends HttpServlet {

    StudentConnectI studentConnect = new StudentConnect();
    ClassConnectInterface classConnect = new ClassConnect();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action){
            case "":
                listStudent(request,response);
                break;
            case "create":
                showFormCreate(request,response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            case "delete":
                showFormDelete(request,response);
                break;
        }
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentConnect.selectById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/delete.jsp");
        request.setAttribute("student",student);
        dispatcher.forward(request,response);

    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        List<Classed> classedList = this.classConnect.selectAll();
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentConnect.selectById(id);
        request.setAttribute("student",student);
        request.setAttribute("classedList",classedList);
        dispatcher.forward(request,response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Classed> classedList = this.classConnect.selectAll();
        request.setAttribute("classedList",classedList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        dispatcher.forward(request,response);

    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentConnect.selectAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        request.setAttribute("studentList", studentList);
        dispatcher.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action){
            case "create":
                createStudent(request,response);
                break;
            case "edit":
                editStudent(request,response);
                break;
            case "delete":
                deleteStudent(request,response);
                break;
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.studentConnect.delete(id);
        request.setAttribute("message","Success");
        response.sendRedirect("student/delete.jsp");
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
      int id = Integer.parseInt(request.getParameter("id"));
      String name = request.getParameter("name");
      String dob = request.getParameter("dob");
      String address = request.getParameter("address");
      int classID = Integer.parseInt(request.getParameter("classId"));
      Classed classed =   this.classConnect.selectById(classID);
      Student student = new Student(id,name,dob,address,classed);
      this.studentConnect.edit(id,student);
      request.setAttribute("message", "Success");
      response.sendRedirect("/student/edit.jsp");
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = (int) (Math.random()*10000);
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");

        int id_class = Integer.parseInt(request.getParameter("class_id"));
        Classed classed = this.classConnect.selectById(id_class);
        Student student = new Student(id,name,dob,address,classed);

        this.studentConnect.create(student);

        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        request.setAttribute("message","New successful product added");
        dispatcher.forward(request,response);




    }
}
