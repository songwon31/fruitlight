window.onload = function() {
    var prevDate = null;
    var divs = document.querySelectorAll('.order-date-line');

    for (var i = 0; i < divs.length; i++) {
        var currentDate = divs[i].classList[1]; // 클래스명에서 날짜 정보 추출

        if (currentDate === prevDate) {
            divs[i].style.display = 'none'; // 같은 날짜일 경우 숨김
        }

        prevDate = currentDate;
    }
};
