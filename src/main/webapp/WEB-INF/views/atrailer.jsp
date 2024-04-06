<!--<jsp:include page="dheader.jsp"></jsp:include>
<div class="container">
    <h4 class="text-center p-2">Trailer of movie ${movie.mname }</h4>
    <div class="container my-2">
	<a href="${movie.trailer}">
		<button type="button" class="btn btn-primary">Watch Trailer</button>
	</a>
</div>
</div>
<jsp:include page="dfooter.jsp"></jsp:include>-->
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
let url="${movie.trailer}";
setTimeout(function(){
	window.location.replace(url);
},2500);
</script>
<div class="jumbotron bg-dark text-white p-3 text-center rounded-0"
	style="margin-top: 150px;margin-bottom:140px">
	<h4 class="text-center p-2"> Playing Trailer of movie ${ movie.mname }</h4>
	<h3>Loading ...</h3>
</div>
<!-- <div class="container my-2">
	<a href="${movie.trailer }">
		<button type="button" class="btn btn-primary">Watch Trailer</button>
	</a>
</div>-->


<jsp:include page="footer.jsp"></jsp:include>


