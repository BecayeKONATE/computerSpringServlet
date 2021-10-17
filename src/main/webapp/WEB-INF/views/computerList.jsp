<%@ include file="common/head.jspf" %>
<%@ include file="common/navigation.jspf" %>
		<h1>Welcome to our computer sale website</h1><br><br>
		
		
		<table class="table table-striped">
			<thead>
				<tr>
					
					<th scope="col">Image</th>
      				<th scope="col">Make</th>
      				<th scope="col">Model</th>
      				<th scope="col">Price</th>
      				
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${computers }" var="computer">
					<tr>
						<td><a href="/image-computer?id=${computer.id}"><img src="${computer.image}" width="350" height="200"></a></td>
						<td>${computer.make}</td>
						<td><a href="/update-computer?id=${computer.id}"><button type="button" class="btn btn-success">Update</button></a></td>
						<td><a href="/delete-computer?id=${computer.id}"><button type="button" class="btn btn-danger">Delete</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/add-computer"><button type="button" class="btn btn-primary">Add crampon</button></a>
       <%@ include file="common/footer.jspf" %>
