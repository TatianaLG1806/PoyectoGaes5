function validar(){
	var correo = document.getElementById("correo").value;
	var password = document.getElementById("password").value;


	if(correo.length < 1){
		swal ( "Ingrese Correo"  , 
			 {
      icon: "error",
    }); 
		return false; 
	}

	else{
		if(password.length < 1){
			swal ( "Ingrese Contraseña"  ,  {
      icon: "error",
    });  
			 return false; swal ("error");
		}
	}


	if (correo === "admin@gmail.com" && password === "12345"){
		swal("¡Bienvenido Administrador!" , {
      icon: "success",
    });

		  window.location="dashboard/indexAdministrador.html"

	}

	else
	if (correo == "empleado@gmail.com" && password === "12345"){
		swal("¡Bienvenid@ Trabajador!" , {
      icon: "success",
    });
		  window.location="dashboard/indexEmpleado.html"
	}

	else{
		swal ( "Correo o Contraseña Incorrecta"  ,  {
      icon: "error",
    }); 
		return false;
	}

}