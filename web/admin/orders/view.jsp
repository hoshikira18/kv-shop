<%-- 
    Document   : update
    Created on : Oct 30, 2024, 2:30:51 PM
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
            <!--            <button onclick='window.history.go(-1);' class="flex items-center">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-arrow-left-to-line"><path d="M3 19V5"/><path d="m13 6-6 6 6 6"/><path d="M7 12h14"/></svg>
                            <p>Back
                        </button>
                        <div class="flex items-center justify-between py-2">
                            <h2 class="text-xl font-semibold mb-4">Order detail</h2>
                        </div>
                        <div class="overflow-x-auto">-->
            <button onclick='window.history.go(-1);' class="flex items-center">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-arrow-left-to-line"><path d="M3 19V5"/><path d="m13 6-6 6 6 6"/><path d="M7 12h14"/></svg>
                <p>Back
            </button>
            <form action="/shop/admin/update-order/${order[0]}" method="POST">
                <input name="orderID" value="${order[0]}" hidden/>
                <h2 class="text-2xl font-semibold" style="padding-bottom: 20px">Order Detail</h2>
                <div class="space-y-3">
                    <div class="grid grid-cols-2 gap-4">
                        <div>
                            <label class=" block pb-2" style="padding-left: 10px">OrderID</label>
                            <input name="ID" value="${order[0]}" disabled 
                                   class="w-full border-2 px-2 py-1 outline-none rounded-md border-black/60"/>
                        </div>
                        <div>
                            <label class="block pb-2" style="padding-left: 10px">Create_At</label>
                            <input name="creat_At" value="${order[3]}" disabled
                                   class="w-full border-2 border-black/60 px-2 py-1 rounded-md"/>
                        </div>
                        <div>
                            <label class=" block pb-2" style="padding-left: 10px">Total</label>
                            <input name="total" value="${order[2]}" disabled 
                                   class="w-full border-2 px-2 py-1 outline-none rounded-md border-black/60"/>
                        </div>
                        <div>
                            <label class="block pb-2" style="padding-left: 10px">Status</label>
                            <select name="status" class="w-full border-2 border-black/60 px-2 py-1 rounded-md">
                                ${order[4]}
                                <option <c:if test="${order[4] == 'completed'}">selected</c:if>>completed</option>
                                <option <c:if test="${order[4] == 'pending'}">selected</c:if>>pending</option>
                                <option <c:if test="${order[4] == 'shipped'}">selected</c:if>>shipped</option>
                                <option <c:if test="${order[4] == 'returned'}">selected</c:if>>returned</option>
                                <option <c:if test="${order[4] == 'Direct Bank Transfer'}">selected</c:if>>Direct Bank Transfer</option>
                                <option <c:if test="${order[4] == 'Check Payment'}">selected</c:if>>Check Payment</option>
                                <option <c:if test="${order[4] == 'Paypal'}">selected</c:if>>Paypal</option>
                                </select>
                            </div>
                            <div>
                                <label class=" block pb-2" style="padding-left: 10px">UserID</label>
                                <input name="userID" value="${order[1]}" disabled 
                                   class="w-full border-2 px-2 py-1 outline-none rounded-md border-black/60"/>
                        </div>
                        <div>
                            <label class="block pb-2" style="padding-left: 10px">UserName</label>
                            <input name="userName" value="${order[5]}" disabled
                                   class="w-full border-2 border-black/60 px-2 py-1 rounded-md"/>
                        </div>
                        <div>
                            <label class=" block pb-2" style="padding-left: 10px">Age</label>
                            <input name="Age" value="${order[6]}" disabled 
                                   class="w-full border-2 px-2 py-1 outline-none rounded-md border-black/60"/>
                        </div>
                        <div>
                            <label class="block pb-2" style="padding-left: 10px">Phone Number</label>
                            <input name="phoneNumber" value="${order[9]}" disabled
                                   class="w-full border-2 border-black/60 px-2 py-1 rounded-md"/>
                        </div>
                        <div>
                            <label class=" block pb-2" style="padding-left: 10px">Email </label>
                            <input name="email" value="${order[8]}" disabled 
                                   class="w-full border-2 px-2 py-1 outline-none rounded-md border-black/60" />
                        </div>
                        <div>
                            <label class=" block pb-2" style="padding-left: 10px">Address </label>
                            <input name="address" value="${order[7]}" disabled 
                                   class="w-full border-2 px-2 py-1 outline-none rounded-md border-black/60"/>
                        </div>
                    </div>
                </div>
                <div class="py-6">
                    <input type="submit" class="bg-black p-2 text-white rounded-md cursor-pointer" 
                           style="width: 100px; margin-right: 20px" value="Update" />
                    <input type="button" id="exitBtn" onclick="exit()" style="width: 100px" 
                           class="bg-black p-2 text-white rounded-md cursor-pointer" value="Exit" />
                </div>
                <script>
                    function exit() {
                        location.assign('/shop/admin/orders');
                    }
                </script>
            </form>
        </div>
        <!--</div>-->
    </body>
</html>

