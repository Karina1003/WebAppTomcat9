<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" errorPage="errorLogin.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
  <meta charset="UTF-8">
  <meta name="description" content="User page">
  <meta name="author" content="Karina Pinchuk">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body style="background-color:rgb(182,207,236);">

  <header>
      <h1 style="text-align:center"> Welcome, ${user.username} </h1>
  </header>

  <c:if test="${not user.loggedIn}"><c:redirect url="/app/errorLogin"/></c:if>

  <h2>Menu</h2>
  <ul>
      <li>
          <form:form modelAttribute="user"
                action="${pageContext.request.contextPath}/app/userList">
                <table>
                   <tr>
                        <td>
                            <input type="submit" value="See list of users" />
                        </td>
                   </tr>
                </table>
          </form:form>
      </li>
      <li>
          <form:form modelAttribute="user"
                    action="${pageContext.request.contextPath}/app/login">
                    <table>
                       <tr>
                            <td>
                                <input type="submit" value="Logout" />
                            </td>
                       </tr>
                    </table>
          </form:form>
      </li>
  </ul>
  </body>