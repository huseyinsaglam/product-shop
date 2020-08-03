<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="productUrlAll" value="${pageContext.request.contextPath}/products/all"/>
<c:set var="productUrlCategory" value="${pageContext.request.contextPath}/products/category"/>
<c:set var="matrixUrl" value="${pageContext.request.contextPath}/products/brand"/>
<%@ page session="false" %>

<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>PRODUCTS</title>



	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">
	<!-- Google Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700' rel='stylesheet' type='text/css'>
	<!-- Animate -->
	<link rel="stylesheet" href="/login/asset/css/animate.css">
	<!-- Icomoon -->
	<link rel="stylesheet" href="/login/asset/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="/login/asset/css/bootstrap.css">

	<link rel="stylesheet" href="/login/asset/css/style.css">


	<link rel="stylesheet" type="text/css" media="screen" href="/css/sidebar.css"/>
	<link rel="stylesheet" type="text/css" media="screen" href="/css/bootstrap.min.css"/>
	<%--<script src="/js/jquery.min.js"/>--%>


	<script>
		function prepareMatrix() {

			var selectedBrands = "";
			$('input:checkbox[name=brand]').each(function () {
				if ($(this).is(':checked'))
					selectedBrands = selectedBrands + $(this).val() + ",";
			});


			var url = '${matrixUrl}/brands=' + selectedBrands;

			$("#search").attr("href", url);


		}
	</script>

	<title>Products</title>

</head>
<body>

<div id="fh5co-offcanvas">
	<a href="#" class="fh5co-close-offcanvas js-fh5co-close-offcanvas"><span><i class="icon-cross3"></i> <span>Kapat</span></span></a>
	<div class="fh5co-bio">
		<figure>
			<img src="/login/asset/images/person1.jpg" alt="Free HTML5 Bootstrap Template" class="img-responsive">
		</figure>
		<h3 class="heading">Hakkimda</h3>
		<h2>${user.name} ${user.surname}</h2>

		<p>
			<a
					href=" <c:url value="/user/kullanicilar" /> "
					class="btn btn-primary"> <span
					class="glyphicon-info-sign glyphicon"/></span> Kullanicilari Listele
			</a>
		</p>

		<p>
			<a
					href=" <c:url value="/product/add" /> "
					class="btn btn-primary"> <span
					class="glyphicon-info-sign glyphicon"/></span> Urun Ekle
			</a>
		</p>

		<p>
			<a
					href=" <c:url value="/logout" /> "
					class="btn btn-primary"> <span
					class="glyphicon-info-sign glyphicon"/></span> Cikis
			</a>
		</p>

	</div>

</div>

<section>

	<div class="jumbotron">
		<div class="container">
			<a href="${productUrlAll}"><h1>Products</h1></a>
			<p>Itelligence Hackatlon</p>
		</div>
		<%--<div class="container">
			<a href="<c:url value="/logout" />"><h5>Logout</h5></a>
		</div>--%>
	</div>
</section>


<!-- END #fh5co-offcanvas -->
<header id="fh5co-header">

	<div class="container-fluid">

		<div class="row">
			<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>

		</div>

	</div>

</header>


<div id="wrapper">

	<!-- Sidebar -->
	<div id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<li class="sidebar-brand">
				Brands
			</li>

			<li>
				<label class="label-align">
					<input type="checkbox" name="brand" value="laptop"><span>Laptop</span>
				</label>
			</li>

			<li>
				<label class="label-align">
					<input type="checkbox" name="brand" value="tablet"><span>Tablet</span>
				</label>
			</li>
			<li>
				<label class="label-align">
					<input type="checkbox" name="brand" value="smartPhones"><span>SmartPhones</span>
				</label>
			</li>

			<a style="margin-left:40px" onclick="prepareMatrix()" id="search" class="btn btn-success">
				<span>Search </span>
			</a>

		</ul>
	</div>

	<div id="page-content-wrapper">
		<section class="container">

			<div class="row">
				<div class="col-md-6">
					<ul class="nav nav-tabs">
						<li class="">
							<a href="${productUrlAll}">All Products</a>
						</li>
						<li>
							<a href="${productUrlCategory}/laptop">Laptops</a>
						</li>
						<li class="">
							<a href="${productUrlCategory}/tablet">Tablets</a>
						</li>
						<li class="">
							<a href="${productUrlCategory}/smartPhones">Smart Phones</a>
						</li>
					</ul>
				</div>
			</div>

			<div class="row">
				<c:forEach items="${products}" var="product">
					<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
						<div class="thumbnail">
							<div class="caption">
								<h3>${product.productCode}</h3>
								<h3>${product.name}</h3>
								<p>${product.description}</p>
								<p>${product.unit_price}USD</p>
								<p>Available ${product.unitsInStock} units in stock</p>
								<p>
									<a
											href=" <c:url value="/products/product?id=${product.id}" /> "
											class="btn btn-primary"> <span
											class="glyphicon-info-sign glyphicon"/></span> Details
									</a>
								</p>

							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
	</div>
</div>


<!-- jQuery -->
<script src="/login/asset/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="/login/asset/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="/login/asset/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="/login/asset/js/jquery.waypoints.min.js"></script>
<!-- Main JS -->
<script src="/login/asset/js/main.js"></script>


</body>
</html>