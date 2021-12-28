/**
 * 
 */

function validarLogin(){
	const email = formLogar.emailLogin.value
	const senha = formLogar.senhaLogin.value
	
	if(email === ""){
		alert("Preencha o email")
		formLogar.email.focus()
		return false	
	}else if(senha === ""){
		alert("Preencha a senha")
		formLogar.senha.focus()
		return false
	}else {
		document.forms["formLogar"].submit()
	}
}