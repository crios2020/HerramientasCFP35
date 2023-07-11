var menu=`
<!-- Inicio Menú de navegación -->
 <nav class="navbar navbar-expand-lg bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand text-info" href="http://localhost:8080/">Herramientas</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link text-light" aria-current="page" href="http://localhost:8080/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-light" aria-current="page"
                        href="herramientas">Herramientas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-light" aria-current="page"
                        href="socios">Socios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-light" aria-current="page"
                        href="prestamos">Préstamos</a>
                </li>
            </ul>

            <!-- reloj -->
            <div id="contReloj">
                <p id="pHoras"></p>
                <p>:</p>
                <p id="pMinutos"></p>
                <p>:</p>
                <p id="pSegundos"></p>
            </div>

            <!-- Botón de busqueda -->
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success text-light" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<!-- Fin Menú de navegación -->
`

document.getElementById('menuPrincipal').innerHTML=menu