<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${cookie['language'].value}"/>
<fmt:setBundle basename="language"/>
<html>
<head>
    <title><fmt:message key="label.financialAssistant"/></title>
    <meta charset="utf-8"/>

    <!--

    Tooplate 2083 Steak House

    https://www.tooplate.com/view/2083-steak-house

    -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">

    <!-- stylesheets css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/bootstrap.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/magnific-popup.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/animate.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/font-awesome.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/nivo-lightbox.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/nivo_themes/default/default.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/hover-min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/flexslider.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/style.css">

    <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300,600' rel='stylesheet' type='text/css'>

</head>
<body id="top" data-spy="scroll" data-target=".navbar-collapse" data-offset="50">

<!-- Navigation section -->
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">

        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon icon-bar"></span>
                <span class="icon icon-bar"></span>
                <span class="icon icon-bar"></span>
            </button>
            <a href="${pageContext.request.contextPath}/languageButton?language=ru" class="navbar-brand">ru</a>
            <a class="navbar-brand">|</a>
            <a href="${pageContext.request.contextPath}/languageButton?language=en" class="navbar-brand">en</a>
            <a class="navbar-brand">|</a>
            <a href="${pageContext.request.contextPath}/languageButton?language=by" class="navbar-brand">by</a>
            <p></p>
            <a href="${pageContext.request.contextPath}/" class="navbar-brand">Financial assistant</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/"><fmt:message key="label.home"/> </a> </li>
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <li><a href="${pageContext.request.contextPath}/profile">${sessionScope.user.name}</a></li>
                        <li><a href="${pageContext.request.contextPath}/signOutButton"><fmt:message
                                key="label.signOut"/></a></li>
                    </c:when>
                    <c:when test="${not empty sessionScope.admin}">
                        <li><a href="${pageContext.request.contextPath}/adminProfile">${sessionScope.admin.email}</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/signOutButton"><fmt:message
                                key="label.signOut"/></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/signIn"><fmt:message key="label.signIn"/></a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/signUp"><fmt:message key="label.signUp"/></a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>

    </div>
</div>


<!-- Feature section -->
<section id="feature" class="parallax-section">
    <div class="container">
        <div class="row">

            <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
                <div class="wow fadeInUp section-title" data-wow-delay="0.6s">
                    <h2>Жизнь — игра, а деньги — способ вести счет.</h2>
                    <h4>Тед Тёрнер</h4>
                </div>
            </div>

            <div class="clearfix"></div>

            <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.3s">
                <div class="feature-thumb">
                    <div class="feature-icon">
                        <span><i class="fa fa-cutlery"></i></span>
                    </div>
                    <h3>SPECIAL DISH</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitquisque tempus ac eget diam et laoreet
                        phasellus.</p>
                </div>
            </div>

            <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.6s">
                <div class="feature-thumb">
                    <div class="feature-icon">
                        <span><i class="fa fa-coffee"></i></span>
                    </div>
                    <h3>BLACK COFFEE</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitquisque tempus ac eget diam et laoreet
                        phasellus.</p>
                </div>
            </div>

            <div class="col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                <div class="feature-thumb">
                    <div class="feature-icon">
                        <span><i class="fa fa-bell-o"></i></span>
                    </div>
                    <h3>DINNER</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitquisque tempus ac eget diam et laoreet
                        phasellus.</p>
                </div>
            </div>

        </div>
    </div>
</section>


