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
        <link rel="stylesheet" href="./assets/css/styles.css" />
        <link rel="stylesheet" href="https://unpkg.com/tailwindcss@2.2.19/dist/tailwind.min.css"/>
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
                    <div class="nav__menu-top">
                        <a href="home" class="nav__menu-logo">
                            <img src="./assets/img/logo.svg" alt="">
                        </a>
                        <div class="nav__close" id="nav-close">
                            <i class="fi fi-rs-cross-small"></i>
                        </div>
                    </div>
                    <ul class="nav__list">
                        <li class="nav__item">

                            <a href="home" class="nav__link active-link">Home</a>
                        </li>
                        <li class="nav__item">
                            <a href="product" class="nav__link">Shop</a>
                        </li>
                        <li class="nav__item">
                            <a href="" class="nav__link">My Account</a>
                        </li>
                        <li class="nav__item">
                            <a href="" class="nav__link">Compare</a>
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
                    <div class="header__action-btn nav__toggle" id="nav-toggle">
                        <img src="https://billalben.github.io/evara-ecommerce/assets//img/menu-burger.svg" alt="">
                    </div>
                </div>
            </nav>
        </header>

        <!--=============== MAIN ===============-->
        <main class="main">
            <!--=============== HOME ===============-->
            <section class="home section--lg">
                <div class="home__container container grid">
                    <div class="home__content">
                        <span class="home__subtitle">Hot Promotions</span>
                        <h1 class="home__title">
                            Fashion Trending <span>Great Collection</span>
                        </h1>
                        <p class="home__description">
                            Save more with coupons & up tp 20% off
                        </p>

                        <a href="allProducts" class="btn">Shop Now</a>
                    </div>
                    <img src="https://billalben.github.io/evara-ecommerce/assets/img/home-img.png" class="home__img" alt="hats" />
                </div>
            </section>

            <!--=============== CATEGORIES ===============-->
            <section class="categories container section">
                <h3 class="section__title"><span>Popular</span> Categories</h3>
                <div class="categories__container swiper">
                    <div class="swiper-wrapper">

                        <c:forEach items="${listCate}" var="cate">
                            <a href="home" class="category__item swiper-slide">
                                <img
                                    src="${cate.image}"
                                    alt=""
                                    class="category__img"
                                    />

                                <h3 class="category__title">${cate.categoryName}</h3>
                            </a>
                        </c:forEach>
                    </div>

                    <div class="swiper-button-prev">
                        <i class="fi fi-rs-angle-left"></i>
                    </div>
                    <div class="swiper-button-next">
                        <i class="fi fi-rs-angle-right"></i>
                    </div>
                </div>
            </section>

            <!--=============== PRODUCTS ===============-->
            <section class="products container section">
                <div class="tab__btns">
                    <span class="tab__btn active-tab" data-target="#featured"
                          >Featured</span
                    >
                    <span class="tab__btn" data-target="#popular">Popular</span>
                    <span class="tab__btn" data-target="#new-added">New Added</span>
                </div>

                <div class="tab__items">
                    <div class="tab__item active-tab" content id="featured">
                        <div class="products__container grid">

                            <!--display product-->

                            <c:forEach items="${list}" var="product">
                                <div class="product__item">
                                    <div class="product__banner">
                                        <a href="products/${product.proID}" class="product__images">
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

                                    <form action="addToCarts" method="POST"> 
                                        <input name="proID" value="${product.proID}" hidden="true" />
                                        <input name="from" value="home" hidden="true" />
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

                                            <button 
                                                class="action__btn cart__btn"
                                                aria-label="Add To Cart"
                                                type="submit"
                                                >
                                                <i class="fi fi-rs-shopping-bag-add"></i>
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="tab__item" content id="popular">
                        <div class="products__container grid">
                            <c:forEach items="${list2}" var="product">
                                <div class="product__item">
                                    <div class="product__banner">
                                        <a href="products/${product.proID}" class="product__images">
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

                                    <form action="addToCarts" method="POST"> 
                                        <input name="proID" value="${product.proID}" hidden="true" />
                                        <input name="from" value="home" hidden="true" />
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
                                                <span class="new__price">$ ${product.price}</span>
                                                <span class="old__price">$245.8</span>
                                            </div>
                                            <button
                                                class="action__btn cart__btn"
                                                aria-label="Add To Cart"
                                                >
                                                <i class="fi fi-rs-shopping-bag-add"></i>
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="tab__item" content id="new-added">
                        <div class="products__container grid">
                            <c:forEach items="${list2}" var="product">
                                <div class="product__item">
                                    <div class="product__banner">
                                        <a href="products/${product.proID}" class="product__images">
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
                                    <form action="addToCarts" method="POST"> 
                                        <input name="proID" value="${product.proID}" hidden="true" />
                                        <input name="from" value="home" hidden="true" />
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
                                            <button
                                                class="action__btn cart__btn"
                                                aria-label="Add To Cart"
                                                >
                                                <i class="fi fi-rs-shopping-bag-add"></i>
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </section>

            <!--=============== DEALS ===============-->
            <section class="deals section">
                <div class="deals__container container grid">
                    <div class="deals__item">
                        <div class="deals__group">
                            <h3 class="deals__brand">Deals of the Day</h3>
                            <span class="deals__category">Limited quantities</span>
                        </div>
                        <h4 class="deals__title">Summer Collection New Modern Design</h4>
                        <div class="deals__price flex">
                            <span class="new__price">$139.00</span>
                            <span class="old__price">$160.99</span>
                        </div>
                        <div class="deals__group">
                            <p class="deals__countdown-text">Hurry Up! Offer Ends In:</p>
                            <div class="countdown">
                                <div class="countdown__amount">
                                    <p class="countdown__period">02</p>
                                    <span class="unit">Days</span>
                                </div>
                                <div class="countdown__amount">
                                    <p class="countdown__period">22</p>
                                    <span class="unit">Hours</span>
                                </div>
                                <div class="countdown__amount">
                                    <p class="countdown__period">57</p>
                                    <span class="unit">Mins</span>
                                </div>
                                <div class="countdown__amount">
                                    <p class="countdown__period">28</p>
                                    <span class="unit">Sec</span>
                                </div>
                            </div>
                        </div>
                        <div class="deals__btn">
                            <a href="details.html" class="btn btn--md">Shop Now</a>
                        </div>
                    </div>
                    <div class="deals__item">
                        <div class="deals__group">
                            <h3 class="deals__brand">Women Clothing</h3>
                            <span class="deals__category">Shirts & Bag</span>
                        </div>
                        <h4 class="deals__title">Try Something new on vacation</h4>
                        <div class="deals__price flex">
                            <span class="new__price">$178.00</span>
                            <span class="old__price">$256.99</span>
                        </div>
                        <div class="deals__group">
                            <p class="deals__countdown-text">Hurry Up! Offer Ends In:</p>
                            <div class="countdown">
                                <div class="countdown__amount">
                                    <p class="countdown__period">02</p>
                                    <span class="unit">Days</span>
                                </div>
                                <div class="countdown__amount">
                                    <p class="countdown__period">22</p>
                                    <span class="unit">Hours</span>
                                </div>
                                <div class="countdown__amount">
                                    <p class="countdown__period">57</p>
                                    <span class="unit">Mins</span>
                                </div>
                                <div class="countdown__amount">
                                    <p class="countdown__period">28</p>
                                    <span class="unit">Sec</span>
                                </div>
                            </div>
                        </div>
                        <div class="deals__btn">
                            <a href="details.html" class="btn btn--md">Shop Now</a>
                        </div>
                    </div>
                </div>
            </section>

            <!--=============== NEW ARRIVALS ===============-->
            <section class="new__arrivals container section">
                <h3 class="section__title"><span>New</span> Arrivals</h3>
                <div class="new__container swiper">
                    <div class="swiper-wrapper">

                        <c:forEach items="${list2}" var="product">
                            <div class="product__item swiper-slide">
                                <div class="product__banner">
                                    <a href="products/${product.proID}" class="product__images">
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
                                        <a href="#" class="action__btn" aria-label="Add to Wishlist">
                                            <i class="fi fi-rs-heart"></i>
                                        </a>
                                        <a href="#" class="action__btn" aria-label="Compare">
                                            <i class="fi fi-rs-shuffle"></i>
                                        </a>
                                    </div>
                                    <div class="product__badge light-pink">Hot</div>
                                </div>
                                <form action="addToCarts" method="POST"> 
                                    <input name="proID" value="${product.proID}" hidden="true" />
                                    <input name="from" value="home" hidden="true" />
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
                                        <button
                                            class="action__btn cart__btn"
                                            aria-label="Add To Cart"
                                            >
                                            <i class="fi fi-rs-shopping-bag-add"></i>
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </c:forEach>
                    </div>

                    <div class="swiper-button-prev">
                        <i class="fi fi-rs-angle-left"></i>
                    </div>
                    <div class="swiper-button-next">
                        <i class="fi fi-rs-angle-right"></i>
                    </div>
                </div>
            </section>

            <!--=============== SHOWCASE ===============-->
           

            <!--=============== NEWSLETTER ===============-->
            <section class="newsletter section home__newsletter">
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