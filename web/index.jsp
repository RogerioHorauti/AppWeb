<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Hello World!</h3>
        
        <a href="${pageContext.request.contextPath}/principal">Principal</a>
        <br/>
        <br/>
        <form action="login" method="POST" >
            <div>
                <label>Usuário</label>
                <input value="Rogerio" type="text" name="user" />
            </div>
            
            <div>
                <label>Senha</label>
                <input value="admin" type="password" name="password" />
            </div>
            
            <div>
                <input value="Enviar" type="submit"></button>
            </div>
        </form>
       
    </body>
</html>
