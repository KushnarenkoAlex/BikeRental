<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="fragment/tagLib.jspf" %>
<html>
<head>
    <title>Bike Shop</title>
    <link href="/resources/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <script src="/resources/js/jquery.min.js"></script>
    <link href="/resources/css/form.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all"/>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords"
          content="Bike-shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
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
    <!-- <script src="js/validate.js" type="text/javascript"></script> -->
    <style type="text/css">
        div#map_container {
            width: 100%;
            height: 350px;
        }
    </style>
    <script type="text/javascript"
            src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>

    <script type="text/javascript">
        function loadMap() {
            var latlng = new google.maps.LatLng(${bike.x}, ${bike.y});
            var myOptions = {
                mapTypeControl: true,
                zoom: 15,
                center: latlng,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("map_container"), myOptions);

            var marker = new google.maps.Marker({
                position: latlng,
                map: map,
                title: "${bike.name}"
            });

        }
    </script>
</head>
<body onload="loadMap()">
<script src="/resources/js/responsiveslides.min.js"></script>
<script>
    $(function () {
        $("#slider").responsiveSlides({
            auto: false,
            nav: true,
            speed: 500,
            namespace: "callbacks",
            pager: true,
        });
    });
</script>
<div class="banner-bg banner-sec">
    <div class="container">
        <div class="header">
            <div class="logo">
                <a href="main"><img src="/resources/images/logo.png" alt=""/></a>
            </div>
            <div class="top-nav">
                <label class="mobile_menu" for="mobile_menu">
                    <span>Menu</span>
                </label> <input id="mobile_menu" type="checkbox">
                <ul class="nav">
                    <li class="dropdown1"><a href="/bicycle/list">BICYCLES</a></li>
                    <li class="dropdown1"><a href="/myPage">MY
                        ACCOUNT</a> <c:choose>
                        <c:when test="${empty currentUser}">
                            <ul class="dropdown2">
                                <li><a href="/login">LOG
                                    IN</a></li>
                                <li><a href="/signUp">SIGN
                                    UP</a></li>
                            </ul>
                        </c:when>
                    </c:choose></li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<div class="container">
    <div class="cart-top">
    </div>
    <br> <br>

    <h2>BIKE RENT</h2>

    <div class="product">
        <div class="container">
            <div class="ctnt-bar cntnt">
                <div class="content-bar">
                    <div class="single-page">
                        <div class="product-head">
                        </div>
                        <link rel="stylesheet" href="/resources/css/etalage.css">
                        <script src="/resources/js/jquery.etalage.min.js"></script>
                        <script>
                            jQuery(document).ready(function ($) {

                                $('#etalage').etalage({
                                    thumb_image_width: 400,
                                    thumb_image_height: 400,
                                    source_image_width: 800,
                                    source_image_height: 1000,
                                    show_hint: true,
                                    click_callback: function (image_anchor, instance_id) {
                                        alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                                    }
                                });

                            });
                        </script>
                        <!--//details-product-slider-->
                        <div class="details-left-slider">
                            <div class="grid images_3_of_2">
                                <ul id="etalage">
                                    <li>
                                        <a href="optionallink.html">
                                            <c:if test="${not empty bike.image}">
                                                <img class="etalage_thumb_image"
                                                     src="/resources/images/bikeimg/${bike.image}" alt=""
                                                     class="img-responsive"/>
                                                <img class="etalage_source_image"
                                                     src="/resources/images/bikeimg/${bike.image}" alt=""
                                                     class="img-responsive"/>
                                            </c:if>
                                            <c:if test="${empty bike.image}">
                                                <img class="etalage_thumb_image" src="/resources/images/bik1.jpg" alt=""
                                                     class="img-responsive"/>
                                                <img class="etalage_source_image" src="/resources/images/bik1.jpg" alt=""
                                                     class="img-responsive"/>
                                            </c:if>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="details-left-info">
                            <h3>${bike.name}</h3>
                            <h4>Model No: 3498</h4>
                            <h4></h4>

                            <p><label>$</label> ${bike.price}</p>
                            <script type="text/javascript">
                                $(document).ready(function () {
                                    $("#rentButton").click(function () {
                                        navigator.geolocation.getCurrentPosition(function (position) {

                                            var rad = function (x) {
                                                return x * Math.PI / 180;
                                            };


                                            var bikLat =${bike.x};
                                            var bikLng =${bike.y};

                                            var curLat = position.coords.latitude;
                                            var curLng = position.coords.longitude;

                                            var R = 6378137; // Earth’s mean radius in meter
                                            var dLat = rad(bikLat - curLat);
                                            var dLong = rad(bikLng - curLng);
                                            var a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                                                    Math.cos(rad(bikLat)) * Math.cos(rad(bikLng)) *
                                                    Math.sin(dLong / 2) * Math.sin(dLong / 2);
                                            var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
                                            var d = R * c;
                                            if (d < 100) {
                                                $("#distError").html('');
                                                window.location.href = "/bicycle/rend?id=${bike.id}";
                                            }
                                            else {
                                                $("#distError").html('You are to far from this bike (' + Math.round(d) + ' m). Go near to 100 m to rent it.');
                                            }
                                        }, function (err) {
                                        });
                                    });
                                });
                            </script>
                            <div class="btn_form" id="rentButton">
                                <a>buy now</a>
                            </div>
                            <div class="bike-type">
                                <p><a href="#" id="distError"></a></p>
                            </div>
                            <div class="bike-type">
                                <p>TYPE ::<a href="#">${bike.type}</a></p>
                            </div>
                            <div id="map_container"></div>
                            <h5>Description ::</h5>

                            <p class="desc">The first mechanically-propelled, two-wheeled vehicle may have been built by
                                Kirkpatrick MacMillan, a Scottish blacksmith, in 1839, although the claim is often
                                disputed. He is also associated with the first recorded instance of a cycling traffic
                                offense, when a Glasgow newspaper in 1842 reported an accident in which an anonymous
                                "gentleman from Dumfries-shire... bestride a velocipede... of ingenious design" knocked
                                over a little girl in Glasgow and was fined five
                                The word bicycle first appeared in English print in The Daily News in 1868, to describe
                                "Bysicles and trysicles" on the "Champs Elysées and Bois de Boulogne.</p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<%@ include file="fragment/footer.jspf" %>
</body>
</html>