<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Access</title>

<style>
    body {
        margin: 0;
        font-family: Arial, sans-serif;
        background: #92a9bf;;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }

    .card {
        background:white ;
        width: 90%;
        max-width: 380px;
        padding: 30px;
        border-radius: 20px;
        box-shadow: 0 5px 20px rgba(0,0,0,0.12);
        text-align: center;
    }

    
    .icon-box {
        width: 110px;
        height: 110px;
        background: linear-gradient(135deg, #a8c6ff, #8be9ff);
        border-radius: 20px;
        margin: 0 auto 15px;
        display: flex;
        justify-content: center;
        align-items: center;
        
        border: 2px solid #1e1e8a;
    }
      
    .icon-box img { 
          width: 100px;
        height: 100px;
    }

    h2 {
        margin: 5px 0;
        color: #2b2bb2;
        font-size: 26px;
        font-weight: bold;
    }

    p {
        color: #325ba1;
        font-size: 14px;
        margin-bottom: 20px;
    }

    label {
        text-align: left;
        display: block;
        font-size: 16px;
        margin-top: 10px;
        color: #2b2bb2;
    }

    input {
        width: 100%;
        padding: 12px;
        border-radius: 10px;
        border: 1px solid #c8c8c8;
        margin-top: 5px;
        font-size: 14px;
    }

    .options {
    display:flex;
    justify-content : space-between;
    align-items: center;
    margin : 8px 0 15px 0 ;
}

.rem-box { 

    display: flex;
    align-items: center;
    gap: 6px;
    font-size: 16px;
    color: #120a62;
    font-weight: 500;
    cursor: pointer;
}
    .options a {
        color: #120a62;
        text-decoration: none;
        font-size: 16px;
        font-weight: 500;
    }
    .login-btn {
        width: 100%;
        padding: 12px;
        background: linear-gradient(135deg, #8fa2ff, #79e0ff);
        border: none;
        border-radius: 12px;
        color: white;
        margin-top: 15px;
        font-size: 17px;
        cursor: pointer;
    }

    .footer-text {
        margin-top: 10px;
        font-size: 13px;
        color: #666;
    }


    @media (min-width: 768px) {
        .card {
            padding: 40px;
            max-width: 380px;
        }
        
    }

</style>
</head>

<body>

              
                  
             
                <!--<li class="separator">
                  <i class="icon-arrow-right"></i>
                </li>
                <li class="nav-item">
                  <a href="${pageContext.request.contextPath}/views/add_Teacher.jsp">add teacher</a>
                </li>
                  <li class="separator">
                  <i class="icon-arrow-right"></i>
                </li>
                <li class="nav-item">
                  <a href="#">Datatables</a>
                </li>   -->
            
<div class="card">
<p align="left"> <a href="${pageContext.request.contextPath}/index.jsp">
 back
</a></p>
    <div class="icon-box"><img src ="${pageContext.request.contextPath}/assets/img/admin.jpg"></div>

    <h2>Admin Access</h2>
    <p>Only authorized administrators can log in to manage the system.</p>
      <form action="${pageContext.request.contextPath}/adminLogin" method="post">
    <label>Admin Email</label>
    <input type="email" placeholder="Enter Email Id" name="email" required="required">

    <label>Password</label>
    <input type="password" placeholder="Enter password" name="password" required="required">

   <!-- 
 <div class="options">
    <label class="rem-box">
    <input type="checkbox">Remember me
    </label>
<a href="#">Forgot?</a> 

    </div>
 --> 
    <button type="submit" class="login-btn">Login</button>
     
     </form>
     <h3 style="color:red;">
      ${error}
     </h3>
    <div class="footer-text">
        Admin accounts are created by the system super-admin only.
    </div>
</div>

</body>
</html>