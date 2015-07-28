<#-- @ftlvariable name="users" type="java.util.List<com.mx.domain.User>" -->

<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
  <head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  <body>
    <table>
	    <thead>
	    	<tr>
	    	  <th>Username</th>
	    	  <th>Role</th>
	    	</tr>
	    </thead>
	    <tbody>
		    <#list users as user>
		    <tr>
		      <td><a href="/user/${user.id}">${user.username}</a></td>
		      <td>${user.role}</td>
		    </tr>
		    </#list>
	    </tbody>
		</table>
  </body>
</html>
