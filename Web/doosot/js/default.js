window.onload = function () {
    getSquareItem();
    getBowlItem();
    getSideItem();
    getBeverageItem();
    getSidemenuItem();
};


/*사각도시락 메뉴 불러오기 메서드*/
function getSquareItem() {
    var menudata = JSON.parse(squaremenu);
    var menuHtml = "";

    for (var i = 0; i < menudata.length; i++) {
        menuHtml += '<div class="menu" onclick = "javascript:addmenuOpen();">';
        menuHtml += '<table>';
        menuHtml += '<tr>';
        menuHtml += '<td><img src="'
        menuHtml += menudata[i].src;
        menuHtml += '" width=200px height=200px></td></tr>'
        menuHtml += '<tr><td><a1>'
        menuHtml += menudata[i].name;
        menuHtml += '</a1></td></tr>'
        menuHtml += '<tr><td><a2>'
        menuHtml += menudata[i].price;
        menuHtml += '</a2></td></tr></table></div>'

        var div_sq = document.getElementById("square");
        console.log(div_sq);
        div_sq.innerHTML = menuHtml;
    };

};

/*보울도시락 메뉴 불러오기 메서드*/
function getBowlItem() {

    var menudata = JSON.parse(bowlmenu);
    var menuHtml = "";

    for (var i = 0; i < menudata.length; i++) {
        menuHtml += '<div class="menu" onclick = "javascript:addmenuOpen();">';
        menuHtml += '<table>';
        menuHtml += '<tr>';
        menuHtml += '<td><img src="'
        menuHtml += menudata[i].src;
        menuHtml += '" width=200px height=200px></td></tr>'
        menuHtml += '<tr><td><a1>'
        menuHtml += menudata[i].name;
        menuHtml += '</a1></td></tr>'
        menuHtml += '<tr><td><a2>'
        menuHtml += menudata[i].price;
        menuHtml += '</a2></td></tr></table></div>'

        var div_bowl = document.getElementById("bowl");
        div_bowl.innerHTML = menuHtml;
    };

};


/*사이드 메뉴 불러오기 메서드*/
function getSideItem() {

    var menudata = JSON.parse(sidemenu);
    var menuHtml = "";

    for (var i = 0; i < menudata.length; i++) {
        menuHtml += '<div class="menu" onclick = "javascript:addmenuOpen();">';
        menuHtml += '<table>';
        menuHtml += '<tr>';
        menuHtml += '<td><img src="'
        menuHtml += menudata[i].src;
        menuHtml += '" width=200px height=200px></td></tr>'
        menuHtml += '<tr><td><a1>'
        menuHtml += menudata[i].name;
        menuHtml += '</a1></td></tr>'
        menuHtml += '<tr><td><a2>'
        menuHtml += menudata[i].price;
        menuHtml += '</a2></td></tr></table></div>'

        var side = document.getElementById("side");
        side.innerHTML = menuHtml;
    };

};


/*음료 메뉴 불러오기 메서드*/
function getBeverageItem() {
    var menudata = JSON.parse(beverage);
    var menuHtml = "";

    for (var i = 0; i < menudata.length; i++) {
        menuHtml += '<div class="menu">';
        menuHtml += '<table>';
        menuHtml += '<tr>';
        menuHtml += '<td><img src="'
        menuHtml += menudata[i].src;
        menuHtml += '" width=200px height=200px></td></tr>'
        menuHtml += '<tr><td><a1>'
        menuHtml += menudata[i].name;
        menuHtml += '</a1></td></tr>'
        menuHtml += '<tr><td><a2>'
        menuHtml += menudata[i].price;
        menuHtml += '</a2></td></tr></table></div>'

        var div_bv = document.getElementById("beverage");
        div_bv.innerHTML = menuHtml;
    };

};




/*사이드 메뉴 불러오기 메서드*/
function getSidemenuItem() {

    var menudata = JSON.parse(adm);
    
    console.log(menudata[0].name);
    var menuHtml = '<h2>밥 추가 변경</h2>';

    for (var i = 0; i < 3; i++) {
        menuHtml += '<div class="addmenu" id="addmenu';
        menuHtml += i+1
        menuHtml += '"><a1>';
        menuHtml += menudata[i].name
        menuHtml += '</a1><br><a2>';
        menuHtml += menudata[i].price
        menuHtml += '</a2></div>'
    }

    menuHtml += '<h2>토핑 추가</h2>'

    for (var i = 3; i < 6; i++) {
        menuHtml += '<div class="addmenu" id="addmenu';
        menuHtml += i+1
        menuHtml += '"><a1>';
        menuHtml += menudata[i].name
        menuHtml += '</a1><br><a2>';
        menuHtml += menudata[i].price
        menuHtml += '</a2></div>'
        
    }
    
    console.log(menuHtml);

        var div_side = document.querySelector("#div_addmenu");
        div_side.innerHTML = menuHtml;
    };


function callbowllist() {
    document.querySelector('#square').style.display = 'none';
    document.querySelector('#bowl').style.display = 'block';
    document.querySelector('#side').style.display = 'none';
    document.querySelector('#beverage').style.display = 'none';

};

function callsqlist() {
    document.querySelector('#square').style.display = 'block';
    document.querySelector('#bowl').style.display = 'none';
    document.querySelector('#side').style.display = 'none';
    document.querySelector('#beverage').style.display = 'none';
};

function callsidelist() {
    document.querySelector('#square').style.display = 'none';
    document.querySelector('#bowl').style.display = 'none';
    document.querySelector('#side').style.display = 'block';
    document.querySelector('#beverage').style.display = 'none';
};

function callbvlist() {
    document.querySelector('#square').style.display = 'none';
    document.querySelector('#bowl').style.display = 'none';
    document.querySelector('#side').style.display = 'none';
    document.querySelector('#beverage').style.display = 'block';
};


/*// 추가메뉴창 닫기 >> 제이쿼리로 변경
function addmenuClose() {
    document.querySelector('#menuinfo').style.display = 'none'
    document.querySelector('#addmenu1').style.border= '0px';
    
};*/



// 추가메뉴창 열기
function addmenuOpen() {
    document.querySelector('#menuinfo').style.display = 'block';
}


/*매장or포장*/
function takeout(takeout) {
    var takeout = takeout;
    console.log(takeout);
    document.querySelector('#takeout').style.display = 'none';
}

/*고른 음식 수량 선택*/
function fnCalCount(type, ths) {
    var $input = $(ths).parents("td").find("input[name='pop_out']");
    var tCount = Number($input.val());

    if (type == 'p') {
        $input.val(Number(tCount) + 1);

    } else {
        if (tCount > 1) $input.val(Number(tCount) - 1);
    }
}

/*카트에 담아둔 음식 삭제*/
// 나중에 데이터 삭제 추가해줘야함

function removeCart() {
    var chk = confirm('모두 삭제하시겠습니까?');

    if (chk) {
        removeHtml = '';
        var removecart = document.getElementById("addmenu_tbody");
        removecart.innerHTML = removeHtml;
        var removecart = document.getElementById("sum");
        removecart.innerHTML = removeHtml;
        
    }
};
