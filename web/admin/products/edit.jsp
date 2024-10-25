<%-- 
    Document   : edit
    Created on : Oct 25, 2024, 8:35:47 AM
    Author     : khuye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://unpkg.com/tailwindcss@2.2.19/dist/tailwind.min.css"/>

    </head>
    <body>

        <form action="/admin/edit-product/${id}" class="flex flex-col mx-auto max-w-screen-xl">
            <img src="${product.image}" alt="alt" class="w-40"/>
            <input name='proName' value="${product.proName}" />            
            <input name='supName' value="${product.supName}" />




        </form>

    </body>
</html>
