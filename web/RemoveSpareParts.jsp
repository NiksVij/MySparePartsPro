<%--
  Created by IntelliJ IDEA.
  User: vijayn
  Date: 7/25/2017
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Home</title>
</head>

<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<%
    if(session==null){
        request.getRequestDispatcher("login.html").forward(request,response);
    }
    else{
        int i=(int)session.getAttribute("isAdmin");
        if(i==1)
            out.print("<script>\n" +
                    "        $.get(\"nav.html\", function(data){\n" +
                    "            $(\"#nav-placeholder\").replaceWith(data);\n" +
                    "        });\n" +
                    "    </script>");
        else
            out.print("<script>\n" +
                    "        $.get(\"nav_op.html\", function(data){\n" +
                    "            $(\"#nav-placeholder\").replaceWith(data);\n" +
                    "        });\n" +
                    "    </script>");

        String  op = (String) session.getAttribute("operation");
        if(op != null){
            //Work under process

            System.out.println("operation not null");
            if(op.equals("Action Successful"))
            out.print("<script>alert('action done');</script>");
            else{
                out.print("<script>alert('unable to perform operation at database side');</script>");
            }
        }
        /*else {System.out.println("operation null");
            out.print("<script>alert('action failed due to bad server');</script>");
        }*/
    }
%>
<style>
    .scroll {
        /*overflow: auto;*/
        height: 80%;
        padding: 20%;
        margin-top: 5%;
        margin-left: 25%;
        /*margin-right: 50%*/;
    }
</style>
<body>
<header>
    <div id="nav-placeholder"></div>
</header>

<form action="SparePartsServ" class="scroll" method="post">
    <input type="hidden" name="spare" id ="spare" value="Remove">
    <table>
    <tr>
        <td>Sparepart Id</td><td><input type="text" id="po_sparepart_id" name="po_sparepart_id"> </td>
    </tr>
    </table>
    <input type="submit" value="Remove Spare Part">
</form>
</body>
</html>