<!-- About section -->
<section id="about" class="parallax-section">
    <div class="container">
        <div class="row">

            <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
                <div class="wow fadeInUp section-title" data-wow-delay="0.3s">
                    <h2>Our Story</h2>
                    <h4>Your Dining Restaurant since 1989</h4>
                </div>
            </div>

            <div class="clearfix"></div>

            <div class="wow fadeInUp col-md-3 col-sm-5" data-wow-delay="0.3s">
                <img src="images/about-img.jpg" class="img-responsive" alt="About">
                <h3>Nunc ullamcorper suscipit neque, ac malesuada purus molestie non.</h3>
            </div>

            <div class="wow fadeInUp col-md-5 col-sm-7" data-wow-delay="0.5s">

                <!-- flexslider -->
                <div class="flexslider">
                    <ul class="slides">

                        <li>
                            <img src="images/slide-img1.jpg" alt="Flexslider">
                        </li>
                        <li>
                            <img src="images/slide-img2.jpg" alt="Flexslider">
                        </li>
                        <li>
                            <img src="images/slide-img3.jpg" alt="Flexslider">
                        </li>

                    </ul>
                </div>

                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt.
                    Lorem ipsum dolor sit amet.</p>
            </div>

            <div class="wow fadeInUp col-md-4 col-sm-12" data-wow-delay="0.9s">
                <h2>Fine Dining</h2>
                <p>Steak House is free website template in HTML CSS for everyone. Please tell your friends about <a
                        rel="nofollow" href="https://www.tooplate.com/free-templates"
                        title="free templates">Tooplate</a> site.</p>
                <p>Vestibulum id iaculis nisl. Pellentesque nec tortor sagittis, scelerisque ante at, sollicitudin leo.
                    Vivamus pulvinar a justo vel lobortis.</p>

                <ul>
                    <li>Donec fringilla ipsum</li>
                    <li>Integer nec urna</li>
                    <li>Curabitur porta</li>
                </ul>
            </div>

        </div>
    </div>
</section>


<!-- Video section -->
<section id="video" class="parallax-section">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">

            <div class="col-md-offset-2 col-md-8 col-sm-12">
                <a class="popup-youtube" href="https://www.youtube.com/watch?v=j-_7Ub-Zkow"><i
                        class="fa fa-play"></i></a>
                <h2 class="wow fadeInUp" data-wow-delay="0.5s">Watch the video</h2>
                <p class="wow fadeInUp" data-wow-delay="0.8s">Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                    sed diam nonummy nibh euismod tincidunt ut laoreet. Dolore magna aliquam erat volutpat.</p>
            </div>

        </div>
    </div>
</section>

<!-- Menu section -->
<section id="menu" class="parallax-section">
    <div class="container">
        <div class="row">

            <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
                <div class="wow fadeInUp section-title" data-wow-delay="0.3s">
                    <h2>Food Menu</h2>
                    <h4>we have special menus</h4>
                </div>
            </div>

            <div class="col-md-6 col-sm-12">
                <div class="media wow fadeInUp" data-wow-delay="0.6s">
                    <div class="media-object pull-left">
                        <img src="images/gallery-img1.jpg" class="img-responsive" alt="Food Menu">
                        <span class="menu-price">$24</span>
                    </div>
                    <div class="media-body">
                        <h3 class="media-heading">Breakfast</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitquisque tempus ac eget diam et.</p>
                    </div>
                </div>

                <div class="media wow fadeInUp" data-wow-delay="0.9s">
                    <div class="media-object pull-left">
                        <img src="images/gallery-img2.jpg" class="img-responsive" alt="Food Menu">
                        <span class="menu-price">$36</span>
                    </div>
                    <div class="media-body">
                        <h3 class="media-heading">New Pizza</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitquisque tempus ac eget diam et.</p>
                    </div>
                </div>

                <div class="media wow fadeInUp" data-wow-delay="1.2s">
                    <div class="media-object pull-left">
                        <img src="images/gallery-img3.jpg" class="img-responsive" alt="Food Menu">
                        <span class="menu-price">$24</span>
                    </div>
                    <div class="media-body">
                        <h3 class="media-heading">Mushroom</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitquisque tempus ac eget diam et.</p>
                    </div>
                </div>
            </div>

            <div class="col-md-6 col-sm-12">
                <div class="media wow fadeInUp" data-wow-delay="1s">
                    <div class="media-object pull-left">
                        <img src="images/gallery-img4.jpg" class="img-responsive" alt="Food Menu">
                        <span class="menu-price">$32</span>
                    </div>
                    <div class="media-body">
                        <h3 class="media-heading">Seafood</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitquisque tempus ac eget diam et.</p>
                    </div>
                </div>

                <div class="media wow fadeInUp" data-wow-delay="1.3s">
                    <div class="media-object pull-left">
                        <img src="images/gallery-img5.jpg" class="img-responsive" alt="Food Menu">
                        <span class="menu-price">$64</span>
                    </div>
                    <div class="media-body">
                        <h3 class="media-heading">Spicy Beef</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitquisque tempus ac eget diam et.</p>
                    </div>
                </div>

                <div class="media wow fadeInUp" data-wow-delay="1.6s">
                    <div class="media-object pull-left">
                        <img src="images/gallery-img6.jpg" class="img-responsive" alt="Food Menu">
                        <span class="menu-price">$45</span>
                    </div>
                    <div class="media-body">
                        <h3 class="media-heading">Dinner</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elitquisque tempus ac eget diam et.</p>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>

