<%-- 
    Document   : categories
    Created on : Oct 13, 2024, 1:36:38 PM
    Author     : khuye
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin | Accounts</title>
        <link rel="stylesheet" href="https://unpkg.com/tailwindcss@2.2.19/dist/tailwind.min.css"/>

    </head>
    <body class="py-10 min-h-screen  px-5">
        <div class="space-x-5 text-center pb-10">
            <a href="/shop/admin/products">Products</a>
            <a href="/shop/admin/orders">Order</a>
            <a href="/shop/admin/categories">Categories</a>
            <a href="/shop/admin/accounts">Accounts</a>
            <a href="/shop/logout">Logout</a>
        </div>

        <div class="bg-white shadow border rounded-lg p-6 max-w-screen-xl mx-auto mt-10">
            <button onclick='window.history.go(-1);' class="flex items-center">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-arrow-left-to-line"><path d="M3 19V5"/><path d="m13 6-6 6 6 6"/><path d="M7 12h14"/></svg>
                <p>Back
            </button>
            <div class="flex items-center justify-between py-2">
                <h2 class="text-xl font-semibold mb-4">Accounts List</h2>
                <a href="/shop/admin/accounts/create.jsp" class="block p-2 bg-black text-white rounded-md">Create new Accounts</a>
            </div>
            <div class="overflow-x-auto">
                <table class="min-w-full divide-y divide-gray-200">
                    <thead class="bg-gray-50">
                        <tr>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">ID</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Name</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"></th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"></th>
                        </tr>
                    </thead>
                    <tbody class="bg-white divide-y divide-gray-200">
                        <c:forEach items="${adminUsers}" var="user">
                            <tr>
                                <td class="px-6 py-4 whitespace-nowrap">${adminUsers.indexOf(user)+1}</td>
                                <td class="px-6 py-4 whitespace-nowrap">${user.userName}</td>
                                <td>
                                    <a href="/shop/admin/edit-account/${user.userID}">Edit</button>
                                </td>
                                <td>
                                    <form action="/shop/admin/delete-account" method="POST">
                                        <input name="user-id" value="${user.userID}" hidden="true" />
                                        <button type="submit">Delete</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>
