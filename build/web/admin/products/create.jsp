<%-- 
    Document   : create.jsp
    Created on : Oct 13, 2024, 3:00:50 PM
    Author     : khuye
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new Product</title>       
        <link rel="stylesheet" href="https://unpkg.com/tailwindcss@2.2.19/dist/tailwind.min.css"/>
        <script src="./../../JS/navigation.js" type="text/javascript" defer></script>

    </head>
    <body class="py-10 min-h-screen">

    <navigation-component></navigation-component>
    <form action="create" method="POST" class="border shadow p-5 rounded-md max-w-screen-md mx-auto space-y-3">
        <button onclick='window.history.go(-1);' class="flex items-center">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-arrow-left-to-line"><path d="M3 19V5"/><path d="m13 6-6 6 6 6"/><path d="M7 12h14"/></svg>
            <p>Back
        </button>
        <h2 class="text-2xl font-semibold">Create new Product</h2>
        <div class="space-y-3">
            <div class="grid grid-cols-2 gap-4">
                <div>
                    <label class=" block pb-2">Title </label>
                    <input name="product-name" value="" required="true" class="w-full border-2 px-2 py-1 outline-none rounded-md border-black/60" placeholder="Product A" />
                </div>
                <div>
                    <label class="block pb-2">Supplier</label>
                    <select name="product-supplier" class="w-full border-2 border-black/60 px-2 py-1 rounded-md">
                        <c:forEach items="${ss}" var="supplier">
                            <option value="${supplier.supplierID}">${supplier.supplierName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div>
                <label class="block pb-2">Category</label>
                <select name="product-category" class="w-full border-2 border-black/60 px-2 py-1 rounded-md">
                    <c:forEach items="${cs}" var="category">
                        <option value="${category.categoryID}">${category.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="grid grid-cols-2 gap-4">
                <div>
                    <label class=" block pb-2">Price </label>
                    <input name="product-price" value="" required="true" class="w-full border-2 px-2 py-1 outline-none rounded-md border-black/60" placeholder="1.000.000" />
                </div>
                <div>
                    <label class="block pb-2">Inventory</label>
                    <input name="product-inventory" value="" required="true" class="w-full border-2 px-2 py-1 outline-none rounded-md border-black/60" placeholder="100" />
                </div>
            </div>
        </div>

        <input class="bg-black p-2 text-white rounded-md cursor-pointer" type="submit" value="Create" />
    </form>
</body>
</html>
