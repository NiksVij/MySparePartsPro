<%-- @ page import="DAO.VehicleServiceDao" %>
<%@ page import="DaoImpl.VehicleServiceDaoImpl" --%>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="DaoImpl.VehicleServiceDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: vijayn
  Date: 7/27/2017
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<head>Vehicle Service</head>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<%--<jsp:useBean id="vehicleServiceDao" class="DaoImpl.VehicleServiceDaoImpl"/>--%>
<%
    if(session==null){
        request.getRequestDispatcher("login.html").forward(request,response);
    }

        int i = (int) session.getAttribute("isAdmin");
        if (i == 1)
        { out.print("<script>\n" +
                    "        $.get(\"nav.html\", function(data){\n" +
                    "            $(\"#nav-placeholder\").replaceWith(data);\n" +
                    "        });\n" +
                    "    </script>");}
        else
        {out.print("<script>\n" +
                    "        $.get(\"nav_op.html\", function(data){\n" +
                    "            $(\"#nav-placeholder\").replaceWith(data);\n" +
                    "        });\n" +
                    "    </script>");}

    String[] arr = new String[7];
    i=0;
    arr[i++]= request.getParameter("r_no");
    arr[i++]=request.getParameter("o_name");
    arr[i++]=request.getParameter("make_model");
    arr[i++]=request.getParameter("o_reading");
    arr[i++]=request.getParameter("service_no");
    arr[i++]=request.getParameter("rb_c");
    arr[i]=request.getParameter("purchase");
    if(arr[0]!=null) {
        /*for(int it=0;it<arr.length;it++){
            System.out.println(arr[it]);
        }*/
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        Date startDate = new Date();
        try {
            startDate = df.parse(arr[6]);
            String newDateString = df.format(startDate);
            System.out.println("newDateString "+ newDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        VehicleServiceDaoImpl vehicleServiceDao = new VehicleServiceDaoImpl();
        i = 0;
        boolean result =vehicleServiceDao.addVService(arr[i++], arr[i++], arr[i++], arr[i++], arr[i++], arr[i++], startDate);
        if (result){
            out.print("<script>alert(\"Order Confirmed\");</script>");
        }
        else {
            out.print("<script>alert(\"ERROR in Ordering\");</script>");
        }
    }
%>

<style>
    body{
        background-color:#ddd
    }
    table{
        padding: 10px;
        margin-top: 5%;
        background-color: #eee;
        margin-left: 40%;
        width: 450px;
        border: thick;
        border-color: #000;
        border-radius: 5%;
    }
    marquee{
        margin:5%;
    }
    td:nth-child(even) {
       text-align: right;
    }
</style>
<html>
<head>
    <title>Title</title>
</head>
<body >
<header>
    <div id="nav-placeholder"></div>
</header>
<
<h2 align="center">Vehicle Services</h2>
<form action="VehicleService.jsp" style="text-align: left" method="post">
    <table>
        <th align="center">Vehicle Details</th>
        <tr>    <td>Registration No.</td><td><input type="text" value="" name="r_no"></td></tr>
        <tr>    <td>Owner Name.</td><td><input type="text" value="" name="o_name"></td>   </tr>
        <tr>    <td>MakeModel</td><td><input type="text" value="" name="make_model"></td> </tr>
        <tr>    <td>Purchase Date</td><td><input type="text" value="" name="purchase"></td> </tr>
        <tr><th align="center">Service(s) Details</th></tr>
        <tr>    <td>Current Odometer Reading</td><td><input type="text" value="" name="o_reading"></td></tr>
        <tr>    <td>Service No.</td><td><input type="text" value="" name="service_no"></td></tr>
        <tr>    <td><input type="radio" value="Free" id="rb_c_f" name="rb_c">Free &nbsp;
            <input type="radio" id="rb_c_p"name="rb_c" value="Cost">Priced </td></tr>
        <tr><td></td>    <td><input type="submit" value="Submit">  </td>      </tr>
    </table>
</form>
<marquee><img src="img/cdk_logo.png" alt="CDK_logo"></marquee>
</body>
</html>
