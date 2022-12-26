<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
td {
  background-color: #C9D9EF;
}
</style>

<body style="background-color:rgb(182,207,236);">
<h1 style="text-align:center"> List of users </h1>
<table>
<thead><td><b>Username</b></td><td><b>Name</b></td></thead>
   <c:forEach var="mapElement" items="${userList}">
       <tr>
           <td>${mapElement.key}</td>
           <td>${mapElement.value.name}</td>
       </tr>
   </c:forEach>
</table>
<p>${user.name}</p>
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
</body>
