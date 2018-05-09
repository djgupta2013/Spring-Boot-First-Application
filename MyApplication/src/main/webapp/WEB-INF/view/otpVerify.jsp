<!DOCTYPE html>

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body {
font-family: Arial, Helvetica, sans-serif;
background-color: #f0f5f5;
}
form {border: 3px solid #f1f1f1;}

 input[type=number],input[type=submit]{
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
<title>Otp verification form</title>
</head>
<body>

<form action="otpVerify"  method="POST" >
<div class="container">
   
    <label for="repsw"><b>Please enter otp</b></label>
    <input type="number" placeholder="Enter otp" name="otp" minlength="5" required/>

    
     
   <input type="submit"   value="submit" >
    
  </div>
</form>
</body>
</html>