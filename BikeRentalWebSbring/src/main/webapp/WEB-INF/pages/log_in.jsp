<%@ include file="fragment/header.jspf" %>
<div class="cart">
    <div class="container">
        <form action="login" method="post">
            <h2>Log In</h2>
            <table>
                <tr>
                    <td>EMAIL:</td>
                    <td><input size="300" type="text" id="email"
                               name="email" class="form-control input-text"
                               placeholder="Email" required><span
                            class="error-message" id="emailError"
                            name="emailError"></span></td>
                </tr>
                <tr>
                    <td>PASSWORD:</td>
                    <td><input type="password" id="password"
                               name="password" class="form-control input-text"
                               placeholder="Password" required><span
                            class="error-message" id="passwordError"
                            name="passwordError"></span>

                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><c:if test="${loginError}">User doesn't exist or incorrect password</c:if>
                    </td>
                </tr>
            </table>
            <input type="text" id="requestedPage" hidden="true"
                   name="requestedPage"
                   value="${requestScope.requestedPage}"> <input
                type="submit" class="btn btn-default" value="LOG IN">

        </form>
    </div>
</div>
<%@ include file="fragment/footer.jspf" %>
</body>
</html>

