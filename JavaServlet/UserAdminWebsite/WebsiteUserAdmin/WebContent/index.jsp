<%@include file="includes/header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<div class="card mt-3">
				<div class="card-body">
					<form method="post" action="Login">
						<div class="row g-3">
							<div class="col-xs-12 col-sm-12 col-md-6">
								<div class="form-group mt-1">
									<label class="form-label">Email</label>
									<input type="email" name="email" class="form-control" placeholder="Enter Email" required />
								</div>
								<div class="form-group m-1">
									<label class="form-label">Password</label>
									<input type="password" name="password" class="form-control" placeholder="Enter Password" required />
								</div>
							</div>
						</div>
						<div class="mt-3">
							<div class="row g-3">
								<div class="col-xs-12 col-sm-12 col-md-3">
									<div class="d-grid gap-2">
									  <input class="btn btn-success" type="submit" value="Login">
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="includes/footer.jsp"%>