<?php
$servername = "homologacao.alfaengenharia.ind.br:3306";
$username = "criasdarosi";
$password = "kPpNLb499&GD";
$database = "criasdarosi";
 
$conn = mysqli_connect($servername, $username, $password, $database);
 
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>