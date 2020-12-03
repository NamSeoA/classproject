    var memeber = [];


    function Member(id, pw, name){
    this.userid = id;
    this.userpw = pw;
    this.username = name;
    };

    Member.prototype.makeHtml = function(index) {
    
    console.log(this.userid+' , '+this.userpw+' , '+this.username);
    
    var memberHtml = '';
    memberHtml += '<tr>';
    memberHtml += ' <td>'+index+'</td>';
    memberHtml += ' <td>'+this.userid+'</td>';
    memberHtml += ' <td>'+this.userpw+'</td>';
    memberHtml += ' <td>'+this.username+'</td>';
    memberHtml += ' <td>';
    memberHtml += '<tr>';
   
    return memberHtml;
    
}
    
    
    
    //유효성 검사
    function recheck(){
    
    var userid = document.querySelector('#userid');
    var userpw = document.getElementById('pw');
    var username = document.querySelector('#username');
        
    var check = false;
        
    if(userid.value.trim().length<1){ document.querySelector('#userid+div.m').style.display='block';
        check = true;
    }
        
    if(userpw.value.trim().length<1){ document.querySelector('#userpw+div.m').style.display='block';
        check = true;
    }
        
    if(username.value.trim().length<1){ document.querySelector('#username+div.m').style.display='block';
        check = true;
    }
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    