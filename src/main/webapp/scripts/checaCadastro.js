/**
 * 
 */

function validar(){
	const nome = formularioCadastro.nome.value;
    const email = formularioCadastro.email.value;
    const senha = formularioCadastro.senha.value;

    if (nome === ""){
        alert("Preencha o campo Nome")
        //posicionar o cursos em cima deste campo
        formularioCadastro.nome.focus
        return false
    }else if(email === ""){
        alert("Preencha o campo email")
        formularioCadastro.email.focus()
        return false
    }else if(senha === "") {
        alert("Preencha o campo senha")
        formularioCadastro.senha.focus()
        return false;
    }else if(senha.length <= 4){
		alert("A senha tem que conter pelo menos 5 caracteres")
		formularioCadastro.senha.focus()
		return false	
	}else {
        document.forms["formularioCadastro"].submit()
    }
}