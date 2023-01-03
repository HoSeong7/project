/**
 * 
 */
 
 function boardCheck(){
	if(document.frm.name.value.length == 0){
		alert("작성자를 입력해주세요.");
		frm.name.focus();
		return false;
	}
	if(document.frm.pass.value.length == 0){
		alert("비밀번호를 입력해주세요.");
		frm.price.focus();
		return false;
	}
	if(isNaN(document.frm.pass.value)){
		alert("비밀번호는 숫자로 넣어주세요.");
		frm.price.focus();
		return false;
	}
	if(document.frm.title.length == 0){
		alert("제목을 입력해주세요.");
		frm.title.focus();
		return false;
	}
	return true;
}
function open_win(url, name){
	window.open(url, name, "width=500, height=230")
}
function passCheck(){
	if(document.frm.pass.value.length == 0){
		alert("비밀번호를 입력해주세요.");
		return false;
	}
	return true;
}