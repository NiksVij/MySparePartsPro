<%--
  Created by IntelliJ IDEA.
  User: vijayn
  Date: 7/24/2017
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html5 lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
    </head>

    <script src="//code.jquery.com/jquery.min.js"></script>
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
        <input type="hidden" name="spare" id ="spare" value="Add">
        <table>
            <tr>
                <td>Vehicle Model:</td><td><input type="text" id="po_vehicle_model" name="po_vehicle_model"> </td>
            </tr>
            <tr>
                <td>Sparepart Id</td><td><input type="text" id="po_sparepart_id" name="po_sparepart_id"> </td>
            </tr>
            <tr>
                <td>Sparepart Name</td><td><input type="text" id="po_sparepart_name" name="po_sparepart_name"></td>
            </tr>
            <tr>
                <td>Unit</td><td><input type="number" id="po_unit" name="po_unit"></td>
            </tr>
            <tr>
                <td>Price</td><td><input type="number" id="po_price" name="po_price"></td>
            </tr>
            <tr>
                <td>Tax</td><td><input type="number" id="po_tax" name="po_tax"></td>
            </tr>
        </table>
        <input type="submit" value="Add Spare Part">
    </form>

    </body>
</html5>
