<%-- 
    Document   : checkOut
    Created on : Oct 29, 2024, 4:01:44 PM
    Author     : VIET
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <a href="logout" class="nav__link active-link"
                               >Login</a
                            >
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
                    <a href="wishlist.html" class="header__action-btn" title="Wishlist">
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
                    <li><span class="breadcrumb__link">Shop</span></li>
                    <li><span class="breadcrumb__link">></span></li>
                    <li><span class="breadcrumb__link">Checkout</span></li>
                </ul>
            </section>

            <!--=============== CHECKOUT ===============-->
            <section class="checkout section--lg">
                <div class="checkout__container container grid">
                    <div class="checkout__group">
                        <h3 class="section__title">Billing Details</h3>
                        <form class="form grid">
                            <input type="text" placeholder="Name" class="form__input" />
                            <input type="text" placeholder="Address" class="form__input" />
                            <input type="text" placeholder="City" class="form__input" />
                            <input type="text" placeholder="Country" class="form__input" />
                            <input type="text" placeholder="Postcode" class="form__input" />
                            <input type="text" placeholder="Phone" class="form__input" />
                            <input type="email" placeholder="Email" class="form__input" />
                            <h3 class="checkout__title">Additional Information</h3>
                            <textarea
                                name=""
                                placeholder="order note"
                                class="form__input textarea"
                                ></textarea>
                        </form>
                    </div>
                    <div class="checkout__group">
                        <h3 class="section__title">Cart Totals</h3>
                        <form action="createOrder" method="POST">
                            <input type="text" name="userID" value="${userID}" hidden="true" />
                            <input type="text" name="cartID" value="${cartID}" hidden="true" />
                            <input type="text" name="sum" value="${sum}" hidden="true" />
                            <table class="order__table">
                                <thead>
                                    <tr>
                                        <th colspan="2">Products</th>
                                        <th>Total</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach items="${listItem}" var="item">
                                        <tr>
                                            <td>
                                                <img
                                                    src="${item[3]}"
                                                    alt=""
                                                    class="order__img"
                                                    />
                                            </td>
                                            <td>
                                                <h3 class="table__title">${item[2]}</h3>
                                                <p class="table__quantity">x ${item[4]}</p>
                                            </td>
                                            <td><span class="table__price">
                                                    ${Integer.parseInt(item[4])*Integer.parseInt(item[5])} VNĐ
                                                </span></td>
                                        </tr>
                                    </c:forEach>
                                    <tr>
                                        <td><span class="order__subtitle">Subtotal</span></td>
                                        <td colspan="2"><span class="table__price">${sum} VNĐ</span></td>
                                    </tr>
                                    <tr>
                                        <td><span class="order__subtitle">Shipping</span></td>
                                        <td colspan="2">
                                            <span class="table__price">10000 VNĐ</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><span class="order__subtitle">Total</span></td>
                                        <td colspan="2">
                                            <span class="order__grand-total">${sum+10000} VNĐ</span>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="payment__methods">
                                <h3 class="checkout__title payment__title">Payment</h3>
                                <div class="payment__option flex">
                                    <label for="l1" class="payment__label">
                                        <select name="payOption" required class="payment__input"
                                                style="width: 120%; height: 150%">
                                            <option>Direct Bank Transfer</option>
                                            <option>Check Payment</option>
                                            <option>Paypal</option>
                                        </select>    
                                    </label>
                                </div>
                                <!--                                <div class="payment__option flex">
                                                                    <input
                                                                        type="radio"
                                                                        name="radio"
                                                                        id="l3"
                                                                        class="payment__input"
                                                                        />
                                                                    <label for="l3" class="payment__label">Paypal</label>
                                                                </div>-->
                            </div>
                            <button type="submit" class="btn btn--md">
                                Place Order
                            </button>
                        </form>
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

