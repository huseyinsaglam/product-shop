<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Giris</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="/login/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/login/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/login/fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/login/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/login/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/login/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/login/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/login/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/login/css/util.css">
    <link rel="stylesheet" type="text/css" href="/login/css/main.css">
    <!--===============================================================================================-->
</head>
<body>

<section class="container">
    <!-- watch out modelAttribute ! -->
    <form:form modelAttribute="register" class="form-horizontal" method="post">
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-form validate-form">
					<span class="login100-form-title p-b-26">
						Kayit Ol
					</span>
                        <span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>


                        <div class="wrap-input100 validate-input" data-validate="Ad Girin">
                            <span class="focus-input100" data-placeholder="Adiniz"></span> <br><br>
                            <form:input id="name" path="name" type="text"  class="form:input-large"/>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Soyad Girin">
                            <span class="focus-input100" data-placeholder="Soyadiniz"></span><br><br>
                            <form:input id="surname" path="surname" type="text"  class="form:input-large"/>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Kullanıcı Adı Girin">
                            <span class="focus-input100" data-placeholder="Kullanici Adi"></span><br><br>
                            <form:input id="username" path="username" type="text" class="form:input-large"/>
                        </div>

                       <%-- <div class="wrap-input100 validate-input" data-validate="Email Girin">
                            <span class="focus-input100" data-placeholder="Email"></span><br><br>
                            <form:input id="e_mail" path="e_mail" type="text" class="form:input-large"/>
                        </div>--%>

                        <div class="wrap-input100 validate-input" data-validate="Parola Girin">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
                            <span class="focus-input100" data-placeholder="Parola"></span><br><br>
                            <form:input id="pass" path="pass" type="password" class="form:input-large"/>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Parola Tekrari Girin">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
                            <span class="focus-input100" data-placeholder="Parola Tekrari"></span><br><br>
                            <form:input id="pass2" path="pass2" type="password" class="form:input-large"/>
                        </div>

                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button class="login100-form-btn" type="submit" id="btnAdd" value ="Kayit Ol"> Kayit Ol</button>
                            </div>
                        </div>
                           ${message}
                        <div class="text-center p-t-115">
                            <a href="login">Giris Yap</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</section>

<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="/login/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="/login/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="/login/vendor/bootstrap/js/popper.js"></script>
<script src="/login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="/login/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="/login/vendor/daterangepicker/moment.min.js"></script>
<script src="/login/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="/login/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->

</body>
</html>