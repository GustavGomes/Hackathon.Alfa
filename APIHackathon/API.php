<?php

ini_set('display_errors', 1);
error_reporting(E_ALL);

header("Content-Type: application/json; charset=utf-8");
header("Acess-Control-Allow-Origin: *");
header("Acess-Control-Allow-Headers: *");

require_once 'DbConnect.php';

$request = json_decode(stripsLashes(file_get_contents("php://input")), TRUE);
//$request = $_POST;

$response = array(
    'success' => '0',
    'message' => 'Requisição Inválida', 
    'request' => $request
);

if (is_array($request) && array_key_exists('cpf', $request) && array_key_exists('senha', $request)) {

    $response = array(
        'success' => '0',
        'message' => 'Login ou Senha Incorretos'
    );

    $sql = "SELECT * FROM funcionario WHERE cpf = '{$request['cpf']}'";
    $sql_result = mysqli_query($conn, $sql);

    if (mysqli_num_rows($sql_result) === 1 ) {
        $row = mysqli_fetch_assoc($sql_result);
        if ($row['permission_id'] == 3) {
             $response = array(
                'success' => '0',
                'message' => 'Usuário não Permitido'
             );
        } else if ($request['senha'] == $row['senha']) {
            $response = array(
                'success' => '1',
                'message' => 'Login e Senha Corretos'
            );
        }
    }
}

mysqli_close($conn);
echo json_encode($response);

?>