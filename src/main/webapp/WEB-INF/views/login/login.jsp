<%@ page errorPage = "errorLogin.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>
  <meta charset="UTF-8">
  <meta name="description" content="Login page">
  <meta name="author" content="Karina Pinchuk">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body style="background-color:rgb(182,207,236);">

  <header>
      <h1 style="text-align:center"> Please, enter your username and password </h1>
  </header>

    <form:form align="center" modelAttribute="user"
            action="${pageContext.request.contextPath}/app/user">
            <table>
                 <tr>
                    <td>Username:</td>
                    <td><form:input type="text" path="username"/></td>
                 </tr>
                 <tr>
                    <td>Password:</td>
                    <td><form:input type="password" path="password"/></td>
                 </tr>
                    <td>
                        <input id="login" name="login" type="submit" value="Login" />
                    </td>
            </table>
    </form:form>
</body>

