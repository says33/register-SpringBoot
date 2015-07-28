<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Collection<String>" -->

<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
  <head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  <body>
    <form align="center" role="form" action="/login" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div>
            <label for="username">username</label>
            <input type="email" name="username" id="username" required="" autofocus="" />
        </div>
        <p></p>
        <div>
            <label for="password">Password</label>
            <input type="password" name="password" id="password" required="" />
        </div>
        <p></p>
        <div>
            <label for="remember-me">Remember me</label>
            <input type="checkbox" name="remember-me" id="remember-me" />
        </div>
        <p></p>
        <button type="submit">Sign in</button>
    </form>
  </body>
</html>