<!-- Team section -->
<section id="team" class="parallax-section">
    <div class="container">
        <div class="row">

            <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
                <div class="wow fadeInUp section-title" data-wow-delay="0.3s">
                    <h2>Meet Our Chefs</h2>
                    <h4>we are food specialists</h4>
                </div>
            </div>

            <div class="clearfix"></div>

            <div class="col-md-3 col-sm-6 wow fadeInUp" data-wow-delay="0.4s">
                <div class="team-thumb">
                    <img src="images/chef1.jpg" class="img-responsive" alt="Team">
                    <div class="team-des">
                        <h3>Sandar</h3>
                        <h4>Kitchen Manager</h4>
                        <ul class="social-icon">
                            <li><a href="#" class="fa fa-facebook"></a></li>
                            <li><a href="#" class="fa fa-twitter"></a></li>
                            <li><a href="#" class="fa fa-dribbble"></a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 wow fadeInUp" data-wow-delay="0.6s">
                <div class="team-thumb">
                    <img src="images/chef2.jpg" class="img-responsive" alt="Team">
                    <div class="team-des">
                        <h3>Candy</h3>
                        <h4>Co-Founder</h4>
                        <ul class="social-icon">
                            <li><a href="#" class="fa fa-twitter"></a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 wow fadeInUp" data-wow-delay="0.9s">
                <div class="team-thumb">
                    <img src="images/chef3.jpg" class="img-responsive" alt="Team">
                    <div class="team-des">
                        <h3>Mama</h3>
                        <h4>Senior Chef</h4>
                        <ul class="social-icon">
                            <li><a href="#" class="fa fa-facebook"></a></li>
                            <li><a href="#" class="fa fa-twitter"></a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 wow fadeInUp" data-wow-delay="1.1s">
                <div class="join-team">
                    <i class="fa fa-plus"></i>
                    <p>Fusce interdum libero id libero volutpat varius convallis at sem.</p>
                    <a href="#" class="btn btn-default hvr-bounce-to-bottom">JOIN US</a>
                </div>
            </div>

            <div class="clearfix"></div>

            <div class="wow fadeInUp col-md-6 col-sm-6" data-wow-delay="0.3s">
                <h2>Our Taste</h2>
                <p>Fusce lobortis quis nisl nec facilisis. Donec fringilla ipsum arcu, quis maximus est molestie eget.
                    Nunc ullamcorper suscipit neque, ac malesuada purus molestie non. Phasellus sollicitudin urna sed
                    ultrices dictum.</p>
            </div>

            <div class="wow fadeInUp col-md-6 col-sm-6" data-wow-delay="0.6s">
                <h2>Our Service</h2>
                <p>Maecenas dictum cursus dui, quis mattis eros ultricies sed. Maecenas ligula nulla, dictum eu cursus
                    id, semper in orci. Fusce vel nisi hendrerit justo viverra vehicula in nec nunc. Curabitur blandit
                    fringilla quam.</p>
            </div>

        </div>
    </div>
