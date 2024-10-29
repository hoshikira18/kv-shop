<%-- 
    Document   : cart
    Created on : Oct 22, 2024, 2:49:14 AM
    Author     : VIET
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import = "models.*" %>
<%@page import = "java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
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

        <!--=============== CSS ===============-->
        <link rel="stylesheet" href="./assets/css/styles.css" />
        <link rel="stylesheet" href="https://unpkg.com/tailwindcss@2.2.19/dist/tailwind.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
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
                            <a href="editAccount" class="nav__link">My Account</a>
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
                    <li><span class="breadcrumb__link"></span>></li>
                    <li><a href="products" class="breadcrumb__link">Shop</a></li>
                    <li><span class="breadcrumb__link"></span>></li>
                    <li><span class="breadcrumb__link">Cart</span></li>
                </ul>
            </section>

            <!--=============== CART ===============-->
            <section class="cart section--lg container">
                <form action="updateCarts" method="POST" id="cartItems">
                    <input type="text" name="userID" value="${userID}" hidden="true" />
                    <input type="text" name="cartID" value="${cartID}" hidden="true" />
                    <div class="table__container">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Image</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Subtotal</th>
                                    <th>Rename</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%int count = 0;%>
                            <input type="text" id="length" value="${length}" hidden="true"/>
                            <c:forEach items="${listItem}" var="item" >
                                <tr>
                                    <td>
                                        <a href="products/${item[1]}">
                                            <!--class cu cua image la table__img-->
                                            <img
                                                src="${item[3]}"
                                                alt=""
                                                class="product__img w-150px"
                                                />
                                        </a>
                                    </td>
                                    <td>
                                        <h3 class="table__title max-w-250px">
                                            ${item[2]}
                                        </h3>
                                        <p class="table__description max-w-250px">
                                            Lorem ipsum dolor sit amet consectetur.
                                        </p>
                                    </td>
                                    <td>
                                        <span class="table__price font-bold">${item[5]} (VNĐ)</span>
                                    </td>
                                    <td>
                                        <!--<input type="number" value="${item[4]}" class="quantity" />-->
                                        <div style="color: black; font-weight: 100;" class="my-1">
                                            <button class="border-solid px-2 rounded" 
                                                    type="button" id="button-minus<%=++count%>"
                                                    onclick="minus(<%=count%>, ${Integer.parseInt(item[5])})">
                                                <i class="fas fa-minus text-sm"></i>
                                            </button>
                                            <input name="proID" value="${item[1]}" hidden="true" />
                                            <input type="text" name="quantity-input" id="quantity-input<%=count%>" style="width: 40px" 
                                                   oninput="input(<%=count%>, ${Integer.parseInt(item[5])})"
                                                   class="text-center font-medium"" value="${item[4]}"/>
                                            <button class="border-solid px-2 my-1 rounded" 
                                                    type="button" id="button-plus<%=count%>" 
                                                    onclick="plus(<%=count%>, ${Integer.parseInt(item[5])})">
                                                <i class="fas fa-plus text-sm"></i>
                                            </button>
                                        </div>
                                    </td>
                                    <td>
                                        <span class="subtotal table__price">
                                            <input type="text" id="subtotal<%=count%>" disabled
                                                   class="text-center font-bold" 
                                                   value="${Integer.parseInt(item[5])*Integer.parseInt(item[4])} (VNĐ)" />
                                        </span>
                                    </td>
                                    <td>
                                        <a href="deleteItem?cartID=${cartID}&id=${item[1]}">
                                            <i class="fi fi-rs-trash table__trash" onclick="" ></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            <!--up-->
                            <script>
                                function plus(count, price) {
                                    var quantityInput = document.getElementById('quantity-input' + count);
                                    var subtotal = document.getElementById('subtotal' + count);
                                    var currentValue = parseInt(quantityInput.value) || 0;
                                    var subtotalValue = parseFloat(subtotal.value);
                                    var sum = document.getElementById("sum");
                                    var sum2 = document.getElementById("sum2");
                                    var sumValue = parseInt(sum.value);
                                    subtotal.value = price * (currentValue + 1) + " (VNĐ)";
                                    quantityInput.value = currentValue + 1;
                                    sum.value = sumValue + price + " (VNĐ)";
                                    sum2.value = sumValue + price + 10000 + " (VNĐ)";
                                }
                                ;
                                function minus(count, price) {
                                    var quantityInput = document.getElementById('quantity-input' + count);
                                    var subtotal = document.getElementById('subtotal' + count);
                                    var currentValue = parseInt(quantityInput.value) || 0;
                                    var subtotalValue = parseFloat(subtotal.value);
                                    var sum = document.getElementById("sum");
                                    var sum2 = document.getElementById("sum2");
                                    var sumValue = parseInt(sum.value);
                                    if (currentValue > 1) {
                                        subtotal.value = price * (currentValue - 1) + " (VNĐ)";
                                        quantityInput.value = currentValue - 1;
                                        sum.value = sumValue - price + " (VNĐ)";
                                        sum2.value = sumValue - price + 10000 + " (VNĐ)";
                                    }
                                }
                                ;
                                function input(count, price) {
                                    var length = document.getElementById('length').value;
                                    var quantityInput = document.getElementById('quantity-input' + count);
                                    var subtotal = document.getElementById('subtotal' + count);
                                    var currentValue = parseInt(quantityInput.value) || 0;
                                    var subtotalValue = parseFloat(subtotal.value);
                                    var sum = document.getElementById("sum");
                                    var sum2 = document.getElementById("sum2");
                                    if (currentValue > 0) {
                                        subtotal.value = price * (currentValue) + " (VNĐ)";
                                        quantityInput.value = currentValue;
                                    } else {
                                        currentValue = 1;
                                        subtotal.value = price * (currentValue) + " (VNĐ)";
                                        quantityInput.value = currentValue;
                                    }
                                    var total = 0;
                                    for (var i = 1, max = length; i <= max; i++) {
                                        let item = document.getElementById('subtotal' + i).value;
                                        let values = item.split(" ")[0];
                                        total += parseInt(values);
                                    }
                                    sum.value = total + " (VNĐ)";
                                    sum2.value = (total + 10000) + " (VNĐ)";

                                }
                                ;
                            </script>
                            <!--down-->
                            </tbody>
                        </table>
                    </div>

                    <div class="cart__actions">
                        <button href="updateCarts" id="updateCartButton" onclick="updateButton()" class="btn flex btn__md">
                            <i class="fi-rs-shuffle"></i> Update Cart 
                        </button>
                        <script>
                            function updateButton() {
                                var button = document.getElementById('updateCartButton');
                                var length = ${length};
                                if (length === 0) {
                                    button.disabled = true;
                                }else{
                                    var form = document.getElementById("cartItems");
                                    form.submit(); // Submit form
                                }
                            }
                        </script>
                        <a href="products" class="btn flex btn__md">
                            <i class="fi-rs-shopping-bag"></i> Continue Shopping
                        </a>
                    </div>
                </form>

                <div class="divider">
                    <i class="fi fi-rs-fingerprint"></i>
                </div>

                <div class="cart__group grid">
                    <div>
                        <div class="cart__shippinp">
                            <h3 class="section__title">Calculate Shipping</h3>
                            <form action="" class="form grid">
                                <input
                                    type="text"
                                    class="form__input"
                                    placeholder="State / Country"
                                    />
                                <div class="form__group grid">
                                    <input type="text" class="form__input" placeholder="City" />
                                    <input
                                        type="text"
                                        class="form__input"
                                        placeholder="PostCode"
                                        />
                                </div>
                                <div class="form__btn">
                                    <button class="btn flex btn--sm">
                                        <i class="fi-rs-shuffle"></i> Update
                                    </button>
                                </div>
                            </form>
                        </div>
                        <div class="cart__coupon">
                            <h3 class="section__title">Apply Coupon</h3>
                            <form action="" class="coupon__form form grid">
                                <div class="form__group grid">
                                    <input
                                        type="text"
                                        class="form__input"
                                        placeholder="Enter Your Coupon"
                                        />
                                    <div class="form__btn">
                                        <button class="btn flex btn--sm">
                                            <i class="fi-rs-label"></i> Aplly
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="cart__total">
                        <h3 class="section__title">Cart Totals</h3>
                        <table class="cart__total-table">
                            <tr>
                                <td><span class="cart__total-title">Cart Subtotal</span></td>
                                <td><span class="cart__total-price">
                                        <input type="text" id="sum" disabled="true"
                                               class="cart__total-price" value="${sum} (VNĐ)" />
                                    </span></td>
                            </tr>
                            <tr>
                                <td><span class="cart__total-title">Shipping</span></td>
                                <td><span class="cart__total-price">10000 (VNĐ)</span></td>
                            </tr>
                            <tr>
                                <td><span class="cart__total-title">Total</span></td>
                                <td><span class="cart__total-price">
                                        <input type="text" id="sum2" disabled="true"
                                               class="cart__total-price" value="${sum + 10000} (VNĐ)" />
                                    </span></td>
                            </tr>
                        </table>
                        <button id="checkOutButton" onclick="changeActionAndSubmit()" class="btn flex btn--md">
                            <i class="fi fi-rs-box-alt"></i> Proceed To Checkout
                        </button>
                        <script>
                            function changeActionAndSubmit() {
                                var button = document.getElementById('checkOutButton');
                                var length = ${length};
                                if (length === 0) {
                                    button.disabled = true;
                                } else {
                                    var form = document.getElementById("cartItems");
                                    form.action = 'checkOut'; // Thay đổi action của form
                                    form.submit(); // Submit form
                                }
                            }
                        </script>
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
