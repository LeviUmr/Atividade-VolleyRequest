<?php
$user_name = "Atividade";
$password = "159482637";
$host = "192.168.1.2";
$db_name = "dbfilmes";
$con = mysqli_connect($host,$user_name,$password,$db_name);
$sql = "select * from titulos where Locado like '0';";
$result = mysqli_query($con,$sql);
if(mysqli_num_rows($result)>0){

	$row = mysqli_fetch_assoc($result);

	echo json_encode(array("Codigo"=>$row["Codigo"],"Nome_do_titulo"=>$row["Nome_do_titulo"],"Tipo"=>$row["Tipo"],"Locado"=>$row["Locado"]));
}
?>