</section>

<!-- Gallery section -->
<section id="gallery" class="parallax-section">
    <div class="container">
        <div class="row">

            <div class="col-md-12">

                <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
                    <div class="wow fadeInUp section-title" data-wow-delay="0.3s">
                        <h2>Food Gallery</h2>
                        <h4>we have special foods</h4>
                    </div>
                </div>

                <!-- iso section -->
                <div class="iso-section wow fadeInUp" data-wow-delay="0.6s">

                    <ul class="filter-wrapper clearfix">
                        <li><a href="#" data-filter="*" class="selected opc-main-bg">All</a></li>
                        <li><a href="#" class="opc-main-bg" data-filter=".breakfast">Breakfast</a></li>
                        <li><a href="#" class="opc-main-bg" data-filter=".pizza">Pizza</a></li>
                        <li><a href="#" class="opc-main-bg" data-filter=".lunch">Lunch</a></li>
                        <li><a href="#" class="opc-main-bg" data-filter=".dinner">Dinner</a></li>
                    </ul>

                    <!-- iso box section -->
                    <div class="iso-box-section wow fadeInUp" data-wow-delay="0.9s">
                        <div class="iso-box-wrapper col4-iso-box">

                            <div class="iso-box breakfast pizza lunch col-md-4 col-sm-6">
                                <div class="gallery-thumb">
                                    <a href="images/gallery-img1.jpg" data-lightbox-gallery="food-gallery">
                                        <img src="images/gallery-img1.jpg" class="fluid-img" alt="Gallery">
                                        <div class="gallery-overlay">
                                            <div class="gallery-item">
                                                <i class="fa fa-search"></i>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <h3>Lorem One</h3>
                            </div>

                            <div class="iso-box breakfast lunch dinner col-md-4 col-sm-6">
                                <div class="gallery-thumb">
                                    <a href="images/gallery-img2.jpg" data-lightbox-gallery="food-gallery">
                                        <img src="images/gallery-img2.jpg" class="fluid-img" alt="Gallery">
                                        <div class="gallery-overlay">
                                            <div class="gallery-item">
                                                <i class="fa fa-search"></i>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <h3>Lorem ipsum two</h3>
                            </div>

                            <div class="iso-box dinner col-md-4 col-sm-6">
                                <div class="gallery-thumb">
                                    <a href="images/gallery-img3.jpg" data-lightbox-gallery="food-gallery">
                                        <img src="images/gallery-img3.jpg" class="fluid-img" alt="Gallery">
                                        <div class="gallery-overlay">
                                            <div class="gallery-item">
                                                <i class="fa fa-search"></i>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <h3>Third Lorem ipsum</h3>
                            </div>

                            <div class="iso-box breakfast col-md-4 col-sm-6">
                                <div class="gallery-thumb">
                                    <a href="images/gallery-img4.jpg" data-lightbox-gallery="food-gallery">
                                        <img src="images/gallery-img4.jpg" class="fluid-img" alt="Gallery">
                                        <div class="gallery-overlay">
                                            <div class="gallery-item">
                                                <i class="fa fa-search"></i>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <h3>Lorem ipsum fourth</h3>
                            </div>

                            <div class="iso-box lunch col-md-4 col-sm-6">
                                <div class="gallery-thumb">
                                    <a href="images/gallery-img5.jpg" data-lightbox-gallery="food-gallery">
                                        <img src="images/gallery-img5.jpg" class="fluid-img" alt="Gallery">
                                        <div class="gallery-overlay">
                                            <div class="gallery-item">
                                                <i class="fa fa-search"></i>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <h3>Fifth Lorem ipsum</h3>
                            </div>

                            <div class="iso-box pizza lunch col-md-4 col-sm-6">
                                <div class="gallery-thumb">
                                    <a href="images/gallery-img6.jpg" data-lightbox-gallery="food-gallery">
                                        <img src="images/gallery-img6.jpg" class="fluid-img" alt="Gallery">
                                        <div class="gallery-overlay">
                                            <div class="gallery-item">
                                                <i class="fa fa-search"></i>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <h3>Sixth Lorem ipsum</h3>
                            </div>

                        </div>
                    </div>

                </div>

            </div>

        </div>
    </div>
