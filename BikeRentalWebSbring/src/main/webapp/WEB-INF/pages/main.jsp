<!DOCTYPE html>
<html>
<head>
    <title>Bike Shop</title>
    <link href="/resources/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <script src="/resources/js/jquery.min.js"></script>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);
        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <link
            href='http://fonts.googleapis.com/css?family=Roboto:500,900,100,300,700,400'
            rel='stylesheet' type='text/css'>
    <script src="/resources/js/jquery.easydropdown.js"></script>
    <link href="/resources/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="/resources/js/scripts.js" type="text/javascript"></script>
    <script type="text/javascript" src="/resources/js/move-top.js"></script>
    <script type="text/javascript" src="/resources/js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({
                    scrollTop: $(this.hash).offset().top
                }, 900);
            });
        });
    </script>


</head>
<body>
<script src="/resources/js/responsiveslides.min.js"></script>
<script>
    $(function () {
        $("#slider").responsiveSlides({
            auto: true,
            nav: true,
            speed: 500,
            namespace: "callbacks",
            pager: true,
        });
    });
</script>
<div class="banner-bg banner-bg1">
    <div class="container">
        <div class="header">
            <!-- <div class="logo">
                <a href="index.html"><img src="images/logo.png"
                    alt="" /></a>
            </div> -->
            <div class="top-nav">
                <label class="mobile_menu" for="mobile_menu">
                    <span>Menu</span>
                </label> <input id="mobile_menu" type="checkbox">
                <ul class="nav">
                    <li class="dropdown1"><a href="/bicycle/list">BICYCLES</a></li>
                    <li class="dropdown1"><a
                            href="/myPage">MY ACCOUNT</a>
                        <ul class="dropdown2">
                            <li><a href="/login">LOG IN</a></li>
                            <li><a href="/signUp">SIGN UP</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="caption">
        <div class="slider">
            <div class="callbacks_container">
                <ul class="rslides" id="slider">
                    <li><h1>HANDMADE BICYCLE</h1></li>
                    <li><h1>SPEED BICYCLE</h1></li>
                    <li><h1>MOUINTAIN BICYCLE</h1></li>
                </ul>
                <p>
                    You <span>create</span> the <span>journey,</span>
                    we supply the <span>parts</span>
                </p>
                <a class="morebtn" href="bicycles.html">SHOP
                    BIKES</a>
            </div>
        </div>
    </div>
    <div class="dwn">
        <a class="scroll" href="#cate"><img
                src="/resources/images/scroll.png" alt=""/></a>
    </div>
</div>
<%@ include file="fragment/footer.jspf" %>

</body>
</html>

