<nav class="navbar navbar-expand-lg navbar-dark bg-success">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <!-- original ul <ul class="navbar-nav me-auto mb-2 mb-lg-0"> -->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active"
                                        aria-current="page" href="index.jsp"><i class="fa fa-home"></i>
                    HOME</a></li>
                <li class="nav-item"><a class="nav-link active"
                                        aria-current="page" href="add_employee.jsp"><i
                        class="fa-solid fa-user-employee"></i> Add Employee</a></li>
                <li class="nav-item"><a class="nav-link active"
                                        aria-current="page" href="view_employee.jsp"><i
                        class="fa-solid fa-list"></i> View Employee</a></li>
            </ul>

            <div class="dropdown">
                <button class="btn btn-light  dropdown-toggle" type="button"
                        id="dropdownMenuButton1" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    <i class="fa fa-universal-access"></i> Welcome! Admin
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                    <li><a class="dropdown-item" href="../adminLogout">Logout</a></li>
                </ul>
            </div>

        </div>
    </div>
</nav>