</section>

<!-- Contact section -->
<section id="contact" class="parallax-section">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">

            <div class="col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10">
                <div class="wow fadeInUp section-title" data-wow-delay="0.3s">
                    <h2>Say hello</h2>
                    <h4>we are always ready to serve you!</h4>
                </div>
                <div class="contact-form wow fadeInUp" data-wow-delay="0.7s">
                    <form id="contact-form" method="post" action="#">
                        <input name="name" type="text" class="form-control" placeholder="Your Name" required>
                        <input name="email" type="email" class="form-control" placeholder="Your Email" required>
                        <textarea name="message" class="form-control" placeholder="Message" rows="5"
                                  required></textarea>
                        <input type="submit" class="form-control submit" value="SEND MESSAGE">
                    </form>
                </div>
            </div>

        </div>
    </div>
</section>

<!-- Footer section -->
<footer>
    <div class="container">
        <div class="row">

            <div class="wow fadeInUp col-md-4 col-sm-4" data-wow-delay="1.3s">
                <h3>About the house</h3>
                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod
                    tincidunt ut laoreet. Dolore magna aliquam erat volutpat ipsum.</p>
            </div>

            <div class="wow fadeInUp col-md-4 col-sm-4" data-wow-delay="1.6s">
                <h3>Contact Detail</h3>
                <p>123 Delicious Street, San Francisco, CA 10110</p>
                <p>010-020-0780</p>
                <p>hello@company.com</p>
            </div>

            <div class="wow fadeInUp col-md-4 col-sm-4" data-wow-delay="1.9s">
                <h3>Opening Hours</h3>
                <strong>Monday - Firday</strong>
                <p>11:00 AM - 10:00 PM</p>
                <strong>Saturday - Sunday</strong>
                <p>10:00 AM - 09:00 PM</p>
            </div>

        </div>
    </div>
</footer>

<!-- Copyright section -->
<section id="copyright">
    <div class="container">
        <div class="row">

            <div class="col-md-8 col-sm-8 col-xs-8">
                <p>Copyright © 2019 Steak House Company

                    - Design: <a rel="nofollow" class="designed-by" href="https://www.tooplate.com">Tooplate</a></p>
            </div>

            <div class="col-md-4 col-sm-4 text-right">
                <a href="#top" class="fa fa-angle-up smoothScroll gototop"></a>
            </div>

        </div>
    </div>
</section>

<!-- javscript js -->
<script src="${pageContext.request.contextPath}/view/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/view/js/bootstrap.min.js"></script>

<script src="${pageContext.request.contextPath}/view/js/jquery.magnific-popup.min.js"></script>

<script src="${pageContext.request.contextPath}/view/js/jquery.sticky.js"></script>
<script src="${pageContext.request.contextPath}/view/js/jquery.backstretch.min.js"></script>

<script src="${pageContext.request.contextPath}/view/js/isotope.js"></script>
<script src="${pageContext.request.contextPath}/view/js/imagesloaded.min.js"></script>
<script src="${pageContext.request.contextPath}/view/js/nivo-lightbox.min.js"></script>

<script src="${pageContext.request.contextPath}/view/js/jquery.flexslider-min.js"></script>

<script src="${pageContext.request.contextPath}/view/js/jquery.parallax.js"></script>
<script src="${pageContext.request.contextPath}/view/js/smoothscroll.js"></script>
<script src="${pageContext.request.contextPath}/view/js/wow.min.js"></script>

<script src="${pageContext.request.contextPath}/view/js/custom.js"></script>

</body>
</html>