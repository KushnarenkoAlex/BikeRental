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

            navigator.geolocation.getCurrentPosition(function (position) {
                var initialLocation = new google.maps.LatLng(position.coords.latitude,
                        position.coords.longitude);
                var markersArray = [];
                var myOptions = {
                    zoom: 15,
                    center: initialLocation,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };

                var map = new google.maps.Map(document.getElementById("map_container"), myOptions);

                google.maps.event.addListener(map, "click", function (event) {
                    placeMarker(event.latLng);
                    document.getElementById("x").value = event.latLng.lat();
                    document.getElementById("y").value = event.latLng.lng();
                });

                function placeMarker(location) {
                    deleteOverlays();

                    var marker = new google.maps.Marker({
                        position: location,
                        map: map
                    });
                    markersArray.push(marker);
                }

                function deleteOverlays() {
                    if (markersArray) {
                        for (i in markersArray) {
                            markersArray[i].setMap(null);
                        }
                        markersArray.length = 0;
                    }
                }


            }, function () {
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

    <h2>ADD NEW BIKE</h2>

    <form action="/bicycle/add" method="post" enctype="multipart/form-data">
        <table border="5" bordercolor="white">
            <tr>
                <td>NAME:</td>
                <td size="100"><input size="100" type="text"
                                      id="name" name="name"
                                      class="form-control input-text"
                                      placeholder="Name" required="required"></td>
            </tr>
            <tr>
                <td>PRICE:</td>
                <td>
                    <input type="number" id="price"
                           name="price" class="form-control input-text"
                           placeholder="Price" required="required"></td>
            </tr>
            <tr>
                <td>TYPE:</td>
                <td>
                    <select name="type" id="type">
                        <option value="MTB">MTB</option>
                        <option value="FIXED GEAR">FIXED GEAR</option>
                        <option value="CITY BIKE">CITY BIKE</option>
                    </select>
            </tr>
            <tr>
                <td>IMAGE:</td>
                <td>
                    <input type="file" name="image" />
            </tr>
            <tr>
                <td>CHOOSE CURRENT BIKE LOCATION:</td>
                <td>
                    <div id="map_container"></div>
                    <input type="hidden" id="x"
                           name="x" class="form-control input-text"
                           placeholder="x"></td>
                <input type="hidden" id="y"
                       name="y" class="form-control input-text"
                       placeholder="y"></td>
                </td>
            </tr>
        </table>
        <input type="submit" class="btn btn-default" name="add" value="Add">
    </form>

</div>
<%@ include file="fragment/footer.jspf" %>
</body>
</html>