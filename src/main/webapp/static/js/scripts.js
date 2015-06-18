/**
 * Created by user on 6/17/2015.
 */


$(function () {
    //when group members collapse/accordion function
   $(document).on('click','.group .group-title',function (e) {

       $(this).siblings('.members').toggleClass('active');
       e.preventDefault();
   })


    //global array to store already added member in the list
    var added_members = [];
    console.log(added_members);

    //add all the members of the group to companions when clicked on add btn
    $(document).on('click','.group .btn-add-group',function (e) {
        var members = $(this).siblings('.members');
        //loop through members
        var companions_div = $(".added-companions");

        members.find('li').each(function () {

            var member_name = $(this).children('span').html();
            var member_id = $(this).children('a').attr('data-member-id');
            var inarray = $.inArray(member_id, added_members);
            if (inarray == -1) {
                var member_div = "<div class='companions'><div class='name'>"+member_name+"</div><input type='hidden' value='"+member_id+"' name='companions[]'/><span class='close' title='Remove'>&times;</span><input class='form-control' type='number' name='amount[]' placeholder='Amount Spent'/><textarea class='form-control' name='description[]' placeholder='Description of Expense'></textarea></div>"
                added_members.push(member_id);
                companions_div.append($(member_div));
            }

        });
        e.preventDefault();
    })

    $(document).on('click','.member .btn-add-member',function (e) {

        //loop through members
        var companions_div = $(".added-companions");
        var member_name = $(this).siblings('span').html();
        var member_id = $(this).attr('data-member-id');
        var inarray = $.inArray(member_id, added_members)
        if (inarray == -1) {
            var member_div = "<div class='companions'><div class='name'>"+member_name+"</div><input type='hidden' value='"+member_id+"' name='companions[]'/><span class='close' title='Remove'>&times;</span><input class='form-control' type='number' name='amount[]' placeholder='Amount Spent'/><textarea class='form-control' name='description[]' placeholder='Description of Expense'></textarea></div>"
            added_members.push(member_id);
            companions_div.append($(member_div));
        }
        //console.log('test');
        e.preventDefault();
    })



    //remove companion when clicked on remove btn
    $(document).on('click','.companions .close',function (e) {
        $(this).parent('.companions').remove();
        var removeItem = $(this).siblings('input').val();
        added_members = jQuery.grep(added_members, function(value) {
            return value != removeItem;
        });
    })
    
    //script for the member search 
    $(document).on('keyup','#members-search-input',function () {
    	var search_text = $.trim($(this).val());
    	var url = '/group/search-member';
    	var resultDiv = $(".search-result");
    	if (search_text == '') {
    		resultDiv.removeClass("show");
    		return false;
    	}
    	resultDiv.addClass("show");
    	var data = "q="+search_text;
    	$.ajax({
    		url: url,
    		type: 'GET',
    		data: data,
    		dataType:'JSON',
    		beforeSend:function () {
    			//do something before sending request
    		},
    		success:function (response) {
    			//do something with the response
    			var resultWrap = $('.search-result ul');
    			var list = "";
    			if (response.userlist.length == 0) {
    				list += "<li class='no-data'>No data to show</li>";
    			}
    			var addedMembersEmail = [];
    			$.each($("#group-members li"),function () {
    	    		var tmpEmail = $(this).children('input').val();
    	    		addedMembersEmail.push(tmpEmail);
    	    	});
    			$.each(response.userlist, function(index, user) {
    			    var userEmail = user.email;
    			    var userName = user.firstName + ' ' + user.lastName;
    			    userEmail = $.trim(userEmail);
    			    if ($.inArray(userEmail,addedMembersEmail) == -1) {
    			    	list += "<li><span class='name'>"+userName+"</span> (<span class='email'>"+userEmail+"</span>)</li>";
    			    }
    			});
    			
    			resultWrap.html(list);
    			
    		},
    		complete:function () {
    			//do something after completion of request
    		}
    	});
    })
    
    $(document).click(function () {
    	$(".search-result").removeClass("show");
    })
    
    $(document).on('click','.search-result ul li', function () {
    	var no_of_members = $('.count_member').length;
    	var groupMember = $("#group-members");
    	var email = $(this).children('span.email').text();
    	var name = $(this).children('span.name').text();
    	
    	
    	var member = "<li>"+name+"<input type='hidden' class='count_member' name='members["+no_of_members+"].email' value='"+email+"' /><span class='remove'>&times;</span></li>";
    	groupMember.append(member);
    })
    
    $(document).on('click','#group-members li .remove', function () {
    	$(this).parent().remove();
    })
    
});
