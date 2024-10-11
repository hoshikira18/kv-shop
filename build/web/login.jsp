<%-- 
    Document   : login.jsp
    Created on : Oct 9, 2024, 12:00:40 PM
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
    <body class="flex items-center justify-center min-h-screen bg-gray-100 dark:bg-gray-900">
    <div class="w-full max-w-md p-8 space-y-4 bg-white dark:bg-gray-800 rounded-lg shadow-lg">
        <div class="space-y-2 text-center">
            <h2 class="text-3xl font-bold tracking-tight text-gray-900 dark:text-gray-100">Sign in</h2>
            <p class="text-sm text-gray-500 dark:text-gray-400">Enter your email and password to access your account</p>
        </div>
        <form action="signin" method="POST" class="space-y-4">
            <div class="space-y-2">
                <label for="email" class="text-sm font-medium text-gray-700 dark:text-gray-200">Email</label>
                <input id="phone" name="phone" required
                    class="w-full px-3 py-2 text-sm border rounded-md focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500 dark:border-gray-600 dark:bg-gray-700 dark:text-gray-100"
                    placeholder="012345678">
            </div>
            <div class="space-y-2">
                <label for="password" class="text-sm font-medium text-gray-700 dark:text-gray-200">Password</label>
                <input type="password" id="password" name="password" required
                    class="w-full px-3 py-2 text-sm border rounded-md focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500 dark:border-gray-600 dark:bg-gray-700 dark:text-gray-100">
            </div>
            <div class="flex items-center space-x-2">
                <input type="checkbox" id="remember" name="remember"
                    class="w-4 h-4 border-gray-300 rounded text-blue-600 focus:ring-blue-500 dark:border-gray-600 dark:bg-gray-700">
                <label for="remember" class="text-sm text-gray-600 dark:text-gray-300">Remember me</label>
            </div>
            <button type="submit"
                class="w-full px-4 py-2 text-sm font-medium text-white bg-blue-600 rounded-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500 dark:bg-blue-500 dark:hover:bg-blue-600">
                Sign in
            </button>
        </form>
        <div class="text-sm text-center text-gray-500 dark:text-gray-400">
            <a href="#" class="font-medium text-blue-600 hover:underline dark:text-blue-400">Forgot your password?</a>
        </div>
        <div class="text-sm text-center text-gray-500 dark:text-gray-400">
            Don't have an account?
            <a href="signup.jsp" class="font-medium text-blue-600 hover:underline dark:text-blue-400">Sign up</a>
        </div>
    </div>
</body>
</html>
