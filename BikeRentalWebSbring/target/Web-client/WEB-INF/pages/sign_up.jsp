<%@ include file="fragment/header.jspf" %>
<div class="container">
    <div class="cart-top">
    </div>
    <br> <br>

    <h2>SIGN UP</h2>

    <form action="signUp" method="post">
        <table size="1000" border="5" bordercolor="white">
            <tr>
                <td>NAME:</td>
                <td size="100"><input size="100" type="text"
                                      id="nameReg" name="nameReg" value="${nameVal}"
                                      class="form-control input-text"
                                      placeholder="Name" required="required"></td>
            </tr>
            <tr>
                <td>PASSWORD:</td>
                <td><input type="password" id="passwordReg"
                           name="passwordReg" class="form-control input-text"
                           placeholder="Password" required="required"></td>
            </tr>
            <tr>
                <td>REPEAT PASSWORD:</td>
                <td><input type="password" id="password2"
                           name="password2" class="form-control input-text"
                           placeholder="Password" required="required"><c:if
                        test="${requestScope.pass==true}"><span>Incorrect password</span></c:if></td>
            </tr>
            <tr>
                <td>EMAIL:</td>
                <td><input type="email" required="required" id="emailReg" value="${emailVal}"
                           name="emailReg" class="form-control input-text"
                           placeholder="Email"><c:if
                        test="${requestScope.exist==true}"><span>User already exist</span></c:if></td>
            </tr>
        </table>
        <input type="submit" class="btn btn-default" name="signup" value="Sign Up">
    </form>

</div>
<%@ include file="fragment/footer.jspf" %>
</body>
</html>