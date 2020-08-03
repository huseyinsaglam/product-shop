<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <link rel="stylesheet" type="text/css" media="screen" href="/css/sidebar.css"/>
    <link rel="stylesheet" type="text/css" media="screen" href="/css/bootstrap.min.css"/>
    <script src="/js/jquery.min.js"/>

    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>

    <title>Kullanicilar</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Kullanicilar</h1></a>
            <p>Itelligence Hackatlon</p>
            <p>
                <a href="<spring:url value="/products/all" />" class="btn btn-default">
                    <span class="glyphicon-hand-left glyphicon"></span> back
                </a>
            </p>
        </div>
    </div>
</section>

<div id="wrapper">

    <div id="page-content-wrapper">
        <div class="row">
            <c:forEach items="${data}" var="data">
                <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                    <div class="thumbnail">
                        <div class="caption">
                            <h3><strong> Username : </strong> ${data.username}</h3>
                            <p><strong>Name : </strong> ${data.name}</p>
                            <p><strong>Surname : </strong> ${data.surname}</p>

                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        </section>
    </div>
</div>
</body>
</html>
