<%-- 
    Document   : MyAccount
    Created on : Oct 28, 2024, 12:06:02 PM
    Author     : VIET
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import = "models.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <!--=============== FLATICON ===============-->
        <link
            rel="stylesheet"
            href="https://cdn-uicons.flaticon.com/2.0.0/uicons-regular-straight/css/uicons-regular-straight.css"
            />

        <!--=============== SWIPER CSS ===============-->
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"
            />
        <link rel="stylesheet" href="https://unpkg.com/tailwindcss@2.2.19/dist/tailwind.min.css"/>

        <!--=============== CSS ===============-->
        <link rel="stylesheet" href="./assets/css/styles.css" />

        <title>Ecommerce Website</title>
    </head>
    <body>
        <!--=============== HEADER ===============-->
        <header class="header">
            <div class="header__top">
                <div class="header__container container">
                    <div class="header__contact">
                        <span>(+01) - 2345 - 6789</span>
                        <span>Our location</span>
                    </div>
                    <p class="header__alert-news">
                        Super Values Deals - Save more coupons
                    </p>
                    <a href="logout" class="header__top-action">
                        Log In / Sign Up
                    </a>
                </div>
            </div>

            <nav class="nav container">
                <a href="home" class="nav__logo">
                    <img
                        class="nav__logo-img"
                        src="https://billalben.github.io/evara-ecommerce/assets/img/logo.svg"
                        alt="website logo"
                        />
                </a>
                <div class="nav__menu" id="nav-menu">
                    <ul class="nav__list">
                        <li class="nav__item">
                            <a href="home" class="nav__link">Home</a>
                        </li>
                        <li class="nav__item">
                            <a href="products" class="nav__link">Shop</a>
                        </li>
                        <li class="nav__item">
                            <a href="editAccount" class="nav__link active-link"
                               >My Account</a
                            >
                        </li>
                        <li class="nav__item">
                            <a href="#" class="nav__link">Compare</a>
                        </li>
                        <li class="nav__item">
                            <a href="logout" class="nav__link">Login</a>
                        </li>
                    </ul>
                    <div class="header__search">
                        <input
                            type="text"
                            placeholder="Search For Items..."
                            class="form__input"
                            />
                        <button class="search__btn">
                            <img src="https://billalben.github.io/evara-ecommerce/assets/img/search.png" alt="search icon" />
                        </button>
                    </div>
                </div>
                <div class="header__user-actions">
                    <a href="#" class="header__action-btn" title="Wishlist">
                        <img src="https://billalben.github.io/evara-ecommerce/assets/img/icon-heart.svg" alt="" />
                        <span class="count">3</span>
                    </a>
                    <a href="cart" class="header__action-btn" title="Cart">
                        <img src="https://billalben.github.io/evara-ecommerce/assets/img/icon-cart.svg" alt="" />
                        <span class="count">3</span>
                    </a>
                </div>
            </nav>
        </header>

        <!--=============== MAIN ===============-->
        <main class="main">
            <!--=============== BREADCRUMB ===============-->
            <section class="breadcrumb">
                <ul class="breadcrumb__list flex container">
                    <li><a href="home" class="breadcrumb__link">Home</a></li>
                    <li><span class="breadcrumb__link">></span></li>
                    <li><span class="breadcrumb__link">Account</span></li>
                </ul>
            </section>

            <!--=============== ACCOUNTS ===============-->
            <section class="accounts section--lg">
                <div class="accounts__container container grid">
                    <div class="account__tabs">
                        <p class="account__tab active-tab" data-target="#dashboard">
                            <i class="fi fi-rs-settings-sliders"></i> Dashboard
                        </p>
                        <p class="account__tab" data-target="#orders">
                            <i class="fi fi-rs-shopping-bag"></i> Orders
                        </p>
                        <p class="account__tab" data-target="#update-profile">
                            <i class="fi fi-rs-user"></i> Update Profile
                        </p>
                        <p class="account__tab" data-target="#address">
                            <i class="fi fi-rs-marker"></i> My Address
                        </p>
                        <p class="account__tab" data-target="#change-password">
                            <i class="fi fi-rs-settings-sliders"></i> Change Password
                        </p>
                        <p onclick="dieu_huong()" class="account__tab">
                            <i class="fi fi-rs-exit"></i> Logout
                        </p>
                        <script>
                            function dieu_huong() {
                                location.assign("logout");
                            }
                        </script>
                    </div>
                    <div class="tabs__content">
                        <div class="tab__content active-tab" content id="dashboard">
                            <h3 class="tab__header">Hello ${user.getUserName()}</h3>
                            <div class="tab__body">
                                <p class="tab__description">
                                    From your account dashboard. you can easily check & view your
                                    recent order, manage your shipping and billing addresses and
                                    edit your password and account details
                                </p>
                            </div>
                        </div>
                        <div class="tab__content" content id="orders">
                            <h3 class="tab__header">Your Orders</h3>
                            <div class="tab__body">
                                <table class="placed__order-table">
                                    <thead>
                                        <tr>
                                            <th>Orders</th>
                                            <th>Date</th>
                                            <th>Status</th>
                                            <th>Totals</th>
                                            <th>Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${orders}" var="o" >
                                            <tr>
                                                <td>${o.getOrderID()}</td>
                                                <td>${o.getCreate_at()}</td>
                                                <td>${o.getStatus()}</td>
                                                <td>${o.getTotal()}</td>
                                                <td><a href="#" class="view__order">View</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="tab__content" content id="update-profile">
                            <h3 class="tab__header">Update Profile</h3>
                            <div class="tab__body">
                                <form class="form grid" action="editAccount" method="POST">
                                    <input name="from" value="profile" hidden="true"/>
                                    <input
                                        type="text"
                                        name="userName"
                                        placeholder="Username"
                                        class="form__input"
                                        />
                                    <div class="form__btn">
                                        <button class="btn btn--md">Save</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="tab__content" content id="address">
                            <h3 class="tab__header">Shipping Address</h3>
                            <div id="display" style="display: block" class="tab__body">
                                <!--                                <address class="address">
                                                                    3522 Interstate <br />
                                                                    75 Business Spur, <br />
                                                                    Sault Ste. <br />
                                                                    Marie, Mi 49783
                                                                </address>-->
                                <address class="address">
                                    ${user.getAddress()}
                                </address>
                                <!--<p class="city">New York</p>-->
                                <button onclick="toggleDisplay()" class="edit">Edit</button>
                            </div>
                            <div id="edit" style="display: none" class="tab__body">
                                <form class="form grid" action="editAccount" method="POST">
                                    <input name="from" value="address" hidden="true"/>
                                    <input type="text" name="address" style="width: 100%"
                                           value="${user.getAddress()}"  />
                                    <div class="form__btn">
                                        <button class="btn btn--md">Save</button>
                                    </div>
                                </form>
                                <div class="form__btn" style="margin-top: 10px">
                                    <button onclick="toggleDisplay()" class="btn btn--md">Exit</button>
                                </div>
                            </div>
                            <script>
                                function toggleDisplay() {
                                    const div = document.getElementById('display');
                                    const div2 = document.getElementById('edit');

                                    if (div.style.display === 'none') {
                                        div.style.display = 'block'; // Hiện
                                        div2.style.display = 'none';
                                    } else {
                                        div.style.display = 'none'; // Ẩn
                                        div2.style.display = 'block';
                                    }
                                }
                            </script>
                        </div>
                        <div class="tab__content" id="change-password">
                            <h3 class="tab__header">Change Password</h3>
                            <div class="tab__body">
                                <form class="form grid" action="editAccount" method="POST">
                                    <input name="from" value="password" hidden="true"/>
                                    <!--<input hidden disabled value="${oldPassword}" id="oldPassword" />-->

                                    <input
                                        type="password"
                                        id="inputOldPassword"
                                        placeholder="Current Password"
                                        class="form__input"
                                        />
                                    <input hidden value="Mật khẩu cũ không đúng!" id="msgOldPass" 
                                           style="display: none; font-size: small; color: red"/>

                                    <input
                                        type="password"
                                        id="inputNewPassword"
                                        name="newPassword"
                                        placeholder="New Password"
                                        class="form__input"
                                        />
                                    <input
                                        type="password"
                                        id="reInputNewPassword"
                                        placeholder="Confirm Password"
                                        class="form__input"
                                        />
                                    <input hidden value="Nhắc lại mật khẩu mới không đúng!" id="msgMatch" 
                                           style="display: none; font-size: small; color: red"/>
                                    <div class="form__btn">
                                        <button class="btn btn--md" id="savePasswordButton">Save</button>
                                    </div>
                                </form>
                            </div>

                            <script>
                                // Mật khẩu cũ
                                const oldPassword = "${oldPassword}";
                                // Kiểm tra mật khẩu cũ
                                document.getElementById('inputOldPassword').addEventListener('blur', function () {
                                    var inputOldPassword = this.value;
                                    var msgOldPass = document.getElementById('msgOldPass');
                                    var saveButton = document.getElementById('savePasswordButton');

                                    if (inputOldPassword === oldPassword) {
                                        msgOldPass.style.display = 'none'; // Mật khẩu đúng, ẩn thông báo
                                        var newPassword = document.getElementById('inputNewPassword').value;
                                        if (newPassword.length > 0) {
                                            saveButton.disabled = false;
                                        }else{
                                            saveButton.disabled = true;
                                        }
                                    } else {
                                        msgOldPass.style.display = 'block'; // Mật khẩu sai, hiển thị thông báo
                                        saveButton.disabled = true;
                                    }
                                });

                                // Kiểm tra xác nhận mật khẩu mới
                                document.getElementById('reInputNewPassword').addEventListener('blur', function () {
                                    var newPassword = document.getElementById('inputNewPassword').value;
                                    var reInputNewPassword = this.value;
                                    var msgMatch = document.getElementById('msgMatch'); // Tạo thông báo nếu cần
                                    var saveButton = document.getElementById('savePasswordButton');

                                    if (newPassword === reInputNewPassword && newPassword.length > 0) {
                                        msgMatch.style.display = 'none'; // Hiển thị thông báo nếu không khớp
                                        saveButton.disabled = false;
                                    } else {
                                        msgMatch.style.display = 'block'; // Ẩn thông báo nếu khớp
                                        saveButton.disabled = true;
                                    }
                                });
                            </script>
                        </div>
                    </div>
                </div>
            </section>

            <!--=============== NEWSLETTER ===============-->
            <section class="newsletter section">
                <div class="newsletter__container container grid">
                    <h3 class="newsletter__title flex">
                        <img
                            src="./assets/img/icon-email.svg"
                            alt=""
                            class="newsletter__icon"
                            />
                        Sign in to Newsletter
                    </h3>
                    <p class="newsletter__description">
                        ...and receive $25 coupon for first shopping.
                    </p>
                    <form action="" class="newsletter__form">
                        <input
                            type="text"
                            placeholder="Enter Your Email"
                            class="newsletter__input"
                            />
                        <button type="submit" class="newsletter__btn">Subscribe</button>
                    </form>
                </div>
            </section>
        </main>

        <!--=============== FOOTER ===============-->
        <footer class="footer container">
            <div class="footer__container grid">
                <div class="footer__content">
                    <a href="index.html" class="footer__logo">
                        <img src="./assets/img/logo.svg" alt="" class="footer__logo-img" />
                    </a>
                    <h4 class="footer__subtitle">Contact</h4>
                    <p class="footer__description">
                        <span>Address:</span> 13 Tlemcen Road, Street 32, Beb-Wahren
                    </p>
                    <p class="footer__description">
                        <span>Phone:</span> +01 2222 365 /(+91) 01 2345 6789
                    </p>
                    <p class="footer__description">
                        <span>Hours:</span> 10:00 - 18:00, Mon - Sat
                    </p>
                    <div class="footer__social">
                        <h4 class="footer__subtitle">Follow Me</h4>
                        <div class="footer__links flex">
                            <a href="#">
                                <img
                                    src="./assets/img/icon-facebook.svg"
                                    alt=""
                                    class="footer__social-icon"
                                    />
                            </a>
                            <a href="#">
                                <img
                                    src="./assets/img/icon-twitter.svg"
                                    alt=""
                                    class="footer__social-icon"
                                    />
                            </a>
                            <a href="#">
                                <img
                                    src="./assets/img/icon-instagram.svg"
                                    alt=""
                                    class="footer__social-icon"
                                    />
                            </a>
                            <a href="#">
                                <img
                                    src="./assets/img/icon-pinterest.svg"
                                    alt=""
                                    class="footer__social-icon"
                                    />
                            </a>
                            <a href="#">
                                <img
                                    src="./assets/img/icon-youtube.svg"
                                    alt=""
                                    class="footer__social-icon"
                                    />
                            </a>
                        </div>
                    </div>
                </div>
                <div class="footer__content">
                    <h3 class="footer__title">Address</h3>
                    <ul class="footer__links">
                        <li><a href="#" class="footer__link">About Us</a></li>
                        <li><a href="#" class="footer__link">Delivery Information</a></li>
                        <li><a href="#" class="footer__link">Privacy Policy</a></li>
                        <li><a href="#" class="footer__link">Terms & Conditions</a></li>
                        <li><a href="#" class="footer__link">Contact Us</a></li>
                        <li><a href="#" class="footer__link">Support Center</a></li>
                    </ul>
                </div>
                <div class="footer__content">
                    <h3 class="footer__title">My Account</h3>
                    <ul class="footer__links">
                        <li><a href="#" class="footer__link">Sign In</a></li>
                        <li><a href="#" class="footer__link">View Cart</a></li>
                        <li><a href="#" class="footer__link">My Wishlist</a></li>
                        <li><a href="#" class="footer__link">Track My Order</a></li>
                        <li><a href="#" class="footer__link">Help</a></li>
                        <li><a href="#" class="footer__link">Order</a></li>
                    </ul>
                </div>
                <div class="footer__content">
                    <h3 class="footer__title">Secured Payed Gateways</h3>
                    <img
                        src="./assets/img/payment-method.png"
                        alt=""
                        class="payment__img"
                        />
                </div>
            </div>
            <div class="footer__bottom">
                <p class="copyright">&copy; 2024 Evara. All right reserved</p>
                <span class="designer">Designer by Crypticalcoder</span>
            </div>
        </footer>

        <!--=============== SWIPER JS ===============-->
        <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

        <!--=============== MAIN JS ===============-->
        <script src="assets/js/main.js"></script>
    </body>
</html>

