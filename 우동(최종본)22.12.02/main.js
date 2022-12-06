// 변수선언
const toggleBtn = document.querySelector('.navbar_toggleBtn');
const menu = document.querySelector('.navbar_menu');
const login = document.querySelector('.navbar_login');

// navbtn을 클릭할때마다 아래함수들를 호출
toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
    login.classList.toggle('active');
});

// 상단메뉴고정
var $navbar = $('.navbar');    // 변수
$(window).scroll(function() {
    if($(this).scrollTop() > 0) {
        $navbar.addClass('sticky');
    } else {
        $navbar.removeClass('sticky');
    }
});


