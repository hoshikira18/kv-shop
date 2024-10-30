<%-- 
    Document   : order
    Created on : Oct 30, 2024, 1:35:56 PM
    Author     : VIET
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin | Products</title>
        <link rel="stylesheet" href="https://unpkg.com/tailwindcss@2.2.19/dist/tailwind.min.css"/>
    </head>
    <body class="py-10">
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
                <h2 class="text-xl font-semibold mb-4">Orders List</h2>
            </div>
            <div class="overflow-x-auto">
                <table class="min-w-full divide-y divide-gray-200 h-2/3 overflow-y-scroll">
                    <thead class="bg-gray-50">
                        <tr>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">STT</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">OrderID</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">UserID</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Total</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Create_At</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Status</th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">View</th>
                        </tr>
                    </thead>
                    <tbody class="bg-white divide-y divide-gray-200">
                        <c:forEach items="${ps}" var="order">
                            <tr>
                                <td class="px-6 py-4 whitespace-nowrap">${ps.indexOf(order) + 1}</td>
                                <td class="px-6 py-4 whitespace-nowrap">${order.getOrderID()}</td>
                                <td class="px-6 py-4 whitespace-nowrap">${order.getUserID()}</td>
                                <td class="px-6 py-4 whitespace-nowrap">${order.getTotal()}</td>
                                <td class="px-6 py-4 whitespace-nowrap">${order.getCreate_at()}</td>
                                <td class="px-6 py-4 whitespace-nowrap">${order.getStatus()}</td>
                                <td>
                                    <a class="text-blue-500" href="/shop/admin/view-orders/${order.getOrderID()}">View</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

