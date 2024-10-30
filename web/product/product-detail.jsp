<%-- 
    Document   : index.jsp
    Created on : Oct 9, 2024, 12:03:09 PM
    Author     : khuye
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

        <!--=============== CSS ===============-->
        <link rel="stylesheet" href="../assets/css/styles.css" />
        <!--<link rel="stylesheet" href="https://unpkg.com/tailwindcss@2.2.19/dist/tailwind.min.css"/>-->

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

                    <a href="/shop/logout" class="header__top-action">
                        Log In / Sign Up
                    </a>
                </div>
            </div>

            <nav class="nav container">

                <a href="/shop/home" class="nav__logo">
                    <img
                        class="nav__logo-img"
                        src="https://billalben.github.io/evara-ecommerce/assets/img/logo.svg"
                        alt="website logo"
                        />
                </a>
                <div class="nav__menu" id="nav-menu">
                    <div class="nav__menu-top">
                        <a href="/shop/home" class="nav__menu-logo">
                            <img src="./assets/img/logo.svg" alt="">
                        </a>
                        <div class="nav__close" id="nav-close">
                            <i class="fi fi-rs-cross-small"></i>
                        </div>
                    </div>
                    <ul class="nav__list">
                        <li class="nav__item">

                            <a href="/shop/home" class="nav__link active-link">Home</a>
                        </li>
                        <li class="nav__item">
                            <a href="/shop/products" class="nav__link">Shop</a>
                        </li>
                        <li class="nav__item">
                            <a href="#" class="nav__link">My Account</a>
                        </li>
                        <li class="nav__item">
                            <a href="#" class="nav__link">Compare</a>
                        </li>
                        <li class="nav__item">
                            <a href="/shop/logout" class="nav__link">Login</a>
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

                    <a href="/shop/cart" class="header__action-btn" title="Cart">
                        <img src="https://billalben.github.io/evara-ecommerce/assets/img/icon-cart.svg" alt="" />
                        <span class="count">3</span>
                    </a>
                    <div class="header__action-btn nav__toggle" id="nav-toggle">
                        <img src="https://billalben.github.io/evara-ecommerce/assets//img/menu-burger.svg" alt="">
                    </div>
                </div>
            </nav>
        </header>
        <!--=============== MAIN ===============-->
        <main class="main">
            <!--=============== BREADCRUMB ===============-->
            <section class="breadcrumb">
                <ul class="breadcrumb__list flex container">
                    <li><a href="/shop/home" class="breadcrumb__link">Home</a></li>
                    <li><span class="breadcrumb__link"></span>></li>
                    <li><span class="breadcrumb__link">Fashion</span></li>
                    <li><span class="breadcrumb__link"></span>></li>
                    <li><span class="breadcrumb__link">${product.proName}</span></li>
                </ul>
            </section>

            <!--=============== DETAILS ===============-->
            <section class="details section--lg">
                <div class="details__container container grid">
                    <div class="details__group">
                        <img
                            src="${product.image}"
                            alt=""
                            class="details__img"
                            />
                        <div class="details__small-images grid">
                            <img
                                src="${product.image}"
                                alt=""
                                class="details__small-img"
                                />
                            <img
                                src="${product.image}"

                                alt=""
                                class="details__small-img"
                                />
                            <img
                                src="${product.image}"

                                alt=""
                                class="details__small-img"
                                />
                        </div>
                    </div>
                    <form action="/shop/addToCarts" method="POST"> 
                        <input name="proID" value="${product.proID}" hidden="true" />
                        <input name="from" value="detail" hidden="true" />
                        <div class="details__group">
                            <h3 class="details__title">${product.proName}</h3>
                            <p class="details__brand">Brand: <span>adidas</span></p>
                            <div class="details__price flex">
                                <span class="new__price">${product.price}</span>
                                <span class="old__price">$200.00</span>
                                <span class="save__price">25% Off</span>
                            </div>
                            <p class="short__description">
                                ${product.description} 
                            </p>
                            <ul class="products__list">
                                <li class="list__item flex">
                                    <i class="fi-rs-crown"></i> 1 Year Al Jazeera Brand Warranty
                                </li>
                                <li class="list__item flex">
                                    <i class="fi-rs-refresh"></i> 30 Days Return Policy
                                </li>
                                <li class="list__item flex">
                                    <i class="fi-rs-credit-card"></i> Cash on Delivery available
                                </li>
                            </ul>
                            <div class="details__color flex">
                                <span class="details__color-title">Color</span>
                                <ul class="color__list">
                                    <li>
                                        <a
                                            href="#"
                                            class="color__link"
                                            style="background-color: hsl(37, 100%, 65%)"
                                            ></a>
                                    </li>
                                    <li>
                                        <a
                                            href="#"
                                            class="color__link"
                                            style="background-color: hsl(353, 100%, 65%)"
                                            ></a>
                                    </li>
                                    <li>
                                        <a
                                            href="#"
                                            class="color__link"
                                            style="background-color: hsl(49, 100%, 60%)"
                                            ></a>
                                    </li>
                                    <li>
                                        <a
                                            href="#"
                                            class="color__link"
                                            style="background-color: hsl(304, 100%, 78%)"
                                            ></a>
                                    </li>
                                    <li>
                                        <a
                                            href="#"
                                            class="color__link"
                                            style="background-color: hsl(126, 61%, 52%)"
                                            ></a>
                                    </li>
                                </ul>
                            </div>
                            <div class="details__size flex">
                                <span class="details__size-title">Size</span>
                                <select name="size" class="p-2">
                                    <c:forEach items="${sizes}" var="size">
                                        <option>
                                            <a href="#" class="size__link size-active">${size}</a>
                                        </option>
                                    </c:forEach>
                                </select>

                            </div>
                            <div class="details__action">
                                <input type="number" name="quantity" class="quantity" value="1" min="0"/>
                                <button class="btn btn--sm">Add To Card</button>
                                <a href="#" class="details__action-btn">
                                    <i class="fi fi-rs-heart"></i>
                                </a>
                            </div>
                            <ul class="details__meta">
                                <li class="meta__list flex"><span>SKU:</span>FWM15VKT</li>
                                <li class="meta__list flex">
                                    <span>Tags:</span>Clothes, Women, Dress
                                </li>
                                <li class="meta__list flex">
                                    <span>Availability:</span>8 Items in Stock
                                </li>
                            </ul>
                        </div>
                    </form>
                </div>
            </section>

            

            <!--=============== PRODUCTS ===============-->
            <section class="products container section--lg">
                <h3 class="section__title"><span>Related</span> Products</h3>
                <div class="products__container grid">
                    <c:forEach items="${relatedProducts}" var="product">
                        <div class="product__item">
                            <div class="product__banner">
                                <a href="details.html" class="product__images">
                                    <img
                                        src="${product.image}"
                                        alt=""
                                        class="product__img default"
                                        />
                                    <img
                                        src="${product.image}"
                                        alt=""
                                        class="product__img hover"
                                        />
                                </a>
                                <div class="product__actions">
                                    <a href="#" class="action__btn" aria-label="Quick View">
                                        <i class="fi fi-rs-eye"></i>
                                    </a>
                                    <a
                                        href="#"
                                        class="action__btn"
                                        aria-label="Add to Wishlist"
                                        >
                                        <i class="fi fi-rs-heart"></i>
                                    </a>
                                    <a href="#" class="action__btn" aria-label="Compare">
                                        <i class="fi fi-rs-shuffle"></i>
                                    </a>
                                </div>
                                <div class="product__badge light-pink">Hot</div>
                            </div>
                            <div class="product__content">
                                <span class="product__category">Clothing</span>
                                <a href="details.html">
                                    <h3 class="product__title">${product.proName}</h3>
                                </a>
                                <div class="product__rating">
                                    <i class="fi fi-rs-star"></i>
                                    <i class="fi fi-rs-star"></i>
                                    <i class="fi fi-rs-star"></i>
                                    <i class="fi fi-rs-star"></i>
                                    <i class="fi fi-rs-star"></i>
                                </div>
                                <div class="product__price flex">
                                    <span class="new__price">${product.price}</span>
                                    <span class="old__price">$245.8</span>
                                </div>
                                <a
                                    href="#"
                                    class="action__btn cart__btn"
                                    aria-label="Add To Cart"
                                    >
                                    <i class="fi fi-rs-shopping-bag-add"></i>
                                </a>
                            </div>
                        </div>
                    </c:forEach>

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
