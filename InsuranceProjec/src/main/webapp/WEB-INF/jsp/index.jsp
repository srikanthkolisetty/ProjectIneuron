<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>
    <script>
      
    </script>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand">Insurance Policy Management</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse p-2" id="navbarNav">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0 fs-5"></ul>
          <div class="d-flex navbar-nav fs-5">
            <li class="nav-item">
              <a
                class="nav-link active text-warning"
                aria-current="page"
                href="http://localhost:8080/"
              >
                Home
              </a>
            </li>
            <li class="nav-item">
              <a
                class="nav-link active"
                aria-current="page"
                href="http://localhost:8080/userLogin"
                >Customer</a
              >
            </li>
            <li class="nav-item">
              <a
                class="nav-link active"
                aria-current="page"
                href="http://localhost:8080/adminLogin"
              >
                Admin
              </a>
            </li>
          </div>
        </div>
      </div>
    </nav>

    <div class="container text-center p-5 mb-5">
     

      <h1 class="mb-5">Login as</h1>
      <div class="row">
        <div class="mb-3 col-6">
          <a
            class="card btn btn-outline-primary fs-3 text-end"
            href="adminLogin"
          >
            <div class="card-body">
              <p class="card-text">Admin</p>
            </div>
          </a>
        </div>
        <div class="mb-3 col-6">
          <a
            class="card btn btn-outline-primary fs-3 text-start"
            href="userLogin"
          >
            <div class="card-body">
              <p class="card-text">Customer</p>
            </div>
          </a>
          Don't have an account <a href="signup">click here</a> to create one.
        </div>
      </div>
    </div>
    <footer class="bg-dark text-white text-center text-lg-start p-3 fixed-bottom">
      <div class="text-center p-3">ME Insurance Company</div>
    </footer>
  </body>
</html>
