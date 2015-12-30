<%@ include file="fragment/header.jspf" %>
<div class="cart">
    <div class="container">
        <c:choose>
            <c:when test="${not empty currentUser}">
                <div align="center">
                    <h1>${sessionScope.currentUser.name}</h1>
                    <img src="/resources/images/profile.gif"></div>
                <c:if test="${not empty sessionScope.curAgreement}">

                    <div class="cart">
                        <div class="container">
                            <div class="col-md-9 cart-items">
                                <h2>Rented bike</h2>

                                <div class="cart-header">
                                    <div class="cart-sec">
                                        <div class="cart-item cyc">
                                            <img src="/resources/images/bik1.jpg"/>
                                        </div>
                                        <div class="cart-item-info">
                                            <h3>${sessionScope.curAgreement.bicycle.name}</h3>
                                            <h4>
                                                <span>Price $ </span>${sessionScope.curAgreement.bicycle.price}
                                            </h4>
                                            <br>
                                            <h4>
                                                <span>From:</span> ${sessionScope.curAgreement.fromDate}
                                            </h4>
                                        </div>
                                        <div class="clearfix"></div>
                                        <div class="delivery">
                                            <p>Service Charges:: Rs.100.00</p>
                                            <span>Click pay if you already finished renting</span>

                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-3 cart-total">
                                <form action="/bicycle/rend" method="post">
                                    <div class="price-details">
                                        <h3>Choose Options</h3>
                                        <span>Payment</span> <br> <select
                                            class="selectpicker" name="payment">
                                        <option value="">PayPal</option>
                                        <option value="">Privat</option>
                                    </select>

                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="clearfix"></div>
                                    <h2>Total price: ${sessionScope.price}</h2>
                                    <input type="submit" class="btn btn-default" name="Pay"
                                           value="Pay">
                                </form>
                            </div>
                        </div>
                    </div>

                </c:if>
                <form action="logout" method="post">
                    <input type="submit" class="btn btn-default"
                           value="LOG OUT">
                </form>
            </c:when>
            <c:otherwise>
                <jsp:forward page="log_in.jsp"/>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<%@ include file="fragment/footer.jspf" %>
</body>
</html>

