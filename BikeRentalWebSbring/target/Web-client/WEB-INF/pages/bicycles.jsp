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
                    zoom: 12,
                    center: initialLocation,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };

                var map = new google.maps.Map(document.getElementById("map_container"), myOptions);
                <c:forEach var="bike" items="${bikes}">
                var marker = new google.maps.Marker({
                    position: new google.maps.LatLng(${bike.x}, ${bike.y}),
                    map: map,
                    title: "${bike.name}"
                });
                </c:forEach>
//                google.maps.event.addListener(map, "click", function (event) {
//                    placeMarker(event.latLng);
//                    document.getElementById("x").value = event.latLng.lat();
//                    document.getElementById("y").value = event.latLng.lng();
//                });

//                function placeMarker(location) {
//                    deleteOverlays();
//
//                    var marker = new google.maps.Marker({
//                        position: location,
//                        map: map
//                    });
//                    markersArray.push(marker);
//                }

//                function deleteOverlays() {
//                    if (markersArray) {
//                        for (i in markersArray) {
//                            markersArray[i].setMap(null);
//                        }
//                        markersArray.length = 0;
//                    }
//                }


            }, function () {
            });


        }
    </script>
</head>
<body onload="loadMap()">
<c:if test="${empty currentUser}">
    <%response.sendRedirect("/login");%>
</c:if>
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
<div class="parts">
    <div class="container">
        <h2>BICYCLES</h2>

        <div class="bike-parts-sec">
            <%--<form role="form" action="bikeList">--%>
            <div class="bike-parts">
                <div class="top">
                    <h4><a href="/bicycle/add">ADD NEW BIKE</a></h4>

                    <div id="map_container"></div>
                    <%--<label>Sort by: </label> <select--%>
                    <%--class="selectpicker" name="sortCriteria"--%>
                    <%--onchange="this.form.submit()">--%>
                    <%--<option--%>
                    <%--${(criteria.sortCriteria == 'Price')?'selected':''}>Price--%>
                    <%--</option>--%>
                    <%--<option--%>
                    <%--${(criteria.sortCriteria == 'Name')?'selected':''}>Name--%>
                    <%--</option>--%>
                    <%--</select> <select class="selectpicker" name="order"--%>
                    <%--onchange="this.form.submit()">--%>
                    <%--<option value="true"--%>
                    <%--${(criteria.order eq 'Descending')?'selected':''}>&#8593;</option>--%>
                    <%--<option value="false"--%>
                    <%--${(!(criteria.order eq 'Descending'))?'selected':''}>&#8595;</option>--%>
                    <%--</select> <label>On page: </label> <select--%>
                    <%--class="selectpicker" name="onPage"--%>
                    <%--onchange="this.form.submit()">--%>
                    <%--<option value="12"--%>
                    <%--${(criteria.onPage == 12)?'selected':''}>12--%>
                    <%--</option>--%>
                    <%--<option value="24"--%>
                    <%--${(criteria.onPage == 24)?'selected':''}>24--%>
                    <%--</option>--%>
                    <%--<option value="36"--%>
                    <%--${(criteria.onPage == 36)?'selected':''}>36--%>
                    <%--</option>--%>
                    <%--</select>--%>

                    <%--<div align="center">--%>
                    <%--<pref:PageTag--%>
                    <%--currentPage="${criteria.currentPage}"--%>
                    <%--numberOfPages="${numberOfPages}"></pref:PageTag>--%>
                    <%--</div>--%>
                </div>
                <c:choose>
                    <c:when test="${empty bikes}">
                        <h3 align="center">No products</h3>
                    </c:when>
                    <c:otherwise>
                        <div class="bike-apparels">
                            <c:forEach var="bike" items="${bikes}">
                                <div class="part-sec">
                                    <c:if test="${not empty bike.image}">
                                        <img src="/resources/images/bikeimg/${bike.image}" alt=""/>
                                    </c:if>
                                    <c:if test="${empty bike.image}">
                                        <img src="/resources/images/bik1.jpg" alt=""/>
                                    </c:if>

                                    <div class="part-info">
                                        <a href="#"><h5>
                                                ${bike.name}<span>${bike.price}$</span>
                                        </h5></a>
                                        <c:set var="titleURL">
                                            <c:url value="/bicycle/rent">
                                                <c:param name="id" value="${bike.id}"/>
                                            </c:url>
                                        </c:set>
                                        <a class="add-cart" href="${titleURL}">Quick
                                            View</a> <a class="qck addtobucket" href="${titleURL}"
                                                        data-product-id="${bike.id}">BUY NOW</a>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="rsidebar">

                <%--<h3 class="m_2">Name</h3>--%>

                <%--<div class="form-group">--%>
                <%--<input type="text" name="name"--%>
                <%--value="${criteria.name}"--%>
                <%--class="form-control" placeholder="Name">--%>
                <%--</div>--%>
                <%--<h3 class="m_2">Category</h3>--%>

                <%--<div class="form-group">--%>
                <%--<select class="selectpicker" name="category">--%>
                <%--<option value="0"--%>
                <%--${(criteria.categoryId == 0)?'selected':''}></option>--%>
                <%--<c:forEach var="category"--%>
                <%--items="${categories}">--%>
                <%--<option value="${category.id}"--%>
                <%--${(criteria.categoryId == category.id)?'selected':''}>${category.name}</option>--%>
                <%--</c:forEach>--%>
                <%--</select>--%>
                <%--</div>--%>
                <%--<h3 class="m_2">Brand</h3>--%>
                <%--<c:forEach var="brand" items="${brands}">--%>
                <%--<label class="checkbox"><input--%>
                <%--type="checkbox" name="brands"--%>
                <%--value="${brand.id}"--%>
                <%--${criteria.brands.contains(brand.id)?'checked':''}>${brand.name}</label>--%>
                <%--</c:forEach>--%>
                <%--<h3 class="m_2">Price</h3>--%>
                <%--<label>From: </label> <input type="range"--%>
                <%--id="fromPrice" name="fromPrice"--%>
                <%--value="${criteria.minPrice}" min="${min}"--%>
                <%--max="${max}" onchange="fromText.value=value"/>--%>
                <%--<output for=from id=fromText>${criteria.minPrice}</output>--%>
                <%--<label>To: </label> <input type="range" id="toPrice"--%>
                <%--name="toPrice" value="${criteria.maxPrice}"--%>
                <%--min="${min}" max="${max}"--%>
                <%--onchange="toText.value=value"/>--%>
                <%--<output id="toText">${criteria.maxPrice}</output>--%>
                <%--<input type="submit" class="btn btn-default">--%>
            </div>
            <%--<div class="clearfix"></div>--%>
            <%--</form>--%>
        </div>
    </div>
</div>
<%@ include file="fragment/footer.jspf" %>
</body>
</html>