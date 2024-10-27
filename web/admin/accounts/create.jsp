<%-- 
    Document   : edit
    Created on : Oct 27, 2024, 3:11:24 PM
    Author     : khuye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Edit</title>
        <link rel="stylesheet" href="https://unpkg.com/tailwindcss@2.2.19/dist/tailwind.min.css"/>

    </head>
    <body>
    <body class="bg-gray-100">
        <div class="container mx-auto px-4 py-8">
            <h1 class="text-3xl font-bold mb-6 text-center text-gray-900">Edit Account</h1>
            ${message}
            <form method="POST" action="/shop/admin/accounts/create" class="max-w-md mx-auto bg-white shadow-lg rounded-lg px-8 pt-6 pb-8 mb-4">
                <div class="mb-4">
                    <label class="block text-gray-800 text-sm font-bold mb-2" for="name">
                        Name
                    </label>
                    <input name="name" class="shadow appearance-none border border-gray-300 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:ring-2 focus:ring-gray-500" id="name" type="text" placeholder="John Doe" value="${user.userName}">
                </div>
                <div class="mb-4">
                    <label class="block text-gray-800 text-sm font-bold mb-2" for="age">
                        Age
                    </label>
                    <input name="age" type="number" value="${user.age}" class="shadow appearance-none border border-gray-300 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:ring-2 focus:ring-gray-500" id="age" placeholder="30">
                </div>
                <div class="mb-4">
                    <label class="block text-gray-800 text-sm font-bold mb-2" for="phone">
                        Phone Number
                    </label>
                    <input name="phone"  value="${user.phoneNumber}" class="shadow appearance-none border border-gray-300 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:ring-2 focus:ring-gray-500" id="phone" type="tel" placeholder="123-456-7890">
                </div>
                <div class="mb-4">
                    <label class="block text-gray-800 text-sm font-bold mb-2" for="address">
                        Address
                    </label>
                    <input name="address" value="${user.getAddress()}" class="shadow appearance-none border border-gray-300 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:ring-2 focus:ring-gray-500" id="address" placeholder="123 Main St, City, Country"/>
                </div>
                <div class="mb-4">
                    <label class="block text-gray-800 text-sm font-bold mb-2" for="email">
                        Email
                    </label>
                    <input name="email" value="${user.getEmail()}" class="shadow appearance-none border border-gray-300 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:ring-2 focus:ring-gray-500" id="email" type="email" placeholder="john@example.com">
                </div>
                <div class="mb-6">
                    <label class="block text-gray-800 text-sm font-bold mb-2" for="password">
                        Password
                    </label>
                    <input name="password" value="${user.getPassword()}" class="shadow appearance-none border border-gray-300 rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:ring-2 focus:ring-gray-500" id="password" type="text" placeholder="******************">
                </div>
                <div class="flex items-center justify-between">
                    <button class="bg-gray-800 hover:bg-gray-900 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline transition duration-300 ease-in-out" type="submit">
                        Save Changes
                    </button>
                </div>
            </form>
        </div>
    </body>
</body>
</html>
