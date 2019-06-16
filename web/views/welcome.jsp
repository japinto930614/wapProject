<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Voting Project</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Actors<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/student">Students</a></li>
                    <li><a href="/faculties">Faculty Members</a></li>
                    <li><a href="/rstaffs">Staffs</a></li>
                </ul>
            </li>
            <li><a href="#"></a></li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Reports<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/rstudents">Students</a></li>
                    <li><a href="/rfaculties">Faculty Members</a></li>
                    <li><a href="/rstaffs">Staffs</a></li>
                </ul>
            </li>
            <li><a href="#"></a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            <li><a href="/"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>

<div class="container">

</div>

</body>
</html>
