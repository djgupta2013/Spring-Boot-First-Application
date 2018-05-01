<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
font-family: Arial, Helvetica, sans-serif;
background-color: #f0f5f5;
}
form {border: 3px solid #f1f1f1;}

input[type=email], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
img{
text-align: center;
  margin-left:200px;
    margin: 50px 0 25px 0;
}
    
}

img.avatar {
margin-left:400px;
    width: 15%;
    border-radius: 25%;
}

.container {
    padding: 12px;
    margin-left:200px;
    margin-right:200px;
}

.heading {
    padding: 12px;
    margin-left:200px;
    margin-right:200px;
}

span.psw {
    float: right;
    padding-top: 16px;
}
span.register {
    float: left;
    padding-top: 20px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
</head>
<body class="heading">
<div>
<h2>Welcome to login page</h2>
</div>

<form action="login" method="POST">
  <div class="imgcontainer">
    <img src="../static/image/download.jpg" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="uname"><b>Username</b></label>
    <input type="email" placeholder="Enter Email id" name="email" required/>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" minlength="8" required/>
        
    <button type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <!-- <button type="button" class="cancelbtn">Cancel</button> -->
    <span class="psw"><a href="#">Forgot  password</a></span>
    <span class="register"><a href="register">New Registration</a></span>
  </div>
</form>

</body>
</html>
