// 아이디 체크
function checkId(elem) {
  elem.addEventListener("keyup", () => {
    const pattern1 = /^(?!(?:[0-9]+)$)([a-zA-Z]|[0-9a-zA-Z]){4,}$/;
    let idLength = elem.value.length;
    document.getElementById("아이디검증").innerHTML =
      idLength >= 6 && idLength <= 16 && pattern1.test(elem.value)
        ? ""
        : "6자 이상 16자 이하의 영문 혹은 영문과 숫자를 조합";
    allcollect();
  });
}
// 비밀번호 체크
function checkPassword(elem) {
  elem.addEventListener("keyup", () => {
    let pattern2 =
      /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/;
    let pwLength = elem.value.length;
    document.getElementById("비밀번호검증").innerHTML =
      pwLength >= 8 && pwLength <= 20 && pattern2.test(elem.value)
        ? ""
        : "8자 이상 20자 이하의 영문, 숫자, 특수문자를 조합";
    allcollect();
  });
}
// 비밀번호 2차 체크
function doubleCheckPassword(elem) {
  elem.addEventListener("keyup", () => {
    let pwLength = elem.value.length;
    document.getElementById("비밀번호2차검증").innerHTML =
      elem.value === document.getElementById("password").value
        ? ""
        : "비밀번호가 일치하지 않습니다.";
    allcollect();
  });
}
// 이름 체크
function namecheck(elem) {
  elem.addEventListener("keyup", () => {
    let nameLength = elem.value.length;
    document.getElementById("이름검증").innerHTML =
      nameLength >= 2 && nameLength <= 10
        ? ""
        : "2자 이상 10자 이하의 이름을 입력해주세요.";
    allcollect();
  });
}
// 이메일 체크
function emailcheck(elem) {
  elem.addEventListener("keyup", () => {
    const pattern3 =
      /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    document.getElementById("이메일검증").innerHTML = pattern3.test(elem.value)
      ? ""
      : "이메일 형식에 맞게 입력해주세요.";
    allcollect();
  });
}
// 휴대전화 체크
function phoneCheck(elem) {
  elem.addEventListener("keyup", () => {
    const pattern4 = /^(?:(010\d{4})|(01[1|6|7|8|9]\d{3,4}))(\d{4})$/i;
    document.getElementById("휴대전화검증").innerHTML = pattern4.test(
      elem.value
    )
      ? ""
      : "-를 제외한 휴대폰번호를 입력해주세요";
    allcollect();
    // 인증 번호 받기 활성화
    if (document.getElementById("휴대전화검증").innerHTML == "") {
      document.getElementById("인증번호").style.backgroundColor = "black";
      document.getElementById("인증번호").style.color = "white";
      document.getElementById("인증번호").style.pointerEvents = "auto";
      document.getElementById("인증번호").style.cursor = "pointer";
    } else {
      document.getElementById("인증번호").style.backgroundColor =
        "rgb(214, 214, 214)";
      document.getElementById("인증번호").style.color = "grey";
      document.getElementById("인증번호").style.pointerEvents = "none";
      document.getElementById("인증번호").style.cursor = "none";
    }
  });
}

// 전체 체크 및 체크해제
function allchecked(elem) {
  const allow = document.getElementsByClassName("동의");
  if (elem.checked) {
    for (let a = 0; a < allow.length; a++) {
      allow[a].checked = true;
    }
  } else {
    for (let a = 0; a < allow.length; a++) {
      allow[a].checked = false;
    }
  }
  allcollect();
  checkboxisall();
}

// 회원가입 활성화
function allcollect() {
  let button = "allcheck";
  for (let a = 0; a < document.getElementsByClassName("검증").length; a++) {
    if (!document.getElementsByClassName("검증")[a].innerHTML == "") {
      button = "uncheck";
    }
  }
  for(let b=1;b<document.getElementsByClassName("동의").length-1;b++){
    if(!document.getElementsByClassName("동의")[b].checked){
      button = "uncheck";
    }  
  }
  button == "uncheck" ? disable() : able();
  checkboxisall();
}

function able() {
  document.getElementById("회원가입버튼").style.backgroundColor = "black";
  document.getElementById("회원가입버튼").style.color = "white";
  document.getElementById("회원가입버튼").style.pointerEvents = "auto";
  document.getElementById("회원가입버튼").style.cursor = "pointer";
}
function disable() {
  document.getElementById("회원가입버튼").style.backgroundColor =
    "rgb(214, 214, 214)";
  document.getElementById("회원가입버튼").style.color = "grey";
  document.getElementById("회원가입버튼").style.pointerEvents = "none";
  document.getElementById("회원가입버튼").style.cursor = "none";
}

  function checkboxisall(){
  let checkbox = "allcheck"
    for(a=1;a<document.getElementsByClassName("동의").length;a++){
     if(!document.getElementsByClassName("동의")[a].checked){
      checkbox="unchecked";
     }
    }
    if(checkbox=="unchecked"){
      document.getElementsByClassName("동의")[0].checked=false;
    }else{
      document.getElementsByClassName("동의")[0].checked=true;   
    }
}

