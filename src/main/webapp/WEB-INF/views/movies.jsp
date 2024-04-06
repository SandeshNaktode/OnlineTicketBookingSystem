<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="dheader.jsp"/>
<a href="addmovie" class="btn btn-sm btn-primary float-right m-2">Add New Movie</a>
<div class='clearfix'></div>
<div class="container-fluid">
    <jsp:include page="msg"/>   
    <div class="row">
        <div class="col mx-auto">
            <h3 class="text-center heading">All Movies</h3>
            <table class="table table-bordered table-sm table-striped">
                <thead class='table-danger'>
                    <tr>
                        <th>Movie ID</th>
                        <th>Movie Name</th>
                        <th>Release Date</th>
                        <th>Director</th>    
                        <th>Actor</th>
                        <th>Actress</th>
                        <th>CRUD</th>                        
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${list }" var="movie"> 
                     <tr>
                         <td>${movie.mid}</td>
                         <td>${movie.mname}</td>
                         <td>${movie.reldate}</td>
                         <td>${movie.director}</td>
                         <td>${movie.actor}</td>
                         <td>${movie.actress}</td>
                         <td>
                             <a href="madetails/${movie.mid}" class="btn btn-primary btn-sm">Details</a>
                             <a href="editmovie/${movie.mid}" class="btn btn-primary btn-sm">Edit</a>
                             <a href="editmovie/${movie.mid}" class="btn btn-primary btn-sm">Delete</a>
                         </td>
                     </tr>
                 </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="dfooter.jsp"/>